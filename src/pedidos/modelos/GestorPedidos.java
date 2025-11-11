/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author octav
 */
public class GestorPedidos implements IGestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos instancia;
    private GestorPedidos() {

    }

    public static GestorPedidos instanciar() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        Pedido pedido= new Pedido(fecha,hora,productosDelPedido,cliente);
        if(cliente==null)
            return ERROR_CLIENTE;
        if(productosDelPedido==null)
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        if(pedidos.contains(pedido))
            return PEDIDOS_DUPLICADOS;
        else
            pedidos.add(pedido);
        cliente.agregarPedido(pedido);
        return EXITO;
    }
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar.verEstado()==null)
            return ERROR_ESTADO;
        if(pedidoAModificar.verEstado()==Estado.CREADO)
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        else if(pedidoAModificar.verEstado()==Estado.PROCESANDO)
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        return EXITO;
    }
    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: pedidos){
            if(p.verCliente() == cliente)
                return true;
        }
        return false;
                
    }
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: pedidos){
            for(ProductoDelPedido pdp: p.verProductoPedido()){
                if(pdp.verUnProducto() == producto){
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p: pedidos){
            if(pedidos.contains(pedido))
                return true;
        }
        return false;
    }
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero()==numero)
                return p;
        }
        return null;
    }
    @Override
    public String cancelarPedido(Pedido pedido){
        Cliente unCliente = pedido.verCliente();
        for(Pedido p: pedidos){
            if(p.verCliente() == unCliente){
                unCliente.cancelarPedido(pedido);
                return PEDIDO_BORRADO;
            }
        }
        return PEDIDO_INEXISTENTE;
    }
}
