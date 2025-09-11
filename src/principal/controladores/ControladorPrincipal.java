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
        Cliente cliente1 = new Cliente();
        Empleado empleado1 = new Empleado();
        Encargado encargado1 = new Encargado();
        
        producto1.codigo=1234;
        producto1.descripcion="Producto1";
        producto1.categoria="A";
        producto1.estado="Disponible";
        producto1.precio=43.5f
;        
        cliente1.correo="correo1@gmail.com";
        cliente1.clave="11111";
        cliente1.apellido="aaa";
        cliente1.nombre="bbb";
        
        empleado1.correo="correo2@gmail.com";
        empleado1.clave="22222";
        empleado1.apellido="ccc";
        empleado1.nombre="ddd";
        
        encargado1.correo="correo3@gmail.com";
        encargado1.clave="33333";
        encargado1.apellido="eee";
        encargado1.nombre="fff";
        
        unCliente.add(cliente1);
        unEmpleado.add(empleado1);
        unEncargado.add(encargado1);
        unProducto.add(producto1);
        
        for (int i=0;i<2;i++){
            for(Cliente cliente: unCliente)
            System.out.println(cliente);
        
            for(Empleado empleado: unEmpleado)
                System.out.println(empleado);
        
            for(Encargado encargado: unEncargado)
                System.out.println(encargado);

            for(Producto producto: unProducto)
                System.out.println(producto);
            
            producto1.codigo=54376;
            producto1.categoria="C";
            producto1.estado="No Disponible";
            producto1.precio=654.5f
    ;        
            cliente1.clave="11211";
            cliente1.apellido="aaaAA";
            cliente1.nombre="bbbB";

            empleado1.correo="correo2@gmail.com";
            empleado1.clave="22322";
            empleado1.apellido="cccCC";
            empleado1.nombre="dddDD";

            encargado1.correo="correo3@gmail.com";
            encargado1.clave="33433";
            encargado1.apellido="eeeEE";
            encargado1.nombre="fffFF";
        }
    }
}
