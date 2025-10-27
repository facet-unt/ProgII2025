/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import pedidos.modelos.Pedido;


>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17

/**
 *
 * @author
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

<<<<<<< HEAD
public class Cliente extends Usuario{
    private ArrayList<Pedido> pedidos= new ArrayList<>();

    
    public void mostrar() {
      super.mostrar();
      for (Pedido p: pedidos)
            System.out.println(p.verNumero());
  
    }

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo,clave, apellido, nombre);


    }
    
    //metodos get/set
    


    public void agregarPedido(Pedido unPedido) {
        this.pedidos.add(unPedido);
    }
    public void cancelarPedido(Pedido unPedido) {
        if(pedidos.contains(unPedido)&&unPedido!=null)
        this.pedidos.remove(unPedido);
=======
public class Cliente extends Usuario {


   private ArrayList<Pedido> pedidos; /*implementacion de asociacion con clase pedido*/
    
   /*Constructor*/
   
   public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }
   
    
    

    public String toString(){

        return verApellido() + ", " + verNombre();
    }      
    
 
   @Override /*Redifinicion del metodo verPedidos. Devuelve los pedidos del cliente*/
    public ArrayList<Pedido> verPedidos()
    {
        return this.pedidos;
    }
   
    /*Agrega pedidos, al conjunto de pedidos de un cliente.*/
    public void agregarPedido(Pedido unPedido)
    {
        if(!pedidos.contains(unPedido)) /*Si no existe el pedido. Lo añade */
        {
           pedidos.add(unPedido);
        } else /*Si ya existe lo reemplaza.*/
        {
           int indice = pedidos.indexOf(unPedido); /* Obtiene el indice(posicion) del pedido que esta en el ArrayList  pedidos */
           pedidos.set(indice, unPedido); /* Reemplaza el pedido viejo por el nuevo pedido en esa misma posicion */
        }
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    }
   

<<<<<<< HEAD
    @Override
    public ArrayList<Pedido> verPedido() {
        return(pedidos);
    }

    
    
    
    
} 
=======
    public void cancelarPedido(Pedido unPedido)
    {
        pedidos.remove(unPedido); /*Metodo para remover un pedido*/
    }
}
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
