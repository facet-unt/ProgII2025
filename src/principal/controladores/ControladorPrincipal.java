package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> unProducto = new ArrayList();
        ArrayList<Cliente> unCliente = new ArrayList();
        ArrayList<Empleado> unEmpleado = new ArrayList();
        ArrayList<Encargado> unEncargado = new ArrayList();
        
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
         
        Empleado empleado1 = new Empleado(); 
        Empleado empleado2 = new Empleado(); 
        Empleado empleado3 = new Empleado(); 
        
        

        Producto p = new Producto();
        p.mostrar();
        
        System.out.println(p);
        
    }
}
