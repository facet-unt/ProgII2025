package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class GestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con exito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";

    private GestorPedidos() {
        
    }
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null){
            return ERROR_FECHA;
        }
        if(hora == null){
            return ERROR_HORA;
        }
        if(productosDelPedido == null || productosDelPedido.isEmpty()){
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if(cliente == null){
            return ERROR_CLIENTE;
        }
        
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        
        int numero = pedidos.size() + 1;
        
        Pedido nuevoPedido = new Pedido(numero, fechaYHora, productosDelPedido, cliente);
        
        if(this.existeEstePedido(nuevoPedido)){
            return PEDIDOS_DUPLICADOS;
        }
        
        pedidos.add(nuevoPedido);
        cliente.agregarPedido(nuevoPedido);
        return EXITO;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar == null){
            return PEDIDO_INEXISTENTE;
        }
        
        if(pedidoAModificar.verEstado() == Estado.CREADO){
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            return EXITO;
        }
        if(pedidoAModificar.verEstado() == Estado.PROCESANDO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            return EXITO;
        }
        
        return ERROR_ESTADO;
    }
    
    public ArrayList<Pedido> verPedidos(){
        return this.pedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : pedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p : pedidos){
            for(ProductoDelPedido pdp : p.verListaProductos()){
                if(pdp.verProducto().equals(producto)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p : pedidos){
            if(p.equals(pedido)){
                return true;
            }
        }
        return false;
    }
    
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p : pedidos){
            if(p.verNumero() == numero){
                return p;
            }
        }
        return null;
    }
}
