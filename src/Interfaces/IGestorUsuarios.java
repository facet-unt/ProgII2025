package Interfaces;

import java.util.ArrayList;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

public interface IGestorUsuarios {
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario escincorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    ArrayList<Usuario> verUsuarios();
    ArrayList<Usuario> buscarUsuarios(String apellido);
    String borrarUsuario(Usuario usuario);
    boolean existeEsteUsuario(Usuario usuario);
    Usuario obtenerUsuario(String correo);
}