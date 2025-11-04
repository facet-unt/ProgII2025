/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.GestorPedidos;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */

public class Encargado extends Usuario{
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo,clave, apellido, nombre, perfil);
    }
    
   @Override
    public ArrayList<Pedido> verPedidos() {
        GestorPedidos i = GestorPedidos.instanciar();
        return i.verPedidos();
    }
    
}
