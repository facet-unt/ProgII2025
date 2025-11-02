/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author octav
 */
public class GestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos instancia;
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
    private GestorPedidos() {

    }

    public static GestorPedidos instanciar() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }
    public String crearPedido(int numero,LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        Pedido pedido= new Pedido(numero,fecha,hora,productosDelPedido,cliente);
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
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar.verEstado()==null)
            return ERROR_ESTADO;
        if(pedidoAModificar.verEstado()==Estado.CREADO)
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        else if(pedidoAModificar.verEstado()==Estado.PROCESANDO)
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        return EXITO;
    }
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        if(cliente.verPedido()!=null)
            return true;
        else
            return false;
    }
    public boolean hayPedidosConEsteProducto(Producto producto){
        
    }
    public boolean existeEstePedido(Pedido pedido){
        for(Pedido p: pedidos){
            if(pedidos.contains(pedido))
                return true;
        }
        return false;
    }
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero()==numero)
                return p;
        }
        return null;
    }
}
