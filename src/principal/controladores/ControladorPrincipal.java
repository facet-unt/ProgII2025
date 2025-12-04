/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author pedri
 */
public class ControladorPrincipal implements IControladorPrincipal {
    
    private VentanaPrincipal ventanaPrincipal;
    
    public ControladorPrincipal(){
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setTitle(TITULO);
        ventanaPrincipal.setVisible(true);
    }
    
     
        
    public static void main(String[] args) {
        IControladorPrincipal cp = new ControladorPrincipal();
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        /*
        IControladorUsuarios cu = new ControladorUsuarios(ventanaPrincipal);
 */ //Debemos crear el controlador usuariios, sino da error
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
