/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lazar
 */
public class ModeloTablaProductos extends AbstractTableModel {
    private String[] columnas = {"Categoría", "Descripción", "Precio"};
    private ArrayList<Producto> listaProductos;
    
    public ModeloTablaProductos(ArrayList<Producto> lista){
        this.listaProductos=lista;
    }
    @Override
    public int getRowCount() {
        return listaProductos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto p = listaProductos.get(fila);
            switch(columna) {
            case 0: return p.verCategoria();
            case 1: return p.verDescripcion();
            case 2: return p.verPrecio();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
}
