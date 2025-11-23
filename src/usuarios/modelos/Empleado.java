/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;


public class Empleado extends Usuario{

    private ArrayList<Pedido> vacio= new ArrayList<>();
    
    /* Constructor */
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);
    }

    @Override /* Metodo redefinido devuelve ArrayList vacio TP4 */
    public List<Pedido> verPedido() {
        
        return vacio;
    }
    
    
}

