
package usuarios.modelos;

import java.util.List;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

//se hace clase abstracta por sugerencia de netbeans
public class Cliente extends Usuario{
    
    
    // Nuevo atributo para guardar pedidos
    private ArrayList<Pedido> pedidos= new ArrayList<>();
    
    

    public Cliente (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, nombre, apellido);
        this.pedidos = new ArrayList<>();  
    }
    
    // Método para agregar un pedido al cliente
    public void agregarPedido(Pedido pedido) {
    if (pedido != null && !pedidos.contains(pedido)) {
        pedidos.add(pedido);
    }
}

    
    @Override
    public void mostrar(){
        System.out.println ("Mail: " + verCorreo());
        System.out.println ("Nombre: " + verNombre());
        System.out.println ("Apellido: " + verApellido()); 
        System.out.println ("Clave: " + verClave());
    }

    @Override
    public String toString() {
        return super.toString() + "pedidos" + pedidos.size(); 
    }
    
    
    //redefino el metodo verPedidos();
    @Override
     public ArrayList<Pedido> verPedidos() {
        return(pedidos);
    }

    public void cancelarPedido(Pedido unPedido) {
        if(pedidos.contains(unPedido)&&unPedido!=null)
        this.pedidos.remove(unPedido);
    }
}


