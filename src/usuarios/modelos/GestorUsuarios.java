/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import Interfaces.IGestorUsuarios;


/**
 *
 * @author Asus
 */
public class GestorUsuarios implements IGestorUsuarios{ 
     private ArrayList<Usuario> usuarios = new ArrayList<>();
     private static GestorUsuarios instancia;
     public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
     
     
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
         if (correo == null || !correo.contains("@") || correo.trim().isEmpty()){
             return ERROR_CORREO;
         }else if (apellido == null || apellido.trim().isEmpty()){
         return ERROR_APELLIDO;
         }else if (nombre == null || nombre.trim().isEmpty()) {
         return ERROR_NOMBRE;
         }else if (clave == null || clave.trim().isEmpty() ||claveRepetida == null || claveRepetida.trim().isEmpty()){
         return ERROR_CLAVES;
         }
         if (perfil == Perfil.CLIENTE){
         Usuario u = new Cliente (correo, clave, nombre, apellido);
         }else if (perfil == Perfil.EMPLEADO){
         Usuario u = new Empleado (correo, clave, nombre, apellido);
         }else if (perfil == Perfil.ENCARGADO){
         Usuario u = new Encargado (correo, clave, nombre, apellido);
         }
         return EXITO;
     }         

     public List<Usuario> verUsuarios(){
            Comparator <Usuario> nComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verNombre().compareTo(u2.verNombre());
               }
           };
            Comparator <Usuario> aComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verApellido().compareTo(u2.verApellido());
               }
           };
            Comparator <Usuario> combinado = aComp.thenComparing(aComp);
            usuarios.sort(combinado);
            return usuarios;
         }
     
     public String borrarUsuario(Usuario usuario){
         Usuario u;
       GestorPedidos gp = GestorPedidos.instanciar();
         if (usuarios.contains(usuario)){
             if (usuario instanceof Cliente){
         if (gp.hayPedidosConEsteCliente((Cliente)usuario))
             for (Pedido p : usuario.verPedidos())
                 if (p.verCliente().equals((Cliente)usuario))
                     this.usuarios.remove(usuario);
                     return EXITO;
         }
           System.out.println("Este usuario no es un cliente");
           return ERROR;
         }
         System.out.println("No existe este usuario");
         return ERROR;
         
     }
     
     
     
     public boolean existeEsteUsuario(Usuario usuario){
         if (usuarios.contains(usuario))
              return true;
             else
             return false;
        }


     public List<Usuario> buscarUsuarios(String apellido){
         ArrayList <Usuario> encontrados = new ArrayList<>();
         for (Usuario u : usuarios){
             if (u.verApellido().toLowerCase().contains(apellido.toLowerCase()))
                 encontrados.add(u);
         }  
         Comparator <Usuario> nComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verNombre().compareTo(u2.verNombre());
               }
           };
            Comparator <Usuario> aComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verApellido().compareTo(u2.verApellido());
               }
           };
            Comparator <Usuario> combinado = aComp.thenComparing(aComp);
            encontrados.sort(combinado);
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