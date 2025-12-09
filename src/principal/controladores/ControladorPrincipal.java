package principal.controladores;   // <-- poné el package que uses

import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.controladores.ControladorUsuarios;

public class ControladorPrincipal implements IControladorPrincipal {

    private VentanaPrincipal ventanaPrincipal;

    public ControladorPrincipal() {
        this.ventanaPrincipal = new VentanaPrincipal(this);
        this.ventanaPrincipal.setLocationRelativeTo(null);
        this.ventanaPrincipal.setTitle(TITULO);
        this.ventanaPrincipal.setVisible(true);
    }

   
    public static void main(String[] args) {
        ControladorPrincipal cp =  new ControladorPrincipal();
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        // abrimos la ventana de usuarios
        IControladorUsuarios cu = new ControladorUsuarios(this.ventanaPrincipal);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        // ESTE era el que te daba error: uso la sobrecarga correcta (4 parámetros)
        int opcion = JOptionPane.showConfirmDialog(
                this.ventanaPrincipal,
                "¿Seguro que desea salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            this.ventanaPrincipal.dispose();
        }
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {
        IControladorProductos cProd = new ControladorUsuarios(this.ventanaPrincipal);
    }

    public void btnPedidosClic(ActionEvent evt) {
        JOptionPane.showMessageDialog(this.ventanaPrincipal,"Funcionalidad de Pedidos aún no está implementada.","Información",JOptionPane.INFORMATION_MESSAGE);
    }
}
