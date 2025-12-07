/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;
import usuarios.modelos.Usuario;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author elame
 */
public class ControladorAMUsuario implements IControladorAMUsuario {
    private VentanaAMUsuario vista;
    private IGestorUsuarios gestor;
    private Usuario usuarioEdicion;

    public ControladorAMUsuario(Usuario usuarioEdicion, VentanaUsuarios padre) {
        this.gestor = GestorUsuarios.instanciar();
        this.usuarioEdicion = usuarioEdicion;
        this.vista = new VentanaAMUsuario(this, padre, true);
        
        if (usuarioEdicion != null) {
            this.vista.setTitle(TITULO_MODIFICAR);
            cargarDatos();
        } else {
            this.vista.setTitle(TITULO_NUEVO);
        }
    }

    private void cargarDatos() {
        vista.setApellido(usuarioEdicion.verApellido());
        vista.setNombre(usuarioEdicion.verNombre());
        vista.setCorreo(usuarioEdicion.verCorreo());
        vista.setPerfil(usuarioEdicion.obtenerPerfil());
        vista.setCorreoEditable(false);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = vista.getApellido().trim();
        String nombre = vista.getNombre().trim();
        String correo = vista.getCorreo().trim();
        String clave = vista.getClave().trim();
        String claveRepetida = vista.getClaveRepetida().trim();
        Perfil perfil = vista.getPerfil();

        if (apellido.isEmpty() || nombre.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Los campos apellido, nombre y correo son obligatorios");
            return;
        }

        if (usuarioEdicion == null) {
            if (clave.isEmpty() || claveRepetida.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Para crear un nuevo usuario, la clave es obligatoria");
                return;
            }
            String resultado = gestor.crearUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);
            JOptionPane.showMessageDialog(vista, resultado);
            if (resultado.equals(IGestorUsuarios.EXITO)) {
                vista.dispose();
            }
        } else {
            if (clave.isEmpty() && claveRepetida.isEmpty()) {
                usuarioEdicion.asignarApellido(apellido);
                usuarioEdicion.asignarNombre(nombre);
                gestor.guardarArchivo();
                JOptionPane.showMessageDialog(vista, "Usuario modificado exitosamente");
                vista.dispose();
            } else if (!clave.isEmpty() || !claveRepetida.isEmpty()) {
                if (!clave.equals(claveRepetida)) {
                    JOptionPane.showMessageDialog(vista, IGestorUsuarios.ERROR_CLAVES);
                    return;
                }
                usuarioEdicion.asignarApellido(apellido);
                usuarioEdicion.asignarNombre(nombre);
                usuarioEdicion.asignarClave(clave);
                gestor.guardarArchivo();
                JOptionPane.showMessageDialog(vista, "Usuario modificado exitosamente");
                vista.dispose();
            }
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
    }
}
