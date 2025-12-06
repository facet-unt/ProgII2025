/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import productos.vistas.VentanaProductos;

/**
 *
 * @author sofia
 */
public class ControladorProductos implements IControladorProductos{
    
    private VentanaProductos vp; //se instancia en constructor
    
    public ControladorProductos() {
        this.vp = new VentanaProductos(this); //cada controlador crea su ventana
    }
    
    public void mostrarVentanaProducto(){
        vp.setVisible(true);
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
    }
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        //buscarenteoria
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vp.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
       
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMProducto cvprod =new ControladorAMProducto();
        cvprod.mostrarVentanaProducto();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        ControladorAMProducto cvprod =new ControladorAMProducto();
        cvprod.mostrarVentanaProducto();
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
    }
    
}
