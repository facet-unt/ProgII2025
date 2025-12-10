package principal.controladores;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;

public class ModeloTablaUsuarios extends AbstractTableModel {

    List<String> nombreColumnas = new ArrayList();
    List<Usuario> usuarios = new ArrayList();

    public ModeloTablaUsuarios() {
        nombreColumnas.add("Apellidos");
        nombreColumnas.add("Nombres");
        nombreColumnas.add("Correo");
        this.actualizarTabla();
    }

    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int filasIndex, int columnasIndex) {
        Usuario u = this.usuarios.get(filasIndex);
        switch (columnasIndex) {
            case 0:
                return u.verApellido();
            case 1:
                return u.verNombre();

            case 2:
                return u.verCorreo();
            default:
                return u.getClass().getSimpleName();
        }
    }

    public void actualizarTabla() {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        ((GestorUsuarios) gu).cargarArchivoEnLista();
        usuarios = gu.verUsuarios();
        Collections.sort(usuarios);

        this.fireTableDataChanged();
    }

    public void actualizarTabla(List<Usuario> usuarios) {
        Collections.sort(usuarios);
        this.usuarios = usuarios;

        this.fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return this.nombreColumnas.get(column);
    }

    public Usuario obtenerUsuario(int fila) {
        return usuarios.get(fila);
    }
}
