/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class GestorUsuarios {

    private ArrayList<Usuario> usuario = new ArrayList<>();
    private static GestorUsuarios instancia;

    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario esincorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden oson incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con esecorreo";
    public static final String VALIDACION_EXITO = "Los datos del usuario soncorrectos";

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public String crearUsuario(String correo, String clave, String apellido, String nombre) {

        if (correo == null || correo.trim().isEmpty()) {
            return ERROR_CORREO;
        }
        if (clave == null || clave.trim().isEmpty()) {
            return ERROR_CLAVES;
        }
        if (apellido == null || clave.trim().isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || clave.trim().isEmpty()) {
            return ERROR_NOMBRE;
        }
        Usuario neuvoUsuario = new Empleado(correo, clave, apellido, nombre);
        usuario.add(neuvoUsuario);

        return EXITO;
    }

    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        for (Usuario u : usuario) {
            if (u.verApellido() == apellido) {
                return this.usuario;
            }
        }
        return null;
    }

    public boolean existeEsteUsuario(Usuario usuario) {
        for (Usuario u : this.usuario) {
            if (!(u.equals(usuario))) {
                return false;
            }
        }
        return true;
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuario) {
            if (u.verCorreo() == correo) {
                return u;
            }
        }
            return null;
    }
}
