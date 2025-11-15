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
import usuarios.modelos.GestorUsuarios;

/**
 *
 * @author estudiante
 */
public class GestorPedidos implements IGestorPedidos{
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
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
    public String crearPedido(LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        LocalDateTime fechaYHora = fecha.atTime(hora);
        contadorPedidos++;
        Pedido p = new Pedido(contadorPedidos, fechaYHora, productosDelPedido, cliente);
        cliente.agregarPedido(p);
        pedidos.add(p);
        return EXITO;
        
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar.verEstado() == Estado.CREADO) pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        if(pedidoAModificar.verEstado() == Estado.PROCESANDO) pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        if(pedidoAModificar.verEstado() == Estado.ENTREGADO) return ERROR_ESTADO;
        return EXITO;
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){
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
            if (p.verlistaProductosdelPedido().contains(producto)) return true;
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
    
    public String validacion(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null) return ERROR_FECHA;
        if(hora == null) return ERROR_HORA;
        if(cliente == null) return ERROR_CLIENTE;
        if(productosDelPedido.isEmpty()) return ERROR_PRODUCTOS_DEL_PEDIDO;
        return VALIDACION_EXITO;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(pedido == null) return PEDIDO_INEXISTENTE;
        if(pedido.verEstado().equals(Estado.ENTREGADO)) return "Este pedido ya fué entregado";
        Cliente clienteDelPedido = pedido.verCliente();
        if(clienteDelPedido != null) clienteDelPedido.cancelarPedido(pedido);
        if(pedidos.remove(pedido)){
            return EXITO;
        } else return PEDIDO_INEXISTENTE;
    }
    
}