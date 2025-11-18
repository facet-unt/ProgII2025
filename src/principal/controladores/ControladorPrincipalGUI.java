package principal.controladores;

import javax.swing.UIManager;
import productos.vistas.VentanaAMProducto;
import usuarios.vistas.VentanaAMCliente;
import usuarios.vistas.VentanaAMEmpleado;
import usuarios.vistas.VentanaAMEncargado;

public class ControladorPrincipalGUI {
    public static void main(String[] args) {
        
        establecerLookAndFeel("Nimbus"); 
        // PRODUCTO
        VentanaAMProducto ventanaProducto = new VentanaAMProducto(null);
        
    }
    
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