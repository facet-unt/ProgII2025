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
        if (!descripcionTexto.equals("") && descripcionTexto != null) {
            productosPorDescripcion = gp.buscarProductos(descripcionTexto);
            TableModel modelo = new ModeloTablaProductos(productosPorDescripcion);
            ventanaProductos.verTablaProductos().setModel(modelo);
        } else {
            TableModel modelo = new ModeloTablaProductos(gp.menu());
            ventanaProductos.verTablaProductos().setModel(modelo);
        }
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
        int fila;
        fila = ventanaProductos.verTablaProductos().getSelectedRow();
        if (fila != -1) {
            int codigo;
            Producto p;
            VentanaAMProducto ventanaAMProducto = new VentanaAMProducto(ventanaProductos);
            ventanaAMProducto.setLocationRelativeTo(null);
            ventanaAMProducto.setTitle("Modificar producto");        
            ventanaAMProducto.verComboCategorias().setModel(new ModeloComboCategorias());
            ventanaAMProducto.verComboEstados().setModel(new ModeloComboEstados());
            codigo = (Integer)ventanaProductos.verTablaProductos().getValueAt(fila, 0);
            p = gp.obtenerProducto(codigo);
            ventanaAMProducto.verTxtCodigo().setText(Integer.toString(p.verCodigo()));
            ventanaAMProducto.verTxtCodigo().setEditable(false);
            ventanaAMProducto.verTxtCodigo().setToolTipText("No puede modificarse el codigo del producto");
            ventanaAMProducto.verTxtDescripcion().setText(p.verDescripcion());
            ventanaAMProducto.verTxtPrecio().setText(Float.toString(p.verPrecio()));
            ((ModeloComboCategorias)ventanaAMProducto.verComboCategorias().getModel()).seleccionarCategoria(p.verCategoria());
            ((ModeloComboEstados)ventanaAMProducto.verComboEstados().getModel()).seleccionarEstado(p.verEstado());
            ventanaAMProducto.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(ventanaProductos, "No se ha seleccionado ningun producto");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila;
        int codigo;
        Producto p; 
        fila = ventanaProductos.verTablaProductos().getSelectedRow();
        if (fila != -1) {
            int opcion = JOptionPane.showConfirmDialog(ventanaProductos, "¿Esta seguro que quiere borrar este producto?");
            codigo = (Integer)ventanaProductos.verTablaProductos().getValueAt(fila, 0);
            p = gp.obtenerProducto(codigo);
            if(opcion == JOptionPane.YES_OPTION){
                gp.borrarProducto(p);
            }
        } else {
            JOptionPane.showMessageDialog(ventanaProductos, "No se ha seleccionado ningun producto");
        }
    } 
}
