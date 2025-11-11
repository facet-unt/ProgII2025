/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author salut
 */
public class GestorPedidos implements IGestorPedidos{
    
    private List<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    private GestorPedidos() {
        
    }

    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora,List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha==null){
            return ERROR_FECHA ;
        }
        if(hora==null){
            return ERROR_HORA ;
        }
        if(productosDelPedido.isEmpty()){
            return ERROR_PRODUCTOS_DEL_PEDIDO ;
        }
        if(cliente==null){
            return ERROR_CLIENTE ;
        }
        Pedido p = new Pedido((pedidos.size()+1),LocalDateTime.of(fecha, hora),productosDelPedido,cliente);
        pedidos.add(p);
        cliente.agregarPedido(p);
        return EXITO; 
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar==null){
            return PEDIDO_INEXISTENTE;
        }
        if(pedidoAModificar.verEstado()==Estado.CREANDO){
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            return EXITO;
        }
        if(pedidoAModificar.verEstado()==Estado.PROCESANDO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            return EXITO;
        }
        return EXITO;
    }
    
    @Override
    public List<Pedido> verPedidos(){
        Collections.sort(pedidos);
        return pedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: pedidos){
            if(p.verUnCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: pedidos){
            for(ProductoDelPedido p1: p.verListaProductos()){
                if(p1.verUnProducto().equals(producto)){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p: pedidos){
            if(pedido.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero()==numero){
                return p;
            }
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(pedido==null){
            return PEDIDO_INEXISTENTE;
        }
        pedidos.remove(pedido);
        pedido.verUnCliente().cancelarPedido(pedido);
        return EXITO;
    }
}
