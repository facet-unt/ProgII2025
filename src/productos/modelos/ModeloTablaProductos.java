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
     
    
    
    public void setTablaProductos (List <Producto> pr) {
        this.listaproductos = pr;
        
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
       Producto pr = listaproductos.get(rowIndex);
        switch(columnIndex) {
            case 0: return pr.verCategoria();
            case 1: return pr.verDescripcion();
            case 2: return pr.verPrecio();
            default: return null; 
    }
    }
}
