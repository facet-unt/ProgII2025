package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel {
    
    private List<Producto> productos = new ArrayList<>();
    private final List<String> columnas = new ArrayList<>();

    public ModeloTablaProductos() {
        columnas.add("Categoría");
        columnas.add("Descripción");
        columnas.add("Precio");

        IGestorProductos gp = GestorProductos.instanciar();
        this.productos = gp.menu();
        ordenarProductos(this.productos);
    }

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnas.get(col);
    }

    @Override
    public Object getValueAt(int fila, int col) {

        Producto p = productos.get(fila);

        switch (col) {
            case 0: return p.verCategoria() == null ? "" : p.verCategoria();
            case 1: return p.verDescripcion() == null ? "" : p.verDescripcion();
            case 2: return p.verPrecio();
            default: return null;
        }
    }

    public void actualizarDatosTabla() {
        IGestorProductos gp = GestorProductos.instanciar();
        this.productos = gp.menu();
        ordenarProductos(this.productos);
        this.fireTableDataChanged();
    }

    public void actualizarDatosTabla(List<Producto> lista) {
        this.productos = lista;
        ordenarProductos(this.productos);
        this.fireTableDataChanged();
    }

    public List<Producto> obtenerProductos() {
        return productos;
    }
    
    private void ordenarProductos(List<Producto> lista) {
        lista.sort((p1, p2) -> {
            String cat1 = String.valueOf(p1.verCategoria());
            String cat2 = String.valueOf(p2.verCategoria());
            int cmp = cat1.compareToIgnoreCase(cat2);

            if (cmp == 0) {
                String desc1 = String.valueOf(p1.verDescripcion());
                String desc2 = String.valueOf(p2.verDescripcion());
                cmp = desc1.compareToIgnoreCase(desc2);
            }
            return cmp;
        });
    }
}