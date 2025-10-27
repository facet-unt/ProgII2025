/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
<<<<<<< HEAD

/**
 *
 * @author Esteban
 */

public class Empleado extends Usuario{

    private ArrayList<Pedido> vacio= new ArrayList<>();
    //constructor
=======


public class Empleado extends Usuario {
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17

    /*Constructor*/
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
<<<<<<< HEAD
        super(correo,clave, apellido, nombre);
    }

    @Override
    public ArrayList<Pedido> verPedido() {
        
        return vacio;
    }
    
=======
        super(correo, clave, apellido, nombre);
    }
    
    
    @Override
      public ArrayList<Pedido> verPedidos()
    {
       return new ArrayList<>(); /*Devuelve un arraylist vacio*/
    }
          
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    
}

