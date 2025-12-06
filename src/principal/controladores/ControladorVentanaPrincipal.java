/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal{
    private VentanaPrincipal ventana;
    private static ControladorVentanaPrincipal instancia;
    
    public static ControladorVentanaPrincipal instanciar(){
        if(instancia == null)
            instancia = new ControladorVentanaPrincipal();
        return instancia;
    }
    
    public ControladorVentanaPrincipal(){
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int accion = JOptionPane.showConfirmDialog(this.ventana, "Esta Seguro que quiere salir?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if(accion == 0){
            this.ventana.dispose();
            System.exit(0);
        }
    }
    
    
    
}
