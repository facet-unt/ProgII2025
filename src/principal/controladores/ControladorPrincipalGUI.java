/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import javax.swing.UIManager;
import productos.vistas.VentanaAMProducto;
//import usuarios.vistas.VentanaAMCliente;
//import usuarios.vistas.VentanaAMEmpleado;
//import usuarios.vistas.VentanaAMEncargado;

/**
 *
 * @author mariana
 */
public class ControladorPrincipalGUI {
    public static void main(String[] args) {
    //Trabajamos con una ventana por vez
    //Para todas las ventanas lo pasos son:
    /*
    * Asigna el look and feel "Nimbus" a la ventana
    * Se crea la ventana
    * Se centra la ventana
    * Se asigna un título a la ventana
    * Se hace visible la ventana
    */
        establecerLookAndFeel("Nimbus");
        // PRODUCTO
        VentanaAMProducto ventanaProducto = new VentanaAMProducto(null);
        ventanaProducto.setLocationRelativeTo(null);
        ventanaProducto.setTitle("Nuevo producto");
        ventanaProducto.setVisible(true);

        //CLIENTE

//        VentanaAMCliente ventana_cliente = new VentanaAMCliente(null);
//        ventana_cliente.setLocationRelativeTo(null);
//        ventana_cliente.setTitle("Nuevo cliente");
//        ventana_cliente.setVisible(true);

       //EMPLEADO
//
//        VentanaAMEmpleado ventana_empleado = new VentanaAMEmpleado(null);
//        ventana_empleado.setLocationRelativeTo(null);
//        ventana_empleado.setTitle("Nuevo empleado");
//        ventana_empleado.setVisible(true);
//
//       //ENCARGADO
//
//        VentanaAMEncargado ventana_encargado = new VentanaAMEncargado(null);
//        ventana_encargado.setLocationRelativeTo(null);
//        ventana_encargado.setTitle("Nuevo encargado");
//        ventana_encargado.setVisible(true);

    }

    /**
     * Asigna el look and feel especificado a la ventana
     * @param laf cadena con el nombre del look and feel
     */
    public static void establecerLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {

                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e2) {
            }
        }
    }
}