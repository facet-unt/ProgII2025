package principal.controladores;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
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
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        IGestorProductos gp = GestorProductos.instanciar();
        System.out.println("\n--- Creo Productos ---");
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        System.out.println("\n--- Menu de Productos ---");
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
    System.out.println("\n--- Modifico Producto 1 y muestro Menu---");
        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        System.out.println("\n--- Busco productos que contienen 'oducto' ---");
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oducto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        System.out.println("\n--- Busco si existe producto 1  ---");
        System.out.println(gp.existeEsteProducto(unProducto));
        System.out.println("\n--- Busco productos por Categoria: ENTRADA ---");
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        System.out.println(gu.crearUsuario("cliente@mail.com", "Perez", "Juan", Perfil.CLIENTE, "clave123", "clave123"));
        System.out.println(gu.crearUsuario("admin@mail.com", "Gomez", "Ana", Perfil.ENCARGADO, "admin", "admin"));
        System.out.println(gu.crearUsuario("cliente@mail.com", "Soto", "Carlos", Perfil.CLIENTE, "clave789", "clave789")); // Fallo duplicado

        System.out.println("\n--- Lista de Usuarios ---");
        for(Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }

        System.out.println("\n--- Buscando usuarios apellido 'Gomez' ---");
        for(Usuario u : gu.buscarUsuarios("Gomez")) {
            u.mostrar();
        }
        
        Usuario uAdmin = gu.obtenerUsuario("admin@mail.com");
        System.out.println(gu.borrarUsuario(uAdmin)); // Borrado
        IGestorPedidos gpe = GestorPedidos.instanciar();
        Usuario uCliente = gu.obtenerUsuario("cliente@mail.com");
        System.out.println("\n--- Creando Pedido ---");
        ArrayList<ProductoDelPedido> prods = new ArrayList<>();
        prods.add(new ProductoDelPedido(gp.obtenerProducto(2), 2)); // 2 Producto2
        System.out.println(gpe.crearPedido(LocalDate.now(), LocalTime.now(), prods, (Cliente)uCliente)); // Pedido 1
        
        Pedido pedido1 = gpe.obtenerPedido(1);
        
        // --- Cambio de Estado ---
        System.out.println("\n--- Cambiando Estado de Pedido 1 ---");
        System.out.println("Estado actual: " + pedido1.verEstado());
        System.out.println(gpe.cambiarEstado(pedido1)); // A PROCESANDO
        System.out.println("Nuevo estado: " + pedido1.verEstado());
        
        // --- Intento Borrar:---
        System.out.println("\n--- Borrado, Falla ---");
        System.out.println("Intentando borrar Producto 1: " + gp.borrarProducto(gp.obtenerProducto(2)));
        System.out.println("Intentando borrar Cliente: " + gu.borrarUsuario(uCliente));

        // --- Cancelo el pedido ---
        System.out.println("\n--- Cancelando Pedido ---");
        System.out.println(gpe.cancelarPedido(pedido1)); // Pedido 1 se cancela

        // --- Intento Borrar: ---
        System.out.println("\n--- Probando Borrado, Funciona ---");
        System.out.println("Intentando borrar Producto 1: " + gp.borrarProducto(gp.obtenerProducto(2)));
        System.out.println("Intentando borrar Cliente: " + gu.borrarUsuario(uCliente));
    }
}
