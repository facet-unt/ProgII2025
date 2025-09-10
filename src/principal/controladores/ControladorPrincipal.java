package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;


public class ControladorPrincipal {
    public static void main(String[] args) {
        
        ArrayList<Cliente> clientes=new ArrayList<>();
        ArrayList<Empleado> empleados=new ArrayList<>();
        ArrayList<Encargado> encargados=new ArrayList<>();
        ArrayList<Producto> productos=new ArrayList<>();
        
        //-----------CLIENTES-------------//
        
        Cliente unCliente1= new Cliente();
        Cliente unCliente2= new Cliente();
        Cliente unCliente3= new Cliente();
        
       unCliente1.correo="juanpablo@gmail.com";
       unCliente1.clave="23l12p";
       unCliente1.apellido="Juarez";
       unCliente1.nombre="Pablo";
       
       unCliente2.correo="juliamartinez@gmail.com";
       unCliente2.clave="456lpqw";
       unCliente2.apellido="Martinez";
       unCliente2.nombre="Laura";
       
       unCliente3.correo="pedromontes@gmail.com";
       unCliente3.clave="56yd9qs";
       unCliente3.apellido="Montes";
       unCliente3.nombre="Pedro";
       
       //-------------EMPLEADOS------------//
       Empleado unEmpleado1=new Empleado();
       Empleado unEmpleado2=new Empleado();
       Empleado unEmpleado3=new Empleado();
       
       unEmpleado1.correo="diazlucas@gmail.com";
       unEmpleado1.clave="lsr312";
       unEmpleado1.apellido="Diaz";
       unEmpleado1.nombre="Lucas";
       
       unEmpleado2.correo="juanatoledo@gmail.com";
       unEmpleado2.clave="geo9812";
       unEmpleado2.apellido="Toledo";
       unEmpleado2.nombre="Juana";
       
       unEmpleado3.correo="bautistasoria@gmail.com";
       unEmpleado3.clave="12qwe23";
       unEmpleado3.apellido="Soria";
       unEmpleado3.nombre="Bautista"; 
       
        //-------------ENCARGADOS------------//
        
       Encargado unEncargado1=new Encargado();
       Encargado unEncargado2=new Encargado();
       Encargado unEncargado3=new Encargado();
       
       unEncargado1.correo="pamegarcia@gmail.com";
       unEncargado1.clave="lasdk12";
       unEncargado1.apellido="Garcia";
       unEncargado1.nombre="Pamela";
       
       unEncargado2.correo="tomasisamendi@gmail.com";
       unEncargado2.clave="bns4566";
       unEncargado2.apellido="Isamendi";
       unEncargado2.nombre="Tomas";
        
       unEncargado3.correo="sofiadicaro@gmail.com";
       unEncargado3.clave="45qaxsd";
       unEncargado3.apellido="Di Caro";
       unEncargado3.nombre="Sofia";
       
       //-------------PRODUCTOS------------//
       
        Producto unProducto1 = new Producto();
        Producto unProducto2= new Producto();
        Producto unProducto3= new Producto();
        
        unProducto1.codigo=123;
        unProducto1.descripcion= "pizza";
        unProducto1.categoria= "comida";
        unProducto1.estado= "entregado";
        unProducto1.precio= 567.78f;
        
        unProducto2.codigo=456;
        unProducto2.descripcion= "empanada";
        unProducto2.categoria= "comida";
        unProducto2.estado= "disponible";
        unProducto2.precio= 893.21f;
        
        
        unProducto3.codigo=768;
        unProducto3.descripcion= "gaseosa";
        unProducto3.categoria= "bebida";
        unProducto3.estado= "disponible";
        unProducto3.precio= 400.00f;
        
        //agregar a las listas
        clientes.add(unCliente1);
        clientes.add(unCliente2);
        clientes.add(unCliente3);
        empleados.add(unEmpleado1);
        empleados.add(unEmpleado2);
        empleados.add(unEmpleado3);

        encargados.add(unEncargado1);
        encargados.add(unEncargado2);
        encargados.add(unEncargado3);

        productos.add(unProducto1);
        productos.add(unProducto2);
        productos.add(unProducto3);
        
       
      System.out.println("---------CLIENTES--------");
      for (Cliente elCliente: clientes ){
          elCliente.mostrar();
      }
      System.out.println( );
      
      System.out.println("---------EMPLEADOS--------");
      for (Empleado elEmpleado: empleados ){
         elEmpleado.mostrar();
      }
      System.out.println( );
      
      System.out.println("---------ENCARGADOS--------");
      for (Encargado  elEncargado: encargados ){
          elEncargado.mostrar();
      }
      System.out.println( );
      
      System.out.println("---------PRODUCTOS--------");
      for(Producto elProducto: productos){
         //elProducto.mostrar();
         System.out.println(elProducto);
      }
      System.out.println( );
      

    }
}
