/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import productos.modelos.GestorProductos;
import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IControladorUsuarios;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {
    private VentanaPrincipal vista;
      
    public ControladorVentanaPrincipal() {
        this.vista = new VentanaPrincipal(this);
        this.vista.setLocationRelativeTo(null); 
        this.vista.setVisible(true); 
        this.vista.setTitle(TITULO); 
    }
    
    @Override
    public void btnProductosClic(ActionEvent evt) {
        IControladorProductos cp = new ControladorVentanaProductos(vista);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios cu = new ControladorVentanaUsuarios(vista);
    }

    
    @Override
    public void btnSalirClic(ActionEvent evt) {
   
    if(javax.swing.JOptionPane.showConfirmDialog(vista,IControladorPrincipal.AVISO,
                    IControladorPrincipal.CONFIRMAR, 0) == 0)
        System.exit(0);

    }

    

    
}
