package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.*;
import pedidos.modelos.*;


public class ControladorPrincipal {
    /*
    public static void main(String[] args) {
        //PRIMERA PARTE
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
        Empleado e1=new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3= new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
               
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS ");
  
        for (Empleado e: listaEmpleados)
            e.mostrar();
        
        e1.asignarApellido("APELLIDOEmpleado11");
        listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");
        
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
        
        p1.asignarDescripcion("Milanesa con puré");
        p1.asignarPrecio(250.0f);
        
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
    }
*/
}
