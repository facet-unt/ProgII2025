/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.ArrayList;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

/**
 *
 * @author estudiante
 */
public class GestorUsuarios {
 private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    
   public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        
        if(perfil == CLIENTE)
        {
           Cliente c;
           if(correo!=null&&correo.contains("@")&&clave!=null&&claveRepetida==clave)
           {
               c=new Cliente(correo, clave, apellido, nombre);
               c.asignarApellido(apellido);
               c.asignarClave(clave);
               c.asignarCorreo(correo);
               c.asignarNombre(nombre);
               usuarios.add(c);
               return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
           }
           else
                {return ("No se pudo realizar la Operación, ingrese valores válidos");}
           }
           else
           {
                if(perfil == EMPLEADO)
            {
                Empleado em;
                if(correo!=null&&correo.contains("@")&&clave!=null&&claveRepetida==clave)
                {
                    em=new Empleado(correo, clave, apellido, nombre);
                    em.asignarApellido(apellido);
                    em.asignarClave(clave);
                    em.asignarCorreo(correo);
                    em.asignarNombre(nombre);
                    usuarios.add(em);
                    return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
                }
                else
                {return ("No se pudo realizar la Operación, ingrese valores válidos");}
            } 
            else
            {
                if(perfil == ENCARGADO)
                {
                    Encargado en;
                    if(correo!=null&&correo.contains("@")&&clave!=null&&claveRepetida==clave)
                    {
                        en=new Encargado(correo, clave, apellido, nombre);
                        en.asignarApellido(apellido);
                        en.asignarClave(clave);
                        en.asignarCorreo(correo);
                        en.asignarNombre(nombre);
                        usuarios.add(en);
                        return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
                    }
                    else
                {return ("No se pudo realizar la Operación, ingrese valores válidos");}
                    } 
                else
                {return ("No se pudo realizar la Operación, ingrese valores válidos");}
            } 
            
           } 
        }
    
   public ArrayList<Usuario> verUsuarios()
    {
     return this.usuarios;  
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
         
        ArrayList<Usuario> encontrados = new ArrayList<>();
        for (Usuario u : usuarios) {
             
            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                encontrados.add(u);
            }
                
            }
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
             
            if (u.verCorreo()==(correo)) {
                return u;
            }
                
            }
        return null;
    }
    }
    
    
