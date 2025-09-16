package principal.controladores;

//importaciones necesarias 
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

public class ControladorPrincipal {
    
    public static void main(String[] args) {
        //Definó ArrayList para cada clase
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Producto>  productos = new ArrayList<>();
        
        // Crear y asignar objetos Cliente
        Cliente c1 = new Cliente(); 
        c1.correo = "Ana@hotmail.com";
        c1.clave = "C";
        c1.apellido = "Perez";
        c1.nombre = "Ana";

        Cliente c2 = new Cliente(); 
        c2.correo = "Luis@hotmail.com";
        c2.clave = "C";
        c2.apellido = "Suarez";
        c2.nombre = "Luis";

        Cliente c3 = new Cliente(); 
        c3.correo = "Marta@gmail.com";
        c3.clave = "C";
        c3.apellido = "Gonzalez";
        c3.nombre = "Marta";
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

        // Crear y asignar objetos Empleado
        Empleado e1 = new Empleado(); 
        e1.correo = "Carlos@gmail.com";
        e1.clave = "E";
        e1.apellido = "Rodriguez";
        e1.nombre = "Carlos";

        Empleado e2 = new Empleado(); 
        e2.correo = "Sofia@hotmail.com";
        e2.clave = "E";
        e2.apellido = "Perez";
        e2.nombre = "Sofia";

        Empleado e3 = new Empleado();  
        e3.correo = "Jorge@hotmail.com";
        e3.clave = "E";
        e3.apellido = "Vera";
        e3.nombre = "Jorge";

        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);

        // Crear y asignar objetos Encargado
        Encargado enc1 = new Encargado(); 
        enc1.correo = "Raul@gmail.com";
        enc1.clave = "D";
        enc1.apellido = "Perez";
        enc1.nombre = "Raul";

        Encargado enc2 = new Encargado();  
        enc2.correo = "Carlos@gmail.com";
        enc2.clave = "D";
        enc2.apellido = "Perez";
        enc2.nombre = "Carlos";

        Encargado enc3 = new Encargado();  
        enc3.correo = "Alvaro@gmail.com";
        enc3.clave = "D";
        enc3.apellido = "Guzman";
        enc3.nombre = "Alvaro";

        encargados.add(enc1);
        encargados.add(enc2);
        encargados.add(enc3);

        // Crear y asignar objetos Producto
        Producto p1 = new Producto();
        p1.codigo = 1;
        p1.descripcion = "Sandwich";
        p1.categoria = "Hamburguesa";
        p1.estado = "Disponible";
        p1.precio = 13000.0f;

        Producto p2 = new Producto();
        p2.codigo = 3;
        p2.descripcion = "Sandwich";
        p2.categoria = "Milanesa";
        p2.estado = "Disponible";
        p2.precio = 10000.0f;

        Producto p3 = new Producto();
        p3.codigo = 5;
        p3.descripcion = "Sandwich";
        p3.categoria = "Lomito";
        p3.estado = "Disponible";
        p3.precio = 15000.0f;

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);

        // Mostrar clientes
        System.out.println("Clientes:");
        for (Cliente c : clientes) {
            System.out.println("Correo: " + c.correo + ", Clave: " + c.clave + ", Apellido: " + c.apellido + ", Nombre: " + c.nombre);
        }
        System.out.println();

        // Mostrar empleados
        System.out.println("Empleados:");
        for (Empleado e : empleados) {
            System.out.println("Correo: " + e.correo + ", Clave: " + e.clave + ", Apellido: " + e.apellido + ", Nombre: " + e.nombre);
        }
        System.out.println();

        // Mostrar encargados
        System.out.println("Encargados:");
        for (Encargado enc : encargados) {
            System.out.println("Correo: " + enc.correo + ", Clave: " + enc.clave + ", Apellido: " + enc.apellido + ", Nombre: " + enc.nombre);
        }
        System.out.println();

        // Mostrar productos
        System.out.println("Productos:");
        for (Producto p : productos) {
            System.out.println("Codigo: " + p.codigo + ", Descripcion: " + p.descripcion + ", Categoria: " + p.categoria + ", Estado: " + p.estado + ", Precio: $" + p.precio);
        }
        System.out.println();

        // --- Modificaciones a algunos objetos ---

        // Cliente c1 cambia su correo
        c1.correo = "ana.nuevo@hotmail.com";

        // Empleado e2 cambia su apellido
        e2.apellido = "Ramirez";

        // Encargado enc1 cambia su nombre
        enc1.nombre = "Raúl Modificado";

        // Producto p3 cambia su estado
        p3.estado = "No disponible";

        // Mostrar clientes modificados
        System.out.println("Clientes modificados:");
        for (Cliente c : clientes) {
            System.out.println("Correo: " + c.correo + ", Clave: " + c.clave + ", Apellido: " + c.apellido + ", Nombre: " + c.nombre);
        }
        System.out.println();

        // Mostrar empleados modificados
        System.out.println("Empleados modificados:");
        for (Empleado e : empleados) {
            System.out.println("Correo: " + e.correo + ", Clave: " + e.clave + ", Apellido: " + e.apellido + ", Nombre: " + e.nombre);
        }
        System.out.println();

        // Mostrar encargados modificados
        System.out.println("Encargados modificados:");
        for (Encargado enc : encargados) {
            System.out.println("Correo: " + enc.correo + ", Clave: " + enc.clave + ", Apellido: " + enc.apellido + ", Nombre: " + enc.nombre);
        }
        System.out.println();

        // Mostrar productos modificados
        System.out.println("Productos modificados:");
        for (Producto p : productos) {
            System.out.println("Codigo: " + p.codigo + ", Descripcion: " + p.descripcion + ", Categoria: " + p.categoria + ", Estado: " + p.estado + ", Precio: $" + p.precio);
        }
        System.out.println();
    }
}
