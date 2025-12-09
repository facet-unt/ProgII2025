/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import productos.modelos.Producto;

/**
 *
 * @author Lyan
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private String[] columnas = {"Apellido", "Nombre", "Correo"};
    private List<Usuario> usuarios = new ArrayList<>();
    
    /*Constructor*/
    public ModeloTablaUsuarios() {
    }
    
    public void setUsuarios(List <Usuario> u){
        this.usuarios = u;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    /*Asigna los valores a las columnas*/
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        switch(columnIndex){
            case 0: return u.verApellido();
            case 1: return u.verNombre();
            case 2: return u.verCorreo();
            default: return null;
        }
    }
    
    
    public Usuario obtenerUsuarioEnFila(int fila) {
      
    return this.usuarios.get(fila); 
    
    }
}
