/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marshmello
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private String[] ATRIBUTOS = {"Apellido", "Nombre", "Correo", "Perfil"};
    private List<Usuario> Usuarios;
    private GestorUsuarios gestor;
    private int filaSeleccionada;

    public ModeloTablaUsuarios() {
        this.gestor = GestorUsuarios.instanciarclase();
        this.Usuarios = new ArrayList<>();
        fireTableDataChanged();
    }

    public void cargarUsuariosOrdenados(){
        this.Usuarios = gestor.leerUsuarios();
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return this.Usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.ATRIBUTOS.length;
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
    public String getColumnName(int columnIndex) {
        return ATRIBUTOS[columnIndex]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    //Se elige un usuario segun la fila seleccionada
    public Usuario seleccionarUsuario(int i){
        if(i == 0 || i >= this.Usuarios.size()){
            return null;
        }
        return this.Usuarios.get(i);
    }
    
}  
