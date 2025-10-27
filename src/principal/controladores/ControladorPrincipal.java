///*
//package principal.controladores;
//
//import java.time.LocalDateTime;
//
//import pedidos.modelos.*;
//import productos.modelos.*;
//
//import productos.modelos.Categoria;
////import productos.modelos.Estado;
//import productos.modelos.Producto;
//
//import usuarios.modelos.*;
//import pedidos.modelos.*;
//import pedidos.modelos.Pedido;
//import pedidos.modelos.ProductoDelPedido;
//import productos.modelos.Categoria;
////import productos.modelos.Estado; //Error hay dos enum con el mismo nombre (cambiar alguna¿)
//import productos.modelos.Producto;
//import usuarios.modelos.Cliente;
//import usuarios.modelos.Empleado;
//import usuarios.modelos.Encargado;
//
//public class ControladorPrincipal {
//
//    public static void main(String[] args) {
//<<<<<<< HEAD
//        //PRIMERA PARTE
//         /*
//        Definir un ArrayList para cada una de las clases Cliente, 
//        Empleado, Encargado y Producto  (realizar las importaciones correspondientes).*/
//        /*
//        ArrayList<Cliente> listaClientes = new ArrayList<>();
//        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
//        ArrayList<Encargado> listaEncargados = new ArrayList<>();
//        ArrayList<Producto> listaProductos = new ArrayList<>();
//        ArrayList<Pedido> listaPedidos = new ArrayList<>();
//        ArrayList<ProductoDelPedido> listaProductosPedidos1 = new ArrayList<>();
//        ArrayList<ProductoDelPedido> listaProductosPedidos2 = new ArrayList<>();
//        ArrayList<ProductoDelPedido> listaProductosPedidos3 = new ArrayList<>();
//         /*
//        
//        /*Instanciar 3 objetos de cada clase y guardarlos en su correspondiente ArrayList. */
//        /*
//        Empleado e1=new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
//        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
//        Empleado e3= new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
//               
//        listaEmpleados.add(e1);
//        listaEmpleados.add(e2);
//        listaEmpleados.add(e3);
//        
//        System.out.println("#################### ");
//        System.out.println("EMPLEADOS ");
//        */
//        /*Recorrer cada ArrayList y mostrar su contenido por pantalla. */
//        /*
//        for (Empleado e: listaEmpleados)
//            e.mostrar();
//        */
//        
//        /*Realizar algunas modificaciones a algunos de los objetos antes creados, */
//        //DEBO usar los métodos para ese fin
///*
//        e1.asignarApellido("APELLIDOEmpleado11");
//        listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");
//        
//        /*y volver a recorrer los ArrayLists verificando que se hicieron los cambios. */
///*
//         for (Empleado e: listaEmpleados)
//            e.mostrar();
//         
//        System.out.println("#################### ");
//        System.out.println("PRODUCTOS");
//        Producto p1 = new  Producto(1, "Producto 1", Categoria.ENTRADA ,productos.modelos.Estado.DISPONIBLE, 200.0f);        
//        Producto p2 = new  Producto(2, "Producto 2", Categoria.PLATO_PRINCIPAL, productos.modelos.Estado.DISPONIBLE, 1950.0f);        
//        Producto p3 = new  Producto(3, "Producto 3",Categoria.POSTRE, productos.modelos.Estado.NO_DISPONIBLE, 580.0f);        
//        
//        listaProductos.add(p1);
//        listaProductos.add(p2);
//        listaProductos.add(p3);
//        
//        for (Producto p: listaProductos)
//            p.mostrar();
//        
//        p1.asignarDescripcion("Milanesa con puré");
//        p1.asignarPrecio(250.0f);
//        
//        for (Producto p: listaProductos)
//            System.out.println(p);
//         
//        System.out.println("#################### ");
//        System.out.println("ENCARGADOS");
//        Encargado unEncargado1 = new Encargado("encargado1@mail.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
//        Encargado unEncargado2 = new Encargado("encargado2@mail.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
//        Encargado unEncargado3 = new Encargado("encargado3@mail.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
//        
//        listaEncargados.add(unEncargado1);
//        listaEncargados.add(unEncargado2);
//        listaEncargados.add(unEncargado3);
//        
//        for (Encargado e: listaEncargados)
//            e.mostrar();
//        
//        System.out.println("#################### ");
//        System.out.println("CLIENTES");
//        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
//        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
//        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
//        
//        listaClientes.add(cliente1);
//        listaClientes.add(cliente2);
//        listaClientes.add(cliente3);
//        
//
//        for (Cliente e: listaClientes)
//           e.mostrar();
//
//        
//        //SEGUNDA PARTE
//        System.out.println("#################### ");
//        System.out.println("PEDIDOS");
//        ProductoDelPedido pdp1 = new ProductoDelPedido(2, p1); 
//        ProductoDelPedido pdp2 = new ProductoDelPedido(1, p2); 
//        
//        listaProductosPedidos1.add(pdp1);
//        listaProductosPedidos1.add(pdp2);
//        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), cliente1,listaProductosPedidos1); 
//        
//        ProductoDelPedido pdp3 = new ProductoDelPedido(3, p3);
//        ProductoDelPedido pdp4 = new ProductoDelPedido(4, p2); 
//        
//        listaProductosPedidos2.add(pdp3);
//        listaProductosPedidos2.add(pdp4);
//        
//        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), listaClientes.get(1),listaProductosPedidos2); 
//        
//        ProductoDelPedido pdp5 = new ProductoDelPedido(1, p1);
//        listaProductosPedidos3.add(pdp5);
//        
//        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), cliente2,listaProductosPedidos3); 
//=======
//        ArrayList<ProductoDelPedido> pido1 = new ArrayList<>();
//        pido1.add(new ProductoDelPedido(p1, 1));
//        pido1.add(new ProductoDelPedido(p2, 2));
//        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(),pido1, cliente1); 
//        
//=======
//
//        //Creacion de ArrayList
//        ArrayList<Producto> unProducto = new ArrayList();
//        ArrayList<Cliente> unCliente = new ArrayList();
//        ArrayList<Empleado> unEmpleado = new ArrayList();
//        ArrayList<Encargado> unEncargado = new ArrayList();
//        ArrayList<Pedido> listaPedidos = new ArrayList<>(); /* Nuevo arraylist */
//        ArrayList<ProductoDelPedido> pido1 = new ArrayList<>(); 
//>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
//        ArrayList<ProductoDelPedido> pido2 = new ArrayList<>();
//        ArrayList<ProductoDelPedido> pido3 = new ArrayList<>();
//<<<<<<< HEAD
//        pido3.add(new ProductoDelPedido(p1, 1));
//        pido3.add(new ProductoDelPedido(p3, 2));
//        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(),pido3, cliente2); 
//>>>>>>> desarrollo
//        
//        listaPedidos.add(unPedido1);
//        listaPedidos.add(unPedido2);
//        listaPedidos.add(unPedido3);
//        
//        for (Pedido p: listaPedidos)
//            p.mostrar();
//        System.out.println("#################### ");
//        
//        
//        
//        
//        
//    }
//}*/
//=======
//        
//        //Creacion de cada objeto y asignado de valores //
//        System.out.println("PRODUCTOS");
//        Producto producto1 = new Producto(0, "Pizza", Categoria.ENTRADA, productos.modelos.Estado.NO_DISPONIBLE, 453.23f);
//        Producto producto2 = new Producto(1, "Hamburguesa", Categoria.PLATO_PRINCIPAL, productos.modelos.Estado.DISPONIBLE, 2332.45f);
//        Producto producto3 = new Producto(2, "Tiramisu", Categoria.POSTRE, productos.modelos.Estado.DISPONIBLE, 2343.65f);
//
//        System.out.println("CLIENTES");
//        Cliente cliente1 = new Cliente("rociortteg@gmail.com", "123", "Ortega", "Rocio");
//        Cliente cliente2 = new Cliente("lmensege@gamil.com", "456", "Mensege", "Lyan");
//        Cliente cliente3 = new Cliente("lucruiz@gmail.com", "845", "Ruiz", "Lucia");
//
//        System.out.println("EMPLEADOS");
//        Empleado empleado1 = new Empleado("sofiarobl@gamil.com", "800", "Robledo", "Sofia");
//        Empleado empleado2 = new Empleado("sabrina123@gmail.com", "500", "Vega", "Sabrina");
//        Empleado empleado3 = new Empleado("karengomez@gamil.com", "342", "Gomez", "Karen");
//
//        System.out.println("ENCARGADOS");
//        Encargado encargado1 = new Encargado("jose34gmail.com", "645", "Brizuela", "Jose");
//        Encargado encargado2 = new Encargado("guadab@gmail.com", "565", "Aguirre", "Guada");
//        Encargado encargado3 = new Encargado("lourdes@gmail.com", "233", "Gomez", "Lourdes");
//
//        /* Creacion de nuevos objetos de tipo Pedido */
//        Pedido pedido1 = new Pedido(1, LocalDateTime.now(), Estado.CREADO, pido1, cliente1);
//        Pedido pedido2 = new Pedido(2, LocalDateTime.now(), Estado.ENTREGADO, pido2, cliente2);
//        Pedido pedido3 = new Pedido(3, LocalDateTime.now(), Estado.PROCESANDO, pido3, cliente3);
//        
//        //Cargado de cada objeto en el arraylist
//        unProducto.add(producto1);
//        unProducto.add(producto2);
//        unProducto.add(producto3);
//
//        unCliente.add(cliente1);
//        unCliente.add(cliente2);
//        unCliente.add(cliente3);
//
//        unEmpleado.add(empleado1);
//        unEmpleado.add(empleado2);
//        unEmpleado.add(empleado3);
//
//        unEncargado.add(encargado1);
//        unEncargado.add(encargado2);
//        unEncargado.add(encargado3);
//        
//        /*Se añaden los nuevos objetos al arraylist */
//        listaPedidos.add(pedido1);
//        listaPedidos.add(pedido2);
//        listaPedidos.add(pedido3);
//        
//        //Agregacion de objeto del tipo ProductoDelPedido al arraylist
//        pido1.add(new ProductoDelPedido(producto1, 1));
//        pido1.add(new ProductoDelPedido(producto2, 2));
//        
//        pido2.add(new ProductoDelPedido(producto3, 5));
//        pido2.add(new ProductoDelPedido(producto2, 10));
//        
//        pido3.add(new ProductoDelPedido(producto1, 5));
//        pido3.add(new ProductoDelPedido(producto2, 2));
//        
//        //Asignando valores a los atributos de algunos objetos con metodos
//        /*producto1.asignarCodigo(12);
//       producto1.asignarCodigo(312);
//       producto1.asignarDescripcion("pizza");
//       producto1.asignarEstado("Disponible");
//       producto1.asignarCategoria("Plato principal");
//    
//       cliente1.asignarApellido("Ortega");
//       cliente1.asignarClave("11fsaf");
//       
//       empleado1.asignarApellido("Mensege");
//       empleado1.asignarClave("123JK");
//       
//       encargado2.asignarNombre("Leandro");
//       encargado2.asignarCorreo("lmensege@gmail.com");*/
//        //Recorriendo cada Arraylist
//        for (Producto producto : unProducto) {
//            producto.mostrar(); //Llamo al metodo mostrar
//        }
//
//        for (Cliente cliente : unCliente) {
//            cliente.mostrar();
//        }
//
//        for (Empleado empleado : unEmpleado) {
//            empleado.mostrar();
//        }
//
//        for (Encargado encargado : unEncargado) {
//            encargado.mostrar();
//        }
//
//        //Se muestran los nuevos objetos agregados de Pedido //
//        for (Pedido pedido : listaPedidos) {
//            pedido.mostrar();
//        }
//
//        //Uso de to-string con Producto
//        for (Producto producto : unProducto) {
//            System.out.println(producto);
//        }
//
//    }
//}
//>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
