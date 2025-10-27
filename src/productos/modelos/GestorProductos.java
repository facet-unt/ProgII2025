package productos.modelos;

import java.util.ArrayList;


public class GestorProductos {
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
        Producto producto= new Producto(codigo,descripcion,precio,categoria,estado);
        productos.add(producto);
        String cadena= "Se creo el Producto con exito";
        return cadena;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        productoAModificar.asignarCodigo(codigo);
        productoAModificar.asignarDescripcion(descripcion);
        productoAModificar.asignarPrecio(precio);
        productoAModificar.asignarCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        String cadena="Se modificó el Producto con exito";
        return cadena;
    }
    
    public ArrayList<Producto> menu() {
        
        return this.productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto>productosbuscados =new ArrayList<>();
        for (Producto p : productos) {
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()));
                productosbuscados.add(p);
        }
        return productosbuscados;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        return true;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        return null;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        return null;
    }
}
