
package usuarios.modelos;

import java.util.List;
import java.util.ArrayList;
import pedidos.modelos.Pedido;   


public class Cliente extends Usuario{
    
    // Nuevo atributo para guardar pedidos
    private List<Pedido> pedidos;

    public Cliente (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, nombre, apellido);
        this.pedidos = new ArrayList<>();  
    }
    
    // Método para agregar un pedido al cliente
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    @Override
    public void mostrar(){
        
    }

    @Override
    public String toString() {
        return super.toString() + "pedidos" + pedidos.size(); 
    }
    
}


