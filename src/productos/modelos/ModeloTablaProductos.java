/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author damia
 */
public class ModeloTablaProductos extends AbstractTableModel implements TableModel {
    private GestorProductos gp = GestorProductos.instanciar();
    private List<TableModelListener> listeners = new ArrayList<>();
    private List<Producto> productos;
    
    //Constructor

    public ModeloTablaProductos(List<Producto> productos) {
        this.productos = new ArrayList<>(productos);
    }
    
    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return Producto.class.getDeclaredFields().length - 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Codigo";
            case 1:
                return "Descripcion";
            case 2:
                return "Categoria";
            case 3:
                return "Estado";
            case 4:
                return "Precio";
            default:
                return "Out of Bounds";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Categoria.class;
            case 3:
                return Estado.class;
            case 4:
                return Float.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return (Integer)(productos.get(rowIndex).verCodigo());
            case 1:
                return (String)productos.get(rowIndex).verDescripcion();
            case 2:
                return (Categoria)productos.get(rowIndex).verCategoria();
            case 3:
                return (Estado)productos.get(rowIndex).verEstado();
            case 4:
                return (Float)productos.get(rowIndex).verPrecio();
            default:
                return (String)("?");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                productos.get(rowIndex).asignarCodigo((Integer)aValue);
                break;
            case 1:
                productos.get(rowIndex).asignarDescripcion((String)aValue);
                break;
            case 2:
                productos.get(rowIndex).asignarCategoria((Categoria)aValue);
                break;
            case 3:
                productos.get(rowIndex).asignarEstado((Estado)aValue);
                break;
            case 4:
                productos.get(rowIndex).asignarPrecio((Float)aValue);
                break;
            default:
                System.out.println("Ingrese un numero de columna correcto");
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
    
}
