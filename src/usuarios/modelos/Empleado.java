/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */

public class Empleado extends Usuario{
    
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
  }
    //metodos
    @Override
    public ArrayList<Pedido> verPedidos(){
        return GestorPedidos.instanciar().verPedidos();
    }
    //Atributos
    
    @Override
    public String toString() {
        return super.toString();
    }   
}