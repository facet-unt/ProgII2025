/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author octav
 */
public class GestorUsuarios {
    private ArrayList<Usuario> usuarios=new ArrayList<>();
    private static GestorUsuarios instancia;
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario esincorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String cadena="El usuario se creo con exito";
        Usuario usuario= new Cliente(correo,apellido,nombre,perfil,clave,claveRepetida);
        if(correo.isEmpty()||!correo.contains("@"))
            return ERROR_CORREO;
        if(apellido.isBlank()||apellido.isEmpty())
            return ERROR_APELLIDO;
        if(nombre.isBlank()||nombre.isEmpty())
            return ERROR_NOMBRE;
        if(clave.isEmpty()||clave.isBlank())
            return ERROR_CLAVES;
        if(claveRepetida.isBlank()||claveRepetida.isEmpty()||!claveRepetida.contains(clave))
            return ERROR_CLAVES;
        if(usuarios.contains(usuario))
            return USUARIOS_DUPLICADOS;
        else
        usuarios.add(usuario);
        return EXITO;
    }
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosbuscados= new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido().toLowerCase().contains(apellido.toLowerCase()));
            usuariosbuscados.add(u);
        }
        return usuariosbuscados;
    }
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.verApellido().contentEquals(usuario.verApellido()))
             return true;       
        }
            return false;
    }
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().contentEquals(correo))
                return u;
        }
        return null;
    }
}