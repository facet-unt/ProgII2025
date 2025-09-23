/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;


// Paquetes importados:

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.*;


public class ControladorPrincipal {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();

        Producto prod1 = new Producto(1, "Laptop", "Electronica", "Nuevo", 1200.5f);
       
        Producto prod2 = new Producto(2, "Mouse", "Accesorio", "Nuevo", 25.0f);
        
        Producto prod3 = new Producto(3, "Silla", "Muebles", "Usado", 100.0f);
        
        Producto prod4 = new Producto(4, "Pizza", "Plato principal", 100.0f);
        
        Producto prod5 = new Producto(5, "Hamburguesa", 100.0f);
      
        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        // Clientes
        Cliente cli1 = new Cliente("juan@mail.com", "1234", "Perez", "Juan");
      
        Cliente cli2 = new Cliente("ana@mail.com", "5678", "Garcia", "Ana");
        

        Cliente cli3 = new Cliente("mario@mail.com", "abcd", "Lopez", "Mario");
        

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        // Empleados
        Empleado emp1 = new Empleado("emp1@mail.com", "pass1", "Rodriguez", "Carlos");
        
        Empleado emp2 = new Empleado("emp2@mail.com", "pass2", "Martinez", "Lucia");
        

        Empleado emp3 = new Empleado("emp3@mail.com", "pass3", "Gomez", "Pedro");
        

        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);

        // Encargados
        Encargado en1 = new Encargado("enc1@mail.com", "key1", "Sanchez", "Laura");
        

        Encargado en2 = new Encargado("enc2@mail.com", "key2", "Fernandez", "Jose");
      

        Encargado en3 = new Encargado("enc3@mail.com", "key3", "Ruiz", "Marta");
       

        encargados.add(en1);
        encargados.add(en2);
        encargados.add(en3);

        // Mostrar contenido inicial
        System.out.println("---- Productos ----");
        for (Producto p : productos) p.mostrar();

        System.out.println("---- Clientes ----");
        for (Cliente c : clientes) c.mostrar();

        System.out.println("---- Empleados ----");
        for (Empleado e : empleados) e.mostrar();

        System.out.println("---- Encargados ----");
        for (Encargado en : encargados) en.mostrar();


        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS\n");
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
        System.out.println("\nEl precio del producto es: " +  listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es: " +  listaProductos.get(2).verPrecio());
        
        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### \n");
        
        
        
        System.out.println("#################### ");
        System.out.println("CLIENTES\n");
        Cliente c1 = new Cliente("tebybtb@gmail.com", "46263", "Lobo Silva","Esteban");
        Cliente c2 = new Cliente("pepito@gmail.com", "00063", "Perez","Pedro");
        Cliente c3 = new Cliente("vegeta777@gmail.com", "77777", "Cano","Joaquin");
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        System.out.println("CLIENTES usando mostrar()");
        for (Cliente c: listaClientes)
            c.mostrar();
         
        listaClientes.get(1).asignarClave("55555");
        System.out.println("\nEl nombre del cliente es: " +  listaClientes.get(1).verNombre());
        listaClientes.get(1).asignarCorreo("esteban@gmail.com");
        System.out.println("El nuevo correo es: " +  listaClientes.get(1).verCorreo());
        
        System.out.println("\nCLIENTES usando toString()");
        for (Cliente c: listaClientes)
            System.out.println(c);
        System.out.println("#################### \n");
        
        
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS\n");
        Empleado e1 = new Empleado("alfonsogutierrez@gmail.com", "6998fgh", "Gutierrez", "Alfonso");
        Empleado e2 = new Empleado("josesito@gmail.com", "55567fd", "Diaz", "Jose");
        Empleado e3 = new Empleado("thomasale354@gmail.com", "4445jhg", "Diaz", "Thomas");
        
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        
        System.out.println("EMPLEADOS usando mostrar():");
        for (Empleado e : listaEmpleados){
            e.mostrar();
        }
        
        System.out.println("\nEMPLEADOS usando el metodo toString()");
        for (Empleado e : listaEmpleados){
            System.out.println(e);
        }
        
        //Cambio algunos atribtos con los metodos get/set
        
        listaEmpleados.get(0).asignarCorreo("gutierrezalf234@gmail.com");
        System.out.println("\nEl nombre del empleado es: " + listaEmpleados.get(0).verNombre());
        System.out.println("Su nuevo correo es: " + listaEmpleados.get(0).verCorreo());
        
        listaEmpleados.get(2).asignarClave("67770009k"); //Nueva clave para el cliente 3
        
        System.out.println("\nRecorro el array con toString con los cambios");
        for (Empleado e : listaEmpleados){
            System.out.println(e);
        }
        System.out.println("#################### \n");
        
        
        
        System.out.println("#################### ");
        System.out.println("ENCARGADOS\n");
        Encargado encargado1 = new Encargado("jimenezals@gmail.com", "888999jku", "Salomon", "Jimenez");
        Encargado encargado2 = new Encargado("lucasquarta@gmail.com", "7778jjd33", "Quarta", "Lucas");
        
        listaEncargados.add(encargado1);
        listaEncargados.add(encargado2);
        
        System.out.println("Encargados usando toString(): ");
        for (Encargado enc : listaEncargados){
            System.out.println(enc);
        }
        
        // Cambio algunos atributos con los metodos get/set
        
        listaEncargados.get(0).asignarClave("hidraulica123jj");
        listaEncargados.get(0).asignarCorreo("salojime@gmail.com");
        listaEncargados.get(1).asignarCorreo("quarta123luc@hotmail.com");
        
        System.out.println("\nCambios en los correos y una clave: ");
        for (Encargado enc : listaEncargados){
            System.out.println(enc);
        }
    }
}