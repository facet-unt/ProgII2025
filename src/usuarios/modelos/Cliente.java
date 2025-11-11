/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario {
    private List<Pedido> pedidos = new ArrayList<>();
    
    @Override
    public void mostrar(){
        System.out.println("Los datos de este cliente son:");
        super.mostrar();
    }

    @Override
    public List<Pedido> verPedidos(){
        return pedidos;
    }
    
    public void agregarPedido(Pedido unpedido){
        int i = 0;
        if(!pedidos.contains(unpedido)){
            pedidos.add(unpedido);
        }else{
            for(Pedido p: pedidos){
                if(p.equals(unpedido)){
                    p=unpedido;
                    i++;
                }    
            }
        }
        if (i != 0)
            pedidos.add(unpedido);
    }    
    
    public void cancelarPedido(Pedido unpedido){
        if (pedidos.contains(unpedido))
            pedidos.remove(unpedido);
    }

    public Cliente(String correo, String clave, String apellido, String nombre) {
       super(correo, clave, apellido, nombre);
       this.pedidos = new ArrayList<>();
    }
}
