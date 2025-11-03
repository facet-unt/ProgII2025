package principal.controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        GestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
                        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("Producto1");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
          
        System.out.println("GESTOR PEDIDOS");
        
        GestorUsuarios gu = GestorUsuarios.instanciar();
        System.out.println(gu.crearUsuario("correo@gmail", "apellido", "nombre", Perfil.CLIENTE, "clave12", "clave12"));
        ArrayList<ProductoDelPedido> pdp= new ArrayList<ProductoDelPedido>();
        
       ProductoDelPedido pdp1= new ProductoDelPedido(gp.obtenerProducto(1), 1 );
       pdp.add(pdp1);
        
        GestorPedidos gped = GestorPedidos.instanciar();
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), pdp,(Cliente)gu.obtenerUsuario("correo") ));
        Pedido ped1= gped.obtenerPedido(1);
        System.out.println(gped.existeEstePedido(ped1));
        
        gped.cambiarEstado(gped.obtenerPedido(1));
        
        System.out.println(gped.obtenerPedido(1).getEstado());
        
        System.out.println(gped.hayPedidosConEsteCliente((Cliente)gu.obtenerUsuario("correo")));
        
        System.out.println(gped.hayPedidosConEsteProducto(unProducto));
        
        System.out.println("GESTOR USUARIOS");
        
        System.out.println(gu.buscarUsuarios("apellido"));
        
        System.out.println(gu.existeEsteUsuario(gu.obtenerUsuario("correo@gmail")));
        
    }
    
    
    
    
}
