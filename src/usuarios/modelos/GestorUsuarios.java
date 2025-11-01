/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import productos.modelos.Perfil;

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
        
    }
    
    public ArrayList<Usuario> verUsuarios(){
        
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        
    }
    
    public Usuario obtenerUsuario(String correo){
        
    }
    
}

