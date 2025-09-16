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
 
        
        //Creacion de ArrayList
        ArrayList<Producto> unProducto = new ArrayList();
        ArrayList<Cliente> unCliente = new ArrayList();
        ArrayList<Empleado> unEmpleado = new ArrayList();
        ArrayList<Encargado> unEncargado = new ArrayList();
        
        //Creacion de cada objeto
        
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
         
        Empleado empleado1 = new Empleado(); 
        Empleado empleado2 = new Empleado(); 
        Empleado empleado3 = new Empleado(); 
        
        Encargado encargado1 = new Encargado(); 
        Encargado encargado2 = new Encargado(); 
        Encargado encargado3 = new Encargado(); 
        
        //Cargado de cada objeto en el arraylist
        
        unProducto.add(producto1);
        unProducto.add(producto2);
        unProducto.add(producto3);   
        
        unCliente.add(cliente1);
        unCliente.add(cliente2);
        unCliente.add(cliente3);
        
        unEmpleado.add(empleado1);
        unEmpleado.add(empleado2);
        unEmpleado.add(empleado3);
        
        unEncargado.add(encargado1);
        unEncargado.add(encargado2);
        unEncargado.add(encargado3);
        
       //Asignando valores a los atributos de algunos objetos
       producto1.asignarCodigo(12);
       producto1.asignarCodigo(312);
       producto1.asignarDescripcion("pizza");
       producto1.asignarEstado("Disponible");
       producto1.asignarCategoria("Plato principal");
       producto1.verCategoria();
       producto1.verCodigo();
       producto1.verDescripcion();
       producto1.verEstado();
       producto1.verPrecio();
       
       
       cliente1.asignarApellido("Ortega");
       cliente1.asignarClave("11fsaf");
       
       empleado1.asignarApellido("Mensege");
       empleado1.asignarClave("123JK");
       
       encargado2.asignarNombre("Leandro");
       encargado2.asignarCorreo("lmensege@gmail.com");
       
       //Recorriendo cada Arraylist
       
       for(Producto producto: unProducto)
       {
           producto.mostrar(); //Llamo al metodo mostrar
       }
     
       for(Cliente cliente: unCliente)
       {
           cliente.mostrar(); 
       }
     
       for(Empleado empleado: unEmpleado)
       {
           empleado.mostrar();
       }
     
       for(Encargado encargado: unEncargado)
       {
           encargado.mostrar();
       }      
    
       //Uso de to-string con Producto
       
       for(Producto producto: unProducto)
       {
           System.out.println(producto); 
       }
    }
}