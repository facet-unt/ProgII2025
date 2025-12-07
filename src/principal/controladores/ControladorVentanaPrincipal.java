package principal.controladores;


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

        // Asociar eventos de la vista a los métodos de la interfaz
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
        VentanaUsuarios vUsuarios = new VentanaUsuarios();
        new ControladorUsuarios(vUsuarios); 
        
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

