package principal.controladores;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        
        IGestorProductos gp = GestorProductos.instanciar();
        IGestorUsuarios gu = GestorUsuarios.crear();
        IGestorPedidos gpe = GestorPedidos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
                        
        System.out.println(gu.crearUsuario("correo@gmail.com", "Mensege", "Lyan", Perfil.CLIENTE, "contraseña", "contraseña"));
        
        System.out.println(gpe.crearPedido(LocalDate.EPOCH, LocalTime.NOON, unProducto2, cliente));
        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oducto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
            
        Producto unProducto2 = gp.obtenerProducto(3);
        
        System.out.println(gp.borrarProducto(unProducto2));
        
        Usuario unUsuario = gu.obtenerUsuario("correo");
        
        
         System.out.println(gu.borrarUsuario(unUsuario));
            
        }
    }
}
