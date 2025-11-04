/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author karen
 */
public class GestorUsuarios {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";

    private static GestorUsuarios instancia;

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
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
            case ENCARGADO -> {
                Encargado E = new Encargado(correo, clave, apellido, nombre);
                if (usuarios.contains(E)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(E);
                break;
            }

            case EMPLEADO -> {
                Empleado e = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(e);
                break;
            }

            case CLIENTE -> {
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);
                break;
            }
            default -> {
                return ERROR_PERFIL;
            }
        }
        return EXITO;
    }

    public ArrayList<Usuario> verUsuarios() {
        return usuarios;
    }

    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> buscados = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.verApellido().contains(apellido)) {
                buscados.add(u);
            }
        }
        return buscados;
    }

    public boolean existeEsteUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return usuarios.contains(usuario);
        }
        
         return false;
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
