package principal.controladores;

import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.modelos.Cliente;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {
        IGestorProductos gp = GestorProductos.instanciar();
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        IGestorPedidos gped = GestorPedidos.instanciar();
        
        System.out.println("=== PRUEBA GESTOR PRODUCTOS ===");
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
        
        List<Producto> productosBuscados = gp.buscarProductos("Producto3");
        System.out.println("Productos encontrados: " + productosBuscados.size());
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println("¿Existe el producto?: " + gp.existeEsteProducto(unProducto));
        
        List<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        System.out.println("Productos ENTRADA: " + productosEntrada.size());
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
        
        System.out.println("\n=== PRUEBA GESTOR USUARIOS ===");
        System.out.println(gu.crearUsuario("Nata@gmail.com", "si", "Nata", Perfil.CLIENTE, "clave123", "clave123"));
        System.out.println(gu.crearUsuario("Lucas@mail.com", "Arroyo", "Lucas", Perfil.CLIENTE, "clave456", "clave456"));
        System.out.println(gu.crearUsuario("carlos@mail.com", "López", "Carlos", Perfil.EMPLEADO, "clave789", "clave789"));
        
        List<Usuario> usuarios = gu.verUsuarios();
        System.out.println("Total de usuarios: " + usuarios.size());
        for(Usuario u : usuarios) {
            u.mostrar();
        }
        
        List<Usuario> usuariosPérez = gu.buscarUsuarios("Arroyo");
        System.out.println("Usuarios apellido Arroyo: " + usuariosPérez.size());
        for(Usuario u : usuariosPérez) {
            u.mostrar();
        }
        
        Usuario usuarioObtenido = gu.obtenerUsuario("Nata@gmail.com");
        System.out.println("¿Existe usuario Nata@gmail.com?: " + (usuarioObtenido != null));
        
        System.out.println("\n=== PRUEBA GESTOR PEDIDOS ===");
        Cliente clienteJuan = (Cliente) gu.obtenerUsuario("Nata@gmail.com");
        
        ArrayList<ProductoDelPedido> productosDelPedido1 = new ArrayList<>();
        productosDelPedido1.add(new ProductoDelPedido(gp.obtenerProducto(1), 2));
        productosDelPedido1.add(new ProductoDelPedido(gp.obtenerProducto(2), 1));
        
        String resultadoPedido = gped.crearPedido(LocalDate.of(2025, 1, 15), LocalTime.of(12, 30), productosDelPedido1, clienteJuan);
        System.out.println("Crear pedido: " + resultadoPedido);
        
        List<Pedido> todosLosPedidos = gped.verPedidos();
        System.out.println("Total de pedidos: " + todosLosPedidos.size());
        if (!todosLosPedidos.isEmpty()) {
            todosLosPedidos.get(0).mostrar();
            
            System.out.println("\n--- Cambiar estado de pedido ---");
            System.out.println(gped.cambiarEstado(todosLosPedidos.get(0)));
            System.out.println("Estado actual: " + todosLosPedidos.get(0).verEstado());
            System.out.println(gped.cambiarEstado(todosLosPedidos.get(0)));
            System.out.println("Estado actual: " + todosLosPedidos.get(0).verEstado());
            
            System.out.println("\n--- Hay pedidos con este cliente ---");
            System.out.println("Hay pedidos con Nata: " + gped.hayPedidosConEsteCliente(clienteJuan));
            
            System.out.println("\n--- Hay pedidos con este producto ---");
            System.out.println("Hay pedidos con Producto1?: " + gped.hayPedidosConEsteProducto(gp.obtenerProducto(3)));
            
            System.out.println("\n--- Cancelar pedido ---");
            System.out.println(gped.cancelarPedido(todosLosPedidos.get(0)));
            System.out.println("Pedidos restantes: " + gped.verPedidos().size());
        }
        
        System.out.println("\n=== PRUEBA ELIMINAR PRODUCTO/USUARIO ===");
        System.out.println("Intentar borrar producto sin pedidos: " + gp.borrarProducto(gp.obtenerProducto(3)));
        System.out.println("Productos restantes: " + gp.menu().size());
        
        System.out.println("Intentar borrar usuario sin pedidos: " + gu.borrarUsuario(gu.obtenerUsuario("carlos@mail.com")));
        System.out.println("Usuarios restantes: " + gu.verUsuarios().size());
    }
}
