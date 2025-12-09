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
    public static final String COLUMNA_CODIGO = "Codigo";
    public static final String COLUMNA_ESTADO = "Estado";

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
        return 5;
    }

    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return COLUMNA_CATEGORIA;
            case 1:
                return COLUMNA_DESCRIPCION;
            case 2:
                return COLUMNA_PRECIO;
            case 3:
                return COLUMNA_ESTADO;
            default:
                return COLUMNA_CODIGO;
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
            case 2:
                return producto.verPrecio();
            case 3:
                return producto.verEstado();
            default:
                return producto.verCodigo();

        }
    }

    public Producto productoAsignado(int fila) {
        return productos.get(fila);
    }

}
