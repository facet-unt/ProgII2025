/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

/**
 *
 * @author Orlando
 */
import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;

public class ModeloTablaProductos extends AbstractTableModel {

    private List<String> nombreColumnas = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();

    private String[] columnas = {"Categoría", "Descripción", "Precio"};

    private List<Producto> listaProductos = new ArrayList<>();

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
        Producto p = listaProductos.get(fila);

        switch (columna) {
            case 0:
                return p.verCategoria();   
            case 1:
                return p.verDescripcion(); 
            case 2:
                return p.verPrecio();     
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

    public void actualizarTabla() {
        IGestorProductos gestor = GestorProductos.instanciar();
        this.listaProductos = gestor.menu();
        this.fireTableDataChanged();
    }

    public void actualizarTabla(List<Producto> listaFiltrada) {
        this.listaProductos = listaFiltrada;
        this.fireTableDataChanged();
    }

    public Producto obtenerProducto(int fila) {
        return listaProductos.get(fila);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
