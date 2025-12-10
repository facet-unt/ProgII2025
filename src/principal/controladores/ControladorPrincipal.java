package principal.controladores;

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
        IControladorProductos cp = new productos.controladores.ControladorProductos(this.ventanaPrincipal);
    }

    public void btnPedidosClic(ActionEvent evt) {
        String mensajeFuncionalidadNoDisp = "Esta funcionalidad aún no está disponible.";
        JOptionPane.showMessageDialog(
            this.ventanaPrincipal,
            mensajeFuncionalidadNoDisp,
            "Advertencia",
            JOptionPane.INFORMATION_MESSAGE);
    }
}