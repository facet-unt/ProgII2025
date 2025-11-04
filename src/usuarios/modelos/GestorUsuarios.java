/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import static usuarios.modelos.Perfil.EMPLEADO;

/**
 *
 * @author Orlando
 */
public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios gestor;

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    public String borrarUsuario(Usuario usuario) {
        if (usuario.verPedidos().isEmpty()) {

            usuarios.remove(usuario);
            return BORRADO_EXITO;
        }
        return BORRADO_ERROR;
    }

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || correo.isEmpty() || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (clave == null || clave.isEmpty() || claveRepetida == null || claveRepetida.isEmpty() || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }

        switch (perfil) {
            case ENCARGADO:
                Encargado e = new Encargado(correo, clave, apellido, nombre);
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(e);

                break;

            case EMPLEADO:
                Empleado en = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(en)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(en);

                break;

            case CLIENTE:
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);

                break;
            default:
                return ERROR_PERFIL;
        }
        return EXITO;
    }

    public ArrayList<Usuario> verUsuarios() {
        return usuarios;
    }

    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> usuariosBuscados = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.verApellido().contains(apellido)) {
                usuariosBuscados.add(u);
            }
        }
        return usuariosBuscados;
    }

    public boolean existeEsteUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
            if (u.verCorreo().contains(correo)) {
                return u;
            }
        }
        return null;
    }
}
