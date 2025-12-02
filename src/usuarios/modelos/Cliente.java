/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario{
    
    private ArrayList<Pedido> pedidos= new ArrayList<>();

    
    @Override /* Metodo redefinido */
    public void mostrar() {
      super.mostrar();
      for (Pedido p: pedidos)
            System.out.println(p.verNumero());
  
    }
    
    /* Constructor */
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);


    }
    
    /* Metodos agregados TP4  */
    
    public void agregarPedido(Pedido unPedido) {
        if(!pedidos.contains(unPedido))
        {
            this.pedidos.add(unPedido);
        }
        else
        {
            this.pedidos.remove(unPedido);
            this.pedidos.add(unPedido);
        }
    }
    
    public void cancelarPedido(Pedido unPedido) {
        if(pedidos.contains(unPedido)&&unPedido!=null)
        {
            this.pedidos.remove(unPedido);
        }
    }

   
    @Override /*Metodo redefinido */
    public List<Pedido> verPedido() {
        return(pedidos);
    }

    @Override 
    public String verPerfil() {
       return "Cliente";
    }
} 
