
package usuarios.modelos;

import java.util.List;
import java.util.ArrayList;
import pedidos.modelos.Pedido;   


public class Cliente {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;

    // Nuevo atributo para guardar pedidos
    private List<Pedido> pedidos;

    public Cliente (String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();  
    }
    
    // Método para agregar un pedido al cliente
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    
    public void mostrar(){
        
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

    // Get y set
    public String verCorreo() {
        return correo;
    }
   
    
    //esto se llama get, es para otener al objeto
    
    public void asignarCorreo (String Correo) {
        if (Correo != null && !Correo.isBlank())
            correo = Correo;
    }
    
    public String verClave() {
        return clave;
    }
    
    public void asignarClave(String Clave) {
        if (Clave != null && !Clave.isBlank())
            clave = Clave;
    }
    
    public String verNombre() {
        return nombre;
    }
    
    public void asignarNombre(String Nombre) {
        if (Nombre != null && !Nombre.isBlank())
            nombre = Nombre;
    }
    
    public String verApellido() {
        return apellido;
    }
    
    public void asignarApellido(String Apellido) {
        if (Apellido != null && !Apellido.isBlank())
            apellido = Apellido;
    }
}


