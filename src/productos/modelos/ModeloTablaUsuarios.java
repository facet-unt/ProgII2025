/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;

/**
 *
 * @author Erika
 */
public class ModeloTablaUsuarios extends AbstractTableModel {

    public static final String COLUMNA_APELLIDO = "Apellido";
    public static final String COLUMNA_NOMBRE = "Nombre";
    public static final String COLUMNA_PERFIL = "Perfil";
    public static final String COLUMNA_CORREO = "Correo";

    private List<Usuario> usuarios = new ArrayList<>();
    
    public ModeloTablaUsuarios() {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.usuarios = gu.verUsuarios();
    }
    
    public ModeloTablaUsuarios(String CadenaBusqueda) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.usuarios = gu.buscarUsuarios(CadenaBusqueda);
    }
    
    
    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return COLUMNA_APELLIDO;
            case 1:
                return COLUMNA_NOMBRE;
            case 2:
                return COLUMNA_PERFIL;
            default:
                return COLUMNA_CORREO;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Usuario usuario = this.usuarios.get(fila);
        switch (columna) {
            case 0:
                return usuario.verApellido();
            case 1: 
                return usuario.verNombre();
            case 2:
                return usuario.verPerfil();
            default:
                return usuario.verCorreo();
        }
    }
    
    public Usuario usuarioAsignado(int fila){
        return usuarios.get(fila);
    }

}
