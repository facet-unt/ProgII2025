package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

public class ControladorPrincipal {
    public static void main(String[] args) {
        
        ArrayList<Cliente> clientesArray=new ArrayList();
        ArrayList<Empleado> empleadosArray=new ArrayList();
        ArrayList<Encargado> encargadosArray=new ArrayList();
        ArrayList<Producto> productosArray=new ArrayList();
        
        Producto pizza = new Producto();
        Producto burger = new Producto();
        Producto sanguche = new Producto();
        
        pizza.precio=12000f;
        pizza.categoria="Con lactosa";
        pizza.codigo=123;
        pizza.estado="Disponible";
        pizza.descripcion="Pizza";
        
        burger.precio=10000f;
        burger.categoria="No apto para cardiacos";
        burger.codigo=124;
        burger.estado="Disponible";
        burger.descripcion="Hamburgesa";
        
        sanguche.precio=8000f;
        sanguche.categoria="Balanceado";
        sanguche.codigo=125;
        sanguche.estado="Disponible";
        sanguche.descripcion="Sanguche de milanesa";
                
        productosArray.add(pizza);
        productosArray.add(burger);
        productosArray.add(sanguche);
        
        Cliente clienteUno=new Cliente();
        Cliente clienteDos=new Cliente();
        Cliente clienteTres=new Cliente();
        
        clientesArray.add(clienteUno);
        clientesArray.add(clienteDos);
        clientesArray.add(clienteTres);
        
        Empleado empleadoUno=new Empleado();
        Empleado empleadoDos=new Empleado();
        Empleado empleadoTres=new Empleado();
        
        empleadosArray.add(empleadoUno);
        empleadosArray.add(empleadoDos);
        empleadosArray.add(empleadoTres);
        
        Encargado encargadoUno=new Encargado();
        Encargado encargadoDos=new Encargado();
        Encargado encargadoTres=new Encargado();
        
        encargadosArray.add(encargadoUno);
        encargadosArray.add(encargadoDos);
        encargadosArray.add(encargadoTres);
        
        for(Producto obj: productosArray){
            System.out.println(obj.toString());
        }
        
        for(Cliente obj: clientesArray){
            obj.mostrar();
        }
        
        for(Empleado obj: empleadosArray){
            obj.mostrar();
        }
        
        for(Encargado obj: encargadosArray){
            obj.mostrar();
        }
        
    }
}
