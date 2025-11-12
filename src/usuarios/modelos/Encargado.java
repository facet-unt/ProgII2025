/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */

public class Encargado extends Usuario{
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);
    }
    
 
    @Override
    public List<Pedido> verPedido() {
        throw new UnsupportedOperationException("Un Encargado no puede hacer un pedido"); 
    }
    
}
