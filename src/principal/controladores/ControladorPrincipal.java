package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto pizza = new Producto();
      
        
        
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        
        pizza.descripcion = "muzzarela";
        pizza.categoria= "comida";
        pizza.estado = "pendiente";
        pizza.precio = 1200f;
        
        productos.add(pizza);
        
        Producto hamburguesa= new Producto();
        hamburguesa.estado="pendiente";
        hamburguesa.precio=10000f;
        hamburguesa.descripcion="Con cheddar y baccon";
        hamburguesa.categoria="comida";
        
        productos.add(hamburguesa);
        
        for(Producto comida:productos){
            System.out.println(comida);
            
        }
        
        Cliente cliente1 = new Cliente();
        cliente1.apellido= "lodi";
        cliente1.clave= "45332932";
        cliente1.correo="gdewhfg";
        cliente1.nombre="sofia";
        
        Cliente cliente2= new Cliente();
        cliente2.apellido= "acevedo";
        cliente2.clave= "453329334342";
        cliente2.correo="gdfgdgewhfg";
        cliente2.nombre="sodfghtgfrshhsrhtyia";
        
               clientes.add(cliente1);
               clientes.add(cliente2);

        
        for(Cliente clientess:clientes){
            System.out.println(clientess);
            
        }
        
        
    }
    
    
    
}
