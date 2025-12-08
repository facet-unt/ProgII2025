/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ortiz
 */
public class ModeloTablaProductos extends AbstractTableModel{
    IGestorProductos gestorProductos = GestorProductos.instanciar();
    private String[] columnas = {"Categoria","Descripcion", "Precio","Estado"};
    private Producto producto;

    @Override
    public int getRowCount() {
        return gestorProductos.menu().size();
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
        producto = gestorProductos.menu().get(fila);
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
    
}
