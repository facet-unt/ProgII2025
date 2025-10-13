package usuarios.modelos;

import pedidos.modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    // Atributo específico de Cliente
    private List<Pedido> pedidos;

    // Constructor: usa super() para inicializar atributos heredados
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }

    // Métodos específicos
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    
    @Override
    public String toString() {
        return "Cliente{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pedidos=" + pedidos.size() +
                '}';
    }

    // Opcional: puedes sobrescribir mostrar() o usar el heredado de Usuario
    // public void mostrar() {
    //     System.out.println(this.toString());
    // }
}
