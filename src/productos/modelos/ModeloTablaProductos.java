/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author karen
 */
public class ModeloTablaProductos extends AbstractTableModel {

    public static final String COLUMNA_CATEGORIA = "Categoria";
    public static final String COLUMNA_DESCRIPCION = "Descripcion";
    public static final String COLUMNA_PRECIO = "Precio";

    private List<Producto> productos = new ArrayList<>();
    
    public ModeloTablaProductos() {
        IGestorProductos gp = GestorProductos.instanciar();
        this.productos = gp.menu();
    }
    
    public ModeloTablaProductos(String CadenaBusqueda) {
        IGestorProductos gp = GestorProductos.instanciar();
        this.productos = gp.buscarProductos(CadenaBusqueda);
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return COLUMNA_CATEGORIA;
            case 1:
                return COLUMNA_DESCRIPCION;
            default:
                return COLUMNA_PRECIO;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Producto producto = this.productos.get(fila);
        switch (columna) {
            case 0:
                return producto.verCategoria();
            case 1:
                return producto.verDescripcion();
            default:
                return producto.verPrecio();

        }
    }
    
    public Producto productoAsignado(int fila){
        return productos.get(fila);
    }

}
