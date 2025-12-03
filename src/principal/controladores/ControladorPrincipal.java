/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author rocio
 */
public class ControladorPrincipal implements IControladorPrincipal {
    private VentanaPrincipal ventana;
      
    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventana.setVisible(true); /* La hace visible */
        this.ventana.setTitle(TITULO);
    }

     
    
    @Override
    public void btnProductosClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    @Override
//    public void btnSalirClic(ActionEvent evt) {
//       this.ventana.dispose(); 
//       System.exit(0);
//    }
//    
    
    @Override
    public void btnSalirClic(ActionEvent evt) {
        /* Muestra un cuadro de dialogo con botones de confirmacion, /ventana sobre la aparece el dialogo/
        mensaje/titulo de la ventana/ 0 indica los botones si/no 
        */
    if(javax.swing.JOptionPane.showConfirmDialog(ventana,"¿Seguro que quieres salir?", "Confirmar salida", 0) == 0);
    System.exit(0);

    }

    
}
