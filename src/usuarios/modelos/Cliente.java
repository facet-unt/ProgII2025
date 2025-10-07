/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario{
    private ArrayList<Pedido> listaPedidos= new ArrayList<>();

    
    public void mostrar() {
      super.mostrar();
      for (Pedido p: listaPedidos)
            System.out.println(p.verNumero());
    }

   
    
    //Metodos
 

    
    //constructor


    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);
        this.listaPedidos = new ArrayList<>();

    }
    
    //metodos get/set

    public ArrayList<Pedido> verListaPedidos() {
        return listaPedidos;
    }

    public void asignarListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    
    
    
    
    
} 
