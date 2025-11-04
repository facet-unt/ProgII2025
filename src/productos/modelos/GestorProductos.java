package productos.modelos;

import Interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

public class GestorProductos implements IGestorProductos{
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
        if(codigo<=0){
            return ERROR_CODIGO;
        }
        if(descripcion==null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio<=0){
            return ERROR_PRECIO;
        }
        if(categoria==null){
            return ERROR_CATEGORIA;
        }
        if(estado==null){
            return ERROR_ESTADO;
        }
        Producto pNuevo =new Producto(codigo, descripcion, categoria, estado, precio);
        
        if(existeEsteProducto(pNuevo))
            return PRODUCTOS_DUPLICADOS;
        productos.add(pNuevo);
        return EXITO;
    }
    
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (p==null){
            return PRODUCTO_INEXISTENTE;
        }
        if (codigo <= 0){
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0){
            return ERROR_PRECIO;
        }
        if (categoria == null){
            return ERROR_CATEGORIA;
        }
        if (estado == null){
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
        ArrayList<Producto> pEncontrados = new ArrayList<>();
        if(descripcion==null || descripcion.trim().isEmpty()){
            return pEncontrados;
        }
        for(Producto p : productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())){
                pEncontrados.add(p);
            }
        }
        return pEncontrados;
    }
    
    public String borrarProducto(Producto producto) {
        if (producto == null) {
            return PRODUCTO_INEXISTENTE;
        }

        GestorPedidos gp = GestorPedidos.instanciar();
        if (gp.hayPedidosConEsteProducto(producto)) {
            return "No se puede borrar el producto, existen pedidos con el mismo.";
        }
        
        if (productos.remove(producto)) {
            return "Producto borrado con éxito";
        } else {
            return PRODUCTO_INEXISTENTE;
        }
    }
    
    public boolean existeEsteProducto(Producto producto) {
        for(Producto p : productos){
            if(p.verCodigo()== producto.verCodigo()){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> categoriaBusq = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                categoriaBusq.add(p);
            }
        }
        return categoriaBusq;
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