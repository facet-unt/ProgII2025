/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import productos.vistas.VentanaProductos;

/**
 *
 * @author thoma
 */
public class ControladorProductos implements IControladorProductos {
    private VentanaProductos ventana;
    private static ControladorProductos instancia;
    
    private ControladorProductos() {
        this.ventana = new VentanaProductos(this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
    }
    
    public static ControladorProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorProductos();
        }
        
        instancia.ventana.setVisible(true);
       
        return instancia;
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
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
        IControladorAMProducto controladorNuevoProducto = ControladorAMProductos.instanciar(null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
//        IControladorAMProducto controladorModificarProducto = ControladorAMProductos.instanciar(null);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
