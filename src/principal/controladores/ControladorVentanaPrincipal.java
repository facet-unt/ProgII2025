/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;
import productos.vistas.VentanaProductos;

/**
 *
 * @author sofia
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {
    private VentanaPrincipal ventana;

    public ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventana.setVisible(true); /* La hace visible */
        this.ventana.setTitle(TITULO);
    }
    
    
    
    
    public void mostrarVentanaPrincipal(){
        ventana.setVisible(true);
    }
    
    
    //los botones de esta clase solamente crea controladores y inicializa las ventanas
   
    @Override
    public void btnProductosClic(ActionEvent evt) {
        
        ControladorVentanaProducto cvprod =new ControladorVentanaProducto();
        cvprod.mostrarVentanaProducto();
        
        
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        
    }
    
    public static void main(String[] args) {
        
        ControladorVentanaPrincipal cvp= new ControladorVentanaPrincipal();
        cvp.mostrarVentanaPrincipal();
        
        
        
    }
    
}
