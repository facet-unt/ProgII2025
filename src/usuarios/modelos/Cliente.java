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
    
  public ArrayList<Pedido> verPedidos()
  {
      return this.pedidos;
  }
 
    
    
    public void agregarPedido(Pedido pedido) {
        int indice = pedidos.indexOf(pedido); // usa equals de Pedido (por numero)
        if (indice == -1) {
            this.pedidos.add(pedido);
        } else {
            pedidos.set(indice, pedido); // reemplazo
        }
    }
    
    public void cancelarPedido(Pedido pedido)
    {
        pedidos.remove(pedido);
        
    }
    public void mostrar() {
        super.mostrar();

        for (Pedido p : pedidos) {
            System.out.println("pedido numero:" + p.obtenerNumero());
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
