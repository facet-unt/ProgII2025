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
        Producto p2= new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
        Producto p3 = new Producto(3, "Producto3", "Plato Principal", "No Disponible", 1050.0f);
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
         
        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del "+ listaProductos.get(2).verDescripcion()+" es: "+  listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
        
        
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente c1 = new Cliente("cliente1@gmail.com", "123123", "aC1", "nC1");
        Cliente c2= new Cliente("cliente2@gmail.com", "12341234", "aC2", "nC2");
        Cliente c3 = new Cliente("cliente3@gmail.com", "123423", "aC3", "nC3");
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        for (Cliente c: listaClientes)
            c.mostrar();
        System.out.println("#################### ");
        
        listaClientes.get(1).asignarNombre("Pablo");
        System.out.println("El nuevo nombre del cliente 2 es: " + listaClientes.get(1).verNombre());
        
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS");
        Empleado emp1 = new Empleado("empleado1@gmail.com", "123123", "aE1", "nE1");
        Empleado emp2= new Empleado("empleado2@gmail.com", "12341234", "aE2", "nE2");
        Empleado emp3 = new Empleado("empleado3@gmail.com", "123423", "aE3", "nE3");
        
        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);
        
        for (Empleado emp: listaEmpleados)
            emp.mostrar();
        System.out.println("#################### ");
        
        listaEmpleados.get(1).asignarApellido("Juarez");
        System.out.println("El nuevo apellido del empleado 2 es: " + listaEmpleados.get(1).verApellido());
    
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("ENCARGADOS");
        Encargado enc1 = new Encargado("encargado1@gmail.com", "123123", "aE1", "nE1");
        Encargado enc2= new Encargado("encargado2@gmail.com", "12341234", "aE2", "nE2");
        Encargado enc3 = new Encargado("encargado3@gmail.com", "123423", "aE3", "nE3");
        
        listaEncargados.add(enc1);
        listaEncargados.add(enc2);
        listaEncargados.add(enc3);
        
        for (Encargado enc: listaEncargados)
            enc.mostrar();
        System.out.println("#################### ");
        
        listaEncargados.get(2).asignarCorreo("mejorencargado@gmail.com");
        System.out.println("El correo del encargado 3 es: " + listaEncargados.get(2).verCorreo());
    
    }
    
    
}