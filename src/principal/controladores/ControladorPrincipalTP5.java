package principal.controladores;

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
import usuarios.modelos.Empleado;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        // Prueba de GestorProductos
        GestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(5, "Producto5", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(4, "Producto6", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        
        List<Producto> productosBuscados = gp.buscarProductos("2");                
        for(Producto p : productosBuscados) {
            p.mostrar();
            System.out.println("");
        }
   

//        Producto unProducto = gp.obtenerProducto(1);
//        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
//        for(Producto p : gp.menu()) {
//            p.mostrar();
//        }
//        
//        List<Producto> productosBuscados = gp.buscarProductos("oducto");
//        for(Producto p : productosBuscados) {
//            p.mostrar();
//            System.out.println("");
//        }
//        
//        System.out.println(gp.existeEsteProducto(unProducto));
//        
//        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
//        for(Producto p : productosEntrada) {
//            p.mostrar();
//        }
//        
        // Prueba de GestorUsuarios

        GestorUsuarios gu = GestorUsuarios.instanciar();
        gu.crearUsuario("correo@cliente1", "1234", "1", "a", Perfil.CLIENTE, "1234");
        gu.crearUsuario("correo@cliente2", "1234", "1", "a", Perfil.CLIENTE, "1234");
        gu.crearUsuario("correo@cliente3", "1234", "1", "a", Perfil.CLIENTE, "1234");
        gu.crearUsuario("correo@empleado1", "0000", "3", "c", Perfil.EMPLEADO, "0000");
        gu.crearUsuario("correo@empleado2", "0000", "3", "b", Perfil.EMPLEADO, "0000");
        gu.crearUsuario("correo@empleado3", "0000", "2", "d", Perfil.EMPLEADO, "0000");
        
               
        for(Usuario u : gu.buscarUsuarios("3")) {
            u.mostrar();
            System.out.println("");
        }
 

//        // Prueba de GestorPedidos
//      
        
        List<ProductoDelPedido> listapdp1 = new ArrayList();
        ProductoDelPedido pdp1 = new ProductoDelPedido(gp.obtenerProducto(1),2);
        ProductoDelPedido pdp2 = new ProductoDelPedido(gp.menu().get(0), 2);        
        if (!listapdp1.contains(pdp1))
            listapdp1.add(pdp1);
        if (!listapdp1.contains(pdp2))
            listapdp1.add(pdp2);
        
        List<ProductoDelPedido> listapdp2 = new ArrayList();
        ProductoDelPedido pdp3 = new ProductoDelPedido(gp.obtenerProducto(1),2);
        ProductoDelPedido pdp4 = new ProductoDelPedido(gp.menu().get(0), 2);        
        if (!listapdp2.contains(pdp3))
            listapdp2.add(pdp3);
        if (!listapdp2.contains(pdp4))
            listapdp2.add(pdp4);
        
        List<ProductoDelPedido> listapdp3 = new ArrayList();
        ProductoDelPedido pdp5 = new ProductoDelPedido(gp.obtenerProducto(1),2);
        ProductoDelPedido pdp6 = new ProductoDelPedido(gp.menu().get(0), 2);        
        if (!listapdp3.contains(pdp5))
            listapdp3.add(pdp5);
        if (!listapdp3.contains(pdp6))
            listapdp3.add(pdp6);
        
        GestorPedidos gpe = GestorPedidos.instanciar();
        
        System.out.println(gpe.crearPedido(LocalDate.now(),LocalTime.now(),listapdp1,(Cliente)gu.ObtenerUsuario("correo@cliente1")));
        System.out.println(gpe.crearPedido(LocalDate.now(),LocalTime.now(),listapdp2,(Cliente)gu.ObtenerUsuario("correo@cliente2")));
        System.out.println(gpe.crearPedido(LocalDate.now(),LocalTime.now(),listapdp3,(Cliente)gu.ObtenerUsuario("correo@cliente3")));
        gpe.obtenerPedido(1).asignarNumero(5);
        
        Empleado e1=(Empleado)gu.ObtenerUsuario("correo@empleado1");
        for(Pedido pe : e1.verPedidos()) {
            pe.mostrar();
        }
        
    }
}
//        
//        System.out.println("El estado del pedido numero 1 se modifico a: "+ gpe.cambiarEstado(gpe.obtenerPedido(1)));
//        
//        if(gpe.hayPedidosConEsteCliente((Cliente)gu.ObtenerUsuario("correo@cliente1"))){
//            System.out.println("El Cliente: "+(Cliente)gu.ObtenerUsuario("correo@cliente1")+"si tiene un pedido");
//        }
//        if(gpe.hayPedidosConEsteProducto(gp.obtenerProducto(1))){
//            System.out.println("Si hay pedidos con " + gp.obtenerProducto(1).verDescripcion());
//        }else {
//            System.out.println("no hay pedidos con" + gp.obtenerProducto(1).verDescripcion());
//        }
        
//        
//    }
//}
