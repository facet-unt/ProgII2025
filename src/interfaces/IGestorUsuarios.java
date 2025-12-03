/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author damia
 */
public interface IGestorUsuarios {
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    /**
     * Crea un usuario
     * @param correo
     * @param apellido
     * @param nombre
     * @param perfil
     * @param clave
     * @param claveRepetida
     * @return Devuelve un String con el resultado de la operacion
     */
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    /**
     * 
     * @return Devuelve una lista con todos los usuarios
     */
    public List<Usuario> verUsuarios();
    /**
     * Busca los usuarios por apellido
     * @param apellido
     * @return Devuelve una lista con los usuarios con el apellido ingresado
     */
    public List<Usuario> buscarUsuarios(String apellido);
    /**
     * Borra un usuario
     * @param usuario
     * @return Devuelve un String con el resultado de la operacion
     */
    public String borrarUsuario(Usuario usuario); 
    /**
     * 
     * @param usuario
     * @return Devuelve true si existe el usuario ingresado
     */
    public boolean existeEsteUsuario(Usuario usuario);
    /**
     * Busca un usuario por su correo
     * @param correo
     * @return Devuelve el usuario con el correo ingresado
     */
    public Usuario obtenerUsuario(String correo);
}
