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
        Producto producto= new Producto(codigo,descripcion,precio,categoria,estado);
        if(codigo<=0)
            return ERROR_CODIGO;
        if(descripcion.isEmpty()||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if(categoria==null)
            return ERROR_CATEGORIA;
        if(estado==null)
            return ERROR_ESTADO;
        if(productos.contains(producto))
            return PRODUCTOS_DUPLICADOS;
        else
            productos.add(producto);
        String cadena= "Se creo el Producto con exito";
        return cadena;
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(productoAModificar==null)
            return PRODUCTO_INEXISTENTE;
        if(codigo<=0)
            return ERROR_CODIGO;
        productoAModificar.asignarCodigo(codigo);
        if(descripcion.isEmpty()||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        productoAModificar.asignarDescripcion(descripcion);
        if(precio<=0)
            return ERROR_PRECIO;
        productoAModificar.asignarPrecio(precio);
        if(categoria==null)
            return ERROR_CATEGORIA;
        productoAModificar.asignarCategoria(categoria);
        if(estado==null)
            return ERROR_ESTADO;
        productoAModificar.asignarEstado(estado);
        String cadena="Se modificó el Producto con exito";
        return cadena;
    }
    
    @Override
    public ArrayList<Producto> menu() {
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto>productosbuscados =new ArrayList<>();
        for (Producto p : productos) {
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                productosbuscados.add(p);
      }
        return productosbuscados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for (Producto p: productos) {
            if(p.verCodigo()==producto.verCodigo())
            return true;
        }
        return false;
        }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto>productoDelaCategoria=new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria)
                productoDelaCategoria.add(p);
        }
        return productoDelaCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
        }
    @Override
    public String borrarProducto(Producto producto){
        GestorPedidos gPedidos= GestorPedidos.instanciar();
        if(gPedidos.hayPedidosConEsteProducto(producto)== true){
            return PRODUCTO_EN_PEDIDO;
        }
        else{
            productos.remove(producto);
            return PRODUCTO_BORRADO;
        }
    }
    }