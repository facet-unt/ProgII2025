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
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
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
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oducto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
        
//        // -------------------- GESTOR USUARIOS --------------------
//        System.out.println("\n=== PRUEBA GESTOR USUARIOS ===");
//        GestorUsuarios gu = GestorUsuarios.instanciar();
//
//        System.out.println(gu.crearUsuario("cliente1@mail.com", "Perez", "Ana", Perfil.CLIENTE, "123", "123"));
//        System.out.println(gu.crearUsuario("empleado1@mail.com", "Gomez", "Juan", Perfil.EMPLEADO, "123", "123"));
//        System.out.println(gu.crearUsuario("encargado1@mail.com", "Sosa", "Maria", Perfil.ENCARGADO, "123", "123"));
//        System.out.println("Intento duplicado: " + gu.crearUsuario("cliente1@mail.com", "Perez", "Ana", Perfil.CLIENTE, "123", "123"));
//
//        System.out.println("\nLista de usuarios registrados:");
//        for (var u : gu.verUsuarios()) {
//            System.out.println(u.verCorreo() + " - " + u.verApellido() + ", " + u.verNombre());
//        }
//
//        Cliente cliente = (Cliente) gu.obtenerUsuario("cliente1@mail.com");
//        Empleado empleado = (Empleado) gu.obtenerUsuario("empleado1@mail.com");
//        Encargado encargado = (Encargado) gu.obtenerUsuario("encargado1@mail.com");
//
//        // -------------------- GESTOR PEDIDOS --------------------
//        System.out.println("\n=== PRUEBA GESTOR PEDIDOS ===");
//        GestorPedidos gped = GestorPedidos.instanciar();
//
//        // Crear productos para usar en los pedidos
//        Producto p1 = new Producto(10, "Pizza", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 2500f);
//        Producto p2 = new Producto(11, "Flan", Categoria.POSTRE, Estado.DISPONIBLE, 1200f);
//
//        ArrayList<ProductoDelPedido> listaProductos = new ArrayList<>();
//        listaProductos.add(new ProductoDelPedido(p1, 2));
//        listaProductos.add(new ProductoDelPedido(p2, 1));
//
//        // Crear pedido correcto
//        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), listaProductos, cliente));
//
//        // Crear pedido con cliente nulo (debe dar error)
//        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), listaProductos, null));
//
//        System.out.println("\nLista de pedidos registrados:");
//        for (Pedido p : gped.verPedidos()) {
//            p.mostrar();
//        }
//
//        // Cambiar estado de pedido 1 si existe
//        Pedido primerPedido = gped.obtenerPedido(1);
//        if (primerPedido != null) {
//            System.out.println("Estado actual: " + primerPedido.verEstado());
//            System.out.println("Resultado cambiarEstado: " + gped.cambiarEstado(primerPedido));
//            System.out.println("Nuevo estado: " + primerPedido.verEstado());
//        }
//
//        System.out.println("\nPedidos vistos por empleado:");
//        for (Pedido p : empleado.verPedidos()) {
//            System.out.println(p.verNumero() + " - " + p.verEstado());
//        }
//
//        System.out.println("\nPedidos vistos por encargado:");
//        for (Pedido p : encargado.verPedidos()) {
//            System.out.println(p.verNumero() + " - " + p.verEstado());
//        }
//
//        System.out.println("\nHay pedidos con este cliente?: " + gped.hayPedidosConEsteCliente(cliente));
//        System.out.println("Hay pedidos con este producto (Pizza)?: " + gped.hayPedidosConEsteProducto(p1));
    }
//        
}
