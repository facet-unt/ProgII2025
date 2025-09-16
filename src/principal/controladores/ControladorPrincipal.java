package principal.controladores;

import Producto.Modelos.Producto;
import java.util.ArrayList;

import usuarios.modelos.Cliente;

import usuarios.modelos.Encargado;



public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto unProducto = new Producto();
        unProducto.codigo = 100;
        unProducto.descripcion = "pizza de roquefort";
        unProducto.estado = "disponible";
        unProducto.categoria = "pizzas";
        unProducto.precio = 25000f;
        unProducto.mostrar();
        
        Producto dosProducto = new Producto();
        dosProducto.codigo = 100;
        dosProducto.descripcion = "milanesa";
        dosProducto.estado = "disponible";
        dosProducto.categoria = "al plato";
        dosProducto.precio = 15000f;
        dosProducto.mostrar();
        
        Producto tresProducto = new Producto();
        tresProducto.codigo = 100;
        tresProducto.descripcion = "empanada";
        tresProducto.estado = "disponible";
        tresProducto.categoria = "entradas";
        tresProducto.precio = 4000f; //agregado del objeto a cada categoria
        tresProducto.mostrar();
        
        ArrayList <Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(unProducto);  //agregado de el objeto al arraylist
        listaDeProductos.add(dosProducto);
        listaDeProductos.add(tresProducto);
        
        for (Producto p : listaDeProductos) {
            p.mostrar();           
        }
        
       
        Cliente unCliente = new Cliente();
        unCliente.correo = "juan.perez@gmail.com"; 
        unCliente.clave = "123345";
        unCliente.nombre = "Juan";
        unCliente.apellido= "Perez";
        
        Cliente dosCliente = new Cliente();
        dosCliente.correo = "alanAre@gmail.com"; 
        dosCliente.clave = "Alancero";
        dosCliente.nombre = "Alan";
        dosCliente.apellido= "Arevalo";
        
        Cliente tresCliente = new Cliente();
        tresCliente.correo = "micaeli1@gmail.com"; 
        tresCliente.clave = "MIcaaellli123";
        tresCliente.nombre = "Micaela";
        tresCliente.apellido= "Eli";
       
        ArrayList <Cliente> listaDeClientes = new ArrayList<>();
        listaDeClientes.add(unCliente);  
        listaDeClientes.add(dosCliente);
        listaDeClientes.add(tresCliente);
        
        for (Cliente Clienten : listaDeClientes) {
            Clienten.mostrar();           
        }
        
        
        Encargado unEncargado = new Encargado();
        unEncargado.correo = "mariaJp@gmail.com";
        unEncargado.clave = "Mar14jp";
        unEncargado.nombre = "Maria";
        unEncargado.apellido = "Jose";
        
       
        Encargado dosEncargado = new Encargado();
        dosEncargado.correo = "JMiguel.carrizo@gmail.com";
        dosEncargado.clave = "JMcarrizo2";
        dosEncargado.nombre = "Miguel";
        dosEncargado.apellido = "Carrizo";
        
        Encargado tresEncargado = new Encargado();
        tresEncargado.correo = "Carbajalmsantino@gmail.com";
        tresEncargado.clave = "Marcarba";
        tresEncargado.nombre = "Santimo Marcos";
        tresEncargado.apellido = "Carbajal";
        
        ArrayList <Encargado> listaDeEncargados = new ArrayList<>();
        listaDeEncargados.add(unEncargado);  
        listaDeEncargados.add(dosEncargado);
        listaDeEncargados.add(tresEncargado);
        
        for (Encargado Encargadosn : listaDeEncargados) {
            Encargadosn.mostrar();           
        }
    }
     
}
