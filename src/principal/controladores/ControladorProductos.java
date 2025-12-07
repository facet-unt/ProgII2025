/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
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
            tablaProductos.setRowSelectionInterval(this.filaSeleccionada, 0);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("apreto");
                if (tabla.getSelectedRow() != -1) {
                    this.filaSeleccionada = tabla.getSelectedRow();
                    System.out.println(filaSeleccionada);
                }
            }
        });
    }
}
