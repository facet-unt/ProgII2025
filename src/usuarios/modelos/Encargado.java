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

public class Encargado extends Usuario{
     //metodos
    @Override
    public ArrayList<Pedido> verPedidos(){
        return null;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
}
