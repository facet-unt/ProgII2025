/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author thoma
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private List<Usuario> listaUsuarios;
    private static final String[] TITULOS = {"Apellido", "Nombre", "Correo", "Perfil"};
    
    public ModeloTablaUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return this.listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return TITULOS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = this.listaUsuarios.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return u.verApellido();
            case 1: return u.verNombre();
            case 2: return u.verCorreo();
            case 3: return u.getPerfil();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName (int columnIndex) {
        return TITULOS[columnIndex];
    }
    
    public void dibujarTabla(List<Usuario> usuarios) {
        this.listaUsuarios = usuarios;
        fireTableDataChanged();
    }
}
