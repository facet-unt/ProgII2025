/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.controladores;

import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import productos.modelos.Categoria;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author elame
 */
public class ControladorProductos implements IControladorProductos {

    private VentanaProductos vista;
    private IGestorProductos gestor;
    private int filaSeleccionada = -1;

    public ControladorProductos(VentanaProductos vista) {
        this.vista = vista;
        this.vista.setTitle(TITULO);
        this.gestor = GestorProductos.instanciar();
        inicializar();
    }
    private void inicializar() {
        agregarListenerATabla();
        cargarDatos("");
    }
    private void agregarListenerATabla() {
        vista.getTabla().getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (vista.getTabla().getSelectedRow() != -1) {
                    this.filaSeleccionada = vista.getTabla().getSelectedRow();
                }
            }
        });
    }

    private void cargarDatos(String descripcion) {
        ArrayList<Producto> productos;
        if (descripcion.isEmpty()) {
            productos = (ArrayList<Producto>) gestor.menu();
        } else {
            productos = new ArrayList<>();
            for (Producto u : gestor.menu()) {
                if (u.verDescripcion() != null && u.verDescripcion().toUpperCase().contains(descripcion.toUpperCase())) {
                    productos.add(u);
                }
            }
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");

        for (Producto u : productos) {
            modelo.addRow(new Object[]{
                u.verCategoria(),
                u.verDescripcion(),
                u.verPrecio(),});
        }
        vista.setModeloTabla(modelo);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        cargarDatos(vista.getTextDescripcion());
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        cargarDatos(vista.getTextDescripcion());
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        new ControladorAMProductos(vista, null);
        cargarDatos(vista.getTextDescripcion());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto para modificar");
            return;
        }
        // Get the code from the selected row (first column with category, second with description)
        // We need to find the product by description since the table shows category, description, price
        String descripcionSeleccionada = (String) vista.getTabla().getValueAt(filaSeleccionada, 1);
        Float precioSeleccionado = (Float) vista.getTabla().getValueAt(filaSeleccionada, 2);
        
        // Find the product in the gestor
        Producto productoAModificar = null;
        for (Producto p : gestor.menu()) {
            if (p.verDescripcion().equals(descripcionSeleccionada) && p.verPrecio() == precioSeleccionado) {
                productoAModificar = p;
                break;
            }
        }
        
        if (productoAModificar != null) {
            new ControladorAMProductos(vista, productoAModificar);
            cargarDatos(vista.getTextDescripcion());
        } else {
            JOptionPane.showMessageDialog(vista, "No se pudo encontrar el producto seleccionado");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un producto para borrar");
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(vista, CONFIRMACION, "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String descripcionSeleccionada = (String) vista.getTabla().getValueAt(filaSeleccionada, 1);
            Float precioSeleccionado = (Float) vista.getTabla().getValueAt(filaSeleccionada, 2);
            
            // Find the product in the gestor
            Producto productoABorrar = null;
            for (Producto p : gestor.menu()) {
                if (p.verDescripcion().equals(descripcionSeleccionada) && p.verPrecio() == precioSeleccionado) {
                    productoABorrar = p;
                    break;
                }
            }
            
            if (productoABorrar != null) {
                String resultado = gestor.borrarProducto(productoABorrar);
                JOptionPane.showMessageDialog(vista, resultado);
                if (resultado.equals(IGestorProductos.PRODUCTO_BORRADO)) {
                    gestor.crearYescribirArchivo();
                    cargarDatos(vista.getTextDescripcion());
                    filaSeleccionada = -1;
                }
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo encontrar el producto seleccionado");
            }
        }
    }

}
