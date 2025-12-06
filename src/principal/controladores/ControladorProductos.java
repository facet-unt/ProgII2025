/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import principal.vistas.VentanaPrincipal;
import productos.vistas.VentanaProductos;

/**
 *
 * @author ortiz
 */
public class ControladorProductos implements IControladorProductos {
    private static ControladorProductos instancia;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaProductos ventanaProductos;

    public ControladorProductos() {
        ventanaProductos = new VentanaProductos(ventanaPrincipal,true,this); 
        ventanaProductos.setTitle("Productos");
        ventanaProductos.setLocationRelativeTo(ventanaPrincipal);
        ventanaProductos.setVisible(true);
    }
    
    public static ControladorProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorProductos();
        }
        return instancia;
}
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ventanaProductos.requestFocusInWindow();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaProductos.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}
