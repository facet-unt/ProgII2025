package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;


public class GestorProductos implements IGestorProductos {
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    
    // Metodos
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String validacion = this.validacionDatos(codigo, descripcion, precio, categoria, estado);
        
        if (!validacion.equals(VALIDACION_EXITO)){
            return validacion;
        }
        
        if (this.obtenerProducto(codigo) != null) {
            return PRODUCTOS_DUPLICADOS;
        }
        
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        this.listaProductos.add(nuevoProducto);
        
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!this.existeEsteProducto(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        
        String validacion = validacionDatos(codigo, descripcion, precio, categoria, estado);
        
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        
        if (this.obtenerProducto(codigo) != null) {
            return PRODUCTOS_DUPLICADOS;
        }
        
        productoAModificar.asignarCodigo(codigo);
        productoAModificar.asignarDescripcion(descripcion);
        productoAModificar.asignarPrecio(precio);
        productoAModificar.asignarCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        
        return EXITO;
    }
    
    @Override
    public ArrayList<Producto> menu() {
        return this.listaProductos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosEncontrados = new ArrayList();
        
        //Devuelvo lista vacia si la descripcion no es valida
        if (descripcion == null || descripcion.isEmpty()) {
            return productosEncontrados;
        }
        
        for (Producto p : this.listaProductos) {
            if (p.verDescripcion().toLowerCase().equals(descripcion.toLowerCase())) {
                productosEncontrados.add(p);
            }
        }
        
        return productosEncontrados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        return this.listaProductos.contains(producto);
    }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList();
        
        if (categoria == null) {
            return productosPorCategoria;
        }
        
        for (Producto p : this.listaProductos) {
            if (p.verCategoria() == categoria) {
                productosPorCategoria.add(p);
            }
        }
        
        return productosPorCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : this.listaProductos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String borrarProducto(Producto producto) {
        GestorPedidos g = GestorPedidos.instanciar();
        
        if (!g.hayPedidosConEsteProducto(producto)) {
            this.listaProductos.remove(producto);
            return "Producto eliminado con exito";
        }
        
        return "Hay pedidos con este producto, no es posible eliminarlo";
    }
    
    // Verificacion datos
    private String validacionDatos (int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigo <= 0) {
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()) {
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0) {
            return ERROR_PRECIO;
        }
        if (categoria == null) {
            return ERROR_CATEGORIA;
        }
        if (estado == null) {
            return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }
}
