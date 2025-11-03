/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;


/**
 *
 * @author Asus
 */
public class GestorUsuarios { 
     private ArrayList<Usuario> usuarios = new ArrayList<>();
     private static GestorUsuarios instancia;
     public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
     
     public static final String EXITO = "Usuario creado/modificado con éxito";
public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
     
     public String crearUsuario(String Correo, String Clave, String Nombre, String Apellido, String claveRepetida, Perfil perfil){
         if (Correo == null || !Correo.contains("@") || Correo.trim().isEmpty()){
             return ERROR_CORREO;
         }else if (Apellido == null || Apellido.trim().isEmpty()){
         return ERROR_APELLIDO;
         }else if (Nombre == null || Nombre.trim().isEmpty()) {
         return ERROR_NOMBRE;
         }else if (Clave == null || Clave.trim().isEmpty() ||claveRepetida == null || claveRepetida.trim().isEmpty()){
         return ERROR_CLAVES;
         }
         if (perfil == Perfil.CLIENTE){
         Usuario u = new Cliente (Correo, Clave, Nombre, Apellido);
         }else if (perfil == Perfil.EMPLEADO){
         Usuario u = new Empleado (Correo, Clave, Nombre, Apellido);
         }else if (perfil == Perfil.ENCARGADO){
         Usuario u = new Encargado (Correo, Clave, Nombre, Apellido);
         }
         return EXITO;
     }         

     public ArrayList<Usuario> verUsuarios(){
         return this.usuarios;
         }
     public boolean existeEsteUsuario(Usuario usuario){
         if (usuarios.contains(usuario))
              return true;
             else
             return false;
        }


     public ArrayList<Usuario> buscarUsuarios(String apellido){
         ArrayList <Usuario> encontrados = new ArrayList<>();
         for (Usuario u : usuarios){
             if (u.verApellido().toLowerCase().contains(apellido.toLowerCase()))
                 encontrados.add(u);
         }
         return encontrados;
     }
     public Usuario obtenerUsuario(String correo){
      for (Usuario u : usuarios){   
            if (u.verCorreo().equals(correo)) {
                return u;
            }
            }
        return null;
    }
}