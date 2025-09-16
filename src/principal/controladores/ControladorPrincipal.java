/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;


// Paquetes importados:

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

/**
 *
 * @author Esteban
 */
public class ControladorPrincipal {
    
    public static void main(String[] args) {
        
        //Arrays para cada clase
        ArrayList<Producto> listaProductos = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();
        ArrayList<Empleado> listaEmpleados = new ArrayList();
        ArrayList<Encargado> listaEncargados = new ArrayList();
        
        //Inicializacion de 3 objetos de la clase Producto
        Producto unProducto = new Producto();
        Producto unProducto1 = new Producto();
        Producto unProducto2 = new Producto();
        
        //unProducto:
        unProducto.categoria = "Entrada";
        unProducto.codigo = 01;
        unProducto.descripcion = "Berenjena al escabeche";
        unProducto.estado = "Disponible";
        unProducto.precio = 510.5f ;
        
        //unProducto1:
        unProducto1.categoria = "Plato Principal";
        unProducto1.codigo = 02;
        unProducto1.descripcion = "Asado";
        unProducto1.estado = "Disponible";
        unProducto1.precio = 34054.1f ;
        
        //unProducto2:
        unProducto2.categoria = "Postre";
        unProducto2.codigo = 03;
        unProducto2.descripcion = "Helado";
        unProducto2.estado = "No disponible";
        unProducto2.precio = 2600.5f ;
        
        //Agrego los productos a la lista de Productos
        listaProductos.add(unProducto);
        listaProductos.add(unProducto1);
        listaProductos.add(unProducto2);
        
        //Muestro los atributos de los productos:
        for(Producto p : listaProductos)
            System.out.println(p); //utilizo internamente el metodo toString();
        
        
        //Inicializacion de 3 objetos de la clase Cliente
        Cliente unCliente = new Cliente();
        Cliente unCliente1 = new Cliente();
        Cliente unCliente2 = new Cliente();
        
        //unCliente
        unCliente.apellido = "Diaz";
        unCliente.nombre = "Thomas";
        unCliente.correo = "thomasale354@gmail.com";
        unCliente.clave = "12345jhkhl";
        
        //unCliente1
        unCliente1.apellido = "Lobo Silva";
        unCliente1.nombre = "Esteban";
        unCliente1.correo = "estebanlobo3123@gmail.com";
        unCliente1.clave = "holA12345";
        
        //unCliente2
        unCliente2.apellido = "Paredes";
        unCliente2.nombre = "Luciano";
        unCliente2.correo = "paredesluciano2344@gmail.com";
        unCliente2.clave = "caballo2345";
        
        //Agrego los clientes a su ArrayList
        listaClientes.add(unCliente);
        listaClientes.add(unCliente1);
        listaClientes.add(unCliente2);
        
        for (Cliente c : listaClientes){
            System.out.println(c);
        }
        
        
        //Inicializacion de 3 objetos de la clase Empleado
        Empleado unEmpleado = new Empleado();
        Empleado unEmpleado1 = new Empleado();
        Empleado unEmpleado2 = new Empleado();
        
        //unEmpleado
        unEmpleado.apellido = "Gonzalez";
        unEmpleado.nombre = "Leandro";
        unEmpleado.correo = "gonzalezlean123@gmail.com";
        unEmpleado.clave = "123hhjg44";
        
        //unEmpleado1
        unEmpleado1.apellido = "Lopez";
        unEmpleado1.nombre = "Manuel";
        unEmpleado1.correo = "manuellopez223@gmail.com";
        unEmpleado1.clave = "cont334s";
        
        //unEmpleado2
        unEmpleado2.apellido = "Cardozo";
        unEmpleado2.nombre = "Hernan";
        unEmpleado2.correo = "hernanCardozo55663@gmail.com";
        unEmpleado2.clave = "especias12333f";
        
        //Agrego los empleados a su ArrayList y lo recorro en un for
        listaEmpleados.add(unEmpleado);
        listaEmpleados.add(unEmpleado1);
        listaEmpleados.add(unEmpleado2);
        
        for (Empleado e : listaEmpleados){
            System.out.println(e);
        }
        
        
        //Inicializacion de 3 objetos de la clase Encargado
        Encargado unEncargado = new Encargado();
        Encargado unEncargado1 = new Encargado();
        
        //unEncargado
        unEncargado.apellido = "Sanchez";
        unEncargado.nombre = "Mariana";
        unEncargado.correo = "sanchezmar2323@gmail.com";
        unEncargado.clave = "ell345dk";
        
        //unEncargado1
        unEncargado1.apellido = "Gonzalez";
        unEncargado1.nombre = "Miguel";
        unEncargado1.correo = "miguelgon456@gmail.com";
        unEncargado1.clave = "segur2345kk";
        
        listaEncargados.add(unEncargado);
        listaEncargados.add(unEncargado1);
        
        for (Encargado manager : listaEncargados){
            System.out.println(manager);
        }
    }
}
package principal.controladores;

import productos.modelos.Producto;


public class ControladorPrincipal {
    public static void main(String[] args) {
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
