/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author salut
 */
public class GestorUsuarios {
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if(!(correo.contains("@"))||correo.equals(null)){
            return ERROR_CORREO;
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario u = new Cliente(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario u = new Empleado(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario u = new Encargado(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        return EXITO;
    }
    
    public String modificarUsuario(Usuario u, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if(!(correo.contains("@"))||correo.equals(null)){
            return ERROR_CORREO;
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario usuarioModificado = new Cliente(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario usuarioModificado = new Empleado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario usuarioModificado = new Encargado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        return EXITO;
    }
    
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido().contains(apellido)){
                usuariosEncontrados.add(u);
            }
        }
        return usuariosEncontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.equals(usuario)){
                return true;
            }
        }
        return false;
    }
    
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }
}
