/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author damia
 */
public class ModeloTablaUsuarios implements TableModel {
    private List<TableModelListener> listeners = new ArrayList<>();
    private List<Usuario> usuarios;
    
    //Constructor

    public ModeloTablaUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return Usuario.class.getDeclaredFields().length - 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Correo";
             case 1:
                return "Apellido";
            case 2:
                return "Nombre";
            case 3:
                return "Perfil";
            default:
               return "Out of Bounds";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Perfil.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return (String)(usuarios.get(rowIndex).verCorreo());
            case 1:
                return (String)usuarios.get(rowIndex).verApellido();
            case 2:
                return (String)usuarios.get(rowIndex).verNombre();
            case 3:
                return (Perfil)usuarios.get(rowIndex).verPerfil();
            default:
                return (String)("?");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
               usuarios.get(rowIndex).asignarCorreo((String)aValue);
                break;
            case 1:
               usuarios.get(rowIndex).asignarApellido((String)aValue);
                break;
            case 2:
               usuarios.get(rowIndex).asignarNombre((String)aValue);
                break;
            case 3:
               usuarios.get(rowIndex).asignarPerfil((Perfil)aValue);
                break;
            default:
                System.out.println("Ingrese un numero de columna correcto");
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.add(l);
    }
    
    
}
