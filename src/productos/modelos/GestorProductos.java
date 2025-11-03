package productos.modelos;

import java.util.ArrayList;
import usuarios.modelos.Usuario;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia; //implementacion para se pueda instancias una vez
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
public static final String EXITO = "Producto creado/modificado con éxito";
public static final String ERROR_CODIGO = "El código del producto es incorrecto";
public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
   
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
                
                if (codigo <= 0){
                   return ERROR_CODIGO;
                   }else if (descripcion == null || descripcion.isEmpty()){
                    return ERROR_DESCRIPCION;
                   }else if(precio <= 0){
                       return ERROR_PRECIO;
                   }else if(categoria == null){
                       return ERROR_CATEGORIA;
                   }else if(estado == null){
                   return ERROR_ESTADO;}

                Producto p = new Producto (codigo, descripcion, precio, categoria, estado);
                if (!productos.contains(p)){
                    productos.add(p);
                return EXITO;
                }else{
                return PRODUCTOS_DUPLICADOS;
                }
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
            this.obtenerProducto(codigo);
            if (!this.productos.contains(productoAModificar)){ //agrego un control para saber si el que quiero modificar existe
            return PRODUCTO_INEXISTENTE;
            }
            Producto p = this.obtenerProducto(codigo);
            if (p != null && !p.equals(this.obtenerProducto(codigo))) {
            // ... entonces es un duplicado.
            return PRODUCTOS_DUPLICADOS;
 }
            //modifico el producto que necesito
                    productoAModificar.asignarCategoria(categoria);
                    productoAModificar.asignarDescripcion(descripcion);
                    productoAModificar.asignarEstado(estado);
                    productoAModificar.asignarPrecio(precio);
                    productoAModificar.asignarCodigo(codigo); 
                    return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto> productosEncontrados = new ArrayList<>();
        for (Producto p : productos){
            if (p.verDescripcion().equals(descripcion))
                productosEncontrados.add(p);
        }
        return productosEncontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto))
        return true;
        else
            return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList <Producto> Encontrados = new ArrayList<>();
        for (Producto p : productos){
         if ( p.verCategoria().equals(categoria))
             Encontrados.add(p);
            
        }
        return Encontrados;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos){   
            if (p.verCodigo() == codigo) {
                return p;
            }
            }
        return null;
    }
}
