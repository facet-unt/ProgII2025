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

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Clientes
        Cliente cli1 = new Cliente("juan@mail.com", "1234", "Perez", "Juan");

        Cliente cli2 = new Cliente("ana@mail.com", "5678", "Garcia", "Ana");

        Cliente cli3 = new Cliente("mario@mail.com", "abcd", "Lopez", "Mario");

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        // Empleados
        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Rodriguez", "Carlos");

        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Martinez", "Lucia");

        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Gomez", "Pedro");

        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);

        // Encargados
        Encargado en1 = new Encargado("enc1@mail.com", "key1", "Sanchez", "Laura");

        Encargado en2 = new Encargado("enc2@mail.com", "key2", "Fernandez", "Jose");

        Encargado en3 = new Encargado("enc3@mail.com", "key3", "Ruiz", "Marta");

        encargados.add(en1);
        encargados.add(en2);
        encargados.add(en3);

        // CREAR PRODUCTOS
        Producto prod1 = new Producto(1, "Pizza", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 1200.5f);
        Producto prod2 = new Producto(2, "Hamburguesa", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 25.0f);
        Producto prod3 = new Producto(3, "Pancho", Categoria.ENTRADA, Estado.DISPONIBLE, 100.0f);

        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        // crear PRODUCTOS DEL PEDIDO
        
        ProductoDelPedido pdp1=new ProductoDelPedido(1,prod1);
        ProductoDelPedido pdp2=new ProductoDelPedido(2,prod2);
        ProductoDelPedido pdp3=new ProductoDelPedido(3,prod3);
        ProductoDelPedido pdp4=new ProductoDelPedido(4,prod1);
        ProductoDelPedido pdp5 =new ProductoDelPedido(3,prod3);


        
        // CREAR LAS LISTAS CON LOS PDP
        ArrayList<ProductoDelPedido> productoTotal1 = new ArrayList<>();
        ArrayList<ProductoDelPedido> productoTotal2 = new ArrayList<>();
        ArrayList<ProductoDelPedido> productoTotal3 = new ArrayList<>();
        

        // AGREGAR PDP CREADOS A LAS LISTAS
        productoTotal1.add(pdp1);
        productoTotal1.add(pdp2);
        productoTotal1.add(pdp3);
        productoTotal2.add(pdp4);
        productoTotal3.add(pdp5);


        // CREAR LOS PEDIDOS
        Pedido ped1 = new Pedido(1, LocalDateTime.now(), pedidos.modelos.Estado.CREADO, cli1, productoTotal1);
        Pedido ped2 = new Pedido(2, LocalDateTime.now(), pedidos.modelos.Estado.CREADO, cli1, productoTotal2);
        Pedido ped3 = new Pedido(3, LocalDateTime.now(), pedidos.modelos.Estado.CREADO, cli2, productoTotal3);

        listaPedidos.add(ped1);
        listaPedidos.add(ped2);
        listaPedidos.add(ped3);

        System.out.println("---- Pedidos ----");
        for (Pedido pe : listaPedidos) {
            pe.mostrar();
            System.out.println("");
        }

//        // Mostrar contenido inicial
//        System.out.println("---- Productos ----");
//        for (Producto p : productos) {
//            p.mostrar();
//        }
        System.out.println("---- Clientes ----");
        for (Cliente c : clientes) {
            c.mostrar();
            System.out.println("");

        }
//
//        System.out.println("---- Empleados ----");
//        for (Empleado e : empleados) {
//            e.mostrar();
//        }
//
//        System.out.println("---- Encargados ----");
//        for (Encargado en : encargados) {
//            en.mostrar();
//        }
//
//        //Cambio de algunas variables
//        prod1.asignarCodigo(4);
//        cli2.asignarClave("12345");
//        emp3.asignarClave("45678");
//        en2.asignarNombre("Mauro");
//
//        System.out.println("----CON CAMBIOS----");
//        //Mostrar Cambios
//        System.out.println("---- Productos ----");
//        for (Producto p : productos) {
//            p.mostrar();
//        }
//
//        System.out.println("---- Clientes ----");
//        for (Cliente c : clientes) {
//            c.mostrar();
//        }
//
//        System.out.println("---- Empleados ----");
//        for (Empleado e : empleados) {
//            e.mostrar();
//        }
//
//        System.out.println("---- Encargados ----");
//        for (Encargado en : encargados) {
//            en.mostrar();
//        }
    }
}
