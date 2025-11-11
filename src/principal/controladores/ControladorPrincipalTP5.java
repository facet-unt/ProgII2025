package principal.controladores;

import interfaces.IGestorProductos;
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

public class ControladorPrincipalTP5 {
    public static void main(String[] args) {
        
        // PRODUCTOS
        
        IGestorProductos gp = GestorProductos.instanciar();
        
        System.out.println("\n=== CREACION DE PRODUCTOS ===");
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE));
           
        System.out.println("\n--- MENU COMPLETO ---");
        for (Producto p : gp.menu()) p.mostrar();

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println("\n--- MODIFICACIUN DE PRODUCTO ---");
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        
        System.out.println("\n--- MENU LUEGO DE MODIFICAR ---");
        for (Producto p : gp.menu()) p.mostrar();
        
        System.out.println("\n--- BUSQUEDA DE PRODUCTOS ('Producto2') ---");
        for (Producto p : gp.buscarProductos("Producto2")) p.mostrar();
       
        System.out.println("\n--- EXISTENCIA DE PRODUCTO ---");
        System.out.println(gp.existeEsteProducto(unProducto));
        
        System.out.println("\n--- PRODUCTOS POR CATEGORIA (ENTRADA) ---");
        for (Producto p : gp.verProductosPorCategoria(Categoria.ENTRADA)) p.mostrar();
        
        // USUARIOS
        
        GestorUsuarios gu = GestorUsuarios.instanciar();
        
        System.out.println("\n=== CREACION DE USUARIOS ===");
        System.out.println(gu.crearUsuario("correo1@gmail.com", "Apellido1", "Nombre1", Perfil.CLIENTE, "Clave1", "Clave1"));
        System.out.println(gu.crearUsuario("correo2@gmail.com", "Apellido2", "Nombre2", Perfil.EMPLEADO, "Clave2", "Clave2"));
        System.out.println(gu.crearUsuario("correo3@gmail.com", "Apellido3", "Nombre3", Perfil.ENCARGADO, "Clave3", "Clave3"));

        System.out.println("\n--- LISTA DE USUARIOS ---");
        for (Usuario u : gu.verUsuarios()) u.mostrar();

        Usuario unUsuario = gu.obtenerUsuario("correo1@gmail.com");
        System.out.println("\n--- EXISTENCIA DE USUARIO ---");
        System.out.println(gu.existeEsteUsuario(unUsuario));
        
        System.out.println("\n--- BUSQUEDA DE USUARIOS ('Apellido') ---");
        for (Usuario u : gu.buscarUsuarios("Apellido")) u.mostrar();
        
        // PEDIDOS
        
        GestorPedidos gped = GestorPedidos.instanciar();

        System.out.println("\n=== CREACION DE PEDIDOS ===");
        Cliente cliente1 = (Cliente) gu.obtenerUsuario("correo1@gmail.com");
        Producto prod1 = gp.obtenerProducto(1);
        Producto prod2 = gp.obtenerProducto(2);
        Producto prod3 = gp.obtenerProducto(3);
        
        ArrayList<ProductoDelPedido> lista1 = new ArrayList<>();
        lista1.add(new ProductoDelPedido(prod1, 2));
        lista1.add(new ProductoDelPedido(prod2, 1));

        ArrayList<ProductoDelPedido> lista2 = new ArrayList<>();
        lista2.add(new ProductoDelPedido(prod3, 3));

        ArrayList<ProductoDelPedido> lista3 = new ArrayList<>();
        lista3.add(new ProductoDelPedido(prod2, 2));
        lista3.add(new ProductoDelPedido(prod3, 1));
        
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista1, cliente1));
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista2, cliente1));
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista3, cliente1));
        
        System.out.println("\n--- PEDIDOS CREADOS ---");
        for (Pedido p : gped.verPedidos()) p.mostrar();

        Pedido unPedido = gped.obtenerPedido(1);
        System.out.println("\n--- CAMBIOS DE ESTADO EN PEDIDO 1 ---");
        System.out.println(gped.cambiarEstado(unPedido)); 
        System.out.println(gped.cambiarEstado(unPedido)); 
        System.out.println(gped.cancelarPedido(unPedido));

        Pedido pedido2 = gped.obtenerPedido(2);
        System.out.println("\n--- CAMBIOS DE ESTADO EN PEDIDO 2 ---");
        System.out.println(gped.cambiarEstado(pedido2));
        System.out.println(gped.cancelarPedido(pedido2)); 

        System.out.println("\n--- PEDIDOS LUEGO DE CAMBIOS ---");
        for (Pedido p : gped.verPedidos()) p.mostrar();
        
        System.out.println("\n--- COMPROBACIONES ---");
        System.out.println("Existe pedido 1: " + gped.existeEstePedido(unPedido));
        System.out.println("Hay pedidos con cliente1: " + gped.hayPedidosConEsteCliente(cliente1));
        System.out.println("Hay pedidos con prod1: " + gped.hayPedidosConEsteProducto(prod1));
        
        System.out.println("\n=== BORRADO DE USUARIOS Y PRODUCTOS SIN PEDIDOS ===");

        Usuario usuarioSinPedidos = gu.obtenerUsuario("correo2@mail.com");
        System.out.println(gu.borrarUsuario(usuarioSinPedidos));

        Producto productoSinPedidos = gp.obtenerProducto(3);
        System.out.println(gp.borrarProducto(productoSinPedidos));

        System.out.println("\n--- USUARIOS RESTANTES ---");
        for (Usuario u : gu.verUsuarios()) u.mostrar();

        System.out.println("\n--- PRODUCTOS RESTANTES ---");
        for (Producto p : gp.menu()) p.mostrar();
    }
}