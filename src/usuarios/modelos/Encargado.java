
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

public class Encargado extends Usuario {
    //Metodos
    @Override
    public void mostrar(){
        System.out.println("Encargado: " + verApellido() + " " + verNombre());
    }

    @Override
    public String toString() {
        return "Encargado{" + "correo=" + verCorreo() + ", clave=" + verClave() + ", apellido=" + verApellido() + ", nombre=" + verNombre() + '}';
    }
    
    //constructor

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        GestorPedidos gestor = GestorPedidos.instanciar();
        return gestor.verPedidos();
    }
}
