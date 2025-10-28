/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.ArrayList;

/**
 *
 * @author salut
 */
public class GestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    private GestorPedidos() {
        
    }
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
}
