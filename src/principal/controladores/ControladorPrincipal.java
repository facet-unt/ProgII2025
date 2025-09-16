package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
        Producto p2 = new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
        Producto p3 = new Producto(3, "Producto3", "Plato Principal", "No Disponible", 1050.0f);
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        System.out.println("PRODUCTOS usando mostrar()");
        for (Producto p: listaProductos)
            p.mostrar();
         
        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del producto es :" +  listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente c1 = new Cliente("correo1","clave","apellidoa","nombrea"); 
        Cliente c2 = new Cliente("correo2","clave","apellidob","nombreb"); 
        Cliente c3 = new Cliente("correo3","clave","apellidoc","nombrec"); 
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        for(Cliente c: listaClientes)
            c.mostrar();
        
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("EMPLEADO");
        Empleado e1 = new Empleado("Correouno","clave","apellidouno","nombreuno");
        Empleado e2 = new Empleado("Correodos","clave","apellidouno","nombreuno");
        Empleado e3 = new Empleado("Correotres","clave","apellidouno","nombreuno");
        
        listaEmpleado.add(e1);
        listaEmpleado.add(e2);
        listaEmpleado.add(e3);
        
        for(Empleado e: listaEmpleado)
            e.mostrar();
        
        ArrayList<Encargado> listaEncargado = new ArrayList<>();
        System.out.println("#################### ");
        System.out.println("ENCARGADO");
        Encargado en1 = new Encargado("Correouno","clave","apellidouno","nombreuno");
        Encargado en2 = new Encargado("Correodos","clave","apellidouno","nombreuno");
        Encargado en3 = new Encargado("Correotres","clave","apellidouno","nombreuno");
        
        listaEncargado.add(en1);
        listaEncargado.add(en2);
        listaEncargado.add(en3);
        
        for(Encargado en: listaEncargado)
            en.mostrar();
    }
}