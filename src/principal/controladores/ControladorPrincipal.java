package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;
import usuarios.modelos.*;

public class ControladorPrincipal {
    public static void main(String[] args) {
//
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
//

        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
        Producto p2 = new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
        Producto p3 = new Producto(3, "Producto3", "Plato Principal", "No Disponible", 1050.0f);
        
        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656");
        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5");
        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e");
        
        Empleado e1 = new Empleado("Martinez ", "Juan ", "juan@gmail.com", "h566");
        Empleado e2 = new Empleado("Paz ", "Lucia ", "Lucia@gmail.com", "h566");
        Empleado e3 = new Empleado("Alvarez ", "Martin ", "Martin@gmail.com", "h566");
       
        Encargado en1 = new Encargado("Rodriguez ", "Leandro ", "Leandro@gmail.com", "j67r");
        Encargado en2 = new Encargado("Quintero ", "Franco ", "julieta@gmail.com", "f34g6");
        Encargado en3 = new Encargado("Barrios ", "Carlos ", "Carlos@gmail.com", "f345g");

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
   
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        listaEncargados.add(en1);
        listaEncargados.add(en2);
        listaEncargados.add(en3);
        
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

       
        //Falta el bloque para cambiar algun dato de clientes, empleados o encargados.
        System.out.println("\n==Clientes==");
        for (Cliente c: listaClientes)
            System.out.println(c);
        
        System.out.println("\n==Empleados==");
        for (Empleado e: listaEmpleados)
            System.out.println(e);
        
        System.out.println("\n==Encargados==");
        for (Encargado en: listaEncargados)
            System.out.println(en);

    }
    

}