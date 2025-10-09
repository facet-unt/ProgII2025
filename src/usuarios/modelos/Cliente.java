/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

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
}
