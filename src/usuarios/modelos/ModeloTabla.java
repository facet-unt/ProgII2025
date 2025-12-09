package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

    private List<Usuario> usuarios = new ArrayList<>();
    private final List<String> nombresColumnas = new ArrayList<>();

    public ModeloTabla() {
        // columnas visibles en el JTable
        this.nombresColumnas.add("Apellido");
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Perfil");

        // cargar usuarios desde el gestor
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.usuarios = gu.verUsuarios();
    }

    @Override
    public int getRowCount() {
        return this.usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    @Override
    public Object getValueAt(int fila, int columna) {

        Usuario usuario = usuarios.get(fila);

        switch (columna) {
            case 0:
                return usuario.verApellido();
            case 1:
                return usuario.verNombre();
            case 2:
                if (usuario instanceof Cliente) {
                    return Perfil.CLIENTE.toString();
                } else if (usuario instanceof Empleado) {
                    return Perfil.EMPLEADO.toString();
                } else {
                    return Perfil.ENCARGADO.toString();
                }
        }
        return "Error";
    }

    public void actualizarDatosTabla() {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.usuarios = gu.verUsuarios();
        this.fireTableDataChanged(); // refrescar JTable
    }

    public void actualizarDatosTabla(List<Usuario> nuevaLista) {
        this.usuarios = nuevaLista;
        this.fireTableDataChanged();
    }

    public List<Usuario> obtenerUsuarios() {
        return this.usuarios;
    }

    public void asignarUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        this.fireTableDataChanged();
    }
}