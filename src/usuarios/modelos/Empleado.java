/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;


public class Empleado extends Usuario {

    private GestorPedidos gp = GestorPedidos.instanciar();
    /*Constructor*/
    
    public Empleado(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        super(correo, apellido, nombre, perfil, clave, claveRepetida);
    }
    
    
//    @Override
//      public ArrayList<Pedido> verPedidos()
//    {
//       return new ArrayList<>(); /*Devuelve un arraylist vacio*/
//    }
          
     public ArrayList<Pedido> verPedidos()
    {
       return gp.verPedidos();
    }
}
