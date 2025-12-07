/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NEW GAME
 */
public class ModeloTablaProductos extends AbstractTableModel {
    private String[] columnasproducto = {"Categoria" , "Descripcion" , "Precio"};
    private List<Producto> listaproductos = new ArrayList<>();

    public ModeloTablaProductos() {
    }
     
    @Override
    public int getRowCount() {
        return listaproductos.size();
    }

    @Override
    public int getColumnCount() {
        return columnasproducto.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
    }
    
}
