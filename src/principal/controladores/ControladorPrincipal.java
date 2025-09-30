
package principal.controladores;

// Paquetes importados:

import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.*;
import pedidos.modelos.*;


public class ControladorPrincipal {
    public static void main(String[] args) {

        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Productos
        Producto prod1 = new Producto(1, "Pizza", 1222.6f, Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE);
        
        Producto prod2 = new Producto(2, "Empanadas", 200.6f, Categoria.ENTRADA, Estado.DISPONIBLE);
        
        Producto prod3 = new Producto(3, "Helado", 122.6f, Categoria.POSTRE, Estado.NODISPONIBLE);
      
        listaProductos.add(prod1);
        listaProductos.add(prod2);
        listaProductos.add(prod3);

        // Clientes
        Cliente cli1 = new Cliente("juan@mail.com", "1234", "Perez", "Juan");
      
        Cliente cli2 = new Cliente("ana@mail.com", "5678", "Garcia", "Ana");

        Cliente cli3 = new Cliente("mario@mail.com", "abcd", "Lopez", "Mario");

        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        // Empleados
        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Rodriguez", "Carlos");
        
        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Martinez", "Lucia");
        
        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Gomez", "Pedro");
        
        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);

        // Encargados
        Encargado en1 = new Encargado("enc1@mail.com", "key1", "Sanchez", "Laura");
        
        Encargado en2 = new Encargado("enc2@mail.com", "key2", "Fernandez", "Jose");
      
        Encargado en3 = new Encargado("enc3@mail.com", "key3", "Ruiz", "Marta");
       
        listaEncargados.add(en1);
        listaEncargados.add(en2);
        listaEncargados.add(en3);

        // Mostrar contenido inicial
        System.out.println("---- Productos ----");
        for (Producto p : listaProductos) p.mostrar();

        System.out.println("---- Clientes ----");
        for (Cliente c : listaClientes) c.mostrar();

        System.out.println("---- Empleados ----");
        for (Empleado e : listaEmpleados) e.mostrar();

        System.out.println("---- Encargados ----");
        for (Encargado en : listaEncargados) en.mostrar();
        
        //Segunda PARTE
        System.out.println("\n#################### ");
        System.out.println("PEDIDOS");
        
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), cli1, pedidos.modelos.Estado.CREADO); 
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), listaClientes.get(2), pedidos.modelos.Estado.SOLICITADO); 
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), cli2, pedidos.modelos.Estado.ENTREGADO); 
               
        listaPedidos.add(unPedido1);
        listaPedidos.add(unPedido2);
        listaPedidos.add(unPedido3);
        
        unPedido1.agregarProductodelPedido(prod3, 6);
        unPedido2.agregarProductodelPedido(prod1, 7);
        unPedido3.agregarProductodelPedido(prod2, 1);
        unPedido1.agregarProductodelPedido(prod1, 2);
        
        
        for (Pedido p: listaPedidos)
            p.mostrar();
        
    }
}