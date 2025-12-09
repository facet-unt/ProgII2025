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

/**
 *
 * @author sofia
 */
public class ControladorPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventana;

    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        /* Centra la ventana */
        this.ventana.setVisible(true);
        /* La hace visible */
        this.ventana.setTitle(TITULO);
    }

    public void mostrarVentanaPrincipal() {
        ventana.setVisible(true);
    }

    //los botones de esta clase solamente crea controladores e inicializa las ventanas
    @Override
    public void btnProductosClic(ActionEvent evt) {

        IControladorProductos cvprod = new ControladorProductos();
        ((ControladorProductos) cvprod).mostrarVentanaProducto();

    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios cvu = new ControladorUsuarios();
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int i = JOptionPane.showOptionDialog(null, "¿Seguro que quiere salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
        if (i == 0) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        IControladorPrincipal cvp = new ControladorPrincipal();
        ((ControladorPrincipal) cvp).mostrarVentanaPrincipal();
    }

}
