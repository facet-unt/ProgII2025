package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        
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
       
       producto1.precio = 1540.32f;
       producto1.descripcion = "gaseosa";
       
       producto2.categoria = "bebidas";
       producto2.codigo = 1325;  
       
       cliente1.nombre = "Rocio";
       cliente2.nombre = "Lyan";
       
       empleado1.correo = "rocioorteg@gmail.com";
       empleado2.correo = "lmensege@gmail.com";
       
       encargado1.clave = "incorrecta";
       encargado2.clave = "123456";
       
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
