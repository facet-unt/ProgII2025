package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.*;
import pedidos.modelos.Pedido;
import pedidos.modelos.EstadoPedido;
import pedidos.modelos.ProductoDelPedido;


public class ControladorPrincipal {
    public static void main(String[] args) {

//        ArrayList<Producto> productos = new ArrayList<>();
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        ArrayList<Empleado> empleados = new ArrayList<>();
//        ArrayList<Encargado> encargados = new ArrayList<>();
//
//        Producto prod1 = new Producto(1, "Laptop", "Electronica", "Nuevo", 1200.5f);
//       
//        Producto prod2 = new Producto(2, "Mouse", "Accesorio", "Nuevo", 25.0f);
//        
//        Producto prod3 = new Producto(3, "Silla", "Muebles", "Usado", 100.0f);
//        
//        Producto prod4 = new Producto(4, "Pizza", "Plato principal", 100.0f);
//        
//        Producto prod5 = new Producto(5, "Hamburguesa", 100.0f);
//      
//        productos.add(prod1);
//        productos.add(prod2);
//        productos.add(prod3);
//
//        // Clientes
//        Cliente cli1 = new Cliente("juan@mail.com", "1234", "Perez", "Juan");
//      
//        Cliente cli2 = new Cliente("ana@mail.com", "5678", "Garcia", "Ana");
//        
//
//        Cliente cli3 = new Cliente("mario@mail.com", "abcd", "Lopez", "Mario");
//        
//
//        clientes.add(cli1);
//        clientes.add(cli2);
//        clientes.add(cli3);
//
//        // Empleados
//        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Rodriguez", "Carlos");
//        
//        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Martinez", "Lucia");
//        
//
//        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Gomez", "Pedro");
//        
//
//        empleados.add(emp1);
//        empleados.add(emp2);
//        empleados.add(emp3);
//
//        // Encargados
//        Encargado en1 = new Encargado("enc1@mail.com", "key1", "Sanchez", "Laura");
//        
//
//        Encargado en2 = new Encargado("enc2@mail.com", "key2", "Fernandez", "Jose");
//      
//
//        Encargado en3 = new Encargado("enc3@mail.com", "key3", "Ruiz", "Marta");
//       
//
//        encargados.add(en1);
//        encargados.add(en2);
//        encargados.add(en3);
//
//        // Mostrar contenido inicial
//        System.out.println("---- Productos ----");
//        for (Producto p : productos) p.mostrar();
//
//        System.out.println("---- Clientes ----");
//        for (Cliente c : clientes) c.mostrar();
//
//        System.out.println("---- Empleados ----");
//        for (Empleado e : empleados) e.mostrar();
//
//        System.out.println("---- Encargados ----");
//        for (Encargado en : encargados) en.mostrar();


        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<ProductoDelPedido> cantidad = new ArrayList<>();
        
        Producto p1 = new Producto(1, "Helado",Categoria.POSTRE , Estado.DISPONIBLE, 1550.8f);
        Producto p2= new Producto(2, "Pizza", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 850.8f);
        Producto p3 = new Producto(3, "Empanadas", Categoria.ENTRADA, Estado.DISPONIBLE, 1050.0f);
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        System.out.println("------------ Lista de Productos ------------");
        for (Producto p: listaProductos){
            p.mostrar();
        }
         
        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del producto es :" +  listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
        
        System.out.println("Agreagado de Empleados\n");
        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Juarez", "Lucas");
        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Acevedo", "Karian");
        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Lobo", "javier");
        
        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);
        
        System.out.println("---- Lista de Empleados ----");
        for (Empleado e : listaEmpleados){
            e.mostrar();
            System.out.println("---------------------------");
        }

        Encargado enc1 = new Encargado("enc1@mail.com", "pass", "Martinez", "Lucia");        
        Encargado enc2 = new Encargado("enc2@mail.com", "pass2", "Toledo", "Juan Pablo");
        Encargado enc3 = new Encargado("enc3@mail.com", "pass3", "Gomez", "Lautaro");
        
        listaEncargados.add(enc1);
        listaEncargados.add(enc2);
        listaEncargados.add(enc3);
        
        System.out.println("---- Lista de Encargados ----");
        for(Encargado enc : listaEncargados){
            enc.mostrar();
            System.out.println("-----------------------------");
        }
        
        Cliente c1 = new Cliente("juan@mail.com", "1234", "Toledo", "Juan");
        Cliente c2 = new Cliente("ana@mail.com", "5678", "Pérez", "Ana");
        
        Pedido pedido1 = new Pedido(1, c1, EstadoPedido.CREADO);
        Pedido pedido2 = new Pedido(2, c2, EstadoPedido.PROCESANDO);


        c1.agregarPedido(pedido1);
        c2.agregarPedido(pedido2);

        listaClientes.add(c1);
        listaClientes.add(c2);
        
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        
          for (Cliente c : listaClientes) {
            c.mostrar();
        }
    }
}
