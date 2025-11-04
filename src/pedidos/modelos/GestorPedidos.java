package pedidos.modelos;

import interfaces.IGestorPedidos;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestorPedidos implements IGestorPedidos {

   

    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    private static GestorPedidos instanciar_Pedido;

    private GestorPedidos() {
    }

    public static GestorPedidos instanciar() {
        if (instanciar_Pedido == null) {
            instanciar_Pedido = new GestorPedidos();
        }
        return instanciar_Pedido;
    }

    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }

        LocalDateTime fechaYhora = LocalDateTime.of(fecha, hora);

        Estado estado_def = Estado.PROCESANDO;

        int numeroDePedido = listaPedidos.size() + 1;

        Pedido p = new Pedido(numeroDePedido, fechaYhora, estado_def, productosDelPedido, cliente);
        listaPedidos.add(p);

        cliente.agregarPedido(p);

        return EXITO;
    }

    public String cambiarEstado(Pedido pedidoAModificar) {
        for (Pedido p : listaPedidos) {
            if (p.equals(pedidoAModificar)) {
                if (p.verEstado() == Estado.CREADO) {
                    p.asignarEstado(Estado.PROCESANDO);
                    return EXITO;
                }
                if (p.verEstado() == Estado.PROCESANDO) {
                    p.asignarEstado(Estado.ENTREGADO);
                    return EXITO;
                }
            }
        }
        return PEDIDO_INEXISTENTE;
    }

    public ArrayList<Pedido> verPedidos() {
        return this.listaPedidos;
    }

    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido p : listaPedidos) {
            if (p.verUnCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido p : listaPedidos) {
            for (ProductoDelPedido producto_buscado : p.verunPedido()) {
                if (producto_buscado.verUnProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existeEstePedido(Pedido pedido) {
        for (Pedido p : listaPedidos) {
            if (p.equals(pedido)) {
                return true;
            }
        }
        return false;
    }

    public Pedido obtenerPedido(Integer numero) {
        for (Pedido p : listaPedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }
        return null;
    }
   
    
    public String cancelarPedido(Pedido pedido){
        for (Pedido p: listaPedidos){
            if(p.equals(pedido)){
                p.verUnCliente().cancelarPedido(pedido);
            }
        }
    return EXITO2;
    }
}
