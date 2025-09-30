package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import pedidos.modelos.Pedido;

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

        //PRIMERA PARTE
         /*
        Definir un ArrayList para cada una de las clases Cliente, 
        Empleado, Encargado y Producto  (realizar las importaciones correspondientes).*/
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
    
        
        /*Instanciar 3 objetos de cada clase y guardarlos en su correspondiente ArrayList. */
        Empleado e1=new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3= new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
               
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS ");
        /*Recorrer cada ArrayList y mostrar su contenido por pantalla. */
        for (Empleado e: listaEmpleados)
            e.mostrar();
        
        /*Realizar algunas modificaciones a algunos de los objetos antes creados, */
        //DEBO usar los métodos para ese fin
        e1.asignarApellido("APELLIDOEmpleado11");
        listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");
        
        /*y volver a recorrer los ArrayLists verificando que se hicieron los cambios. */
         for (Empleado e: listaEmpleados)
            e.mostrar();
         
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new  Producto(1, "Producto 1", Categoria.ENTRADA ,Estado.DISPONIBLE, 200.0f);        
        Producto p2 = new  Producto(2, "Producto 2", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 1950.0f);        
        Producto p3 = new  Producto(3, "Producto 3",Categoria.POSTRE, Estado.NODISPONIBLE, 580.0f);        
        
//<<<<<<< HEAD
//        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656", listaPedidos);
//        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5", listaPedidos);
//        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e", listaPedidos);
//        
//        Empleado e1 = new Empleado("Martinez ", "Juan ", "juan@gmail.com", "h566");
//        Empleado e2 = new Empleado("Paz ", "Lucia ", "Lucia@gmail.com", "h566");
//        Empleado e3 = new Empleado("Alvarez ", "Martin ", "Martin@gmail.com", "h566");

        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656", new ArrayList<>());
        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5", new ArrayList<>());
        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e", new ArrayList<>());

       
        Encargado en1 = new Encargado("Rodriguez ", "Leandro ", "Leandro@gmail.com", "j67r");
        Encargado en2 = new Encargado("Quintero ", "Franco ", "julieta@gmail.com", "f34g6");
        Encargado en3 = new Encargado("Barrios ", "Carlos ", "Carlos@gmail.com", "f345g");
        
        Pedido ped1 = new Pedido(1, LocalDateTime.now(), c1, pedidos.modelos.Estado.CREADO, new ArrayList<>());
        Pedido ped2 = new Pedido(2, LocalDateTime.now(), c2, pedidos.modelos.Estado.PROCESANDO, new ArrayList<>());
        Pedido ped3 = new Pedido(3, LocalDateTime.now(), c3, pedidos.modelos.Estado.ENTREGADO, new ArrayList<>());

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
        
        listaPedidos.add(ped1);
        listaPedidos.add(ped2);
        listaPedidos.add(ped3);
        
        for (Producto p: listaProductos)
            p.mostrar();
        
        p1.asignarDescripcion("Milanesa con puré");
        p1.asignarPrecio(250.0f);
        
        for (Producto p: listaProductos)
            System.out.println(p);

        System.out.println("\n==Modificar un cliente==");
        listaClientes.get(0).asignarCorreo("nuevoCorreo@gmail.com");
        System.out.println("Correo actualizado: " + listaClientes.get(0).verCorreo());

        System.out.println("\n==Modificar un empleado==");
        listaEmpleados.get(1).asignarNombre("Luciana");
        System.out.println("Nombre actualizado: " + listaEmpleados.get(1).verNombre());

        System.out.println("\n==Modificar un encargado==");
        listaEncargados.get(2).asignarApellido("Barrionuevo");
        System.out.println("Apellido actualizado: " + listaEncargados.get(2).verApellido());

       
        System.out.println("\n==Clientes==");
        for (Cliente c: listaClientes)
            System.out.println(c);
        
        System.out.println("\n==Empleados==");
        for (Empleado e: listaEmpleados)
            System.out.println(e);
        
        System.out.println("\n==Encargados==");
        for (Encargado en: listaEncargados)
            System.out.println(en);

        
        System.out.println("\n==Pedidos==");
        for (Pedido p : listaPedidos) {
            p.mostrar();
        }
    }
}