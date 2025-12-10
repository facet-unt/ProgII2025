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
        this.ventana.setResizable(false);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void ControladorVentana () {
        this.ventana.setVisible(true);
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        IControladorProductos cvp = new ControladorVentanaProductos();
        
        
        
    }
    @Override
    public void btnUsuariosClic(ActionEvent evt) {
       IControladorUsuarios controladorUsuarios = new ControladorVentanaUsuarios(ventana);
       
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int accion = JOptionPane.showConfirmDialog(this.ventana, "Esta seguro que quiere salir?", "Salir", JOptionPane.YES_NO_OPTION);
        
        if(accion == 0){
            this.ventana.dispose();
            System.exit(0);
        }
    }
    
    
    
}
