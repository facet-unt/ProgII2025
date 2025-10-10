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
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {
    private ArrayList<Pedido> listaPedidos;
    
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo,clave,apellido,nombre);
        this.listaPedidos = new ArrayList<>();
    }
    public ArrayList<Pedido> verListaPedidos() {
        return this.listaPedidos;
    }
    
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        return this.listaPedidos;
    }

    public void asignarPedido(Pedido p) {
        this.listaPedidos.add(p);
    }
    
    public void agregarPedido(Pedido unpedido){
        int i = this.listaPedidos.indexOf(unpedido);
        
        if (!this.listaPedidos.contains(unpedido))
            this.listaPedidos.add(unpedido);
        else
            this.listaPedidos.set(i, unpedido);
    }
    
    public void cancelarPedido(Pedido unpedido){
        this.listaPedidos.remove(unpedido);
    }
}  
    
   
