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
 * @author Esteban
 */
public class ModeloTablaProductos extends AbstractTableModel {
    
    private final String[] columnas = {"Categoría", "Descripción", "Precio", "Estado"};
    private List<Producto> listaProductos;

    public ModeloTablaProductos(List<Producto> lista) {
        this.listaProductos = lista;
    }
    
    public ModeloTablaProductos() {
        this.listaProductos = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return this.listaProductos.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto p = this.listaProductos.get(fila);
        
        switch(columna) {
            case 0: return p.verCategoria();    // Columna 0: Categoría
            case 1: return p.verDescripcion();  // Columna 1: Descripción
            case 2: return p.verPrecio();       // Columna 2: Precio
            case 3: return p.verEstado();       // Columna 3: Estado
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int i) {
        return this.columnas[i];
    }
    
    public void dibujarProductosEnTabla(List<Producto> nuevaLista) {
        this.listaProductos = nuevaLista;
        this.fireTableDataChanged(); 
    }
    
    // Método auxiliar para obtener el objeto Producto de una fila seleccionada
    public Producto obtenerProducto(int fila) {
        if (fila >= 0 && fila < listaProductos.size()) {
            return listaProductos.get(fila);
        }
        return null;
    }
    
}
