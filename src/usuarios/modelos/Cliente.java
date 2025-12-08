/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
/**
 *
 * @author alumno
 */

import pedidos.modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    // Atributo específico de Cliente
    ArrayList <Pedido> pedidos = new ArrayList<>();

    // Constructor
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }

    // Método para agregar un pedido
    public void agregarPedido(Pedido pedido) {
    
        pedidos.add(pedido);
}

    @Override
    public void mostrar(){
        System.out.println("Nombre: " +this.verNombre());
        System.out.println("apellido: " + this.verApellido());
    }

   

    @Override
    public String toString() {
        return super.toString() + "pedidos" + pedidos.size(); 
    }
    
    
    //redefino el metodo verPedidos();
    @Override
     public List<Pedido> verPedidos() {
        return pedidos; //devuelve pedidos por que es el arraylist que declaramos al inicio
     }
     

    // Método para cancelar un pedido
    public void cancelarPedido(Pedido unPedido) {
        if(pedidos.contains(unPedido)&&unPedido!=null)
        this.pedidos.remove(unPedido);
    }
}


