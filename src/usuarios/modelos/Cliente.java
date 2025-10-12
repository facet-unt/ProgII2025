/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    
    //Metodos
    @Override
    public ArrayList<Pedido> verPedidos(){
        return listaPedidos;
    }
    
    public void agregarPedido(Pedido p) {
        if (!listaPedidos.contains(p)&& p!=null) {
            listaPedidos.add(p);
        }
    } 
    
    public void cancelarPedido(Pedido p){
        if (listaPedidos.contains(p) && p!=null ) {
            listaPedidos.remove(p);
        }
    }

    @Override
    public String toString() {
        return super.toString()+ "pedidos: "+ listaPedidos.size();
    }
    
    //constructores

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }    
}
