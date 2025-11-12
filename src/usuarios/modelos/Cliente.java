/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;



/**
 *
 * @author
 */
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {


   private ArrayList<Pedido> pedidos; /*implementacion de asociacion con clase pedido*/
   private GestorPedidos gp = GestorPedidos.instanciar();
   
    
   /*Constructor*/
   
   public Cliente(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        super(correo, apellido, nombre, perfil, clave, claveRepetida);
        this.pedidos = new ArrayList<>();
    }
   
    
    

    public String toString(){

        return verApellido() + ", " + verNombre();
    }      
    
// 
//   @Override /*Redifinicion del metodo verPedidos. Devuelve los pedidos del cliente*/
//    public ArrayList<Pedido> verPedidos()
//    {
//        return this.pedidos;
//    }
//   
     
    /*Agrega pedidos, al conjunto de pedidos de un cliente.*/
    public void agregarPedido(Pedido unPedido)
    {
        if(!pedidos.contains(unPedido)) /*Si no existe el pedido. Lo añade */
        {
           pedidos.add(unPedido);
        } else /*Si ya existe lo reemplaza.*/
        {
           int indice = pedidos.indexOf(unPedido); /* Obtiene el indice(posicion) del pedido que esta en el ArrayList  pedidos */
           pedidos.set(indice, unPedido); /* Reemplaza el pedido viejo por el nuevo pedido en esa misma posicion */
        }
    }

    public void cancelarPedido(Pedido unPedido)
    {
        pedidos.remove(unPedido); /*Metodo para remover un pedido*/
    }
}
