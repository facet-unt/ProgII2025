/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String c, String cl, String a, String n) {
        super(c, cl, a, n);

    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }

    public void agregarPedido(Pedido p) {
        if (!pedidos.contains(p)) {
            pedidos.add(p);
        } else {
            int indice = pedidos.indexOf(p);
            pedidos.set(indice, p);
        }

    }

    public void cancelarPedido(Pedido pedido) {
        pedidos.remove(pedido);

    }

    /**
     *
     */
    @Override
    public void mostrar() {
        super.mostrar();
        for (Pedido p : pedidos) {
            System.out.println("pedido numero:" + p.obtenerNumero());
            p.mostrar();
            System.out.println("========================");

        }
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + verCorreo() + ", clave=" + verClave() + ", apellido=" + verApellido() + ", nombre=" + verNombre() + '}';
    }

}
