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
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaModificarUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaModificarUsuarios implements IControladorAMUsuario{
    private VentanaUsuarios vista;
    private VentanaModificarUsuarios ventana;
    private static Usuario u;
    private String clave, claverep, nombre, apellido, correo;
    GestorUsuarios gu = GestorUsuarios.instanciarclase();
    
    public ControladorVentanaModificarUsuarios(VentanaUsuarios padre, Usuario usuario){
        this.ventana = new VentanaModificarUsuarios(vista, this);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
        this.ventana.setLocationRelativeTo(padre);
        this.ventana.requestFocus();
    }

    private void mostrarMensajeError(String aviso){
        JOptionPane.showMessageDialog(ventana, aviso, "Error", JOptionPane.ERROR_MESSAGE);
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
        this.correo = gu.verUsuarios().get(vista.filaSeleccionada).verCorreo();
        String resultado = validarDatos(nombre, apellido, clave, claverep);
        
        if(!resultado.equals(VALIDACION_EXITO)){
            mostrarMensajeError(resultado);
        }
        else{
            u = gu.verUsuarios().get(vista.filaSeleccionada);
            gu.modificarUsuarios(u, nombre, apellido, correo, clave, claverep, u.verPerfil());
            vista.verModelo().modificarUsuario(vista.filaSeleccionada, u);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.apellido = campo.getText().trim();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.nombre = campo.getText().trim();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.clave = campo.getText().trim();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.claverep = campo.getText().trim();
    }
    
    
}
