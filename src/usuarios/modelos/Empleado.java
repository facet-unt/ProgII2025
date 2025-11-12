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

public class Empleado extends Usuario{

    private ArrayList<Pedido> vacio= new ArrayList<>();
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);
    }

    @Override
    public List<Pedido> verPedido() {
        
        return vacio;
    }
    
    
}

