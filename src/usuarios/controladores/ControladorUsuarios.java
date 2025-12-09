/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import usuarios.modelos.ModeloTablaUsuarios;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.*;
import java.util.List;
import usuarios.vistas.*;
import usuarios.modelos.*;

/**
 *
 * @author juamp
 */
public class ControladorUsuarios implements IControladorUsuarios {

    private VentanaUsuarios vp;
    private ModeloTablaUsuarios modelo;

    public ControladorUsuarios() {
        this.vp = new VentanaUsuarios(this);

        this.modelo = new ModeloTablaUsuarios();

        this.vp.getTablaUsuarios().setModel(this.modelo);
    }

    public void mostrarVentanaUsuarios() {

        this.modelo.actualizarTabla();

        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.modelo.actualizarTabla();
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMUsuario cvprod = new ControladorAMUsuario(false);
        cvprod.mostrarVentanaAMUsuario();
        this.modelo.actualizarTabla();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int fila = vp.getTablaUsuarios().getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vp, "Seleccione un usuario para modificar.");
            return;
        }
        Usuario usuarioSeleccionado = modelo.obtenerUsuario(fila);

        ControladorAMUsuario controladorAM = new ControladorAMUsuario(true);

        controladorAM.inicializarModificacion(usuarioSeleccionado);

        controladorAM.mostrarVentanaAMUsuario();

        this.modelo.actualizarTabla();
    }
    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila = vp.getTablaUsuarios().getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vp, "Seleccione un usuario para borrar.");
            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(vp,
                "¿Seguro que desea borrar este usuario?",
                "Confirmar Borrado",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            Usuario p = modelo.obtenerUsuario(fila);

            IGestorUsuarios gestor = GestorUsuarios.instanciar();
            String resultado = gestor.borrarUsuario(p);

            javax.swing.JOptionPane.showMessageDialog(vp, resultado);
            modelo.actualizarTabla();
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vp.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnBuscarClic(null);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String texto = vp.getCampoDescripcion().getText().trim();

        IGestorUsuarios gestor = GestorUsuarios.instanciar();

        if (texto.isEmpty()) {
            modelo.actualizarTabla();
        } else {
            List<Usuario> filtrados = gestor.buscarUsuarios(texto);
            modelo.actualizarTabla(filtrados);
        }
    }
}

