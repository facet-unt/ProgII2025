//package principal.controladores;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import usuarios.modelos.Cliente;
//import usuarios.modelos.Empleado;
//import usuarios.modelos.Encargado;
//import productos.modelos.Producto;
//import productos.modelos.Categoria;
//import productos.modelos.Estado;
//import pedidos.modelos.Pedido;
//import pedidos.modelos.ProductoDelPedido;
//
//public class ControladorPrincipalGUI {
//    public static void main(String[] args) {
//
//        ArrayList<Cliente> listaClientes = new ArrayList<>();
//        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
//        ArrayList<Pedido> listaPedidos = new ArrayList<>();
//        ArrayList<Encargado> listaEncargados = new ArrayList<>();
//        ArrayList<Producto> listaProductos = new ArrayList<>();
//    
//        
//        /*Instanciar 3 objetos de cada clase y guardarlos en su correspondiente ArrayList. */
////        Empleado e1=new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
////        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
////        Empleado e3= new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
////               
////        listaEmpleados.add(e1);
////        listaEmpleados.add(e2);
////        listaEmpleados.add(e3);
//        
////        System.out.println("#################### ");
////        System.out.println("EMPLEADOS ");
////        /*Recorrer cada ArrayList y mostrar su contenido por pantalla. */
////        for (Empleado e: listaEmpleados)
////            e.mostrar();
//        
//        /*Realizar algunas modificaciones a algunos de los objetos antes creados, */
//        //DEBO usar los métodos para ese fin
////        e1.asignarApellido("APELLIDOEmpleado11");
////        listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");
////        
////        /*y volver a recorrer los ArrayLists verificando que se hicieron los cambios. */
////         for (Empleado e: listaEmpleados)
////            e.mostrar();
//         
//        System.out.println("#################### ");
//        System.out.println("PRODUCTOS");
//        Producto p1 = new  Producto(1, "Producto 1", Categoria.ENTRADA ,Estado.DISPONIBLE, 200.0f);        
//        Producto p2 = new  Producto(2, "Producto 2", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 1950.0f);        
//        Producto p3 = new  Producto(3, "Producto 3",Categoria.POSTRE, Estado.NODISPONIBLE, 580.0f);        
//        
////<<<<<<< HEAD
////        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656", listaPedidos);
////        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5", listaPedidos);
////        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e", listaPedidos);
//        
//        Empleado e1 = new Empleado("Martinez ", "Juan ", "juan@gmail.com", "h566");
//        Empleado e2 = new Empleado("Paz ", "Lucia ", "Lucia@gmail.com", "h566");
//        Empleado e3 = new Empleado("Alvarez ", "Martin ", "Martin@gmail.com", "h566");
//
//        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656", new ArrayList<>());
//        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5", new ArrayList<>());
//        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e", new ArrayList<>());
//
//       
//        Encargado en1 = new Encargado("Rodriguez ", "Leandro ", "Leandro@gmail.com", "j67r");
//        Encargado en2 = new Encargado("Quintero ", "Franco ", "julieta@gmail.com", "f34g6");
//        Encargado en3 = new Encargado("Barrios ", "Carlos ", "Carlos@gmail.com", "f345g");
//        
//        Pedido ped1 = new Pedido(1, LocalDateTime.now(), c1, pedidos.modelos.Estado.CREADO, new ArrayList<>());
//        Pedido ped2 = new Pedido(2, LocalDateTime.now(), c2, pedidos.modelos.Estado.PROCESANDO, new ArrayList<>());
//        Pedido ped3 = new Pedido(3, LocalDateTime.now(), c3, pedidos.modelos.Estado.ENTREGADO, new ArrayList<>());
//
//        // === Agrego productos con cantidades a los pedidos ===
//        ped1.verListaProductos().add(new ProductoDelPedido(p1, 2));  
//        ped1.verListaProductos().add(new ProductoDelPedido(p1,1));  
//        ped2.verListaProductos().add(new ProductoDelPedido(p2, 3));  
//        ped3.verListaProductos().add(new ProductoDelPedido(p1, 1));  
//        ped3.verListaProductos().add(new ProductoDelPedido(p3, 2));  
//        
//        listaProductos.add(p1);
//        listaProductos.add(p2);
//        listaProductos.add(p3);
//   
//        listaClientes.add(c1);
//        listaClientes.add(c2);
//        listaClientes.add(c3);
//        
//        listaEmpleados.add(e1);
//        listaEmpleados.add(e2);
//        listaEmpleados.add(e3);
//        
//        listaEncargados.add(en1);
//        listaEncargados.add(en2);
//        listaEncargados.add(en3);
//        
//        listaPedidos.add(ped1);
//        listaPedidos.add(ped2);
//        listaPedidos.add(ped3);
//        
//        c1.agregarPedido(ped1);
//        c2.agregarPedido(ped2);
//        c3.agregarPedido(ped3);
//
//        
//        for (Producto p: listaProductos)
//            p.mostrar();
//        
//        p1.asignarDescripcion("Milanesa con pure");
//        p1.asignarPrecio(250.0f);
//        
//        for (Producto p: listaProductos)
//            System.out.println(p);
//
//        System.out.println("\n==Modificar un cliente==");
//        listaClientes.get(0).asignarCorreo("nuevoCorreo@gmail.com");
//        System.out.println("Correo actualizado: " + listaClientes.get(0).verCorreo());
//
//        System.out.println("\n==Modificar un empleado==");
//        listaEmpleados.get(1).asignarNombre("Luciana");
//        System.out.println("Nombre actualizado: " + listaEmpleados.get(1).verNombre());
//
//        System.out.println("\n==Modificar un encargado==");
//        listaEncargados.get(2).asignarApellido("Barrionuevo");
//        System.out.println("Apellido actualizado: " + listaEncargados.get(2).verApellido());
//
//       
//        System.out.println("\n==Clientes==");
//        for (Cliente c: listaClientes)
//            System.out.println(c);
//        
//        System.out.println("\n==Empleados==");
//        for (Empleado e: listaEmpleados)
//            System.out.println(e);
//        
//        System.out.println("\n==Encargados==");
//        for (Encargado en: listaEncargados)
//            System.out.println(en);
//
//        
//        System.out.println("\n==Pedidos por cliente==");
//        for (Cliente c : listaClientes) {
//            c.mostrarPedidos();
//        }
//    }
//}