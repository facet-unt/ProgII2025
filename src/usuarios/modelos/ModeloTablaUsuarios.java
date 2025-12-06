/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lazar
 */
public class ModeloTablaUsuarios extends AbstractTableModel {
    private String[] columnas = {"Apellido/s", "Nombre/s", "Correo"};
    private ArrayList<Usuario> listaProductos;
    
    public ModeloTablaUsuarios(ArrayList<Usuario> lista){
        this.listaProductos=lista;
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
        Usuario u = listaProductos.get(fila);
            switch(columna) {
            case 0: return u.verApellido();
            case 1: return u.verNombre();
            case 2: return u.verCorreo();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
}