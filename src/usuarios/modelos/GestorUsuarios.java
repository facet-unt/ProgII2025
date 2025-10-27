/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import static usuarios.modelos.Perfil.CLIENTE;

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
           Cliente u;
           if(correo!=null&&correo.contains("@")&&clave!=null&&claveRepetida==clave)
           {
               u=new Cliente(correo, clave, apellido, nombre);
               u.asignarApellido(apellido);
               u.asignarClave(clave);
               u.asignarCorreo(correo);
               u.asignarNombre(nombre);
               usuarios.add(u);
               return ("Operación exitosa: El usuario " + apellido + nombre + " con correo "+correo +" clave "+ clave +" se guardó correctamente"); 
           }
             
           else
           {
                return ("No se pudo realizar la Operación, ingrese valores válidos");
           } 
        }
        }
        
   }
    
    public ArrayList<Usuario> verUsuarios()
    {
     return this.usuarios;  
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
         
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
             
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                encontrados.add(p);
            }
                
            }
        return encontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto))
            return false;
        else
            return true;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
         ArrayList<Producto> prodcat = new ArrayList<>();
        for (Producto p : productos) {
             
            if (p.verCategoria()==(categoria)) {
                prodcat.add(p);
            }
                
            }
        return prodcat;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
             
            if (p.verCodigo()==(codigo)) {
                return p;
            }
                
            }
        return null;
    }
    }
