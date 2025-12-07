/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
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
    public static final String BORRADO_EXITO = "Se borro correctamente el usuario";
    public static final String BORRADO_ERROR = "Error al borrar el usuario ";
    public static final String CREACION_ERROR = "Error al crear el archivo de usuarios";
    public static final String LECTURA_OK = "Se pudieron leer los usuarios";
    public static final String CREACION_OK = "Se pudo crear el archivo de usuarios";
    public static final String ESCRITURA_OK = "Se pudieron guardar los usuarios";
    public static final String ESCRITURA_ERROR = "Error al guardar los usuarios";
    public static final String LECTURA_ERROR = "Error al leer los usuarios";

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);

    public String borrarUsuario(Usuario usuario);

    public boolean existeEsteUsuario(Usuario usuario);

    public Usuario obtenerUsuario(String correo);

    public List<Usuario> verUsuarios();

    public List<Usuario> buscarUsuarios(String apellido);
    
    public String modificarUsuario(Usuario usuario, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
}
