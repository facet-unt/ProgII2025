package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;



public class ControladorPrincipal {
    public static void main(String[] args) {
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

        // === 2) Cargar datos en cada objeto ===
        cliente1.apellido = "Cagna";
        cliente1.nombre = "Pedro";
        cliente1.correo = "pedro@gmail.com";
        cliente1.clave = "123";

        cliente2.apellido = "Toledo";
        cliente2.nombre = "Olivia";
        cliente2.correo = "olivia@gmail.com";
        cliente2.clave = "543";

        cliente3.apellido = "Sanchez";
        cliente3.nombre = "Mariana";
        cliente3.correo = "mariana@mail.com";
        cliente3.clave = "789";

        empleado1.apellido = "Torres";
        empleado1.nombre = "Martin";
        empleado1.correo = "martin@gmail.com";
        empleado1.clave = "a2c";

        empleado2.apellido = "Mendez";
        empleado2.nombre = "Maria";
        empleado2.correo = "maria@gmail.com";
        empleado2.clave = "d3w";

        empleado3.apellido = "Silva";
        empleado3.nombre = "Sofia";
        empleado3.correo = "sofia@gmail.com";
        empleado3.clave = "5y6";

        encargado1.apellido = "Rojas";
        encargado1.nombre = "Lucía";
        encargado1.correo = "lucia@mail.com";
        encargado1.clave = "aaa";

        encargado2.apellido = "Fernandez";
        encargado2.nombre = "Matías";
        encargado2.correo = "matias@gmail.com";
        encargado2.clave = "tgt";

        encargado3.apellido = "Suarez";
        encargado3.nombre = "Claudio";
        encargado3.correo = "claudio@gmail.com";
        encargado3.clave = "7ur";

        producto1.codigo = 101;
        producto1.descripcion = " Milanesa";
        producto1.categoria = " Minutas";
        producto1.estado = " Disponible";
        producto1.precio = 8000.4f;

        producto2.codigo = 102;
        producto2.descripcion = " Pizza";
        producto2.categoria = " Minutas";
        producto2.estado = " Disponible";
        producto2.precio = 6000.0f;

        producto3.codigo = 103;
        producto3.descripcion = " Asado";
        producto3.categoria = " Parrilla";
        producto3.estado = " Disponible";
        producto3.precio = 5000.0f;

        // === 3) Crear listas y agregar los objetos ===
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);

        ArrayList<Encargado> encargados = new ArrayList<>();
        encargados.add(encargado1);
        encargados.add(encargado2);
        encargados.add(encargado3);

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        // === 4) Mostrar todos los objetos ===
        System.out.println("\n--- CLIENTES ---");
        for (Cliente c : clientes) c.mostrar();

        System.out.println("\n--- EMPLEADOS ---");
        for (Empleado e : empleados) e.mostrar();

        System.out.println("\n--- ENCARGADOS ---");
        for (Encargado en : encargados) en.mostrar();

        System.out.println("\n--- PRODUCTOS ---");
        for (Producto p : productos) System.out.println(p);
    } 
}
