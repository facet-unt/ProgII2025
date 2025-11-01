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
        
        establecerLookAndFeel("Nimbus"); 
        // PRODUCTO
        VentanaAMProducto ventanaProducto = new VentanaAMProducto(null);
<<<<<<< HEAD
        
=======
        ventanaProducto.setLocationRelativeTo(null);
        ventanaProducto.setTitle("Nuevo producto");
        ventanaProducto.setVisible(true);
        
        //CLIENTE
      
<<<<<<< HEAD
        VentanaAMCliente ventanaCliente = new VentanaAMCliente(null);
        ventanaCliente.setLocationRelativeTo(null);
        ventanaCliente.setTitle("Nuevo cliente");
        ventanaCliente.setVisible(true);
               
       //EMPLEADO 
       
        VentanaAMEmpleado ventanaEmpleado = new VentanaAMEmpleado(null);
        ventanaEmpleado.setLocationRelativeTo(null);
        ventanaEmpleado.setTitle("Nuevo empleado");
        ventanaEmpleado.setVisible(true);
        
       //ENCARGADO
       
        VentanaAMEncargado ventanaEncargado = new VentanaAMEncargado(null);
        ventanaEncargado.setLocationRelativeTo(null);
        ventanaEncargado.setTitle("Nuevo encargado");
        ventanaEncargado.setVisible(true);
=======
        VentanaAMCliente ventana_cliente = new VentanaAMCliente(null);
        ventana_cliente.setLocationRelativeTo(null);
        ventana_cliente.setTitle("Nuevo cliente");
        ventana_cliente.setVisible(true);
               
       //EMPLEADO 
       
        VentanaAMEmpleado ventana_empleado = new VentanaAMEmpleado(null);
        ventana_empleado.setLocationRelativeTo(null);
        ventana_empleado.setTitle("Nuevo empleado");
        ventana_empleado.setVisible(true);
        
       //ENCARGADO
       
        VentanaAMEncargado ventana_encargado = new VentanaAMEncargado(null);
        ventana_encargado.setLocationRelativeTo(null);
        ventana_encargado.setTitle("Nuevo encargado");
        ventana_encargado.setVisible(true);
>>>>>>> 15a0463680b867d69a4514c4d1d174206f6bafda
       
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
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