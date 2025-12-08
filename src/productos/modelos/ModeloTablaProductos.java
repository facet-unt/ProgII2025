/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NEW GAME
 */
public class ModeloTablaProductos extends AbstractTableModel {
    
    private String[] columnas = {"Categoría", "Descripción", "Estado"};
    private List<Producto> listaProductos;
    private GestorProductos gestor;
    private int filaSeleccionada;
    
    
    public ModeloTablaProductos() {
        this.gestor = GestorProductos.instanciar();
        this.listaProductos = new ArrayList<>();
        cargarTodos();
    }
    
    // Cargar todos los productos ordenados
    public void cargarTodos() {
        this.listaProductos = gestor.leerProductos();
        fireTableDataChanged();
    }
    
    // Buscar por descripción
    public void buscarPorDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            cargarTodos();
            return;
        }
        
        // Buscar productos que contengan la descripción
        List<Producto> todos = gestor.menu();
        this.listaProductos = new ArrayList<>();
        
        for (Producto p : todos) {
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                this.listaProductos.add(p);
            }
        }
        
        fireTableDataChanged();
    }
    
    // Filtrar por categoría
    public void filtrarPorCategoria(Categoria categoria) {
        this.listaProductos = gestor.verProductosPorCategoria(categoria);
        fireTableDataChanged();
    }
    
    // Obtener producto de una fila
    public Producto obtenerProducto(int fila) {
        if (fila >= 0 && fila < listaProductos.size()) {
            return listaProductos.get(fila);
        }
        return null;
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
    public String getColumnName(int column) {
        return columnas[column];
    }
    
     @Override
    public Object getValueAt(int filaproducto, int columnas) {
        Producto p = listaProductos.get(filaproducto);
            switch(columnas) {
            case 0: return p.verCategoria();
            case 1: return p.verDescripcion();
            case 2: return p.verPrecio();
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    private void agregarListenerATabla(JTable tabla) {
    tabla.getSelectionModel().addListSelectionListener((e) -> {
    if (!e.getValueIsAdjusting()) {


    if (tabla.getSelectedRow() != -1)
    this.filaSeleccionada = tabla.getSelectedRow();
}
});
}
}
