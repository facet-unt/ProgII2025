package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    public static final String EXITO = "Producto creado/modificado con éxito";
    
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    private GestorProductos() {
        
    }
    
    
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        return null;
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        return null;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> lista = new ArrayList<>();
                
        for (Producto p : productos){            
            if(p.verDescripcion().equals(descripcion)){
                lista.add(p);
            }           
        }
        
        return lista;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if(this.productos.contains(producto)){
            return true;
        }
        else{
           return false; 
        }
    }
    
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> categorias = new ArrayList<>();
        
        for(Producto pr : productos){
            if(pr.verCategoria().equals(categoria)){
                categorias.add(pr);
            }
        }
        
        return categorias;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        return null;
    }
}
