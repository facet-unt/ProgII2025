package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;


public class  GestorProductos implements IGestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    

    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String borrarProducto(Producto producto){
        if (producto==null|| !productos.contains(producto)) {
            return PRODUCTO_INEXISTENTE;
        }
        //verifica si hay pedidos que contengan el producto
        GestorPedidos gpedidos = GestorPedidos.instanciar();
        if (gpedidos.hayPedidosConEsteProducto(producto)) {
            return "no se puede borrar el producto porque tiene pedidos asociados";
        }
        productos.remove(producto);
        return EXITO_BORRADO;
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto)) {
            return productos.contains(producto);
        }
        System.out.println(PRODUCTO_INEXISTENTE);
         return false;
    }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria()==categoria) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }
    
    @Override
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
