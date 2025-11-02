/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import usuarios.modelos.Perfil;

/**
 *
 * @author tobias150
 */
public class GestorUsuarios {
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios(){
        
    }

    public static GestorUsuarios instanciarclase(){
        if (instancia == null){
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    public static final String EXITO = "Usuario creado/modificado con éxito";
    
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo"; 
    
    public static final String VALIDACION_EXITO = "Los datos del usuario socorrectos";
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String resultado = validarValores(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        if (obtenerUsuario(correo) != null){
            return USUARIOS_DUPLICADOS;
        }
               
        Usuario u = null;
        switch (perfil){
            case CLIENTE:
                u = new Cliente(correo, clave, apellido, nombre, perfil);
                break;
            case EMPLEADO:
                u = new Empleado(correo, clave, apellido, nombre, perfil);
                break;
            case ENCARGADO:
                u = new Encargado(correo, clave, apellido, nombre, perfil);
                break;
            default:
                return ERROR_PERFIL;
                
         
        }
       
        usuarios.add(u);
        return EXITO;
    }
    
    private String validarValores(String correo, String apellido, String nombre, Perfil perfil, String clave, String claverepetida){
        if (correo.isEmpty() || !correo.contains("@")){
            return ERROR_CORREO;
        }
        
        if (apellido.isEmpty() || apellido == null){
            return ERROR_APELLIDO;
        }
        
        if (nombre.isEmpty() || nombre == null){
            return ERROR_NOMBRE;
        }
        
        if (clave == null && clave.isEmpty() && claverepetida.isEmpty() && !claverepetida.equals(clave)){
            return ERROR_CLAVES;
        }
        
        if (perfil == null){
            return ERROR_PERFIL;
        }
        
        return VALIDACION_EXITO;
    }
    
    public ArrayList<Usuario> verUsuarios(){
        return this.usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> buscados = new ArrayList<>();
        
        for(Usuario u : usuarios){
            if (u.verApellido().equals(apellido)){
                buscados.add(u);
            }
        }
                
        return buscados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        if (usuarios.contains(usuario)){
            return true;
        }
        else
            return false;
    }
    
    public Usuario obtenerUsuario(String correo){
        for (Usuario u : usuarios){
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }
    
}

