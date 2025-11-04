package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

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

    @Override
    public String borrarProducto(Producto producto){
        IGestorPedidos gped = GestorPedidos.instanciar();
        for(Pedido p:gped.verPedidos()){
            for(ProductoDelPedido pdp:p.getCantidadProducto()){
                if(pdp.getUnProducto().equals(producto)){
                    return BORRADO_ERROR;
                }
                    
            }
            
        }
        productos.remove(producto);
        return BORRADO_EXITO;
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

        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(p);
        return VALIDACION_EXITO;
    }

    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
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

        return EXITO;
    }

    public ArrayList<Producto> menu() {
        return this.productos;
    }

    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> prod = new ArrayList<>();

        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                prod.add(p);
            }

        }
        return prod;
    }

    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria);
            return productosPorCategoria;
        }
        return productosPorCategoria;
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
