/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;

/**
 *
 * @author lazar
 */
public class Cliente extends Usuario {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    
    public Cliente(String c,String cl,String a,String n){
        super(c,cl,a,n);
    }
    
    public Cliente(String c,String cl,String a,String n,ArrayList<Pedido> listaPedidos){
        super(c,cl,a,n);
        this.listaPedidos=listaPedidos;
    }

    public ArrayList<Pedido> verListaPedidos() {
        return listaPedidos;
    }

    public void asignarListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + this.verCorreo() + ", clave=" + this.verClave() + ", apellido=" + this.verApellido() + ", nombre=" + this.verNombre() + '}';
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return listaPedidos;
    }

    public void agregarPedido(Pedido Pedido){
        for(Pedido p: listaPedidos){
            if(!listaPedidos.contains(p))
                listaPedidos.add(p);
            else
                listaPedidos.set(listaPedidos.indexOf(p), Pedido);
        }
    }
    
    public void cancelarPedido(Pedido Pedido){
        listaPedidos.remove(Pedido);
    }
}
