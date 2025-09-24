package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Estado;
import pedidos.modelos.Pedido;
//import productos.modelos.Categoria;//
//import productos.modelos.Estado;//
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;



public class ControladorPrincipal {

    public static void main(String[] args) {  
        
        //Creacion de ArrayList
        ArrayList<Producto> unProducto = new ArrayList();
        ArrayList<Cliente> unCliente = new ArrayList();
        ArrayList<Empleado> unEmpleado = new ArrayList();
        ArrayList<Encargado> unEncargado = new ArrayList();
        ArrayList<Pedido> listaPedidos = new ArrayList<>(); /* Nuevo arraylist */
        
        //Creacion de cada objeto y asignado de valores //
        System.out.println("PRODUCTOS");
        Producto producto1 = new Producto(0, "Pizza", "Plato principal", "Disponible", 453.23f );
        Producto producto2 = new Producto(1, "Hamburguesa","Plato principal","Disponible", 2332.45f);
        Producto producto3 = new Producto(2, "Tiramisu", "Postre", "Disponible", 2343.65f);
        System.out.println("CLIENTES");
        Cliente cliente1 = new Cliente("rociortteg@gmail.com", "123" , "Ortega", "Rocio");
        Cliente cliente2 = new Cliente("lmensege@gamil.com", "456", "Mensege", "Lyan");
        Cliente cliente3 = new Cliente("lucruiz@gmail.com", "845", "Ruiz", "Lucia");
        System.out.println("EMPLEADOS");
        Empleado empleado1 = new Empleado("sofiarobl@gamil.com", "800", "Robledo", "Sofia"); 
        Empleado empleado2 = new Empleado("sabrina123@gmail.com", "500", "Vega", "Sabrina"); 
        Empleado empleado3 = new Empleado("karengomez@gamil.com", "342", "Gomez", "Karen");
        
        System.out.println("ENCARGADOS");
        Encargado encargado1 = new Encargado("jose34gmail.com", "645", "Brizuela", "Jose"); 
        Encargado encargado2 = new Encargado("guadab@gmail.com", "565", "Aguirre", "Guada"); 
        Encargado encargado3 = new Encargado("lourdes@gmail.com", "233", "Gomez", "Lourdes"); 
         /* Creacion de nuevos objetos de tipo Pedido */
        Pedido pedido1= new Pedido(1, LocalDateTime.now(), Estado.SOLICITADO, cliente1 );
        Pedido pedido2= new Pedido(2, LocalDateTime.now(), Estado.ENTREGADO, cliente2);
        Pedido pedido3=new Pedido(3, LocalDateTime.now(), Estado.PROCESANDO, cliente3);
        
        //Cargado de cada objeto en el arraylist
        
        unProducto.add(producto1);
        unProducto.add(producto2);
        unProducto.add(producto3);   
        
        unCliente.add(cliente1);
        unCliente.add(cliente2);
        unCliente.add(cliente3);
        
        unEmpleado.add(empleado1);
        unEmpleado.add(empleado2);
        unEmpleado.add(empleado3);
        
        unEncargado.add(encargado1);
        unEncargado.add(encargado2);
        unEncargado.add(encargado3);
          /*Se añaden los nuevos objetos al arraylist */
        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);
        
       //Asignando valores a los atributos de algunos objetos con metodos
       /*producto1.asignarCodigo(12);
       producto1.asignarCodigo(312);
       producto1.asignarDescripcion("pizza");
       producto1.asignarEstado("Disponible");
       producto1.asignarCategoria("Plato principal");
    
       cliente1.asignarApellido("Ortega");
       cliente1.asignarClave("11fsaf");
       
       empleado1.asignarApellido("Mensege");
       empleado1.asignarClave("123JK");
       
       encargado2.asignarNombre("Leandro");
       encargado2.asignarCorreo("lmensege@gmail.com");*/ 
       
       //Recorriendo cada Arraylist
       
       for(Producto producto: unProducto)
           producto.mostrar(); //Llamo al metodo mostrar
       
     
       for(Cliente cliente: unCliente)
           cliente.mostrar(); 
      
     
       for(Empleado empleado: unEmpleado)
           empleado.mostrar();
       
     
       for(Encargado encargado: unEncargado)
           encargado.mostrar();    
       
       //Se muestran los nuevos objetos agregados de Pedido //
       
       for(Pedido pedido: listaPedidos)
           pedido.mostrar();
       
       //Uso de to-string con Producto
       
       for(Producto producto: unProducto)
           System.out.println(producto); 
       

    }
}