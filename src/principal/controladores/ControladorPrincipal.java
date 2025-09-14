package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

public class ControladorPrincipal {

    public static void main(String[] args) {
        Producto p = new Producto();
        p.mostrar();
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        ArrayList<Encargado> listaEncargado = new ArrayList<>();
        ArrayList<Producto> listaProducto = new ArrayList<>();

        //CLIENTE
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();

        cliente1.correo = "arroyoLucas@gmail.com";
        cliente1.clave = "arrolu";
        cliente1.apellido = "Arroyo";
        cliente1.nombre = "Lucas";

        cliente2.correo = "ssyhakarNatanael@gmail.com";
        cliente2.clave = "ssynata";
        cliente2.apellido = "Ssyhakar";
        cliente2.nombre = "Natanael";

        cliente3.correo = "messiLionel@gmail.com";
        cliente3.clave = "mesLi";
        cliente3.apellido = "Messi";
        cliente3.nombre = "Lionel";

        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);
        //EMPLEADO
        Empleado empleado1 = new Empleado();
        Empleado empleado2 = new Empleado();
        Empleado empleado3 = new Empleado();

        empleado1.correo = "empleado1@gmail.com";
        empleado1.clave = "emple1";
        empleado1.apellido = "Clinton";
        empleado1.nombre = "Bill";

        empleado2.correo = "empleado2@gmail.com";
        empleado2.clave = "emple2";
        empleado2.apellido = "Oscar";
        empleado2.nombre = "Barrera";

        empleado3.correo = "empleado3@gmail.com";
        empleado3.clave = "emple3";
        empleado3.apellido = "Fuentes";
        empleado3.nombre = "Armando";

        listaEmpleado.add(empleado1);
        listaEmpleado.add(empleado2);
        listaEmpleado.add(empleado3);

        //ENCARGADO
        Encargado encargado1 = new Encargado();
        Encargado encargado2 = new Encargado();
        Encargado encargado3 = new Encargado();

        encargado1.correo = "encargado1@gmail.com";
        encargado1.clave = "encar1";
        encargado1.apellido = "Valdez";
        encargado1.nombre = "Ana";

        encargado2.correo = "encargado2@gmail.com";
        encargado2.clave = "encar2";
        encargado2.apellido = "Rojas";
        encargado2.nombre = "Luis";

        encargado3.correo = "encargado3@gmail.com";
        encargado3.clave = "encar3";
        encargado3.apellido = "Martinez";
        encargado3.nombre = "Lucas";

        listaEncargado.add(encargado1);
        listaEncargado.add(encargado2);
        listaEncargado.add(encargado3);

        //PRODUCTO
        Producto producto1 = new Producto();
        Producto producto2 = new Producto();
        Producto producto3 = new Producto();

        producto1.codigo = 1234;
        producto1.descripcion = "Pizza";
        producto1.categoria = "Salado";
        producto1.estado = "Disponible";
        producto1.precio = 13000f;

        producto2.codigo = 5678;
        producto2.descripcion = "Torta";
        producto2.categoria = "Dulce";
        producto2.estado = "Disponible";
        producto2.precio = 9000f;

        producto3.codigo = 9123;
        producto3.descripcion = "Empanadas";
        producto3.categoria = "Salado";
        producto3.estado = "Disponible";
        producto3.precio = 300f;

        listaProducto.add(producto1);
        listaProducto.add(producto2);
        listaProducto.add(producto3);

        System.out.println("CLIENTES");
        for (Cliente clientes : listaCliente) {
            clientes.mostrar();
        }
        System.out.println("EMPLEADO");
        for (Empleado empleados : listaEmpleado) {
            empleados.mostrar();
        }
        System.out.println("ENCARGADO");
        for (Encargado encargados : listaEncargado) {
            encargados.mostrar();
        }
        System.out.println("PRODUCTO");
        for (Producto productos : listaProducto) {
            productos.mostrar();
        }
    }
}
