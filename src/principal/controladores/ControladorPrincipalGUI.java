package principal.controladores;

import javax.swing.UIManager;
import productos.vistas.VentanaAMProducto;
import usuarios.vistas.VentanaAMCliente;
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
        VentanaAMProducto ventana = new VentanaAMProducto(null);
//        ventana.setLocationRelativeTo(null); //ahora en VentanaAMProducto, cambiar ventana, por una referencia (this.)
//        ventana.setTitle("Nuevo producto");  //ahora en VentanaAMProducto, cambiar ventana, por una referencia (this.)
//        ventana.setVisible(true);    //ahora en VentanaAMProducto, cambiar ventana, por una referencia (this.)
        
        //CLIENTE
      
//<<<<<<< HEAD
//        VentanaAMCliente ventana1 = new VentanaAMCliente(null);
//        ventana.setLocationRelativeTo(null);
//        ventana.setTitle("Nuevo cliente");
//        ventana.setVisible(true);
//              
//       //EMPLEADO 
//       
//////        VentanaAMEmpleado ventana2 = new VentanaAMEmpleado(null);
//        ventana.setLocationRelativeTo(null);
//        ventana.setTitle("Nuevo empleado");
//        ventana.setVisible(true);
//        
//       //ENCARGADO
//       
////        VentanaAMEncargado ventana3 = new VentanaAMEncargado(null);
//        ventana.setLocationRelativeTo(null);
//        ventana.setTitle("Nuevo encargado");
//        ventana.setVisible(true);
//
//        VentanaAMCliente ventanaCliente = new VentanaAMCliente(null);
//        ventanaCliente.setLocationRelativeTo(null);
//        ventanaCliente.setTitle("Nuevo cliente");
//        ventanaCliente.setVisible(true);
              
       //EMPLEADO 
       
//        VentanaAMEmpleado ventanaEMpleado = new VentanaAMEmpleado(null);
//        ventanaEMpleado.setLocationRelativeTo(null);
//        ventanaEMpleado.setTitle("Nuevo empleado");
//        ventanaEMpleado.setVisible(true);
//         
//       //ENCARGADO
//       
//        VentanaAMEncargado ventanaENcargado = new VentanaAMEncargado(null);
//        ventanaENcargado.setLocationRelativeTo(null);
//        ventanaENcargado.setTitle("Nuevo encargado");
//        ventanaENcargado.setVisible(true);

       
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