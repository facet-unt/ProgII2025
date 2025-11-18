package productos.modelos;

import Interfaces.IGestorProductos;
import static Interfaces.IGestorProductos.ERROR_CATEGORIA;
import static Interfaces.IGestorProductos.ERROR_CODIGO;
import static Interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static Interfaces.IGestorProductos.ERROR_PRECIO;
import static Interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static Interfaces.IGestorProductos.PRODUCTO_INEXISTENTE;
import static Interfaces.IGestorProductos.ERROR_BORRADO;
import static Interfaces.IGestorProductos.EXITO_BORRADO;
import pedidos.modelos.GestorPedidos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class GestorProductos implements IGestorProductos{
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia; //implementacion para se pueda instancias una vez
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    

    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
                
                if (codigo <= 0){
                   return ERROR_CODIGO;
                   }else if (descripcion == null || descripcion.isEmpty()){
                    return ERROR_DESCRIPCION;
                   }else if(precio <= 0){
                       return ERROR_PRECIO;
                   }else if(categoria == null){
                       return ERROR_CATEGORIA;
                   }else if(estado == null){
                   return ERROR_ESTADO;}

                Producto p = new Producto (codigo, descripcion, precio, categoria, estado);
                if (!productos.contains(p)){
                    productos.add(p);
                return EXITO;
                }else{
                return PRODUCTOS_DUPLICADOS;
                }
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
            this.obtenerProducto(codigo);
            if (!this.productos.contains(productoAModificar)){ //agrego un control para saber si el que quiero modificar existe
            return PRODUCTO_INEXISTENTE;
            }
            Producto p = this.obtenerProducto(codigo);
            if (p != null && !p.equals(this.obtenerProducto(codigo))) {
            // ... entonces es un duplicado.
            return PRODUCTOS_DUPLICADOS;
 }
            //modifico el producto que necesito
                    productoAModificar.asignarCategoria(categoria);
                    productoAModificar.asignarDescripcion(descripcion);
                    productoAModificar.asignarEstado(estado);
                    productoAModificar.asignarPrecio(precio);
                    productoAModificar.asignarCodigo(codigo); 
                    return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        Comparator<Producto> cComp = new Comparator<Producto>(){//va sin las <> al final pues da error
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verCategoria().compareTo(p2.verCategoria());
                }
         };//fin  del primer criterio de comparacion
         Comparator<Producto> dComp = new Comparator<Producto>(){
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verDescripcion().compareTo(p2.verDescripcion()); 
         }
         };//fin  del segundo criterio de comparacion
                Comparator<Producto> combinado = cComp.thenComparing (dComp); //combina ambos criterios de comparacion
               productos.sort(combinado); //recibe la lista y la compara
               return productos; //devuelve la lista ordenada
    }
    
    
    public List<Producto> buscarProductos(String descripcion) {
            if (descripcion == null){
                System.out.println("erro en la descripcion");
            return null;
        }
        ArrayList <Producto> productosEncontrados = new ArrayList<>();
        for (Producto p : productos){
            if (p.verDescripcion().equals(descripcion))
                productosEncontrados.add(p);
        }
         Comparator<Producto> cComp = new Comparator<Producto>(){//va sin las <> al final pues da error
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verCategoria().compareTo(p2.verCategoria());
                }
         };//fin  del primer criterio de comparacion
         Comparator<Producto> dComp = new Comparator<Producto>(){
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verDescripcion().compareTo(p2.verDescripcion()); 
         }
         };//fin del segundo criterio de comparacion
        Comparator<Producto> combinado = cComp.thenComparing(dComp);
        productosEncontrados.sort(combinado);
        return productosEncontrados;
    }
    
    
    
    
    
    
    public String borrarProducto(Producto producto){
        GestorPedidos gp = GestorPedidos.instanciar();  //uso el gestor de pedidos para obtener los podructos de cada pedido
        if (gp.hayPedidosConEsteProducto(producto)){//controlo que haya pedidos con ese producto
            return ERROR_BORRADO;
        }
        this.productos.remove(producto);
        return EXITO_BORRADO;
    }
    
    public boolean existeEsteProducto(Producto producto) {
        if (productos.contains(producto))
        return true;
        else
            return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList <Producto> Encontrados = new ArrayList<>();
        for (Producto p : productos){
         if ( p.verCategoria().equals(categoria))
             Encontrados.add(p);   
        }
        Comparator<Producto> dComp = new Comparator<Producto>(){//va sin las <> al final pues da error
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verDescripcion().compareTo(p2.verDescripcion());
                }
         };//fin del criterio de comparacion
        Encontrados.sort(dComp);
        return Encontrados;
    }
    
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos){   
            if (p.verCodigo() == codigo) {
                return p;
            }
            }
        return null;
    }
    
    
}
