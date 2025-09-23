package principal.controladores;

import Producto.Modelos.Producto;
import java.util.ArrayList;

import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
 


public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
<<<<<<< HEAD
=======
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
>>>>>>> origin/G07
        
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
     
        ArrayList<Cliente> ListaClientes = new ArrayList<>();
        System.out.println("#################### ");
        System.out.println("Cliente: ");
        Cliente c1 = new Cliente ("correo", "clave", "Apellido", "nombre");
        Cliente c2 = new Cliente ("correo", "clave", "Apellido", "nombre");
        Cliente c3 = new Cliente ("correo", "clave", "Apellido", "nombre");
        
        ListaClientes.add(c1);
        ListaClientes.add(c2);
        ListaClientes.add(c3);
        
        System.out.println("CLIENTES usando mostrar()");
        System.out.println("El nombre del cliente es: " + ListaClientes.get (1).VerNombre());
        ListaClientes.get(2).asignarNombre("juan");
        
        for (Cliente c: ListaClientes)
            System.out.println(c);
        System.out.println("#################### ");
        
        
        
       ArrayList<Encargado> ListaEncargado = new ArrayList<>();
        System.out.println("#################### ");
        System.out.println("Cliente: ");
        Encargado E1 = new Encargado ("correo", "clave", "Apellido", "nombre");
        Encargado E2 = new Encargado ("correo", "clave", "Apellido", "nombre");
        Encargado E3 = new Encargado ("correo", "clave", "Apellido", "nombre");
        
        ListaEncargado.add(E1);
        ListaEncargado.add(E2);
        ListaEncargado.add(E3);
        
        System.out.println("Encargados usando mostrar()");
        System.out.println("El nombre del encargado es: " + ListaEncargado.get (1).VerNombre());
        ListaEncargado.get(2).asignarApellido("Juarez");
        
        for (Encargado E: ListaEncargado)
            System.out.println(E);
        System.out.println("#################### ");
        
        
        ArrayList<Empleado> ListaEmpleado = new ArrayList<>();
        System.out.println("#################### ");
        System.out.println("Cliente: ");
        Empleado Em1 = new Empleado ("correo", "clave", "Apellido", "nombre");
        Empleado Em2 = new Empleado ("correo", "clave", "Apellido", "nombre");
        Empleado Em3 = new Empleado ("correo", "clave", "Apellido", "nombre");
        
        ListaEmpleado.add(Em1);
        ListaEmpleado.add(Em2);
        ListaEmpleado.add(Em3);
        
        System.out.println("Encargados usando mostrar()");
        System.out.println("El nombre del encargado es: " + ListaEncargado.get (1).VerNombre());
        ListaEncargado.get(2).asignarApellido("Juarez");
        
        for (Empleado Em: ListaEmpleado)
            System.out.println(Em);
        System.out.println("#################### ");
             
        }
}
