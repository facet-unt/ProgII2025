/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_ESTADO;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import static interfaces.IGestorProductos.EXITO;
import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;
import pedidos.modelos.*;
import productos.modelos.Categoria;
import productos.modelos.Producto;


public class GestorUsuarios implements IGestorUsuarios{
    
    private List<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios instancia;
    
    /* Constructor predeterminado */
    private GestorUsuarios() { 
        this.leerArchivo(NOMBRE_ARCHIVO);
    }
    
    /* Metodo que devuelve una referencia a GestorUsuarios (se asegura de que exista un solo GestorUsuarios) */
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        
        /*Controla que no haya usuarios con el mismo correo */
        if (this.obtenerUsuario(correo) != null)
         {
             
         return USUARIO_EXISTENTE;
         
         }
        
        
        if(perfil == CLIENTE)
        {
           Cliente c;
           if(nombre!= null && !nombre.isBlank() && apellido!= null && !apellido.isBlank() && correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
               c = new Cliente(correo, clave, apellido, nombre);
               c.asignarApellido(apellido);
               c.asignarClave(clave);
               c.asignarCorreo(correo);
               c.asignarNombre(nombre);
               this.escribirArchivo(NOMBRE_ARCHIVO, c);
               usuarios.add(c);
               
            return OPERACION_EXITOSA; 
           }
            else
                {
                    return OPERACION_FALLIDA;
                }
        }
        else if(perfil == EMPLEADO)
        {
           Empleado em;
           if(nombre!= null && !nombre.isBlank() && apellido!= null && !apellido.isBlank() && correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
                em = new Empleado(correo, clave, apellido, nombre);
                em.asignarApellido(apellido);
                em.asignarClave(clave);
                em.asignarCorreo(correo);
                em.asignarNombre(nombre);
                this.escribirArchivo(NOMBRE_ARCHIVO, em);
                usuarios.add(em);
                    
                return OPERACION_EXITOSA; 
                }
            else
                {
                    return OPERACION_FALLIDA;
                }
        } 
        else if(perfil == ENCARGADO)
        {
           Encargado en;
           if(nombre!= null && !nombre.isBlank() && apellido!= null && !apellido.isBlank() && correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave))
           {
                en = new Encargado(correo, clave, apellido, nombre);
                en.asignarApellido(apellido);
                en.asignarClave(clave);
                en.asignarCorreo(correo);
                en.asignarNombre(nombre);
                this.escribirArchivo(NOMBRE_ARCHIVO, en);
                usuarios.add(en);
                 
                return OPERACION_EXITOSA; 
                }
            else
                {
                    return OPERACION_FALLIDA;
                }
        } 
        else
        {
            return OPERACION_FALLIDA;
        }
     } 
         
    /* Devuelve los usuarios ordenados por Apellido y Nombre */
    public List<Usuario> verUsuarios()
    {
     Collections.sort(this.usuarios);
     return this.usuarios;  
    }
    
    /* Busca usuarios por Apellido */ 
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
    
    /* Metodo para comparar correo de usuarios */
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
             
            if (u.verCorreo().equals(correo)) {
                return u;
            }
                
            }
        return null;
    }
    
      public String modificarUsuario(Usuario u, String correo, String apellido, String nombre, String clave, String claveRepetida) 
    {

        if(nombre!= null && !nombre.isBlank() && apellido!= null && !apellido.isBlank() && correo!=null && correo.contains("@") && clave!=null && claveRepetida!= null && claveRepetida.equals(clave)){
               u.asignarApellido(apellido);
               u.asignarClave(clave);
               u.asignarCorreo(correo);
               u.asignarNombre(nombre);
            this.modificarArchivo(NOMBRE_ARCHIVO);
            return (OPERACION_EXITOSA); 
            
        }
          else{
            return OPERACION_FALLIDA;
    }
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
            this.modificarArchivo(NOMBRE_ARCHIVO);
            return(OPERACION_EXITOSA);
        }
       
            return(OPERACION_FALLIDA + USUARIO_INEX);
        
    }
    
            /* Metodo para escribir en un archivo */
    private String escribirArchivo(String NOMBRE_ARCHIVO, Usuario u)
    {
        
        try( FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true))
        {
            fw.write(deUsuarioaString(u));
            return ESCRITURA_OK;
            
        } catch (IOException ex) {
            return ESCRITURA_ERROR;
        }   
    }
    
    private String deUsuarioaString(Usuario u){
        StringBuilder linea = new StringBuilder();
        linea.append(u.verPerfil());  
        linea.append(SEPARADOR);
        linea.append(u.verApellido());
        linea.append(SEPARADOR);
        linea.append(u.verNombre());
        linea.append(SEPARADOR);
        linea.append(u.verCorreo());
        linea.append(SEPARADOR);
        linea.append(u.verClave());
        linea.append("\n");
        return linea.toString();
    }
    
    private Usuario deStringaUsuario(String linea){
        
        String correo;
        String clave;
        String apellido;
        String nombre;
        String perfil;
        
        String[] cadenas = linea.split("-");
        perfil = cadenas[0];
        apellido = cadenas[1];
        nombre = cadenas[2];
        correo = cadenas[3];
        clave = cadenas[4];
        
        Usuario u; 
        
        if (perfil.equals("Cliente")) {
            u = new Cliente(correo, clave, apellido, nombre);
        } else if (perfil.equals("Empleado")) {
            u = new Empleado(correo, clave, apellido, nombre);
        } else if (perfil.equals("Encargado")) {
            u = new Encargado(correo, clave, apellido, nombre);
        } else {
            return null;
        }
        return u;
    }
    
    private String leerArchivo(String NOMBRE_ARCHIVO){
        
        File f = new File(NOMBRE_ARCHIVO);
        if (f.exists())
        {
        try(FileReader fr = new FileReader(NOMBRE_ARCHIVO))
        {
            BufferedReader bw = new BufferedReader(fr);
            String linea = "";
            while((linea = bw.readLine()) != null)
            {
            Usuario u = this.deStringaUsuario(linea);
            if (!usuarios.contains(u)) {  /* Controla que no haya usuarios  duplicados en el archivo */
               this.usuarios.add(u);
            }
            }
                 
            return LECTURA_OK;
            
        }
        catch (IOException ex) {
            return LECTURA_ERROR;
          }   
        }
        return ERROR_ARCHIVO;
    }
    
       private String modificarArchivo(String NOMBRE_ARCHIVO){ 
        try( FileWriter fw = new FileWriter(NOMBRE_ARCHIVO))
        {
            for(Usuario u : this.usuarios){
                fw.write(deUsuarioaString(u));
            }
            return ESCRITURA_OK;
        } catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
    }
    
}
    
    
