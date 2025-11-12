/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public interface IGestorPedidos {
    //MENSAJES
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String CAMBIO_ESTADO_FRACASO= "Al pedido no se le puede cambiar el estado";    
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    public static final String VALIDACION_FRACASO = "El pedido tiene los datos incorrectos";
    public static final String CANCELACION_EXITO = "El pedido fue cancelado correctamente";
    public static final String CANCELACION_FRACASO = "El pedido no pudo ser cancelado";
    
    
    //METODOS A IMPLEMENTAR
    public abstract String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente);
    public abstract String cambiarEstado(Pedido pedidoAModificar);
    public abstract List<Pedido> verPedidos();
    public abstract boolean hayPedidosConEsteCliente(Cliente cliente);
    public abstract boolean hayPedidosConEsteProducto(Producto producto);
    public abstract String cancelarPedido(Pedido pedido);
    public abstract boolean existeEstePedido(Pedido pedido);
    public abstract Pedido obtenerPedido(Integer numero);
}
