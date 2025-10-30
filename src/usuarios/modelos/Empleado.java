package usuarios.modelos;

import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.GestorPedidos;

public class Empleado extends Usuario {

    public Empleado (String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    @Override
    public List<Pedido> verPedidos() {
        return GestorPedidos.instanciar().verPedidos();
    }
}