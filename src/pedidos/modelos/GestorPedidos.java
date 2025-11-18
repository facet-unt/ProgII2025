/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import interfaces.IGestorPedidos;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class GestorPedidos implements IGestorPedidos{
    private ArrayList<Pedido> pedidos = new ArrayList();
    
    public static GestorPedidos instancia;
    private static int contadorPedidos = 0;
    private GestorPedidos(){
    }
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora,List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = validar(fecha, hora, productosDelPedido, cliente);
        if(validacion.equals(VALIDACION_EXITO)){
            LocalDateTime fechaYHora = fecha.atTime(hora);
            contadorPedidos++;
            Pedido p = new Pedido(contadorPedidos, fechaYHora, productosDelPedido, cliente);
            cliente.agregarPedido(p);
            pedidos.add(p);
            return EXITO;
        }
        return validacion;
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(null != pedidoAModificar.verEstado()){
            switch (pedidoAModificar.verEstado()){
                case CREADO -> pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                case PROCESANDO -> pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                case ENTREGADO -> {
                    return ERROR_ESTADO;
                }
                default -> {
                    return ERROR_ESTADO;
                }
            }
        return EXITO;
        }
        return ERROR_ESTADO;
    }
    
    @Override
    public List<Pedido> verPedidos(){
        return pedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : pedidos)
            if (p.verCliente().equals(cliente)) return true;
        return false; 
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p : pedidos)
            for(ProductoDelPedido pdp : p.verlistaProductosDelPedido()){
                if(pdp.verProducto().equals(producto))
                    return true;
            } 
        return false; 
    }
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        return pedidos.contains(pedido);
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p : pedidos)
            if(numero != null && numero.equals(p.verNumero())) return p;
        return null;
    }
    
    public String validar(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null) return ERROR_FECHA;
        if(hora == null) return ERROR_HORA;
        if(cliente == null) return ERROR_CLIENTE;
        if(productosDelPedido.isEmpty()) return ERROR_PRODUCTOS_DEL_PEDIDO;
        return VALIDACION_EXITO;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(pedido == null) return PEDIDO_INEXISTENTE;
        if(pedido.verEstado().equals(Estado.ENTREGADO)) return ERROR_CANCELAR;
        Cliente clienteDelPedido = pedido.verCliente();
        if(clienteDelPedido != null) clienteDelPedido.cancelarPedido(pedido);
        if(pedidos.remove(pedido)){
            return EXITO;
        } else return PEDIDO_INEXISTENTE;
    }
    
}