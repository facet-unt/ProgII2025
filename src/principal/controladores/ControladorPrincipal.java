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
 * @author damia
 */
public class ControladorPrincipal implements IControladorPrincipal{
    static VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    public static void main(String[] args) {
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setTitle(TITULO);
        ventanaPrincipal.setVisible(true);
    }
    @Override
    public void btnProductosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Esta seguro que quiere salir?");
        if(opcion == JOptionPane.YES_OPTION){
            ventanaPrincipal.dispose();
            System.exit(0);
        }
    }
}
