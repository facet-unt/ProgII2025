package productos.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import static interfaces.IControladorProductos.CONFIRMACION;
import static interfaces.IControladorProductos.TITULO;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;
import productos.vistas.VentanaProductos;

public class ControladorProductos implements IControladorProductos {
    
    private VentanaProductos ventanaProductos;
    private static final String PRODUCTO_NO_SELECCIONADO = "Debe seleccionar un producto de la tabla.";

    public ControladorProductos(java.awt.Frame ventanaPadre) {
        this.ventanaProductos = new VentanaProductos(ventanaPadre, true, this);
        this.ventanaProductos.verTablaProductos().setModel(new ModeloTablaProductos());
        this.ventanaProductos.setLocationRelativeTo(null);
        this.ventanaProductos.setTitle(TITULO);
        this.ventanaProductos.setVisible(true);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        VentanaAMProducto ventanaAM = new VentanaAMProducto(this.ventanaProductos, null);
        IControladorAMProducto controlador = new ControladorAMProducto(ventanaAM, null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        
        int fila = this.ventanaProductos.verTablaProductos().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this.ventanaProductos, PRODUCTO_NO_SELECCIONADO, "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        ModeloTablaProductos modelo = (ModeloTablaProductos) this.ventanaProductos.verTablaProductos().getModel();
        Producto p = modelo.obtenerProductos().get(fila);

        VentanaAMProducto ventanaAM = new VentanaAMProducto(this.ventanaProductos, p);
        IControladorAMProducto controlador = new ControladorAMProducto(ventanaAM, p);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
        int fila = this.ventanaProductos.verTablaProductos().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this.ventanaProductos, PRODUCTO_NO_SELECCIONADO, "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        ModeloTablaProductos modelo = (ModeloTablaProductos) this.ventanaProductos.verTablaProductos().getModel();
        Producto p = modelo.obtenerProductos().get(fila);

        int opcion = JOptionPane.showOptionDialog(this.ventanaProductos, CONFIRMACION, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Sí", "No"}, "Sí");

        if (opcion == JOptionPane.YES_OPTION) {
            IGestorProductos gp = GestorProductos.instanciar();
            gp.borrarProducto(p);
            modelo.actualizarDatosTabla();
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.actualizarDatosTabla();
        this.ventanaProductos.verTxtDescripcion().setText("");
    }

    private void actualizarDatosTabla() {
        AbstractTableModel modelo = (AbstractTableModel) this.ventanaProductos.verTablaProductos().getModel();

        ((ModeloTablaProductos) modelo).actualizarDatosTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaProductos.dispose();
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.btnBuscarClic(null);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
        String desc = this.ventanaProductos.verTxtDescripcion().getText().trim();

        ModeloTablaProductos modelo = (ModeloTablaProductos) this.ventanaProductos.verTablaProductos().getModel();

        if (!desc.isEmpty()) {
            List<Producto> coincidencias = GestorProductos.instanciar().menu().stream().filter(p -> p.verDescripcion() != null && p.verDescripcion().toLowerCase().contains(desc.toLowerCase())).toList();
            modelo.actualizarDatosTabla(coincidencias);
        } else {
            modelo.actualizarDatosTabla();
        }
    }
}