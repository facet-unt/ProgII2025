/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import javax.swing.UIManager;
import productos.vistas.VentanaAMProducto;
import usuarios.vistas.VentanaAMCliente;
import usuarios.vistas.VentanaAMEmpleado;
import usuarios.vistas.VentanaAMEncargado;

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
        VentanaAMProducto ventana = new VentanaAMProducto(null);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Nuevo producto");
        ventana.setVisible(true);
        
        //CLIENTE
      /*Modificar el método main() de la clase ControladorPrincipalGUI y agregar el código para que
        muestre las ventanas que permiten crear clientes, empleados y encargados.*///(esto fue lo que hice)
        VentanaAMCliente ventanaCliente = new VentanaAMCliente(null); 
        ventanaCliente.setLocationRelativeTo(null); //la ubico en el centro de la pantalla
        ventanaCliente.setTitle("Nuevo Cliente"); //quiero que tenga por titulo eso
        ventanaCliente.setVisible(true); //quiero que la ventana sea  visible
       
     
       //EMPLEADO 
       
        VentanaAMEmpleado ventanaEmpleado = new VentanaAMEmpleado(null);
        ventanaEmpleado.setLocationRelativeTo(null);
        ventanaEmpleado.setTitle("Nuevo Empleado");
        ventanaEmpleado.setVisible(true);
       //ENCARGADO
       
       VentanaAMEncargado ventanaEncargado = new VentanaAMEncargado(null);
       ventanaEncargado.setLocationRelativeTo(null);
       ventanaEncargado.setTitle("Nuevo Encargado");
       ventanaEncargado.setVisible(true);
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