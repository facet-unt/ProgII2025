/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario{
   
    private ArrayList<Pedido> pedidos;

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos=new ArrayList<>();
    }

    public Cliente(String correo, String clave, String apellido, String nombre, ArrayList<Pedido> pedidos) {
        super(correo, clave, apellido, nombre);
        this.pedidos = pedidos;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido != null && !pedidos.contains(pedido)) {
            pedidos.remove(pedido);
            pedidos.add(pedido);
        }
    }
        
    public void mostrarPedidos() {
        System.out.println("-- PEDIDOS DEL CLIENTE " + verApellido() + ", " + verNombre() + " --");
        for (Pedido p : pedidos) {
            p.mostrar();
            System.out.println();
        }
    }
    
    public void cancelarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    @Override
    public List<Pedido> verPedidos(){
        return pedidos;
    }
}