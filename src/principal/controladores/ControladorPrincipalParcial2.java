/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import productos.controladores.ControladorProductos;
import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;

/**
 *
 * @author irica
 */
public class ControladorPrincipalParcial2 implements IControladorPrincipal {

   private VentanaPrincipal ventana;

    public ControladorPrincipalParcial2() {
        //IGestorProductos gp = GestorProductos.instanciar();
        //List<Producto> productos = gp.menu();
        //System.out.println(productos.size());
        
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        /* Centra la ventana */
        
        /* La hace visible */
        this.ventana.setTitle(TITULO);
        this.ventana.setVisible(true);
    }
//    public void mostrarVentanaPrincipal() {
//        ventana.setVisible(true);
//    }

    //los botones de esta clase solamente crea controladores y inicializa las ventanas
    @Override
    public void botonProductosClic(ActionEvent evt) {

        IControladorProductos cvprod = new ControladorProductos();
        //cvprod.mostrarVentanaProducto();

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

        IControladorPrincipal cvp = new ControladorPrincipalParcial2();
        //cvp.mostrarVentanaPrincipal();

    }

}

