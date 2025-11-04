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
        String validacion = validarDatos(codigo, descripcion,precio,categoria,estado);
        if(!validacion.equals(VALIDACION_EXITO)) return validacion;
        
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if(existeEsteProducto(p)) return PRODUCTOS_DUPLICADOS;
        
        productos.add(p);
        return EXITO;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validarDatos(codigo, descripcion,precio,categoria,estado);
        if(validacion.equals(VALIDACION_EXITO)){
        if(existeEsteProducto(productoAModificar)){
            productoAModificar.asignarCodigo(codigo);
            productoAModificar.asignarDescripcion(descripcion);
            productoAModificar.asignarPrecio(precio);
            productoAModificar.asignarCategoria(categoria);
            productoAModificar.asignarEstado(estado);
            return EXITO;
        }
        return PRODUCTO_INEXISTENTE;
        }
        return validacion;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> ps = new ArrayList<>();
        for (Producto p : productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) ps.add(p);
        }
        return ps;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if(producto == null) return false;
        return productos.contains(producto);
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> ps = new ArrayList<>();
        for (Producto p : productos){
            if(p.verCategoria() == categoria) ps.add(p);
        }
        return ps;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos){
            if(p.verCodigo()==codigo) return p;
        }
        return null;
    }
    
    private String validarDatos (int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo<=0) return ERROR_CODIGO;
        if(descripcion==null || descripcion.isBlank()) return ERROR_DESCRIPCION;
        if(precio<=0) return ERROR_PRECIO;
        if(categoria==null) return ERROR_CATEGORIA;
        if(estado==null) return ERROR_ESTADO;
        return VALIDACION_EXITO;
    }
    
}
