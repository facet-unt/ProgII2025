package principal.controladores;

import productos.modelos.Producto;
import java.util.ArrayList;
import usuarios.modelos.*;

public class ControladorPrincipal {
    public static void main(String[] args) {
       
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        
        
        Cliente C1 = new Cliente();
        clientes.add(C1);
        Cliente C2 = new Cliente();
        clientes.add(C2);
        Cliente C3 = new Cliente();
        clientes.add(C3);
        
        Empleado Emp1 = new Empleado();
        empleados.add(Emp1);
        Empleado Emp2 = new Empleado();
        empleados.add(Emp2);
        Empleado Emp3 = new Empleado();
        empleados.add(Emp3);
        
        Encargado Enc1 = new Encargado();
        encargados.add(Enc1);
        Encargado Enc2 = new Encargado();
        encargados.add(Enc2);
        Encargado Enc3 = new Encargado();
        encargados.add(Enc3);
        
        Producto P1 = new Producto();
        productos.add(P1);
        Producto P2 = new Producto();
        productos.add(P2);
        Producto P3 = new Producto();
        productos.add(P3);
        
        for(Cliente c : clientes){
            c.mostrar();
        }
        for(Empleado e : empleados){
            e.mostrar();
        }
        for(Encargado e : encargados){
            e.mostrar();
        }
        for(Producto p : productos){
            System.out.println(p);
        }
        
    }
}
