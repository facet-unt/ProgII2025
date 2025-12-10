package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel {

    private String[] columnas = { "Categoría", "Descripción", "Precio",};
    private List<Producto> listaProductos = new ArrayList<>();
    
    // ✅ CORREGIDO: Singleton compartido
    private final IGestorProductos gestor = GestorProductos.instanciar();

    public ModeloTablaProductos() {
        actualizarTabla();
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
        if (fila < 0 || fila >= listaProductos.size()) {
            return null;
        }
        
        Producto p = listaProductos.get(fila);

        switch (columna) {
            case 0:
                return p.verCategoria();
            case 1:
                return p.verDescripcion();    
            case 2:
                return String.format("$%.2f", p.verPrecio()); 
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

    // ✅ CORREGIDO: Usa el gestor singleton
    public void actualizarTabla() {
        this.listaProductos = gestor.menu();
        System.out.println("Productos en tabla: " + listaProductos.size());
        this.fireTableDataChanged();
    }

    // ✅ NUEVO: Actualizar con lista filtrada
    public void actualizarTabla(List<Producto> listaFiltrada) {
        this.listaProductos = new ArrayList<>(listaFiltrada);
        this.fireTableDataChanged();
    }

    public Producto obtenerProducto(int fila) {
        if (fila < 0 || fila >= listaProductos.size()) {
            return null;
        }
        return listaProductos.get(fila);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}

