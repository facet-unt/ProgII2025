/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {

    public static void main(String[] args) {
        // lo nuestro
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();
        Encargado encargado1 = new Encargado();
        Encargado encargado2 = new Encargado();
        Encargado encargado3 = new Encargado();
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();
        
        ArrayList<Cliente> unCliente = new ArrayList<>();
        ArrayList<Empleado> unEmpleado = new ArrayList<>();
        ArrayList<Encargado> unEncargado = new ArrayList<>();
        ArrayList<Producto> unProducto = new ArrayList<>();
        
        producto1.codigo=25;
        producto1.descripcion="Hola buenas";
        producto1.categoria="Postres";
        producto1.estado="En stock";
        producto1.precio=7560.50f;
        cliente1.apellido="garcia";
        cliente1.nombre="Pepito";
        cliente1.correo="pepito@garcia";
        cliente1.clave="ClaveDePepito";
        empleado1.apellido="Apellido del empleado";
        empleado1.nombre="Nombre del empleado";
        empleado1.correo="Empleado@esteEmpleado";
        empleado1.clave="Clave del empleado";
        encargado1.apellido="Apellido del encargado";
        encargado1.nombre="Nombre del encargado";
        encargado1.correo="Correo del encargado";
        encargado1.clave="Clave del encargado";

        unCliente.add(cliente1);
        unCliente.add(cliente2);
        unCliente.add(cliente3);
        unEmpleado.add(empleado1);
        unEmpleado.add(empleado2);
        unEmpleado.add(empleado3);
        unEncargado.add(encargado1);
        unEncargado.add(encargado2);
        unEncargado.add(encargado3);
        unProducto.add(producto1);
        unProducto.add(producto2);
        unProducto.add(producto3);
        
        System.out.println("Este es el arraylist de productos");
        for (Object i : unProducto) {
            System.out.println("Elemento de producto:" + i);
        }
        System.out.println("Este es el arraylist de clientes");
        for (Object i : unCliente) {

            System.out.println("Elemento de cliente:" + i);
        }
        System.out.println("Este es el arraylist de empleados");
        for (Object i : unEmpleado) {

            System.out.println("Elemento de empleado:" + i);
        }
        System.out.println("Este es el arraylist de encargados");
        for (Object i : unEncargado) {

            System.out.println("Elemento de encargado:" + i);
        }
        
        empleado2.clave = "unodostrescuatrocinco";
        encargado1.nombre = "Carlos";
        producto2.descripcion = "nueva descripcion";
        cliente1.nombre = "Carlitos";
        
        System.out.println("Este es el arraylist de productos MODIFICADO");
        for (Object i : unProducto) {
            System.out.println("Elemento de producto:" + i);
        }
        System.out.println("Este es el arraylist de clientes MODIFICADO");
        for (Object i : unCliente) {

            System.out.println("Elemento de cliente:" + i);
        }
        System.out.println("Este es el arraylist de empleados MODIFICADO");
        for (Object i : unEmpleado) {

            System.out.println("Elemento de empleado:" + i);
        }
        System.out.println("Este es el arraylist de encargados MODIFICADO");
        for (Object i : unEncargado) {

            System.out.println("Elemento de encargado:" + i);
        }
        // lo del ingeniero
        Producto p = new Producto();
        p.asignarCodigo(1);
        p.asignarDescripcion("Pizza");
        System.out.println(p);
        
        
/*        
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
        
        */

        //System.out.println(pizza);
    }
    
    
    
}
