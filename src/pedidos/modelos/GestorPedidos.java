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

/**
 *
 * @author salut
 */
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
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    private GestorPedidos() {
        
    }

    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
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
    
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar==null){
            return PEDIDO_INEXISTENTE;
        }
        if(pedidoAModificar.verEstado()==Estado.CREANDO){
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        }
        if(pedidoAModificar.verEstado()==Estado.PROCESANDO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        }
        return EXITO;
    }
    
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: pedidos){
            if(p.verUnCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
    
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
    
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p: pedidos){
            if(pedido.equals(p)){
                return true;
            }
        }
        return false;
    }
    
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero()==numero){
                return p;
            }
        }
        return null;
    }
}
