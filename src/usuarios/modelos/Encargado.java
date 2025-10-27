/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Lyan
 */

public class Encargado extends Usuario{
<<<<<<< HEAD
    private ArrayList<Pedido> vacio= new ArrayList<>();
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);
    }
    
   @Override
    public ArrayList<Pedido> verPedido() {
        
        return vacio;
    }
    
}
=======

    /*Constructor*/
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
         

 public ArrayList<Pedido> p = new ArrayList<>();
    
    @Override
      public ArrayList<Pedido> verPedidos()
    {
        return new ArrayList<>(); /*Devuelve un arraylist vacio*/
    }
}    
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
