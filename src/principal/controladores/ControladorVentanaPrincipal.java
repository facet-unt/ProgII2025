/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;
/**
 *
 * @author Usuario
 */


import Interfaces.IControladorPrincipal;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaUsuarios;
import productos.vistas.VentanaProductos;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal vista;

    public ControladorVentanaPrincipal(VentanaPrincipal vista) {
        this.vista = vista;
        vista.getBtnUsuarios().addActionListener(this::btnUsuariosClic);
        vista.getBtnProductos().addActionListener(this::btnProductosClic);
        vista.getBtnSalir().addActionListener(this::btnSalirClic);
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        new VentanaProductos().setVisible(true);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        // --- CORRECCIÓN AQUÍ ---
        // Tu ventana pide (Frame, boolean), así que se los pasamos:
        // 'vista' es la ventana principal (Frame) y 'true' es para que sea modal
        VentanaUsuarios vUsuarios = new VentanaUsuarios(vista, true);
        
        // Creamos el controlador
        new ControladorUsuarios(vUsuarios); 
        
        // Mostramos la ventana
        vUsuarios.setVisible(true);
    }    

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Desea salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}