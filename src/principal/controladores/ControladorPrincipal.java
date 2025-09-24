/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;


// Paquetes importados:

import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.*;
import pedidos.modelos.Pedido;


public class ControladorPrincipal {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        // Productos
        Producto prod1 = new Producto(1, "Pizza", 1222.6f, Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE);
        
        Producto prod2 = new Producto(2, "Empanadas", 200.6f, Categoria.ENTRADA, Estado.DISPONIBLE);
        
        Producto prod3 = new Producto(3, "Helado", 122.6f, Categoria.POSTRE, Estado.NODISPONIBLE);
      
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

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

        // Mostrar contenido inicial
        System.out.println("---- Productos ----");
        for (Producto p : productos) p.mostrar();

        System.out.println("---- Clientes ----");
        for (Cliente c : clientes) c.mostrar();

        System.out.println("---- Empleados ----");
        for (Empleado e : empleados) e.mostrar();

        System.out.println("---- Encargados ----");
        for (Encargado en : encargados) en.mostrar();
        
        //Segunda PARTE
        System.out.println("\n#################### ");
        System.out.println("PEDIDOS");
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), cli1); 
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), clientes.get(1)); 
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), cli2); 
        
        listaPedidos.add(unPedido1);
        listaPedidos.add(unPedido2);
        listaPedidos.add(unPedido3);
        
        for (Pedido p: listaPedidos)
            p.mostrar();
        System.out.println("#################### ");
    }
}