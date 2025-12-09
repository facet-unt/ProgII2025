/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import productos.controladores.ControladorProductos;
import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author juamp
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventana;

    public ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal();
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setTitle(TITULO);

    }

    @Override
    public void botonProductosClic(ActionEvent evt) {
        System.out.println("Boton productos Clic");
        IControladorProductos controladorProductos= new ControladorProductos();
    }

    @Override
    public void botonUsuariosClic(ActionEvent evt) {
        System.out.println("Boton usuarios Clic");
        //IControladorUsuarios controladorUsuarios= new ControladorVentanaUsuarios();
    }

    @Override
    public void botonSalirClic(ActionEvent evt) {
        System.out.println("Boton salir Clic");
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas salir?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }
}
