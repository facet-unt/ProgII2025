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
     private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String claveRepetida;
    IGestorUsuarios gestorUsuarios = GestorUsuarios.instanciar();
     public ControladorModificarUsuarios() {
        ventanaModificarUsuarios = new VentanaModificarUsuarios(ventanaUsuarios,this);
        ventanaModificarUsuarios.setLocationRelativeTo(ventanaUsuarios);
        ventanaModificarUsuarios.setTitle(TITULO_MODIFICAR);
        ventanaModificarUsuarios.setVisible(true);
        ventanaModificarUsuarios.toFront();
        ventanaModificarUsuarios.requestFocus();
        ventanaModificarUsuarios.requestFocusInWindow();
    }
    
    public static ControladorModificarUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ControladorModificarUsuarios();
        }
        return instancia;
    }    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        gestorUsuarios.crearUsuario(correo,apellido,nombre,Perfil.CLIENTE,clave,claveRepetida);
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
