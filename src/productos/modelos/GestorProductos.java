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
        if(codigo<=0){
            return ERROR_CODIGO;
        }
        if(descripcion==null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio<=0){
            return ERROR_PRECIO;
        }
        if(categoria==null){
            return ERROR_CATEGORIA;
        }
        if(estado==null){
            return ERROR_ESTADO;
        }
        Producto pNuevo =new Producto(codigo, descripcion, categoria, estado, precio);
        
        if(existeEsteProducto(pNuevo))
            return PRODUCTOS_DUPLICADOS;
        productos.add(pNuevo);
        return EXITO;
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (p==null){
            return PRODUCTO_INEXISTENTE;
        }
        if (codigo <= 0){
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0){
            return ERROR_PRECIO;
        }
        if (categoria == null){
            return ERROR_CATEGORIA;
        }
        if (estado == null){
            return ERROR_ESTADO;
        }
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        
        return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> pEncontrados = new ArrayList<>();
        if(descripcion==null || descripcion.trim().isEmpty()){
            return pEncontrados;
        }
        for(Producto p : productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())){
                pEncontrados.add(p);
            }
        }
        return pEncontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p : productos){
            if(p.verCodigo()== producto.verCodigo()){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> categoriaBusq = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                categoriaBusq.add(p);
            }
        }
        return categoriaBusq;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}