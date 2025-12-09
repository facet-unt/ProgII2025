/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.vistas.VentanaProductos;
import usuarios.vistas.VentanaUsuarios;

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
        VentanaProductos ventanaProductos = new VentanaProductos(ventanaPrincipal, true);
        ventanaProductos.setLocationRelativeTo(null);
        ventanaProductos.setTitle(IControladorProductos.TITULO);
        ventanaProductos.setVisible(true);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        VentanaUsuarios ventanaUsuarios = new VentanaUsuarios(ventanaPrincipal, true);
        ventanaUsuarios.setLocationRelativeTo(null);
        ventanaUsuarios.setTitle(IControladorUsuarios.TITULO);
        ventanaUsuarios.setVisible(true);
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
