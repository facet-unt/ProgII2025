package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Encargado extends Usuario {

    private String correo;
    private String nombre;
    private String apellido;

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

   
    @Override
    public String toString() {
        return "Encargado{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
    
    //modificacion del metodo verPedido para que devuelva nada 
     public ArrayList<Pedido> verPedidos() {
        return null;
    }

}
