/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.vistas;

import productos.modelos.Producto;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo para JTable de Productos (View Helper).
 */
public class ModeloTablaProducto extends AbstractTableModel {

    private static final String[] NOMBRES_COLUMNAS = 
        {"Categoría", "Código", "Descripción", "Precio", "Estado"};
    
    private List<Producto> productos = new ArrayList<>();

    public void setProductos(List<Producto> productos) {
        this.productos = (productos != null) ? productos : new ArrayList<>();
        this.fireTableDataChanged();
    }
    
    public Producto obtenerProducto(int fila) {
        if (fila >= 0 && fila < productos.size()) {
            return productos.get(fila);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return NOMBRES_COLUMNAS.length;
    }

    @Override
    public String getColumnName(int columna) {
        return NOMBRES_COLUMNAS[columna];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto p = productos.get(fila);
        switch (columna) {
            case 0: return p.verCategoria().verValor(); 
            case 1: return p.verCodigo();
            case 2: return p.verDescripcion();
            case 3: return String.format("%.2f", p.verPrecio()); // Formato de precio
            case 4: return p.verEstado().verValor(); 
            default: return null;
        }
    }
}