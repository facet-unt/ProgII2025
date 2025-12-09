/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
