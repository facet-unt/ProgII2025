package pedidos.modelos;

import java.time.*;
import usuarios.modelos.*;
import java.util.ArrayList;


public class GestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    
    private GestorPedidos() {
        
    }
    
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        Pedido p = new Pedido (fecha,  hora, productosDelPedido,  cliente);
        if(codigo>0&&descripcion!=null&&precio>0&&categoria!=null&&estado!=null)
        {
            pedidos.add(p);
            return ("Operación exitosa: El producto " + descripcion + " con código "+codigo +" categoría "+ categoria + " estado "+ estado + " y precio " +precio + " se guardó correctamente"); 
            
        }
        else
        {
            return ("No se pudo realizar la Operación, ingrese valores válidos");
        }
        
    }
    
    public String modificarPedido(Pedido p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (productos.contains(p))
            {
                productos.remove(p);
            }
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        productos.add(p);
        if(codigo>0&&descripcion!=null&&precio>0&&categoria!=null&&estado!=null)
        {
            productos.add(p);
            return ("Operación exitosa: Los nuevos datos de producto son: descripción "+descripcion+", código "+codigo+", precio " +precio+", categoría "+categoria+", estado "+estado+"."); 
            
        }
        else
        {
            return ("No se pudo realizar la Operación, ingrese valores válidos");
        }
    }
    
    public ArrayList<Pedido> menu() {
        return this.productos;
        
    }
    
    public ArrayList<Pedido> buscarPedidos(String descripcion) {
         
        ArrayList<Pedido> encontrados = new ArrayList<>();
        for (Pedido p : productos) {
             
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                encontrados.add(p);
            }
                
            }
        return encontrados;
    }
    
    public boolean existeEstePedido(Pedido producto) {
        if (productos.contains(producto))
            return false;
        else
            return true;
    }
    
    public ArrayList<Pedido> verPedidosPorCategoria(Categoria categoria) {
         ArrayList<Pedido> prodcat = new ArrayList<>();
        for (Pedido p : productos) {
             
            if (p.verCategoria()==(categoria)) {
                prodcat.add(p);
            }
                
            }
        return prodcat;
    }
    
    public Pedido obtenerPedido(Integer codigo) {
        for (Pedido p : productos) {
             
            if (p.verCodigo()==(codigo)) {
                return p;
            }
                
            }
        return null;
    }
    }
