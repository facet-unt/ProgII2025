package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Cliente;

public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<> ();
        ArrayList<Encargado> listaEncargados = new ArrayList<> ();
        
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
 
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente c1 = new Cliente ("jp@gmail.com","holasi","Toledo","Juan Pablo");
        Cliente c2 = new Cliente ("capoidolo@gmail.com","metelenomas","Royale","Clash");
        Cliente c3 = new Cliente ("increible@gmail.com","espectacular","Ronaldo","Cristiano");
        
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        for (Cliente c: listaClientes)
            System.out.println(c);
        
        System.out.println("\n El nombre del cliente es :" + listaClientes.get(1).verNombre());
        listaClientes.get(1).AsignarNombre("Tobias");
        System.out.println("\n El nuevo nombre del cliente es :" + listaClientes.get(1).verNombre());
        
        for (Cliente c: listaClientes)
            System.out.println(c);
         
        

       
            
    }
}