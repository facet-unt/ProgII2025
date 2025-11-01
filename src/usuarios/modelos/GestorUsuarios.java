/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author Gaston
 */
public class GestorUsuarios {
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_CLAVE = "La clave especificada no es valida";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    private GestorUsuarios(){
    }
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String validacion = validarDatos(correo, apellido, nombre, clave, claveRepetida);
        if(!validacion.equals(VALIDACION_EXITO)) return validacion;
        Usuario u;
        return EXITO;
    }
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u : usuarios)
            if(u.verApellido().equals(apellido.toLowerCase())) usuariosEncontrados.add(u);
        return usuariosEncontrados;
    }
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u : usuarios)
            if(u.equals(usuario)) return true;
        return false;
    }
    public Usuario obtenerUsuario(String correo){
        for(Usuario u : usuarios)
            if(u.verCorreo().equals(correo.toLowerCase())) return u;
        return null;
    }
    private String validarDatos (String correo, String apellido, String nombre, String clave, String claveRepetida){
        if(correo == null || !correo.contains("@") ) return ERROR_CORREO;
        if(apellido == null || apellido.isBlank()) return ERROR_APELLIDO;
        if(nombre == null || nombre.isBlank()) return ERROR_NOMBRE;
        if(clave == null || clave.isBlank()) return ERROR_CLAVE;
        if((claveRepetida == null || claveRepetida.isBlank()) || !claveRepetida.equals(clave)) return ERROR_CLAVES;
        
        return VALIDACION_EXITO;
    }
    
}