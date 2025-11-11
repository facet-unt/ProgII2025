package interfaces;

import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

public interface IGestorProductos {
    public static final String EXITO = "Producto creado/modificado con exito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

    String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    List<Producto> menu();
    List<Producto> buscarProductos(String descripcion);
    String borrarProducto(Producto producto);
    boolean existeEsteProducto(Producto producto);
    List<Producto> verProductosPorCategoria(Categoria categoria);
    Producto obtenerProducto(Integer codigo); 
}
