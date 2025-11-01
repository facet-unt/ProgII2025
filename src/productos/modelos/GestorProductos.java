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
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo > 0)) {
            return ERROR_CODIGO;
        }

        if (!(descripcion != null && !descripcion.trim().isEmpty())) {
            return ERROR_DESCRIPCION;
        }

        if (!(precio > 0)) {
            return ERROR_PRECIO;
        }

        if (categoria == null) {
            return ERROR_CATEGORIA;
        }

        if (estado == null) {
            return ERROR_ESTADO;
        }
        
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevoProducto);
        

        return EXITO;
    }

    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo > 0)) {
            return ERROR_CODIGO;
        }

        if (!(descripcion != null && !descripcion.trim().isEmpty())) {
            return ERROR_DESCRIPCION;
        }

        if (!(precio > 0)) {
            return ERROR_PRECIO;
        }

        if (categoria == null) {
            return ERROR_CATEGORIA;
        }

        if (estado == null) {
            return ERROR_ESTADO;
        }

        p.asignarCategoria(categoria);
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarEstado(estado);
        p.asignarPrecio(precio);
        
        
        return EXITO;
    }

    public ArrayList<Producto> menu() {
        return this.productos;
    }

    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for(Producto u: productos)
            if(u.verDescripcion().contains(descripcion)){
                productosEncontrados.add(u);
            }
        return productosEncontrados;
    }

    public boolean existeEsteProducto(Producto producto) {
         for(Producto u: productos)
            if(u.equals(producto)){
                return true;
            }
        return false;
    }

    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosMismaCategoria = new ArrayList<>();
        for(Producto u: productos)
            if(u.verCategoria() == categoria){
                productosMismaCategoria.add(u);
            }
        return productosMismaCategoria;
    }

    public Producto obtenerProducto(Integer codigo) {
          for(Producto u: productos)
            if(u.verCodigo() == codigo){
                return u;
            }
        return null;
    }
}
