package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.*;


public class ControladorPrincipal {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();

        Producto prod1 = new Producto(1, "Laptop", "Electronica", "Nuevo", 1200.5f);
       
        Producto prod2 = new Producto(2, "Mouse", "Accesorio", "Nuevo", 25.0f);
        
        Producto prod3 = new Producto(3, "Silla", "Muebles", "Usado", 100.0f);
        
        Producto prod4 = new Producto(4, "Pizza", "Plato principal", 100.0f);
        
        Producto prod5 = new Producto(5, "Hamburguesa", 100.0f);
      
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


        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
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
        Producto p3 = new  Producto(3, "Producto 3",Categoria.POSTRE, Estado.NO_DISPONIBLE, 580.0f);        
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
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
        System.out.println("ENCARGADOS");
        Encargado unEncargado1 = new Encargado("encargado1@mail.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@mail.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@mail.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        
        listaEncargados.add(unEncargado1);
        listaEncargados.add(unEncargado2);
        listaEncargados.add(unEncargado3);
        
        for (Encargado e: listaEncargados)
            e.mostrar();
        
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        
        for (Cliente e: listaClientes)
            e.mostrar();
        
        //SEGUNDA PARTE
        System.out.println("#################### ");
        System.out.println("PEDIDOS");
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), cliente1); 
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), listaClientes.get(1)); 
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), cliente2); 
        
        listaPedidos.add(unPedido1);
        listaPedidos.add(unPedido2);
        listaPedidos.add(unPedido3);
        
        for (Pedido p: listaPedidos)
            p.mostrar();
        System.out.println("#################### ");
    }
}