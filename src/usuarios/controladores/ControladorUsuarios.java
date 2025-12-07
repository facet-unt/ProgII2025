/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IGestorUsuarios;
import interfaces.IControladorUsuarios;
import static interfaces.IControladorUsuarios.CONFIRMACION;
import static interfaces.IControladorUsuarios.TITULO;
import usuarios.vistas.VentanaUsuarios;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.modelos.Usuario;
import usuarios.modelos.GestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elame
 */
public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaUsuarios vista;
    private IGestorUsuarios gestor;
    private int filaSeleccionada = -1;

    public ControladorUsuarios(VentanaUsuarios vista) {
        this.vista = vista;
        this.gestor = GestorUsuarios.instanciar();
        this.vista.setTitle(TITULO);
        inicializar();
    }

    private void inicializar() {
        agregarListenerATabla();
        cargarDatos("");
    }

    private void agregarListenerATabla() {
        vista.getTabla().getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (vista.getTabla().getSelectedRow() != -1) {
                    this.filaSeleccionada = vista.getTabla().getSelectedRow();
                }
            }
        });
    }

    private void cargarDatos(String apellido) {
        ArrayList<Usuario> usuarios;
        if (apellido.isEmpty()) {
            usuarios = (ArrayList<Usuario>) gestor.verUsuarios();
        } else {
            usuarios = new ArrayList<>();
            for (Usuario u : gestor.verUsuarios()) {
                if (u.verApellido() != null && u.verApellido().toUpperCase().contains(apellido.toUpperCase())) {
                    usuarios.add(u);
                }
            }
        }

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Perfil");

        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{
                u.verApellido(),
                u.verNombre(),
                u.verCorreo(),
                u.obtenerPerfil().toString()
            });
        }
        vista.setModeloTabla(modelo);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        VentanaAMUsuario vAMU = new VentanaAMUsuario(new ControladorAMUsuario(null, vista), vista, true);
        vAMU.setVisible(true);
        cargarDatos(vista.getTextApellido());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un usuario para modificar");
            return;
        }
        String correo = (String) vista.getTabla().getValueAt(filaSeleccionada, 2);
        Usuario usuario = gestor.obtenerUsuario(correo);
        VentanaAMUsuario vAMU = new VentanaAMUsuario(new ControladorAMUsuario(usuario, vista), vista, true);
        vAMU.setVisible(true);
        cargarDatos(vista.getTextApellido());
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un usuario para borrar");
            return;
        }
        int respuesta = JOptionPane.showConfirmDialog(vista, CONFIRMACION, "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String correo = (String) vista.getTabla().getValueAt(filaSeleccionada, 2);
            Usuario usuario = gestor.obtenerUsuario(correo);
            String resultado = gestor.borrarUsuario(usuario);
            JOptionPane.showMessageDialog(vista, resultado);
            cargarDatos(vista.getTextApellido());
            filaSeleccionada = -1;
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        cargarDatos(vista.getTextApellido());
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        cargarDatos(vista.getTextApellido());
    }

    @Override
    public void txtApellidoPresionarTecla(ActionEvent evt) {
        cargarDatos(vista.getTextApellido());
    }
}
