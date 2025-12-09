/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo para JTable de Productos (View Helper).
 */
public class ModeloTablaProducto extends AbstractTableModel {
    
    private List<String> nombreColumnas = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    
    public ModeloTablaProducto() {
//        actualizarTabla();
        IGestorProductos gp = GestorProductos.instanciar();
        this.productos = gp.menu();
    }

    private static final String[] columnas = 
        {"Código", "Descripción", "Precio", "Categoría", "Estado"};
    
    

//    public void setProductos(List<Producto> productos) {
//        this.productos = (productos != null) ? productos : new ArrayList<>();
//        this.fireTableDataChanged();
//    }
    
    public void actualizarTabla() {
        IGestorProductos gestor = GestorProductos.instanciar();
        this.productos = gestor.menu();
        this.fireTableDataChanged();
    }

     @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto p = productos.get(fila);
        switch (columna) {
            case 0:
                return p.verCodigo();
            case 1:
                return p.verDescripcion(); 
            case 2:
                return p.verPrecio();  
            case 3:
                return p.verCategoria().toString();
            default:
                return p.verEstado().toString();
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

    public void actualizarTabla(List<Producto> listaFiltrada) {
       this.productos = listaFiltrada;
        this.fireTableDataChanged();
    }

    public Producto obtenerProducto(int fila) {
        return productos.get(fila);
    }

//    @Override
//    public boolean isCellEditable(int row, int col) {
//        return false;
//    }
}