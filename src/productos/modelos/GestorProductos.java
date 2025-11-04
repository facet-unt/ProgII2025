package productos.modelos;

import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import static interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static interfaces.IGestorProductos.PRODUCTO_INEXISTENTE;
import static interfaces.IGestorUsuarios.EXITO;
import static interfaces.IGestorUsuarios.VALIDACION_EXITO;
import java.util.ArrayList;
import static pedidos.modelos.GestorPedidos.ERROR_ESTADO;


public class GestorProductos implements IGestorProductos {
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia;
                
    private GestorProductos() {
        
    }
    
    private String validarInfo(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo < 0){
            return ERROR_CODIGO;
        }
        
        if (descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        
        if (precio < 0){
            return ERROR_PRECIO;
        }
        
        if (categoria == null){
            return ERROR_CATEGORIA;
        }
        
        if (estado == null){
            return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {        
        String resultado = validarInfo(codigo, descripcion, precio, categoria, estado);
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        if (obtenerProducto(codigo) != null){
            return PRODUCTOS_DUPLICADOS;
        }
        
        Producto nuevo = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevo);
        
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (p == null || !this.productos.contains(p)){
            return PRODUCTO_INEXISTENTE;
        }
        

        String resultado = validarInfo(codigo, descripcion, precio, categoria, estado);
        if(!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        p.asignarCodigo(codigo);
        if (obtenerProducto(codigo) != null){
            return PRODUCTOS_DUPLICADOS;
        }            
        
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
        ArrayList<Producto> lista = new ArrayList<>();
                
        for (Producto p : productos){            
            if(p.verDescripcion().equals(descripcion)){
                lista.add(p);
            }           
        }
        
        return lista;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        if(this.productos.contains(producto)){
            return true;
        }
        else{
           return false; 
        }
    }
    
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> categorias = new ArrayList<>();
        
        for(Producto pr : productos){
            if(pr.verCategoria().equals(categoria)){
                categorias.add(pr);
            }
        }
        
        return categorias;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto pr : productos){
            if(pr.verCodigo() == codigo){
                return pr;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        
    }
}
