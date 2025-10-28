package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
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
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto p = new Producto(codigo,descripcion,categoria,estado,precio);
        this.productos.add(p);
        return EXITO;
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p.verCodigo()==codigo){
                break;
            }
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto productoModificado = new Producto(codigo,descripcion,categoria,estado,precio);
        productos.set(productos.indexOf(p), productoModificado);
        return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().contains(descripcion)){
                productosEncontrados.add(p);
            }
        }
        return productosEncontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p: productos){
            if(producto.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria){
                productosPorCategoria.add(p);
            }
        }
        return productosPorCategoria;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo){
                return p;
            }
        }
        return null;
    }
}
