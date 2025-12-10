/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author damia
 */
public class ControladorAMUsuario implements IControladorAMUsuario {
    private VentanaAMUsuario ventanaUsuario;
    private GestorUsuarios gu = GestorUsuarios.instanciar();
    Usuario usuarioAModificar;

    public ControladorAMUsuario(VentanaAMUsuario ventanaUsuario) {
        this.ventanaUsuario = ventanaUsuario;
    }
    
    public void ventanaObtenerFoco(WindowEvent evt){
        String correo = ventanaUsuario.verTxtCorreo().getText().trim();
        String apellido = ventanaUsuario.verTxtApellido().getText().trim();
        String nombre = ventanaUsuario.verTxtNombre().getText().trim();
        String clave = ventanaUsuario.verPassClave().getText().trim();
        switch (ventanaUsuario.getTitle()) {
            case "Modificar encargado":
                {
                    usuarioAModificar = new Encargado(correo, clave, apellido, nombre);
                    break;
                }
            case "Modificar empleado":
                {
                    usuarioAModificar = new Empleado(correo, clave, apellido, nombre);
                    break;
                }
            case "Modificar cliente":
                {
                    usuarioAModificar = new Encargado(correo, clave, apellido, nombre);
                    break;
                }
            default:
                {
                    break;
                }
        }  
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String mensaje;
        String correo = ventanaUsuario.verTxtCorreo().getText().trim();
        String apellido = ventanaUsuario.verTxtApellido().getText().trim();
        String nombre = ventanaUsuario.verTxtNombre().getText().trim();
        String clave = ventanaUsuario.verPassClave().getText().trim();
        String claveRepetida = ventanaUsuario.verPassClaveRepetida().getText().trim();
        switch (ventanaUsuario.getTitle()) {
            case "Nuevo encargado":
                {
                    mensaje = gu.crearUsuario(correo, apellido, nombre, Perfil.ENCARGADO, clave, claveRepetida);
                    break;
                }
            case "Nuevo empleado":
                {
                    mensaje = gu.crearUsuario(correo, apellido, nombre, Perfil.EMPLEADO, clave, claveRepetida);
                    break;
                }
            case "Nuevo cliente":
                {
                    mensaje = gu.crearUsuario(correo, apellido, nombre, Perfil.CLIENTE, clave, claveRepetida);
                    break;
                }
            case "Modificar encargado":
                {
                    mensaje = gu.modificarUsuario(usuarioAModificar, correo, apellido, nombre, clave, claveRepetida);
                    break;
                }
            case "Modificar empleado":
                {
                    mensaje = gu.modificarUsuario(usuarioAModificar, correo, apellido, nombre, clave, claveRepetida);
                    break;
                }
            case "Modificar cliente":
                {
                    mensaje = gu.modificarUsuario(usuarioAModificar, correo, apellido, nombre, clave, claveRepetida);
                    break;
                }
            default:
                {
                    mensaje = "Hay un error con el titulo de la ventana";
                    break;
                }
        }
        if (mensaje.equals(IGestorUsuarios.EXITO)) {
            JOptionPane.showMessageDialog(ventanaUsuario, mensaje);
            ventanaUsuario.dispose();
        } else {
            JOptionPane.showMessageDialog(ventanaUsuario, mensaje);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventanaUsuario, "¿Esta seguro que quiere volver? El usuario no sera guardado");
        if (opcion == JOptionPane.YES_OPTION) {
            ventanaUsuario.dispose();
        }
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
