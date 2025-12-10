/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.VALIDACION_EXITO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaModificarUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaModificarUsuarios implements IControladorAMUsuario{
    private VentanaModificarUsuarios vista;
    private Usuario u;
    GestorUsuarios gu = GestorUsuarios.instanciarclase();
    
    public ControladorVentanaModificarUsuarios(VentanaUsuarios padre, Usuario usuario){
        this.vista = new VentanaModificarUsuarios(vista, this);
        this.vista.setVisible(true);
        this.vista.setTitle(TITULO_MODIFICAR);
        this.vista.setResizable(false);
        this.u = usuario;
    }

    private void mostrarMensajeError(String aviso){
        JOptionPane.showMessageDialog(vista, aviso, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private String validarDatos(String nombre, String apellido, String clave, String claverep){
        if(nombre.isEmpty())
            return "Error Nombre";
        if(apellido.isEmpty())
            return "Apellido no Valido";
        if(clave.isEmpty() || clave == null)
            return "Clave Vacia";
        if(claverep.isEmpty() || claverep.isBlank() || claverep == null)
            return "Clave Repetida Vacia";
        if(!clave.equals(claverep)){
            return "Las Claves No son Iguales";
        }
        
        return VALIDACION_EXITO;
    }
    
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = vista.getTxtApellido().getText().trim();
        String nombre   = vista.getTxtNombre().getText().trim();
        String correo   = vista.getCorreo().getText().trim();
        String clave    = new String(vista.getTxtClave().getPassword());
        String clave2   = new String(vista.getTxtClaveRepetida().getPassword());
        Perfil perfil   = (Perfil) vista.getComboPerfil().getSelectedItem();
        String resp = validarDatos(nombre, apellido, clave, clave2);
        
        if(!resp.equals(VALIDACION_EXITO)){
            JOptionPane.showMessageDialog(vista, resp, "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            gu.modificarUsuarios(u, nombre, apellido, correo, clave, clave2, perfil);
            this.vista.dispose();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.vista.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            vista.getTxtApellido().requestFocus();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            vista.getTxtNombre().requestFocus();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            vista.getTxtClave().requestFocus();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            vista.getTxtClaveRepetida().requestFocus();
    }
    
    
}
