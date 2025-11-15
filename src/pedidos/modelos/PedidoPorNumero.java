/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.Comparator;

/**
 *
 * @author NEW GAME
 */
public class PedidoPorNumero implements Comparator<Pedido> {
  
    @Override
    public int compare(Pedido p1, Pedido p2) {
        return Integer.compare(p1.verNumero(), p2.verNumero());
    }    
}
