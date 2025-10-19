package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

  
    //modificacion del metodo verPedido para que devuelva nada 
     public ArrayList<Pedido> verPedidos() {
        return null;
    }
     
     

}
