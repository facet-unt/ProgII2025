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
import usuarios.vistas.VentanaAMUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaAMUsuarios implements IControladorAMUsuario{
    private VentanaAMUsuarios ventana;
    private static VentanaUsuarios vista;
    private IControladorAMUsuario controlador;
    private static ControladorVentanaAMUsuarios instancia;
    private String correo, clave, claverepetida, nombre, apellido;
    IGestorUsuarios gu = GestorUsuarios.instanciarclase();
    
    private ControladorVentanaAMUsuarios(){
        this.ventana = new VentanaAMUsuarios(vista, this);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.requestFocus();
        this.ventana.requestFocusInWindow();
    }
    
    public static ControladorVentanaAMUsuarios instanciar(){
        if(instancia == null){
            instancia = new ControladorVentanaAMUsuarios();
        }
        else{
            nuevaInstancia(vista);
        }
        return instancia;
    }

    private static void nuevaInstancia(VentanaUsuarios vista){
        instancia = new ControladorVentanaAMUsuarios();
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
    
    private void mostrarMensajeError(String aviso){
        JOptionPane.showMessageDialog(ventana, aviso, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String resultado = validarDatos(nombre, apellido, clave, claverepetida);

        if(!resultado.equals(VALIDACION_EXITO)){
            mostrarMensajeError(resultado);
        }
        else{
            gu.crearUsuario(correo, apellido, nombre, ventana.verPerfil(), clave, claverepetida);
            this.ventana.dispose();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventana.dispose();
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
        this.claverepetida = campo.getText().trim();
    }
    
    
}
