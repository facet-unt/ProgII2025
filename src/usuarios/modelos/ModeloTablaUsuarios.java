/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author juamp
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import interfaces.IGestorUsuarios;
import usuarios.modelos.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Modelo para JTable de Usuarios (View Helper).
 */
public class ModeloTablaUsuarios extends AbstractTableModel {

    private List<String> nombreColumnas = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public ModeloTablaUsuarios() {
        IGestorUsuarios gp = GestorUsuarios.instanciar();
        this.listaUsuarios = gp.verUsuarios();
    }
    private static final String[] columnas
            = {"Apellido", "Nombre", "Correo", "Clave", "Perfil"};


    public void actualizarTabla() {
        IGestorUsuarios gestor = GestorUsuarios.instanciar();

        this.listaUsuarios = gestor.verUsuarios();

        if (this.listaUsuarios == null) {
            this.listaUsuarios = new ArrayList<>();
        }

       
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Usuario p = listaUsuarios.get(fila);

        switch (columna) {
            case 0:
                return p.verApellido();
            case 1:
                return p.verNombre();
            case 2:
                return p.verCorreo();
            case 4:
                return p.verPerfil();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnas[i];
    }

    public void actualizarTabla(List<Usuario> listaFiltrada) {
        this.listaUsuarios = listaFiltrada;
        this.fireTableDataChanged();
    }

    public Usuario obtenerUsuario(int fila) {
        return listaUsuarios.get(fila);
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
