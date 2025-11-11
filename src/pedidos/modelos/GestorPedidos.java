package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class GestorPedidos implements IGestorPedidos{
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;

    private GestorPedidos() {
        
    }
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String error = validarDatosPedido(fecha, hora, productosDelPedido, cliente);
        if (error != null) {
            return error;
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
    
    @Override
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
    
    @Override
    public List<Pedido> verPedidos(){
        ArrayList<Pedido> pedidosOrdenados = new ArrayList<>(pedidos);
        pedidosOrdenados.sort((p1, p2) -> Integer.compare(p1.verNumero(), p2.verNumero()));
        return pedidosOrdenados;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : pedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
    
    @Override
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
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p : pedidos){
            if(p.equals(pedido)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p : pedidos){
            if(p.verNumero() == numero){
                return p;
            }
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if (pedido == null) {
            return PEDIDO_INEXISTENTE;
        }

        if (pedido.verEstado() == Estado.ENTREGADO) {
            return ERROR_CANCELAR;
        }

        Cliente cliente = pedido.verCliente();
        if (cliente != null) {
            cliente.cancelarPedido(pedido);
        }

        if (pedidos.remove(pedido)) {
            return EXITO;
        } else {
            return PEDIDO_INEXISTENTE;
        }
    }
    
    private String validarDatosPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        return null;
    }
}