package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        Producto p = new Producto (codigo, descripcion, categoria, estado, precio);
        if(codigo>0&&descripcion!=null&&precio>0&&categoria!=null&&estado!=null)
        {
            productos.add(p);
            return ("Operación exitosa: El producto " + descripcion + " con código "+codigo +" categoría "+ categoria + " estado "+ estado + " y precio " +precio + " se guardó correctamente"); 
            
        }
        else
        {
            return ("No se pudo realizar la Operación, ingrese valores válidos");
        }
        
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
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
    
    public ArrayList<Producto> menu() {
        return this.productos;
        
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
            return true;
        else
            return false;
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
