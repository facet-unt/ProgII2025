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
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 1550.8f);
        Producto p2 = new Producto(2, "Producto2", Categoria.ENTRADA, Estado.DISPONIBLE, 850.8f);
        Producto p3 = new Producto(3, "Producto3", Categoria.PLATOPRINCIPAL, Estado.NODISPONIBLE, 1050.0f);
        
        Cliente c1 = new Cliente("Cagna ", "Pedro ", "pedri@gmail.com", "5656", new ArrayList<>());
        Cliente c2 = new Cliente("Toledo ", "Olivia ", "olivia@gmail.com", "ht5", new ArrayList<>());
        Cliente c3 = new Cliente("Sanchez ", "Mariana ", "Mariana@gmail.com", "j6e", new ArrayList<>());
        
        Empleado e1 = new Empleado("Martinez ", "Juan ", "juan@gmail.com", "h566");
        Empleado e2 = new Empleado("Paz ", "Lucia ", "Lucia@gmail.com", "h566");
        Empleado e3 = new Empleado("Alvarez ", "Martin ", "Martin@gmail.com", "h566");
       
        Encargado en1 = new Encargado("Rodriguez ", "Leandro ", "Leandro@gmail.com", "j67r");
        Encargado en2 = new Encargado("Quintero ", "Franco ", "julieta@gmail.com", "f34g6");
        Encargado en3 = new Encargado("Barrios ", "Carlos ", "Carlos@gmail.com", "f345g");
        
        Pedido ped1 = new Pedido(1, LocalDateTime.now(), c1, pedidos.modelos.Estado.CREADO);
        Pedido ped2 = new Pedido(2, LocalDateTime.now(), c2, pedidos.modelos.Estado.PROCESANDO);
        Pedido ped3 = new Pedido(3, LocalDateTime.now(), c3, pedidos.modelos.Estado.ENTREGADO);

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
        
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(ped1);
        listaPedidos.add(ped2);
        listaPedidos.add(ped3);
        
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