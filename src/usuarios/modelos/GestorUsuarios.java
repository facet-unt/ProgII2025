/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author rocio
 */
public class GestorUsuarios implements IGestorUsuarios{
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios gestor;


    private GestorUsuarios() {                               /*Implementacion del metodo para que solo se pueda crear
                                                                             una instancia del mismo  */
    }
    
    public static GestorUsuarios crear()
    {
        if(gestor == null)
        {
            gestor = new GestorUsuarios();  
        }
        return gestor;
    }
    
    
public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida)
{  
    if(!(correo!= null && correo.contains("@")))
    {
        return ERROR_CORREO;
    }
    if(!(apellido!= null && !apellido.trim().isEmpty()))
    {
        return ERROR_APELLIDO;
    }
    if(!(nombre!= null && !nombre.trim().isEmpty()))
    {
        return ERROR_NOMBRE;
    }
    if(!(clave!=null && !clave.trim().isEmpty()))
    {
        return ERROR_CLAVES;
    }
    
    if(!(claveRepetida!= null && !claveRepetida.trim().isEmpty() && claveRepetida.equals(clave)))
    {
        return ERROR_CLAVES;
    }
    if(!(perfil!=null))
    {
        return ERROR_PERFIL;
    }
    
    Usuario nuevoUsuario= new Usuario(correo, apellido, nombre, perfil, clave, claveRepetida);
    usuarios.add(nuevoUsuario);
    return EXITO;
}

public ArrayList<Usuario> verUsuarios()
{
    return this.usuarios;
}

public ArrayList<Usuario> buscarUsuarios(String apellido)
{
    ArrayList<Usuario> encontrados = new ArrayList<>();

    for(Usuario u : this.usuarios)
    {
        if(u.verApellido().equalsIgnoreCase(apellido))
        {
            encontrados.add(u);
        }
    }
     return encontrados;
}
    
    public boolean existeEsteUsuario(Usuario usuario)
    {
            for(Usuario u : this.usuarios)
            {
                if(u.equals(usuario))
                {
                  return true;   
                }
            }
            return false;
}
    public Usuario obtenerUsuario(String correo)
    {
        for(Usuario u : this.usuarios)
        {
            if(u.verCorreo().equalsIgnoreCase(correo))
            {
                return u;
            }
        }
           return null;
    }
    
    public String validarUsario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida)
    {
         if(!(correo!= null && correo.contains("@")))
    {
        return ERROR_CORREO;
    }
    if(!(apellido!= null && !apellido.trim().isEmpty()))
    {
        return ERROR_APELLIDO;
    }
    if(!(nombre!= null && !nombre.trim().isEmpty()))
    {
        return ERROR_NOMBRE;
    }
    if(!(clave!=null && !clave.trim().isEmpty()))
    {
        return ERROR_CLAVES;
    }
    
    if(!(claveRepetida!= null && !claveRepetida.trim().isEmpty() && claveRepetida.equals(clave)))
    {
        return ERROR_CLAVES;
    }
    if(perfil==null)
    {
        return ERROR_PERFIL;
    }
    return VALIDACION_EXITO;
    }
    
    public String borrarUsuario(Usuario usuario){
        GestorPedidos gp = GestorPedidos.instanciar();
        
        for(Usuario u: usuarios){
            Cliente unCliente = (Cliente)usuario;
            if(u.equals(usuario) && !gp.hayPedidosConEsteCliente(unCliente))
                usuarios.remove(u);
        }
    return EXITO2;
    }
}




