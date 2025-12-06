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
public class ControladorVentanaProducto implements IControladorProductos{
    
    private VentanaProductos vp; //se instancia en constructor
    
    public ControladorVentanaProducto() {
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
        
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
       
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
    }
    
}
