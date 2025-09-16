package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.*;


public class ControladorPrincipal {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();

        Producto prod1 = new Producto();
        prod1.codigo=1; 
        prod1.descripcion="Laptop";
        prod1.categoria= "Electronica";
        prod1.estado= "Nuevo";
        prod1.precio= 1200.5f;
        Producto prod2 = new Producto();
        prod2.codigo = 2;
        prod2.descripcion = "Mouse";
        prod2.categoria = "Accesorio";
        prod2.estado = "Nuevo";
        prod2.precio = 25.0f;
        Producto prod3 = new Producto();
        prod3.codigo = 3;
        prod3.descripcion = "Silla";
        prod3.categoria = "Muebles";
        prod3.estado = "Usado";
        prod3.precio = 100.0f;

        productos.add(prod1);
        productos.add(prod2);
        productos.add(prod3);

        // Clientes
        Cliente cli1 = new Cliente();
        cli1.correo = "juan@mail.com";
        cli1.clave = "1234";
        cli1.apellido = "Pérez";
        cli1.nombre = "Juan";

        Cliente cli2 = new Cliente();
        cli2.correo = "ana@mail.com";
        cli2.clave = "5678";
        cli2.apellido = "García";
        cli2.nombre = "Ana";

        Cliente cli3 = new Cliente();
        cli3.correo = "mario@mail.com";
        cli3.clave = "abcd";
        cli3.apellido = "López";
        cli3.nombre = "Mario";

        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        // Empleados
        Empleado emp1 = new Empleado();
        emp1.correo = "emp1@mail.com";
        emp1.clave = "pass1";
        emp1.apellido = "Rodríguez";
        emp1.nombre = "Carlos";

        Empleado emp2 = new Empleado();
        emp2.correo = "emp2@mail.com";
        emp2.clave = "pass2";
        emp2.apellido = "Martínez";
        emp2.nombre = "Lucía";

        Empleado emp3 = new Empleado();
        emp3.correo = "emp3@mail.com";
        emp3.clave = "pass3";
        emp3.apellido = "Gómez";
        emp3.nombre = "Pedro";

        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);

        // Encargados
        Encargado en1 = new Encargado();
        en1.correo = "enc1@mail.com";
        en1.clave = "key1";
        en1.apellido = "Sánchez";
        en1.nombre = "Laura";

        Encargado en2 = new Encargado();
        en2.correo = "enc2@mail.com";
        en2.clave = "key2";
        en2.apellido = "Fernández";
        en2.nombre = "José";

        Encargado en3 = new Encargado();
        en3.correo = "enc3@mail.com";
        en3.clave = "key3";
        en3.apellido = "Ruiz";
        en3.nombre = "Marta";

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

       /* Producto p = new Producto();
        p.asignarCodigo(1);
        p.asignarDescripcion("Pizza");
        System.out.println(p);*/
        
        
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
