package principal.controladores;

import interfaces.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        IGestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        
        /* Productos nuevos agregados para comprobar funcionamiento del metodo compareTo TP6 */
        System.out.println(gp.crearProducto(4, "Producto4", 4.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(5, "Producto5", 5.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(6, "Producto6", 6.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
                        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        System.out.println("\n");
        
        
//        System.out.println("----PRUEBAS GESTOR PRODUCTOS----");
//        Producto unProducto = gp.obtenerProducto(1);
//        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 4554.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
//            System.out.println("----PRODUCTO MODIFICADO----");
//            unProducto.mostrar();
//        
//        List<Producto> productosBuscados = gp.buscarProductos("Producto4");
//        for(Producto p : productosBuscados) {
//            System.out.println("----PRODUCTO ENCONTRADO----");
//             p.mostrar();
//        }
//        
//        System.out.println("Existe producto3: " + gp.existeEsteProducto(unProducto));
//        
//        System.out.println("----PRODUCTOS POR CATEGORIA----");
//        List<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
//        for(Producto p : productosEntrada) {
//            p.mostrar();
//        }
//            
//        System.out.println("\n");
//        
//        System.out.println("----PRUEBAS GESTOR USUARIOS---");
//        IGestorUsuarios gu = GestorUsuarios.instanciar();
//        
//        System.out.println(gu.crearUsuario("correo1@mail.com", "Ortega", "Rocio", Perfil.EMPLEADO, "clave1", "clave1")); 
//        System.out.println(gu.crearUsuario("correo2@mail.com", "Ortega", "Sofia", Perfil.CLIENTE, "clave2", "clave2"));
//         
//        for(Usuario u : gu.verUsuarios())
//            u.mostrar();
//        
//        
//        List<Usuario> usuariosBuscados = gu.buscarUsuarios("Apellido1"); 
//        System.out.println("Usuarios buscados por Apellido1:");
//        for(Usuario u : usuariosBuscados) {
//            System.out.println(u.toString()); 
//        }
//        
//        Usuario usuario2 = gu.obtenerUsuario("correo2@mail.com"); 
//        System.out.println("Existe usuario2: " + gu.existeEsteUsuario(usuario2)); 
//        
//        System.out.println("\n");
//        
//
//        System.out.println("\n--- PRUEBAS GESTOR PEDIDOS ---");
//        IGestorPedidos gpe = GestorPedidos.instanciar();
//        
//        ArrayList<ProductoDelPedido> productosDelPedido = new ArrayList<>();
//        productosDelPedido.add(new ProductoDelPedido(gp.obtenerProducto(1), 2)); 
//        productosDelPedido.add(new ProductoDelPedido(gp.obtenerProducto(3), 1));
//        Cliente unCliente = new Cliente("correo2@mail.com","clave2", "Apellido2", "Nombre2");
//        
//        System.out.println(gpe.crearPedido(LocalDate.now(), LocalTime.now(), productosDelPedido, unCliente));
//        
//        List<Pedido> pedidosDelSistema = gpe.verPedidos(); 
//        System.out.println("Pedidos en el sistema: " + pedidosDelSistema.size());
//        
//        System.out.println("Hay pedidos con Producto 1: " + gpe.hayPedidosConEsteProducto(gp.obtenerProducto(1))); 
//        System.out.println("Hay pedidos con Cliente 2: " + gpe.hayPedidosConEsteCliente(unCliente)); 
//        
//        Pedido unPedido = gpe.obtenerPedido(1); 
//        if (unPedido != null) {
//            System.out.println("Cancelando Pedido 1: " + gpe.cancelarPedido(unPedido)); 
//            System.out.println("Existe Pedido 1 después de cancelar: " + gpe.existeEstePedido(unPedido)); 
//        }
//        
//        System.out.println("\n");
//        
//         /* AGREGADO PARA COMPROBAR FUNCIONAMIENTO DE METODOS NUEVOS DEL TP5 */
//        
//        Producto unProducto1 = gp.obtenerProducto(2);
//        System.out.println(gp.borrarProducto(unProducto1));
//        System.out.println("------PRODUCTOS DESPUES DE BORRAR UNO------");
//        for(Producto p : gp.menu()) {
//            p.mostrar();
//        }
//        
//        System.out.println(gu.borrarUsuario(usuario2));
//        for(Usuario u : gu.verUsuarios())
//        {
//            System.out.println("-----LISTA DESPUES DE BORRAR UN USUARIO-----"); 
//            u.mostrar();
//        }
//        
//         
         
        
        
    }
}
    
    
    
    

