package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;

import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

public class ControladorPrincipal {
    public static void main(String[] args) {
        // ========================
        // PRIMERA PARTE
        // ========================

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Empleados
        Empleado e1 = new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3 = new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");

        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);

        System.out.println("#################### ");
        System.out.println("EMPLEADOS");
        for (Empleado e : listaEmpleados)
            e.mostrar();

//        // Modificaciones
//        e1.asignarApellido("APELLIDOEmpleado11");
//        listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");

        for (Empleado e : listaEmpleados)
            e.mostrar();

        // Productos
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");

        Producto p1 = new Producto(1, "Hamburguesa", Categoria.ENTRADA, Estado.DISPONIBLE, 12000.0f);
        Producto p2 = new Producto(2, "Pizza", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 10050.0f);
        Producto p3 = new Producto(3, "Flan", Categoria.POSTRE, Estado.NO_DISPONIBLE, 3500.0f);

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);

        for (Producto p : listaProductos)
            p.mostrar();

        // Modificaciones
        p1.asignarDescripcion("Hamburguesa");
        p1.asignarPrecio(12050.0f);

        for (Producto p : listaProductos)
            System.out.println(p);

        // Encargados
        System.out.println("#################### ");
        System.out.println("ENCARGADOS");

        Encargado enc1 = new Encargado("encargado1@mail.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado enc2 = new Encargado("encargado2@mail.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado enc3 = new Encargado("encargado3@mail.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");

        listaEncargados.add(enc1);
        listaEncargados.add(enc2);
        listaEncargados.add(enc3);

        for (Encargado e : listaEncargados)
            e.mostrar();

        // Clientes
        System.out.println("#################### ");
        System.out.println("CLIENTES");

        
        //se agrega los {} por ser clase sabstracta (sugerencia de netbeans)
        Cliente c1 = new Cliente("cliente1@gmail.com", "11", "ApellidoCliente1", "NombreCliente1") {};
        Cliente c2 = new Cliente("cliente2@hotmail.com", "12", "ApellidoCliente2", "NombreCliente2") {};
        Cliente c3 = new Cliente("cliente3@gmail.com", "13", "ApellidoCliente3", "NombreCliente3") {};

        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        for (Cliente c : listaClientes)
            c.mostrar();

        // ========================
        // SEGUNDA PARTE - PEDIDOS
        // ========================

        System.out.println("#################### ");
        System.out.println("PEDIDOS");

        Pedido pedido1 = new Pedido(1, LocalDateTime.now(), c1);
        Pedido pedido2 = new Pedido(2, LocalDateTime.now(), c2);
        Pedido pedido3 = new Pedido(3, LocalDateTime.now(), c3);

        // Asociar productos a los pedidos
        ProductoDelPedido pdp1 = new ProductoDelPedido(p1, 2); // Milanesa con puré x2
        ProductoDelPedido pdp2 = new ProductoDelPedido(p2, 1); // Pizza x1
        ProductoDelPedido pdp3 = new ProductoDelPedido(p3, 3); // Flan x3

        pedido1.agregarProducto(pdp1);
        pedido1.agregarProducto(pdp3);

        pedido2.agregarProducto(pdp2);

        pedido3.agregarProducto(pdp2);
        pedido3.agregarProducto(pdp3);

        // Guardar pedidos en el ArrayList
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);

        // Mostrar pedidos
        for (Pedido p : listaPedidos)
            p.mostrar();

        System.out.println("#################### ");
    }
}
