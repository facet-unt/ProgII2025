/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import productos.vistas.VentanaAMProducto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author damia
 */
public class ControladorVentanaProductos implements IControladorProductos{
    private VentanaProductos ventanaProductos;
    private GestorProductos gp = GestorProductos.instanciar();
    
    //Constructor
    public ControladorVentanaProductos(VentanaProductos ventanaProductos) {
        this.ventanaProductos = ventanaProductos;
    }
    
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        TableModel modelo = new ModeloTablaProductos(gp.buscarProductos(ventanaProductos.verBuscarCampoTexto().getText().trim()));
        ventanaProductos.verTablaProductos().setModel(modelo);
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaProductos.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String descripcionTexto;
        List<Producto> productosPorDescripcion = new ArrayList<>();
        descripcionTexto = ventanaProductos.verBuscarCampoTexto().getText().trim();
        productosPorDescripcion = gp.buscarProductos(descripcionTexto);
        if (!descripcionTexto.equals("") || descripcionTexto != null) {
            TableModel modelo = new ModeloTablaProductos(gp.menu());
            ventanaProductos.verTablaProductos().setModel(modelo);
        }
        TableModel modelo = new ModeloTablaProductos(productosPorDescripcion);
        ventanaProductos.verTablaProductos().setModel(modelo);
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        String descripcionTexto;
        List<Producto> productosPorDescripcion = new ArrayList<>();
        descripcionTexto = ventanaProductos.verBuscarCampoTexto().getText().trim();
        if (!descripcionTexto.equals("") && descripcionTexto != null) {
            productosPorDescripcion = gp.buscarProductos(descripcionTexto);
            if ((descripcionTexto.charAt(descripcionTexto.length() - 1) != KeyEvent.CHAR_UNDEFINED) && !evt.isActionKey()) {
                TableModel modelo = new ModeloTablaProductos(productosPorDescripcion);
                ventanaProductos.verTablaProductos().setModel(modelo);
            }
        } else {
            TableModel modelo = new ModeloTablaProductos(gp.menu());
            ventanaProductos.verTablaProductos().setModel(modelo);
        }
        
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        VentanaAMProducto ventanaAMProducto = new VentanaAMProducto(ventanaProductos);
        ventanaAMProducto.setLocationRelativeTo(null);
        ventanaAMProducto.setTitle("Nuevo producto");        
        ventanaAMProducto.verComboCategorias().setModel(new ModeloComboCategorias());
        ventanaAMProducto.verComboEstados().setModel(new ModeloComboEstados());
        ventanaAMProducto.setVisible(true);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        VentanaAMProducto ventanaAMProducto = new VentanaAMProducto(ventanaProductos);
        ventanaAMProducto.setLocationRelativeTo(null);
        ventanaAMProducto.setTitle("Modificar producto");        
        ventanaAMProducto.verComboCategorias().setModel(new ModeloComboCategorias());
        ventanaAMProducto.verComboEstados().setModel(new ModeloComboEstados());
        ventanaAMProducto.setVisible(true);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila;
        int codigo;
        Producto p;
        int opcion = JOptionPane.showConfirmDialog(ventanaProductos, "¿Esta seguro que quiere borrar este producto?");
        fila = ventanaProductos.verTablaProductos().getSelectedRow();
        codigo = (Integer)ventanaProductos.verTablaProductos().getValueAt(fila, 0);
        p = gp.obtenerProducto(codigo);
        if(opcion == JOptionPane.YES_OPTION){
            gp.borrarProducto(p);
        }
    } 

}
