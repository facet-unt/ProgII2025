/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaDeProductos;

/**
 *
 * @author karen
 */
public class ControladorProductos implements IControladorProductos {

    private VentanaDeProductos ventanaDp;
    private int filaSeleccionada=-1;

    public ControladorProductos(JFrame VentanaPrincipal) {
        this.ventanaDp = new VentanaDeProductos(VentanaPrincipal, this);
        this.ventanaDp.setLocationRelativeTo(null);
        this.ventanaDp.setTitle(TITULO);
        this.agregarListenerATabla(this.ventanaDp.verTabla());
//        this.ventanaDp.verBotonB().setEnabled(false);
        this.ventanaDp.setVisible(true);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        JTable tablaProductos = this.ventanaDp.verTabla();
        ModeloTablaProductos mtp = new ModeloTablaProductos();
        tablaProductos.setModel(mtp);
        if (mtp.getRowCount()>0) {
            if (this.filaSeleccionada == -1) {
                this.filaSeleccionada =0;
            }
            tablaProductos.setRowSelectionInterval(0, 0);
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaDp.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaProductos mtp;
        String cadenaBusqueda = this.ventanaDp.verDescripcion().getText().trim();
        JTable tablaProductos = this.ventanaDp.verTabla();

        if (cadenaBusqueda.isEmpty()) {
            mtp = new ModeloTablaProductos();
            tablaProductos.setModel(mtp);
        } else {

            mtp = new ModeloTablaProductos(cadenaBusqueda);
            tablaProductos.setModel(mtp);
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
//        char c = evt.getKeyChar();
//        if (!Character.isLetter(c)) {
//            evt.consume();
//        }
//        this.ventanaDp.verBotonB().setEnabled(!this.ventanaDp.verDescripcion().getText().trim().isEmpty());
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto camp = new ControladorAMProducto(ventanaDp);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        JTable tablaProductos = this.ventanaDp.verTabla();
        ModeloTablaProductos mtp = (ModeloTablaProductos)tablaProductos.getModel();
        Producto p = mtp.productoAsignado(filaSeleccionada);
        IControladorAMProducto camp = new ControladorAMProducto(ventanaDp, p);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        JTable tablaProductos = this.ventanaDp.verTabla();
        this.filaSeleccionada = tablaProductos.getSelectedRow();
        if (this.filaSeleccionada!=1) {
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null, null,null);
            if (opcion==JOptionPane.YES_OPTION) {
                ModeloTablaProductos mtp=(ModeloTablaProductos)tablaProductos.getModel();
                Producto productoSele = mtp.productoAsignado(filaSeleccionada);
                if (productoSele != null) {
                    IGestorProductos gPro = GestorProductos.instanciar();
                    String resultado = gPro.borrarProducto(productoSele);
                    if (resultado.equals(IGestorProductos.EXITO_BORRADO)) {
                        mtp = new ModeloTablaProductos();
                        if (mtp.getRowCount()>0) {
                            this.filaSeleccionada =0;
                            tablaProductos.setRowSelectionInterval(0, 0);
                        }
                        else this.filaSeleccionada=-1;
                    }
                    else JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (tabla.getSelectedRow() != -1) {
                    this.filaSeleccionada = tabla.getSelectedRow();
                }
            }
        });
    }
}
