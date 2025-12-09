/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import usuarios.modelos.*;
import usuarios.vistas.*;

/**
 *
 * @author juamp
 */
public class ControladorAMUsuario implements IControladorAMUsuario {

    private VentanaAMUsuario vp; //se instancia en constructor
    private Usuario usuarioAEditar;
    private boolean esModificacion = false;

    public ControladorAMUsuario(Boolean modificar) {
        this.vp = new VentanaAMUsuario(null, this);
        this.esModificacion = modificar;
    }

    public void mostrarVentanaAMUsuario() {
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
        if (this.esModificacion) {
            vp.setTitle(TITULO_MODIFICAR);
        } else {
            vp.setTitle(TITULO_NUEVO);
        }
        vp.setVisible(true);
        
    }

    public void inicializarModificacion(Usuario unUsuario) {
        this.usuarioAEditar = unUsuario;

        vp.verTxtApellido().setText(unUsuario.verApellido());
        vp.verTxtNombre().setText(unUsuario.verNombre());
        vp.verTxtCorreo().setEditable(false);
        vp.verTxtClave().setText(unUsuario.verClave());
        vp.verTxtClaveRepetida().setText(unUsuario.verClave());
        vp.verComboPerfiles().setSelectedItem(unUsuario.verPerfil());
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

        String apellido = vp.verTxtApellido().getText().trim();
        String nombre = vp.verTxtNombre().getText().trim();
        String correo = vp.verTxtCorreo().getText().trim();
        String clave = vp.getClaveTexto();
        String claveRepetida = vp.getClaveRepetidaTexto();

        Perfil perfilSeleccionado = (Perfil) vp.verComboPerfiles().getSelectedItem();

        IGestorUsuarios gestor = GestorUsuarios.instanciar();
        String resultado = null;

        if (this.esModificacion == true) {
            System.out.println(gestor.validarUsuario(this.usuarioAEditar.verCorreo(), apellido, nombre, perfilSeleccionado, clave, claveRepetida));
            if (gestor.validarUsuario(this.usuarioAEditar.verCorreo(), apellido, nombre, perfilSeleccionado, clave, claveRepetida)) {
                this.usuarioAEditar.asignarApellido(apellido);
                this.usuarioAEditar.asignarNombre(nombre);
                this.usuarioAEditar.asignarClave(clave);
                this.usuarioAEditar.asignarPerfil(perfilSeleccionado);
                resultado = gestor.modificarUsuario(this.usuarioAEditar);
            } else {
                JOptionPane.showMessageDialog(vp, GestorUsuarios.VALORES_INVALIDOS);
                resultado=GestorUsuarios.VALORES_INVALIDOS;
            }

        } else {
            resultado = gestor.crearUsuario(correo, apellido, nombre, perfilSeleccionado, clave, claveRepetida);
        }

        JOptionPane.showMessageDialog(vp, resultado);

        if (resultado.equals(GestorUsuarios.OPERACION_EXITOSA)) {
            vp.dispose();
        }

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vp.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtNombre().requestFocus();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtCorreo().requestFocus();
        }
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verComboPerfiles().requestFocus();
        }
    }

    public void comboPerfilesPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtClave().requestFocus();
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtClaveRepetida().requestFocus();
        }
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnGuardarClic(null);
        }
    }

}
