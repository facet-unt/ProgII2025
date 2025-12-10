/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.vistas.VentanaCrearUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author octav
 */
public class ControladorCrearUsuarios implements IControladorAMUsuario{
    private static ControladorCrearUsuarios instancia;
    private static VentanaUsuarios ventanaUsuarios;
    private VentanaCrearUsuarios ventanaCrearUsuarios;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;
    private String claveRepetida;
    IGestorUsuarios gestorUsuarios = GestorUsuarios.instanciar();
    
    public ControladorCrearUsuarios(VentanaUsuarios ventanaUsuarios) {
        this.ventanaUsuarios = ventanaUsuarios;
        ventanaCrearUsuarios = new VentanaCrearUsuarios(ventanaUsuarios,this);
        ventanaCrearUsuarios.setLocationRelativeTo(ventanaUsuarios);
        ventanaCrearUsuarios.setTitle(TITULO_NUEVO);
        ventanaCrearUsuarios.setVisible(true);
        ventanaCrearUsuarios.toFront();
        ventanaCrearUsuarios.requestFocus();
        ventanaCrearUsuarios.requestFocusInWindow();
    }
    
    public static ControladorCrearUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ControladorCrearUsuarios(ventanaUsuarios);
        }
        else
            nuevaInstancia(ventanaUsuarios);
        return instancia;
    }    
    private static void nuevaInstancia(VentanaUsuarios ventanaUsuarios){
        instancia = new ControladorCrearUsuarios(ventanaUsuarios);
    }
    private void mostrarError(String mensaje) {
    JOptionPane.showMessageDialog(ventanaCrearUsuarios, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(correo == null||correo.isEmpty()||!correo.contains("@"))
            mostrarError("Error correo");
        else if(apellido == null||apellido.isBlank()||apellido.isEmpty())
            mostrarError("Error apellido");
        else if(nombre == null||nombre.isBlank()||nombre.isEmpty())
            mostrarError("Error nombre");
        else if(clave == null||clave.isEmpty()||clave.isBlank())
            mostrarError("Error clave");
        else if(claveRepetida == null||!claveRepetida.contains(clave))
            mostrarError("Error clave");
        else{
            gestorUsuarios.crearUsuario(correo, apellido, nombre, ventanaCrearUsuarios.verPerfil(), clave, claveRepetida);
            ventanaCrearUsuarios.dispose();
        }
        
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaCrearUsuarios.dispose();
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
