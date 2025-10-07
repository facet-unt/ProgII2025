/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;



/**
 *
 * @author Esteban
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {


   private ArrayList<Pedido> pedidos; /*implementacion de asociacion con clase pedido*/
    
   /*Constructor*/
   
   public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
   
    public void mostrar() {
      System.out.println("=================");
      System.out.println("Correo:" +  verCorreo());
      System.out.println("Clave:" + verClave());
      System.out.println("Apellido:"+ verApellido());
      System.out.println("Nombre:" + verNombre());      
    }
    
    @Override
    public String toString(){

        return "{" + "Apellido=" + verApellido() + ", Nombre=" + verNombre() + '}';
    }      
}
