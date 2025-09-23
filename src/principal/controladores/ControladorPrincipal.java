package principal.controladores;

import productos.modelos.Producto;
import java.util.ArrayList;
import usuarios.modelos.*;

public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
        Producto p2= new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
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
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();

        System.out.println("####################");
        System.out.println("CLIENTES");
        Cliente c1 = new Cliente("correo1@ejemplo.com", "clave1", "Gómez", "Ana");
        Cliente c2 = new Cliente("correo2@ejemplo.com", "clave2", "Pérez", "Luis");
        Cliente c3 = new Cliente("correo3@ejemplo.com", "clave3", "Díaz", "María");

        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        System.out.println("CLIENTES usando mostrar():");
        for (Cliente c : listaClientes)
            c.mostrar();

        System.out.println("\n####################");
        System.out.println("EMPLEADOS");
        Empleado e1 = new Empleado("empleado1@empresa.com", "empclave1", "Ruiz", "Carlos");
        Empleado e2 = new Empleado("empleado2@empresa.com", "empclave2", "Fernández", "Lucía");

        listaEmpleados.add(e1);
        listaEmpleados.add(e2);

        System.out.println("EMPLEADOS usando mostrar():");
        for (Empleado e : listaEmpleados)
            e.mostrar();

        System.out.println("\n####################");
        System.out.println("ENCARGADOS");
        Encargado en1 = new Encargado("encargado1@empresa.com", "encclave1", "Mendoza", "Jorge");

        listaEncargados.add(en1);

        System.out.println("ENCARGADOS usando mostrar():");
        for (Encargado en : listaEncargados)
            en.mostrar();
    }
}