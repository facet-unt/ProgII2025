/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import productos.modelos.GestorProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author NEW GAME
 */
public class ControladorVentanaProductos implements IControladorProductos {

    private VentanaProductos ventana;
    IGestorProductos gestorproductos = GestorProductos.instanciar();
    
    
    public ControladorVentanaProductos() {
        
        this.ventana = new VentanaProductos(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        
        
    }

    

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        
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
