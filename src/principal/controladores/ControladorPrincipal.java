package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;

import productos.modelos.Producto;
import usuarios.modelos.*;

public class ControladorPrincipal {

    public static void main(String[] args) {

        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<ProductoDelPedido> productosDelPedido1 = new ArrayList<>();
        ArrayList<ProductoDelPedido> productosDelPedido2 = new ArrayList<>();

        Producto prod1 = new Producto(1, "Pizza", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 2500);
        Producto prod2 = new Producto(2, "Pancho", Categoria.ENTRADA, Estado.DISPONIBLE, 500);
        Producto prod3 = new Producto(3, "Hamburguesa", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 3000);
        Producto prod4 = new Producto(1, "Pizza", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 3000);

        if (!listaProductos.contains(prod1)) {
            listaProductos.add(prod1);
        }
        if (!listaProductos.contains(prod2)) {
            listaProductos.add(prod2);
        }
        if (!listaProductos.contains(prod3)) {
            listaProductos.add(prod3);
        }
        if (!listaProductos.contains(prod4)) {
            listaProductos.add(prod4);
            System.out.println("Lo mismo se agregó prod4, no deberia.");
        }

//        System.out.println("Imprimo los productos");
//        for (Producto p : listaProductos) {
//            p.mostrar();
//        }
        Usuario u1 = new Cliente("correo1@gmail.com", "1234", "Apellido1", "Nombre1");
        Usuario u2 = new Empleado("correo2@gmail.com", "1234", "Apellido1", "Nombre1");
        Usuario u3 = new Encargado("correo1@gmail.com", "123433", "Apellido1", "Nombre1");
        Usuario u4 = new Empleado("correo2@gmail.com", "123433", "Apellido1", "Nombre1");
        Usuario u5 = new Cliente("correo3@gmail.com", "123433", "Apellido1", "Nombre1");

        if (!listaUsuarios.contains(u1)) {
            listaUsuarios.add(u1);
        }
        if (!listaUsuarios.contains(u2)) {
            listaUsuarios.add(u2);
        }
        if (!listaUsuarios.contains(u3)) {
            listaUsuarios.add(u3);
        }
        if (!listaUsuarios.contains(u4)) {
            listaUsuarios.add(u4);
        }
        if (!listaUsuarios.contains(u5)) {
            listaUsuarios.add(u5);
        }
//        System.out.println("Imprimo los Usuarios");
//        for (Usuario u : listaUsuarios) {
//            u.mostrar();
//        }

//        System.out.println("Imrpimo solo los clientes");
//        for (Usuario u : listaUsuarios) {
//            if (u instanceof Cliente) {
//                u.mostrar();
//            }
//        }
        Pedido ped1 = new Pedido(1, LocalDateTime.now(), productosDelPedido1, (Cliente) listaUsuarios.get(0));
        Pedido ped2 = new Pedido(2, LocalDateTime.now(), productosDelPedido1, (Cliente) (Cliente) listaUsuarios.get(0));
        Pedido ped3 = new Pedido(3, LocalDateTime.now(), productosDelPedido1, (Cliente) (Cliente) listaUsuarios.get(2));
        Pedido ped4 = new Pedido(2, LocalDateTime.now(), productosDelPedido1, (Cliente) (Cliente) listaUsuarios.get(2));

        if (!listaPedidos.contains(ped1)) {
            listaPedidos.add(ped1);
        }
        if (!listaPedidos.contains(ped2)) {
            listaPedidos.add(ped2);
        }
//        if (!listaPedidos.contains(ped3)) {
//            listaPedidos.add(ped3);
//        }
//        if (!listaPedidos.contains(ped4)) {
//            listaPedidos.add(ped4);
//        }

//        System.out.println("Imprimo los Pedidos");
//        for (Pedido p : listaPedidos) {
//            p.mostrar();
//        }
        ProductoDelPedido pdp1 = new ProductoDelPedido(prod1, 5);
        ProductoDelPedido pdp2 = new ProductoDelPedido(prod2, 2);
        ProductoDelPedido pdp3 = new ProductoDelPedido(prod3, 3);
        ProductoDelPedido pdp4 = new ProductoDelPedido(prod3, 6);

        if (!productosDelPedido1.contains(pdp1)) {
            productosDelPedido1.add(pdp1);
        }
        if (!productosDelPedido1.contains(pdp2)) {
            productosDelPedido1.add(pdp2);
        }
        if (!productosDelPedido2.contains(pdp2)) {
            productosDelPedido2.add(pdp2);
        }
        if (!productosDelPedido2.contains(pdp2)) {
            productosDelPedido2.add(pdp2);
        }

        ped1.setCantidadProducto(productosDelPedido1);
        ped2.setCantidadProducto(productosDelPedido2);

//        System.out.println("Imprimo los Productos de cada pedido");
//        for (ProductoDelPedido p : productosDelPedido1) {
//            p.mostrar();
//        }
//
//        System.out.println("pedido 2");
//        for (ProductoDelPedido p : productosDelPedido2) {
//            p.mostrar();
//        }
        
        ((Cliente) u1).setPedidos(listaPedidos);
        ((Cliente) u5).agregarPedido(ped3);
        ((Cliente) u5).agregarPedido(ped4);

        ((Cliente)u1).mostrar();
    }
}
