/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import static interfaces.IControladorAMProducto.TITULO_NUEVO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import productos.vistas.VentanaCrearProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author ortiz
 */
public class ControladorCrearProductos implements IControladorAMProducto {
    private static ControladorCrearProductos instancia;
    private VentanaProductos ventanaProductos;
    private VentanaCrearProductos ventanaCrearProductos;

    public ControladorCrearProductos() {
        ventanaCrearProductos = new VentanaCrearProductos(ventanaProductos,this);
        ventanaCrearProductos.setLocationRelativeTo(ventanaProductos);
        ventanaCrearProductos.setTitle(TITULO_NUEVO);    
        ventanaCrearProductos.setVisible(true); 
        ventanaCrearProductos.toFront();
        ventanaCrearProductos.requestFocus();
        ventanaCrearProductos.requestFocusInWindow();
//        ventanaProductos.setAlwaysOnTop(false);
//        ventanaProductos.toBack();
    }
    
    public static ControladorCrearProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorCrearProductos();
        }
        return instancia;
    }    
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaCrearProductos.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
