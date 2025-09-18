package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        
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
        
        System.out.println("#################### ");
        System.out.println("Clientes");
        Cliente c1 = new Cliente("Correo1", "Clave1", "Aaa", "Aaa");
        Cliente c2 = new Cliente("Correo2", "Clave2", "Bbb", "Bbb");
        Cliente c3 = new Cliente("Correo3", "Clave3", "Ccc", "Ccc");
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        System.out.println("CLIENTES usando mostrar()");
        for (Cliente c: listaClientes)
            c.mostrar();
         
        listaClientes.get(2).asignarNombre("Nuevo Nombre");
        listaClientes.get(1).asignarApellido("Nuevo Apellido");
        listaClientes.get(0).asignarClave("Nueva Clave");
        
        System.out.println("\nCLIENTES usando toString()");
        for (Cliente c: listaClientes)
            System.out.println(c);
        System.out.println("#################### ");
        
        System.out.println("#################### ");
        System.out.println("Empleados");
        Empleado e1 = new Empleado("Correo1", "Clave1", "Aaa", "Aaa");
        Empleado e2 = new Empleado("Correo2", "Clave2", "Bbb", "Bbb");
        Empleado e3 = new Empleado("Correo3", "Clave3", "Ccc", "Ccc");
        
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        System.out.println("EMPLEADOS usando mostrar()");
        for (Empleado e: listaEmpleados)
            e.mostrar();
         
        listaEmpleados.get(2).asignarNombre("Nuevo Nombre");
        listaEmpleados.get(1).asignarApellido("Nuevo Apellido");
        listaEmpleados.get(0).asignarClave("Nueva Clave");
        
        System.out.println("\nEMPLEADOS usando toString()");
        for (Empleado e: listaEmpleados)
            System.out.println(e);
        System.out.println("#################### ");
        
        System.out.println("#################### ");
        System.out.println("Encargados");
        Encargado en1 = new Encargado("Correo1", "Clave1", "Aaa", "Aaa");
        Encargado en2 = new Encargado("Correo2", "Clave2", "Bbb", "Bbb");
        Encargado en3 = new Encargado("Correo3", "Clave3", "Ccc", "Ccc");
        
        listaEncargados.add(en1);
        listaEncargados.add(en2);
        listaEncargados.add(en3);
        
        System.out.println("ENCARGADOS usando mostrar()");
        for (Encargado e: listaEncargados)
            e.mostrar();
         
        listaEncargados.get(2).asignarNombre("Nuevo Nombre");
        listaEncargados.get(1).asignarApellido("Nuevo Apellido");
        listaEncargados.get(0).asignarClave("Nueva Clave");
        
        System.out.println("\nENCARGADOS usando toString()");
        for (Encargado e: listaEncargados)
            System.out.println(e);
        System.out.println("#################### ");
 
    }
}