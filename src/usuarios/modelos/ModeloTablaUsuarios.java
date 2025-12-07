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
 * @author salut
 */
public class ModeloTablaUsuarios extends AbstractTableModel{
    private IGestorUsuarios gu = GestorUsuarios.instanciar();
    private List<Usuario> usuarios = new ArrayList<>();
    private static final List<String> nombresColumnas = new ArrayList<>(List.of("Perfil", "Correo", "Apellido", "Nombre", "Clave"));        
    
   public ModeloTablaUsuarios(){
       this.usuarios = gu.verUsuarios();
   }
   
   public ModeloTablaUsuarios(String busqueda){
       this.usuarios = gu.buscarUsuarios(busqueda);
   }
    @Override
    public int getRowCount() {
        return usuarios.size();
 
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return nombresColumnas.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = usuarios.get(rowIndex);
        switch(columnIndex){
            case 0: 
                if(u instanceof Cliente){
                    return Perfil.CLIENTE.toString();
                }
                if(u instanceof Empleado){
                    return Perfil.EMPLEADO.toString();
                }
                if(u instanceof Encargado){
                    return Perfil.ENCARGADO.toString();
                }
                break;
            case 1:
                return u.verCorreo();
            case 2:
                return u.verApellido();
            case 3:
                return u.verNombre();
            case 4:
                return u.verClave();
            default: return null;
        }
        return null;
    }
    
}
