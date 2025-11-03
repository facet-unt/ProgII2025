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
 * @author estudiante
 */
public class Empleado extends Usuario {

 GestorPedidos gp = GestorPedidos.instanciar();


    public Empleado(String c, String cl, String a, String n) {
        super(c, cl, a, n);
    }
    
@Override
    public ArrayList<Pedido> verPedidos()
    {
      return gp.verPedidos();
     }
}