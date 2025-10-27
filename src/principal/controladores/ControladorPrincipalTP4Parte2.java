package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Usuario;

public class ControladorPrincipalTP4Parte2 {

    public static void main(String[] args) {
        /*
            ***************************************************
            INICIO Segunda parte - herencia
            ***************************************************
         */

        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");
        Usuario unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");
        Usuario unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        Usuario unCliente4 = new Cliente("cliente3@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4");
        //unCliente4 repetido con unCliente3

        if (!usuarios.contains(unCliente1)) {
            usuarios.add(unCliente1);
        }
        /*
            *************************************************
            AGREGAR aqui las sentencias para agregar los clientes a la lista de
            usuarios verificando que NO se repitan
            *************************************************
         */

        if (!usuarios.contains(unCliente2)) {
            usuarios.add(unCliente2);
        }
        if (!usuarios.contains(unCliente3)) {
            usuarios.add(unCliente3);
        }
        if (!usuarios.contains(unCliente4)) {
            usuarios.add(unCliente4);
        }

        Usuario unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");
        Usuario unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");
        Usuario unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
        Usuario unEmpleado4 = new Empleado("empleado3@bar.com", "claveEmpleado4", "ApellidoEmpleado4", "NombreEmpleado4");
        //empleado repetido

        /*
            *************************************************
            AGREGAR aqui las sentencias para agregar los empleados a la lista de
            usuarios verificando que NO se repitan
            *************************************************
         */
        if (!usuarios.contains(unEmpleado1)) {
            usuarios.add(unEmpleado1);
        }
        if (!usuarios.contains(unEmpleado2)) {
            usuarios.add(unEmpleado2);
        }
        if (!usuarios.contains(unEmpleado3)) {
            usuarios.add(unEmpleado3);
        }
        if (!usuarios.contains(unEmpleado4)) {
            usuarios.add(unEmpleado4);
        }

        System.out.println("Clientes");
        System.out.println("=========");

        /*
            *************************************************
            AGREGAR aqui las sentencias para mostrar UNICAMENTE los
            Usuarios de la lista que son Clientes
            *************************************************
         */
        for (Usuario unUsuario : usuarios) {
            if (unUsuario instanceof Cliente) {
                unUsuario.mostrar();
            }
        }

        System.out.println();
        System.out.println("Empleados");
        System.out.println("=========");

        /*
            *************************************************
            AGREGAR aqui las sentencias para mostrar UNICAMENTE los
            Usuarios de la lista que son empleados
            *************************************************
         */
        for (Usuario unUsuario : usuarios) {
            if (unUsuario instanceof Empleado) {
                unUsuario.mostrar();
            }
        }
        
        
        Usuario unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Usuario unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Usuario unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        Usuario unEncargado4 = new Encargado("encargado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        //encargado repetido

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        * AGREGAR aqui las sentencias para agregar los encargados a la lista de usuarios verificando que NO se repitan
        * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
        
        if (!usuarios.contains(unEncargado1)) {
            usuarios.add(unEncargado1);
        }
        if (!usuarios.contains(unEncargado2)) {
            usuarios.add(unEncargado2);
        }
        if (!usuarios.contains(unEncargado3)) {
            usuarios.add(unEncargado3);
        }
        if (!usuarios.contains(unEncargado4)) {
            usuarios.add(unEncargado4);
        }
        
        
        
                 System.out.println();
        System.out.println("Encargados");
        System.out.println("==========");

        /*
            *************************************************
            AGREGAR aqui las sentencias para mostrar UNICAMENTE los
            Usuarios de la lista que son encargados
            *************************************************
         */
        for (Usuario unUsuario : usuarios) {
            if (unUsuario instanceof Encargado) {
                unUsuario.mostrar();
            }
        }
        
        
        Usuario unEncargado5 = new Encargado("cliente1@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        if (!usuarios.contains(unEncargado5)) {
            usuarios.add(unEncargado5);
        }
        //mismo correo que un cliente, no debe agregarse

        Usuario unCliente5 = new Encargado("empleado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        if (!usuarios.contains(unCliente5)) {
            usuarios.add(unCliente5);
        }
        //mismo correo que un empleado, no debe agregarse

        System.out.println();
        System.out.println("Todos");
        System.out.println("=====");
        for (Usuario u : usuarios) {
            u.mostrar();
            System.out.println();
        }
        System.out.println();

        /*
            *************************************************
            FIN Segunda parte - herencia
            ***************************************************
         */
    }
}
