package principal.controladores;

import interfaces.IGestorProductos;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.modelos.Categoria;
import productos.modelos.Estado;

import interfaces.IGestorUsuarios;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.modelos.Perfil;
import usuarios.modelos.Cliente;

import interfaces.IGestorPedidos;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.ProductoDelPedido;
import pedidos.modelos.Pedido;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ControladorPrincipalTP5 {

    public static void main(String[] args) {
        
      
        IGestorProductos gp = GestorProductos.instanciar();

        System.out.println(gp.crearProducto(1, "Empanadas", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Helado", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Pizza", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(4, "Fideos", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(5, "Tarta", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));

        
        for (Producto p : gp.menu()) {
            p.mostrar();
            System.out.println("\n");
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Milanesa", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));

        for (Producto p : gp.menu()) {
            p.mostrar();
        }

        List<Producto> productosBuscados = gp.buscarProductos("Pizza");
        for (Producto p : productosBuscados) {
            p.mostrar();
        }

        System.out.println(gp.existeEsteProducto(unProducto));

        List<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for (Producto p : productosEntrada) {
            p.mostrar();
        }

        System.out.println("\n--- PRUEBA borrarProducto ---");
        Producto producto1 = gp.obtenerProducto(1);
        System.out.println(gp.borrarProducto(producto1));
        Producto producto2 = gp.obtenerProducto(4);
        System.out.println(gp.borrarProducto(producto2));


        
        IGestorUsuarios gu = GestorUsuarios.instanciarclase();

        System.out.println(gu.crearUsuario("cliente1@bar.com", "Toledo", "Juan", Perfil.CLIENTE, "holasi", "holasi"));
        System.out.println(gu.crearUsuario("encargado2@bar.com", "Peréz", "Lucas", Perfil.ENCARGADO, "tegarcho", "tegarcho"));
        System.out.println(gu.crearUsuario("empleado3@bar.com", "Callejas", "Raul", Perfil.EMPLEADO, "killyou", "killyou"));
        System.out.println(gu.crearUsuario("cliente2@bar.com", "Palavecino", "Fernando", Perfil.CLIENTE, "holasi", "holasi"));
        System.out.println(gu.crearUsuario("cliente4@bar.com", "Rush", "Santiago", Perfil.CLIENTE, "holasi", "holasi"));
        System.out.println(gu.crearUsuario("cliente3@bar.com", "Marsilli", "Maxi", Perfil.CLIENTE, "holasi", "holasi"));
        System.out.println(gu.crearUsuario("cliente6@bar.com", "Marsilli", "Jose", Perfil.CLIENTE, "holasi", "holasi"));
        System.out.println(gu.crearUsuario("cliente7@bar.com", "Toledo", "Axel", Perfil.CLIENTE, "holasi", "holasi"));

        
        for (Usuario u : gu.verUsuarios()) {
            u.mostrar();
            System.out.println("\n");
        }

        Usuario unUsuario = gu.obtenerUsuario("cliente1@bar.com");

        List<Usuario> usuariosBuscados = gu.buscarUsuarios("Marsilli");
        for (Usuario u : usuariosBuscados) {
            u.mostrar();
        }

        System.out.println(gu.existeEsteUsuario(unUsuario));

        System.out.println("\n--- PRUEBA borrarUsuario ---");
        Usuario usuario = gu.obtenerUsuario("cliente1@bar.com");
        System.out.println(gu.borrarUsuario(usuario));

        Usuario usuario2 = gu.obtenerUsuario("cliente6@bar.com");
        System.out.println(gu.borrarUsuario(usuario2));


       
        IGestorPedidos gP = GestorPedidos.getInstancia();

        
        Usuario usuarioCliente = gu.obtenerUsuario("cliente4@bar.com");

        
        Cliente cliente = null;
        if (usuarioCliente instanceof Cliente c) {
            cliente = c;
        } else {
            System.out.println("El usuario no es un cliente, no se puede crear el pedido.");
        }

        
        ArrayList<ProductoDelPedido> productosPedido = new ArrayList<>();

        Producto productoPedido = gp.obtenerProducto(2); 
        if (productoPedido != null) {
            productosPedido.add(new ProductoDelPedido(productoPedido, 2)); 
        }

        
        if (cliente != null) {
            System.out.println("\n--- PRUEBA crearPedido ---");
            System.out.println(gP.crearPedido(LocalDate.now(), LocalTime.now(), productosPedido, cliente));
        }
        Pedido pedidoCreado = gP.obtenerPedido(1); 
        if (pedidoCreado != null) {
            System.out.println("\n--- PRUEBA cancelarPedido ---");
            System.out.println(gP.cancelarPedido(pedidoCreado));
        } else {
            System.out.println("No se pudo cancelar: el pedido no existe o no fue creado correctamente.");
        }
    }  
}
