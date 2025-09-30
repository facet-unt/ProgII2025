package principal.controladores;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargado = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE, 1666.8f);
        Producto p2;
        p2 = new Producto(2, "Producto2", Categoria.POSTRE, Estado.DISPONIBLE, 850.8f);
        Producto p3 = new Producto(3, "Producto3", Categoria.PLATOPRINCIPAL, Estado.NO_DISPONIBLE, 1050.0f);
        
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
        
        System.out.println("CLIENTES");
        Cliente c1= new Cliente("alumno@gmail.com", "1234ju", "dadamo","pablo");
        Cliente c2= new Cliente("alumno1@gmail.com", "1234", "perez","juan");
        Cliente c3= new Cliente("alumno2@gmail.com", "1234123", "correa","angel");
        
        listaCliente.add(c1);
        listaCliente.add(c2);
        listaCliente.add(c3);
        
        for (Cliente p: listaCliente)
            p.mostrar();
        System.out.println("#################### ");
        
        System.out.println("EMPLEADOS");
        Empleado e1= new Empleado("empleado@gmail.com", "1234ju", "andrada","cablo");
        Empleado e2= new Empleado("empleado1@gmail.com", "1234ju", "miranda","joseu");
        Empleado e3= new Empleado("empleado2@gmail.com", "1234ju", "pereira","pablo");
        
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        for (Empleado p: listaEmpleados)
            p.mostrar();
        System.out.println("#################### ");
        
        System.out.println("ENCARGADOS");
        Encargado en1=new Encargado("encargado@gmail.com", "12345", "oro", "faustino");
        Encargado en2=new Encargado("encargado@gmail.com", "12345", "carsel", "daniel");
        Encargado en3=new Encargado("encargado@gmail.com", "12345", "luna", "camila");
        
        listaEncargado.add(en3);
        listaEncargado.add(en1);
        listaEncargado.add(en2);
        
        for (Encargado p: listaEncargado)
            p.mostrar();
        System.out.println("#################### ");
    }
}