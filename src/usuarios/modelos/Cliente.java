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
public class Cliente extends Usuario{
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    //metodos get/set
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido)
    {
        if (!pedidos.contains(pedido))
        pedidos.add(pedido);
        else{
                pedidos.remove(pedido);
                pedidos.add(pedido);
        }
    }
    public void cancelarPedido(Pedido pedido)
    {
        if (pedidos.contains(pedido))
        pedidos.remove(pedido);
    }
    public void asignarPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }   

    
    
}
