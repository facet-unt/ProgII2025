/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_APELLIDO;
import static interfaces.IGestorUsuarios.ERROR_CLAVES;
import static interfaces.IGestorUsuarios.ERROR_CORREO;
import static interfaces.IGestorUsuarios.ERROR_NOMBRE;
import static interfaces.IGestorUsuarios.ERROR_PERFIL;
import static interfaces.IGestorUsuarios.USUARIOS_DUPLICADOS;
import java.util.ArrayList;
import static productos.modelos.GestorProductos.EXITO;
import static productos.modelos.GestorProductos.VALIDACION_EXITO;

/**
 *
 * @author tobias150
 */
public class GestorUsuarios implements IGestorUsuarios{
    
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
    
    @Override
    public ArrayList<Usuario> verUsuarios(){
        return this.usuarios;
    }
    
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> buscados = new ArrayList<>();
        
        for(Usuario u : usuarios){
            if (u.verApellido().equals(apellido)){
                buscados.add(u);
            }
        }
                
        return buscados;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        if (usuarios.contains(usuario)){
            return true;
        }
        else
            return false;
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        for (Usuario u : usuarios){
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        
    }
    
}

