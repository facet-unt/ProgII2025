package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel{
    private String[] columnas = {"Categoría", "Descripción", "Precio"};
    private List<Producto> productos = new ArrayList<>();

    public ModeloTablaProductos() {
    }
    
    public void setProductos(List <Producto> p){
        this.productos = p;
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
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> p.verCategoria();
            case 1 -> p.verDescripcion();
            case 2 -> p.verPrecio();
            default -> null;
        };
    }
    

    public Producto ProductoFila(int fila) { 
    return this.productos.get(fila); 
    
    }

}

