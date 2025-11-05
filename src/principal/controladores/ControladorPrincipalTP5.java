package principal.controladores;

import interfaces.IGestorProductos;
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



public class ControladorPrincipalTP5 {
    public static void main(String[] args) {      
        IGestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE));
                        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("Producto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();               
        }    
        

        for (Producto p : gp.menu()) {
            p.mostrar();//Vuelvo a mostrar los productos, si se elimino uno ya no aparece
        
        }
        //No borramos todavia al producto, ya que puede tener un pedido que lo contenga
          GestorUsuarios gu = GestorUsuarios.instanciar();

        
        System.out.println(gu.crearUsuario("correo1@gmail.com", "Apellido1", "Nombre1", Perfil.CLIENTE, "Clave1", "Clave1"));
        System.out.println(gu.crearUsuario("correo2@gmail.com", "Apellido2", "Nombre2", Perfil.EMPLEADO, "Clave2", "Clave2"));
        System.out.println(gu.crearUsuario("correo3@gmail.com", "Apellido3", "Nombre3", Perfil.ENCARGADO, "Clave3", "Clave3"));

        
        for (Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }

        Usuario unUsuario = gu.obtenerUsuario("correo1@gmail.com");
        System.out.println(gu.existeEsteUsuario(unUsuario));

        ArrayList<Usuario> usuariosBuscados = gu.buscarUsuarios("Apellido");
        for (Usuario u : usuariosBuscados) {
            u.mostrar();
        }

       
        GestorPedidos gped = GestorPedidos.instanciar();

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

        // Creamos los tres pedidos
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista1, cliente1));
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista2, cliente1));
        System.out.println(gped.crearPedido(LocalDate.now(), LocalTime.now(), lista3, cliente1));

        for (Pedido p : gped.verPedidos()) {
            p.mostrar();
        }


        
        Pedido unPedido = gped.obtenerPedido(1);
        System.out.println(gped.cambiarEstado(unPedido)); 
        System.out.println(gped.cambiarEstado(unPedido)); 
        System.out.println(gped.cancelarPedido(unPedido));

        Pedido pedido2 = gped.obtenerPedido(2);
        System.out.println(gped.cambiarEstado(pedido2));
        System.out.println(gped.cancelarPedido(pedido2)); 

        for (Pedido p : gped.verPedidos()) {
            p.mostrar();
        }

        System.out.println(gped.existeEstePedido(unPedido));
        System.out.println(gped.hayPedidosConEsteCliente(cliente1));
        System.out.println(gped.hayPedidosConEsteProducto(prod1));

      
        // Borramos usuarios sin pedidos(Empleados y encargados?) Preguntar
        Usuario usuarioSinPedidos = gu.obtenerUsuario("correo2@mail.com");
        System.out.println(gu.borrarUsuario(usuarioSinPedidos));

        // Mostramos los usuarios que quedan
        for (Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }

        // Borramos los productos que no estan en ningun pedido
        Producto productoSinPedidos = gp.obtenerProducto(3);
        System.out.println(gp.borrarProducto(productoSinPedidos));

        for (Producto p : gp.menu()) {
            p.mostrar();
        }
    
    }
}