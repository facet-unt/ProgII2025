package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {

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
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return PRODUCTOS_DUPLICADOS;
            }
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

    @Override
    public ArrayList<Producto> menu() {
        return this.productos;
    }

    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto u : productos) {
            if (u.verDescripcion().equals(descripcion)) {
                resultados.add(u);
            }
        }
        return resultados;
    }

    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto u : productos) {
            if (u.verCategoria().equals(categoria)) {
                resultados.add(u);
            }
        }
        return resultados;
    }

    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto u : productos) {
            if (u.verCodigo() == codigo) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        GestorPedidos gPedidos = GestorPedidos.instanciar();
        if (gPedidos.hayPedidosConEsteProducto(producto) == true) {
            return PRODUCTO_EN_PEDIDO;
        } else {
            productos.remove(producto);
            return PRODUCTO_BORRADO;
        }
    }
}
