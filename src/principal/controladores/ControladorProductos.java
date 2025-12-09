package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

public class ControladorProductos implements IControladorProductos {

    private VentanaProductos vp;
    private ModeloTablaProductos modelo;

    public ControladorProductos() {
        this.vp = new VentanaProductos(this);
        this.modelo = new ModeloTablaProductos();
        this.vp.getTableMenu().getTableHeader().setResizingAllowed(false);
        this.vp.getTableMenu().getTableHeader().setReorderingAllowed(false);
        this.vp.getTableMenu().setModel(this.modelo);
    }

    public void mostrarVentanaProducto() {
        this.modelo.actualizarTabla();
        vp.setLocationRelativeTo(null);
        vp.setTitle("Productos");
        vp.setVisible(true);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.modelo.actualizarTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vp.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String texto = vp.getFieldDescripcion().getText().trim();
        IGestorProductos gestor = GestorProductos.instanciar();
        if (texto.isEmpty()) {
            modelo.actualizarTabla();
        } else {
            List<Producto> filtrados = gestor.buscarProductos(texto);
            modelo.actualizarTabla(filtrados);
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        this.btnBuscarClic(null);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto cvprod = new ControladorAMProducto();
        ((ControladorAMProducto) cvprod).mostrarVentanaProducto();
        this.modelo.actualizarTabla();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int fila = vp.getTableMenu().getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vp, "Seleccione un producto para modificar.");
            return;
        }
        Producto productoSeleccionado = modelo.obtenerProducto(fila);
        IControladorAMProducto controladorAM = new ControladorAMProducto();
        ((ControladorAMProducto) controladorAM).inicializarModificacion(productoSeleccionado);
        ((ControladorAMProducto) controladorAM).mostrarVentanaProducto();
        this.modelo.actualizarTabla();
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila = vp.getTableMenu().getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vp, "Seleccione un producto para borrar.");
            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(vp,
                "¿Seguro que desea borrar este producto?",
                "Confirmar Borrado",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            Producto p = modelo.obtenerProducto(fila);
            IGestorProductos gestor = GestorProductos.instanciar();
            String resultado = gestor.borrarProducto(p);
            javax.swing.JOptionPane.showMessageDialog(vp, resultado);
            modelo.actualizarTabla();
        }
    }
}
