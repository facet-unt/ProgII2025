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
 * @author ortiz
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private List<Usuario> usuarios = new ArrayList<>();
    private String[] columnas = {"Perfil","Apellido", "Nombre","correo"};
    private Usuario usuario;

    public ModeloTablaUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    public String getColumnName(int col) {
        return columnas[col];
    }
    @Override
    public Object getValueAt(int fila, int columna) {
        usuario = usuarios.get(fila);
        return switch (columna) {
            case 0 -> usuario.verPerfil();
            case 1 -> usuario.verApellido();
            case 2 -> usuario.verNombre();
            case 3 -> usuario.verCorreo();
            default -> null;
        };
    }
    @Override
    public boolean isCellEditable(int fila, int col) {
        return true;
    }
    
    public void setUsuarios(List<Usuario> nuevaLista) {
        this.usuarios = nuevaLista;
        fireTableDataChanged();
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
        fireTableRowsInserted(usuarios.size() - 1, usuarios.size() - 1);
    }

    public void actualizarUsuario(int fila, Usuario u) {
        usuarios.set(fila, u);
        fireTableRowsUpdated(fila, fila);
    }

    public void eliminarUsuario(int fila) {
        usuarios.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }
    
}
