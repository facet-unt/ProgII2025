/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marshmello
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private String[] ATRIBUTOS = {"Apellido", "Nombre", "Correo", "Perfil"};
    private List<Usuario> Usuarios = new ArrayList<>();

    public ModeloTablaUsuarios() {
        
    }

    public void asignarUsuarios(List<Usuario> usuario){
        this.Usuarios = usuario;
        this.fireTableDataChanged();
    }
    
    
    @Override
    public int getRowCount() {
        return Usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return ATRIBUTOS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario us = this.Usuarios.get(rowIndex);
        switch(columnIndex){
            case 0:
                return us.verApellido();
            case 1:
                return us.verNombre();
            case 2:
                return us.verCorreo();
            case 3:
                return us.verPerfil();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return ATRIBUTOS[i]; 
    }
    
    //Se elige un usuario segun la fila seleccionada
    public Usuario seleccionarUsuario(int i){
        return this.Usuarios.get(i);
    }
}  
