/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ortiz
 */
public class ModeloTablaProductos extends AbstractTableModel{
    private List<Producto> productos = new ArrayList<>();
    private String[] columnas = {"Categoria","Descripcion", "Precio","Estado"};
    private Producto producto;

    public ModeloTablaProductos(List<Producto> productos) {
        this.productos = productos;
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
    public String getColumnName(int col) {
        return columnas[col];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        producto = productos.get(fila);
        return switch (columna) {
            case 0 -> producto.verCategoria();
            case 1 -> producto.verDescripcion();
            case 2 -> producto.verPrecio();
            case 3 -> producto.verEstado();
            default -> null;
        };
    }
    
    @Override
    public boolean isCellEditable(int fila, int col) {
        return true;
    }
    
    public void setProductos(List<Producto> nuevaLista) {
        this.productos = nuevaLista;
        fireTableDataChanged();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        fireTableRowsInserted(productos.size() - 1, productos.size() - 1);
    }

    public void actualizarProducto(int fila, Producto p) {
        productos.set(fila, p);
        fireTableRowsUpdated(fila, fila);
    }

    public void eliminarProducto(int fila) {
        productos.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }
    
    
}
