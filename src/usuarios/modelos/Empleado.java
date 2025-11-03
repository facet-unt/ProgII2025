/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Esteban
 */

public class Empleado extends Usuario{

    private ArrayList<Pedido> vacio= new ArrayList<>();
    private Perfil perfil;
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre, Perfil perfil) {
        super(correo,clave, apellido, nombre);
        this.perfil = perfil;
    }

    @Override
    public ArrayList<Pedido> verPedido() {
        
        return vacio;
    }
  
    
}

