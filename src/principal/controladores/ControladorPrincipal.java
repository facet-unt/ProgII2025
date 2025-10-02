package principal.controladores;

import java.util.ArrayList;
import java.time.LocalDateTime;


import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

import productos.modelos.Producto;
import productos.modelos.Categoria;

import pedidos.modelos.Pedido;
import pedidos.modelos.Estado;

public class ControladorPrincipal {
    public static void main(String[] args) {

        // === LISTAS ===
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        // === PRODUCTOS ===
        Producto prod1 = new Producto(1, "Pizza Especial", Categoria.PLATO_PRINCIPAL, 10500.8f);
        Producto prod2 = new Producto(2, "Flan", Categoria.POSTRE, 5000.0f);
        Producto prod3 = new Producto(3, "Budín", Categoria.POSTRE, 1050.0f);

        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        // === CLIENTES ===
        Cliente cli1 = new Cliente("juan@mail.com", "1", "Perez", "Juan");
        Cliente cli2 = new Cliente("ana@mail.com", "3", "Garcia", "Ana");
        Cliente cli3 = new Cliente("mario@mail.com", "5", "Lopez", "Mario");

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        // === EMPLEADOS ===
        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Rodriguez", "Carlos");
        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Martinez", "Lucia");
        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Gomez", "Pedro");

        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);

        // === ENCARGADOS ===
        Encargado en1 = new Encargado("laura@mail.com", "clave1", "Sanchez", "Laura");
        Encargado en2 = new Encargado("jose@mail.com", "clave2", "Fernandez", "Jose");
        Encargado en3 = new Encargado("marta@mail.com", "clave3", "Ruiz", "Marta");

        encargados.add(en1);
        encargados.add(en2);
        encargados.add(en3);

        // === PEDIDOS ===
        Pedido pedido1 = new Pedido(101, LocalDateTime.now(), cli1, Estado.CREADO);
        Pedido pedido2 = new Pedido(102, LocalDateTime.now(), cli2, Estado.PROCESANDO);
        Pedido pedido3 = new Pedido(103, LocalDateTime.now(), cli3, Estado.ENTREGADO);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        // === MOSTRAR LOS DATOS ===
        System.out.println("====== PRODUCTOS ======");
        for (Producto p : productos) p.mostrar();

        System.out.println("\n====== CLIENTES ======");
        for (Cliente c : clientes) c.mostrar();

        System.out.println("\n====== EMPLEADOS ======");
        for (Empleado e : empleados) e.mostrar();

        System.out.println("\n====== ENCARGADOS ======");
        for (Encargado en : encargados) en.mostrar();

        System.out.println("\n====== PEDIDOS ======");
        for (Pedido p : pedidos) p.mostrar();
    }
}

