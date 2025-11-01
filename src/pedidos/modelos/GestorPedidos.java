package pedidos.modelos;

import productos.modelos.Producto;
import usuarios.modelos.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class GestorPedidos {
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";

    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    private static GestorPedidos instanciar_Pedido;

    private GestorPedidos() {
    }

    public static GestorPedidos instanciar(){
        if(instanciar_Pedido == null){
             instanciar_Pedido = new GestorPedidos();
        }
        return instanciar_Pedido;
    }

    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null){
            return ERROR_FECHA;
        }
        if(hora == null){
            return ERROR_HORA;
        }
        if(productosDelPedido.isEmpty()){
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

    public String cambiarEstado(Pedido pedidoAModificar){
        for(Pedido p: listaPedidos){
            if(p.equals(pedidoAModificar)){
                if(p.verEstado() == Estado.CREADO){
                    p.asignarEstado(Estado.PROCESANDO);
                    return EXITO;
                }
                if(p.verEstado() == Estado.PROCESANDO){
                    p.asignarEstado(Estado.ENTREGADO);
                    return EXITO;
                }
            }
        }
        return PEDIDO_INEXISTENTE;
    }

    public ArrayList<Pedido> verPedidos(){
        return this.listaPedidos;
    }

    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: listaPedidos){
            if(p.verUnCliente().equals(cliente)){
                return true;
            }
        }
    return false;
    }

    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: listaPedidos){
            for(ProductoDelPedido producto_buscado: p.verunPedido()){
                if(producto_buscado.verUnProducto().equals(producto)){
                    return true;
                }
            }
        }
    return false;
    }

    public boolean existeEstePedido(Pedido pedido) {
        for(Pedido p: listaPedidos){
            if(p.equals(pedido)){
                return true;
            }
        }
        return false;
    }

    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: listaPedidos){
            if(p.verNumero() == numero){
                return p;
            }
        }
        return null;
    }

}

