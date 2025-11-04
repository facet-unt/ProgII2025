package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos{
    
    
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
            if(u.verDescripcion().equalsIgnoreCase(descripcion)){
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
            if(u.verCategoria().equals(categoria)){
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
    
    public String borrarProducto(Producto producto){
        GestorPedidos gp = GestorPedidos.instanciar();
        for(Producto u: productos){
            if(u.equals(producto) && !gp.hayPedidosConEsteProducto(producto)){
                productos.remove(u);
            }
        }
    
        return EXITO2; 
    }
}
