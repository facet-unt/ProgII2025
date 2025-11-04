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
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto p = new Producto(codigo,descripcion,categoria,estado,precio);
        this.productos.add(p);
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(p==null){
            return PRODUCTO_INEXISTENTE;
        }
        if(codigo<=0){
            return ERROR_CODIGO ;
        }
        for(Producto p1: productos){
            if(p.verCodigo()==codigo){
                break;
            }
            if(p1.verCodigo()==codigo){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        if(descripcion==null||descripcion.isBlank()){
            return ERROR_DESCRIPCION ;
        }
        if(precio<=0){
            return ERROR_PRECIO ;
        }
        if(categoria==null){
            return ERROR_CATEGORIA ;
        }
        if(estado==null){
            return ERROR_ESTADO ;
        }
        Producto productoModificado = new Producto(codigo,descripcion,categoria,estado,precio);
        productos.set(productos.indexOf(p), productoModificado);
        return EXITO;
    }
    
    @Override
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().contains(descripcion)){
                productosEncontrados.add(p);
            }
        }
        return productosEncontrados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p: productos){
            if(producto.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria){
                productosPorCategoria.add(p);
            }
        }
        return productosPorCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo){
                return p;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        if(producto==null){
            return PRODUCTO_INEXISTENTE;
        }
        GestorPedidos gp = GestorPedidos.instanciar();
        if(!(gp.hayPedidosConEsteProducto(producto))){
            productos.remove(producto);
        }
        return EXITO;
    }
}
