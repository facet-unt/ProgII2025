package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        System.out.println(VALIDACION_EXITO);
        Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(unProducto);
        return EXITO;
 
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo < 0) {
            return ERROR_CODIGO;
        }
        else{
            for (Producto producto : productos) {
                if (producto.verCodigo()== codigo) {
                    return PRODUCTOS_DUPLICADOS;
                }
            }
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio < 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        System.out.println(VALIDACION_EXITO);
        p.asignarCodigo(codigo);
        p.asignarPrecio(precio);
        p.asignarDescripcion(descripcion);
        p.asignarEstado(estado);
        p.asignarCategoria(categoria);
        
        return EXITO;
    }
    
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto)) {
            return productos.contains(producto);
        }
        System.out.println(PRODUCTO_INEXISTENTE);
         return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria()==categoria) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p : productos){
            if (p.verCodigo()== codigo) {
                return p;
            }
        }
        System.out.println(PRODUCTO_INEXISTENTE);
        return null;
    }
}
