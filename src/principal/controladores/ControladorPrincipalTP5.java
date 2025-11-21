package principal.controladores;

import java.util.ArrayList;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {
        GestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.NO_DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(4, "niggers", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        System.out.println(gp.borrarProducto(gp.menu().get(2)));
//                         
//        for(Producto p : gp.menu()) {
//            p.mostrar();
//        }
//
//        Producto unProducto = gp.obtenerProducto(1);
//        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
//        for(Producto p : gp.menu()) {
//            p.mostrar();
//        }
//        
//        List<Producto> productosBuscados = gp.buscarProductos("oducto");
//        for(Producto p : productosBuscados) {
//            p.mostrar();
//        }
//        
//        System.out.println(gp.existeEsteProducto(unProducto));
//        
//        List<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
//        for(Producto p : productosEntrada) {
//            p.mostrar();
//        }
//
    }
}
