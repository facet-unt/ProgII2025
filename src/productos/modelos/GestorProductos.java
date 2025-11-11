package productos.modelos;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Producto> productos = new ArrayList<>();

    private static GestorProductos instancia;
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripción del producto esincorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto esincorrecta";
    public static final String ERROR_ESTADO = "El precio del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con esecódigo";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

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
        if (descripcion == null || descripcion.trim().isEmpty()) {
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
        if (descripcion == null || descripcion.trim().isEmpty()) {
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
        for (Producto u : productos) {
            if (u.verDescripcion() == descripcion) {
                return this.productos;
            }
        }
        return null;
    }

    public boolean existeEsteProducto(Producto producto) {
        for (Producto u : productos) {
            if (!(u.equals(producto))) {
                return false;
            }
            return true;
        }
        return true;
    }

    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        return null;
    }

    public Producto obtenerProducto(Integer codigo) {
        return null;
    }
}
