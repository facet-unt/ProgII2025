package usuarios.modelos;

import pedidos.modelos.Pedido;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    // Atributo específico de Cliente
    private List<Pedido> pedidos;

    // Constructor
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }

    // Método para agregar un pedido
    public void agregarPedido(Pedido pedido) {
        if (pedido != null && !pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
    }

    // Getter de pedidos
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    // Método para cancelar un pedido
    public void cancelarPedido(Pedido unPedido) {
        if (unPedido != null && pedidos.contains(unPedido)) {
            pedidos.remove(unPedido);
        }
    }

    // Método mostrar sobrescrito
    @Override
    public void mostrar() {
        System.out.println("Mail: " + verCorreo());
        System.out.println("Nombre: " + verNombre());
        System.out.println("Apellido: " + verApellido()); 
        System.out.println("Clave: " + verClave());
    }

    // Puedes implementar este método si realmente lo necesitas
    @Override
    public ArrayList<Pedido> verPedidos() {
        // Si quieres devolver una copia segura como ArrayList:
        return new ArrayList<>(pedidos);
    }
}
