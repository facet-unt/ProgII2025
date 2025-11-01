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

public class Empleado extends Usuario{

    private ArrayList<Pedido> vacio= new ArrayList<>();
    //constructor

    public Empleado(String correo, String apellido, String nombre,Perfil perfil ,String clave,String claveRepetida) {
        //super(correo,clave, apellido, nombre);
        super(correo,apellido,nombre,perfil,clave,claveRepetida);
    }

    @Override
    public ArrayList<Pedido> verPedido() {
        
        return vacio;
    }
    
    
}

