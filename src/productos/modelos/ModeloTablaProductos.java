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
 * @author salut
 */
public class ModeloTablaProductos extends AbstractTableModel{
    private IGestorProductos gp = GestorProductos.instanciar();
    private List<Producto> productos = new ArrayList<>();
    private static final List<String> nombresColumnas = new ArrayList<>(List.of("Categoría", "Código", "Descripción", "Precio","Estado"));
    
    
    public ModeloTablaProductos(){
        this.productos = gp.menu();
    }

    public ModeloTablaProductos(String busqueda){
        this.productos = gp.buscarProductos(busqueda);
    }
   
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return nombresColumnas.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = productos.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return p.verCategoria().toString();
            case 1:
                return p.verCodigo();
            case 2:
                return p.verDescripcion();
            case 3:
                return p.verPrecio();
            case 4:
                return p.verEstado().toString();
            default: return null;
        }
    }
    
}
