/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;
import pedidos.modelos.*;


public class GestorUsuarios implements IGestorUsuarios{
    
    private List<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios instancia;
    
    /* Constructor predeterminado */
    private GestorUsuarios() { 
    }
    
    /* Metodo que devuelve una referencia a GestorUsuarios (se asegura de que exista un solo GestorUsuarios) */
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        
        if(perfil == CLIENTE)
        {
           Cliente c;
           if(correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
               c = new Cliente(correo, clave, apellido, nombre);
               c.asignarApellido(apellido);
               c.asignarClave(clave);
               c.asignarCorreo(correo);
               c.asignarNombre(nombre);
               usuarios.add(c);
               
            return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
           }
            else
                {
                    return ("No se pudo realizar la Operación, ingrese valores válidos");
                }
        }
        else if(perfil == EMPLEADO)
        {
           Empleado em;
           if(correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
                em = new Empleado(correo, clave, apellido, nombre);
                em.asignarApellido(apellido);
                em.asignarClave(clave);
                em.asignarCorreo(correo);
                em.asignarNombre(nombre);
                usuarios.add(em);
                    
                return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
                }
            else
                {
                    return ("No se pudo realizar la Operación, ingrese valores válidos");
                }
        } 
        else if(perfil == ENCARGADO)
        {
           Encargado en;
           if(correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
                en = new Encargado(correo, clave, apellido, nombre);
                en.asignarApellido(apellido);
                en.asignarClave(clave);
                en.asignarCorreo(correo);
                en.asignarNombre(nombre);
                usuarios.add(en);
                 
                return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
                }
            else
                {
                    return ("No se pudo realizar la Operación, ingrese valores válidos");
                }
        } 
        else
        {
            return ("No se pudo realizar la Operación, ingrese valores válidos");
        }
     } 
            
    public List<Usuario> verUsuarios()
    {
     Collections.sort(this.usuarios);
     return this.usuarios;  
    }
    
    public List<Usuario> buscarUsuarios(String apellido) {
         
      ArrayList<Usuario> encontrados = new ArrayList<>();
      
        for (Usuario u : usuarios) {
             
            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                encontrados.add(u);
            }
                
            }
        Collections.sort(encontrados);
        return encontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario) {
        if (usuarios.contains(usuario))
            return true;
        else
            return false;
    }
    
    
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
             
            if (u.verCorreo().equals(correo)) {
                return u;
            }
                
            }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if(usuarios.contains(usuario) && usuario!=null)
        {
            if (usuario instanceof Cliente)
            {
                GestorPedidos gDeP = GestorPedidos.instanciar();
                for(Pedido unPedido:gDeP.verPedidos())
                {
                    if((unPedido.verCliente()).equals(usuario))
                    {
                        return (OPERACION_FALLIDA + USUARIO_TIENE_PEDIDO);
                    }
                }
            }
            usuarios.remove(usuario);
            return(OPERACION_EXITOSA);
        }
       
            return(OPERACION_FALLIDA + USUARIO_INEX);
        
    }
    
}
    
    
