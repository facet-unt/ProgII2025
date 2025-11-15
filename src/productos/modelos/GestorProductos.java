package productos.modelos;

import java.util.ArrayList;
import interfaces.IGestorProductos;
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
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validarDatos(codigo, descripcion,precio,categoria,estado);
        if(!validacion.equals(VALIDACION_EXITO)) return validacion;
        
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if(existeEsteProducto(p)) return PRODUCTOS_DUPLICADOS;
        
        productos.add(p);
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = validarDatos(codigo, descripcion,precio,categoria,estado);
        if(validacion.equals(VALIDACION_EXITO)){
            if(existeEsteProducto(productoAModificar)){
                productoAModificar.asignarCodigo(codigo);
                productoAModificar.asignarDescripcion(descripcion);
                productoAModificar.asignarPrecio(precio);
                productoAModificar.asignarCategoria(categoria);
                productoAModificar.asignarEstado(estado);
                return EXITO;
        }
        return PRODUCTO_INEXISTENTE;
        }
        return validacion;
    }
    
    @Override
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> ps = new ArrayList<>();
        for (Producto p : productos){
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) ps.add(p);
        }
        return ps;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        if(producto == null) return false;
        return productos.contains(producto);
    }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> ps = new ArrayList<>();
        for (Producto p : productos){
            if(p.verCategoria() == categoria) ps.add(p);
        }
        return ps;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos){
            if(p.verCodigo()==codigo) return p;
        }
        return null;
    }
    
    private String validarDatos (int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo<=0) return ERROR_CODIGO;
        if(descripcion==null || descripcion.isBlank()) return ERROR_DESCRIPCION;
        if(precio<=0) return ERROR_PRECIO;
        if(categoria==null) return ERROR_CATEGORIA;
        if(estado==null) return ERROR_ESTADO;
        return VALIDACION_EXITO;
    }
    
    @Override
    public String borrarProducto(Producto producto) {
        GestorPedidos gp = GestorPedidos.instanciar();
        if(gp.hayPedidosConEsteProducto(producto))
            return "El producto existe en un pedido";
        if(productos.remove(producto))
            return "Producto borrado con exito";  
        else return "El producto no existe en productos";
    }
}
