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
 * @author Gaston
 */
public class ControladorPrincipal implements IControladorPrincipal {
    
    private static ControladorPrincipal instancia;
    private VentanaPrincipal vista;
    
    private ControladorPrincipal(){
        this.vista = new VentanaPrincipal(this);
        vista.setTitle(TITULO);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }
    public static ControladorPrincipal instanciar(){
        if (instancia == null)
            instancia = new ControladorPrincipal();
        return instancia;
    }
    

    @Override
    public void btnProductosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {

    }
    
    public static void main(String[] args) {
        
        ControladorPrincipal.instanciar(); 
    }
    
}
