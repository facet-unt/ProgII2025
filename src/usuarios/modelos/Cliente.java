/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Esteban
 */
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    //Constructor
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre,Perfil.CLIENTE);
    }

    public void agregarPedido(Pedido unPedido) {
        this.pedidos.add(unPedido);
    }

    public void cancelarPedido(Pedido unPedido) {
        if (pedidos.contains(unPedido) && unPedido != null) {
            this.pedidos.remove(unPedido);
        }
    }

    @Override
    public void mostrar() {
        super.mostrar();
        for (Pedido p : pedidos) {
            System.out.println(p.verNumero());
        }

    }

    @Override
    public List<Pedido> verPedidos() {
        return (pedidos);
    }
}
