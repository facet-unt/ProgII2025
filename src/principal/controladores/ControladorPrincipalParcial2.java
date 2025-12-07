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
 * @author irica
 */
public class ControladorPrincipalParcial2 implements IControladorPrincipal {

   private VentanaPrincipal ventana;

    public ControladorPrincipalParcial2() {
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

    //los botones de esta clase solamente crea controladores y inicializa las ventanas
    @Override
    public void botonProductosClic(ActionEvent evt) {

        ControladorProductos cvprod = new ControladorProductos();
        cvprod.mostrarVentanaProducto();

    }

    @Override
    public void botonUsuariosClic(ActionEvent evt) {

    }

    @Override
    public void botonSalirClic(ActionEvent evt) {
        int i = JOptionPane.showOptionDialog(null, "¿Seguro que quiere salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Sí", "No"}, "No");
        if (i == 0) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        ControladorPrincipalParcial2 cvp = new ControladorPrincipalParcial2();
        cvp.mostrarVentanaPrincipal();

    }
    
}
