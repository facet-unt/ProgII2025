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
import usuarios.modelos.ModeloComboPerfil;
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
    private GestorUsuarios gu = GestorUsuarios.instanciarclase();
    private ModeloComboPerfil combo = new ModeloComboPerfil();
    
    public ControladorVentanaModificarUsuarios(VentanaUsuarios padre, Usuario usuario){
        this.vista = new VentanaModificarUsuarios(padre, this);
        this.vista.verComboPerfil().setModel(combo);
        this.vista.setTitle(TITULO_MODIFICAR);
        this.vista.cargarDatosUsuario(usuario);    
        this.vista.setVisible(true);
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(vista);
        this.u = usuario;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = vista.verTxtApellido();
        String nombre   = vista.verTxtNombre();
        String correo   = vista.verCorreo();
        String clave    = new String(vista.verTxtClave().getPassword());
        String clave2   = new String(vista.verTxtClaveRepetida().getPassword());
        Perfil perfil   = vista.devolverPerfil();
        
        if(gu.modificarUsuarios(u, nombre, apellido, correo, clave, clave2, perfil).equals(IGestorUsuarios.EXITO)){
            JOptionPane.showMessageDialog(vista, IGestorUsuarios.EXITO, "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.vista.dispose();
        }
        else{
            JOptionPane.showMessageDialog(vista, IGestorUsuarios.CREACION_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
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
            vista.verTxtClave().requestFocus();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            vista.verTxtClaveRepetida().requestFocus();
    }
    
    
}
