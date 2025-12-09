/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaModificarUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author octav
 */
public class ControladorModificarUsuarios implements IControladorAMUsuario{
    private static ControladorModificarUsuarios instancia;
    private VentanaUsuarios ventanaUsuarios;
    private VentanaModificarUsuarios ventanaModificarUsuarios;
    private Usuario usuario;
     private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String claveRepetida;
    IGestorUsuarios gestorUsuarios = GestorUsuarios.instanciar();
    
     public ControladorModificarUsuarios(VentanaUsuarios ventanaUsuarios, Usuario usuario) {
        ventanaModificarUsuarios = new VentanaModificarUsuarios(ventanaUsuarios,this);
        this.usuario = usuario;
        this.ventanaUsuarios= ventanaUsuarios;
        ventanaModificarUsuarios.setLocationRelativeTo(ventanaUsuarios);
        ventanaModificarUsuarios.setTitle(TITULO_MODIFICAR);
        ventanaModificarUsuarios.setVisible(true);
        ventanaModificarUsuarios.toFront();
        ventanaModificarUsuarios.requestFocus();
        ventanaModificarUsuarios.requestFocusInWindow();
    }
    
    public static ControladorModificarUsuarios instanciar(VentanaUsuarios ventanaUsuarios, Usuario usuario) {
        if (instancia == null) {
            instancia = new ControladorModificarUsuarios(ventanaUsuarios,usuario);
        }
        return instancia;
    }    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        usuario = gestorUsuarios.verUsuarios().get(ventanaUsuarios.filaSeleccionada);
        gestorUsuarios.modificarUsuario(usuario, correo, apellido, nombre,ventanaModificarUsuarios.verPerfil(), clave, claveRepetida);
        ventanaUsuarios.obtenerModeloUsuarios().actualizarUsuario(ventanaUsuarios.filaSeleccionada, usuario);
        ventanaModificarUsuarios.dispose();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaModificarUsuarios.dispose();
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
        JTextField campo = (JTextField) evt.getComponent();
        this.correo = campo.getText().trim();
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.clave = campo.getText().trim();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.claveRepetida = campo.getText().trim();
    }
    
}
