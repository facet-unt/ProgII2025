/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Producto;

/**
 *
 * @author Lyan
 */
public class ModeloTablaProductos extends AbstractTableModel{
    private String[] columnas = {"Categoría", "Descripción", "Precio"};
    private List<Producto> productos = new ArrayList<>();

    /*Constructor*/
    public ModeloTablaProductos() {
    }
    
    /*Metodo para recibir la lista de los productos*/ 
    public void setProductos(List <Producto> p){
        this.productos = p;
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
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.verCategoria();
            case 1: return p.verDescripcion();
            case 2: return p.verPrecio();
            default: return null;
        }
    }
    

    public Producto obtenerProductoEnFila(int fila) {
        
    return this.productos.get(fila); 
    
    }

}
