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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author thoma
 */
public class ControladorProductos implements IControladorProductos {
    private VentanaProductos ventana;
    private static ControladorProductos instancia;
    private ModeloTablaProductos modeloTabla;
    private int filaSeleccionada = -1;
    
    private ControladorProductos() {
        this.ventana = new VentanaProductos(this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        this.inicializarTabla();
        this.actualizarTabla ();
    }
    
    public static ControladorProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorProductos();
        }
        instancia.ventana.setVisible(true);
        return instancia;
    }
    
    public void inicializarTabla() {
        List<Producto> productos = GestorProductos.instanciar().menu();
        modeloTabla = new ModeloTablaProductos(productos);
        this.ventana.definirModeloTabla(modeloTabla);
        this.agregarListenerATabla(this.ventana.getTablaProductos());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String descripcionABuscar = this.ventana.verTxtDescripcion().getText().trim();
        
        List<Producto> productosAMostrar;
        
        if (descripcionABuscar.isEmpty()) {
            productosAMostrar = GestorProductos.instanciar().menu();
        } else {
            productosAMostrar = GestorProductos.instanciar().buscarProductos(descripcionABuscar);
        }
                
        this.modeloTabla = (ModeloTablaProductos) this.ventana.getTablaProductos().getModel();
        this.modeloTabla.dibujarProductosEnTabla(productosAMostrar);
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
            this.btnBuscarClic(null); 
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto controladorNuevoProducto = ControladorAMProductos.instanciar(null);
        actualizarTabla ();
    }

    @Override
public void btnModificarClic(ActionEvent evt) {
    
    if (this.filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(ventana, "Debe seleccionar un producto de la lista.");
        return;
    }
    
    this.modeloTabla = (ModeloTablaProductos) this.ventana.getTablaProductos().getModel();
    
    Producto productoSeleccionado = this.modeloTabla.obtenerProducto(this.filaSeleccionada);
    
    ControladorAMProductos.instanciar(productoSeleccionado);
    
    actualizarTabla();
}

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
        if (this.filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(ventana, "Debe seleccionar un producto para borrar.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.modeloTabla= (ModeloTablaProductos) this.ventana.getTablaProductos().getModel();
        Producto productoABorrar = this.modeloTabla.obtenerProducto(filaSeleccionada);

        int opcion = JOptionPane.showConfirmDialog(ventana, CONFIRMACION, "Borrar Producto", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            String resultado = GestorProductos.instanciar().borrarProducto(productoABorrar);
            
            JOptionPane.showMessageDialog(ventana, resultado, "Información", JOptionPane.INFORMATION_MESSAGE);
            this.filaSeleccionada = -1;
            this.actualizarTabla(); 
        }
    }
    
    private void actualizarTabla (){
        List<Producto> listaActualizada = GestorProductos.instanciar().menu();
        ModeloTablaProductos modelo = (ModeloTablaProductos) this.ventana.getTablaProductos().getModel();
        modelo.dibujarProductosEnTabla(listaActualizada);
    }
    
     //METODO para agregar listener a una tabla: 
    private void agregarListenerATabla(javax.swing.JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (tabla.getSelectedRow() != -1) {
                    this.filaSeleccionada = tabla.getSelectedRow();
                } else {
                    this.filaSeleccionada = -1; // Reseteamos si no hay selección
                }
            }
        });
    }
    
}
