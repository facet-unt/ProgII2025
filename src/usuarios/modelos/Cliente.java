/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario {
    
    private ArrayList<Pedido> pedido;

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    public void mostrar() {
        super.mostrar();
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return this.pedido;
    }

    public void agregarPedido(Pedido pedido) {
        for (int i = 0; i < this.pedido.size() ; i++) {
            if (this.pedido.get(i).equals(pedido)) {
                this.pedido.set(i, pedido);
                return;
            }
        }
        this.pedido.add(pedido);
    }

    public void cancelarPedido(Pedido  pedidoCancelado) {
        this.pedido.remove(pedidoCancelado);
    }
}