/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author octav
 */
public class ControladorUsuarios implements IControladorUsuarios{
    private static ControladorUsuarios instancia;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaUsuarios ventanaUsuarios; 
    IGestorUsuarios gestorUsuarios = GestorUsuarios.instanciar();
    private String apellido;
    private Usuario usuario;
    
    public ControladorUsuarios() {
        ventanaUsuarios = new VentanaUsuarios(ventanaPrincipal,true,this,gestorUsuarios.verUsuarios());
        ventanaUsuarios.setTitle("Usuarios");
        ventanaUsuarios.setLocationRelativeTo(ventanaPrincipal);
        ventanaUsuarios.setVisible(true);
    }
    
    public static ControladorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
}
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ventanaUsuarios.requestFocusInWindow();
    }
    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaUsuarios.dispose();
    }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controladorCrearUsuarios = ControladorCrearUsuarios.instanciar();
        ventanaUsuarios.obtenerModeloUsuarios().setUsuarios(gestorUsuarios.verUsuarios());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        usuario = gestorUsuarios.verUsuarios().get(ventanaUsuarios.filaSeleccionada);
        IControladorAMUsuario controladorModificarUsuarios = ControladorModificarUsuarios.instanciar(ventanaUsuarios,usuario);

    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        ventanaUsuarios.obtenerModeloUsuarios().eliminarUsuario(ventanaUsuarios.filaSeleccionada);
        usuario = gestorUsuarios.verUsuarios().get(ventanaUsuarios.filaSeleccionada);
        gestorUsuarios.borrarUsuario(usuario);
    }
    
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.apellido = campo.getText().trim();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ventanaUsuarios.obtenerModeloUsuarios().setUsuarios(gestorUsuarios.buscarUsuarios(apellido));
    }
    
}
