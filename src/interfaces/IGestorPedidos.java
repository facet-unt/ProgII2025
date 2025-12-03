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
 * @author damia
 */
public interface IGestorPedidos {
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
    
    /**
     * Se crea el producto y se guarda en un archivo de texto
     * @param fecha
     * @param hora
     * @param productosDelPedido
     * @param cliente
     * @return Devuelve un String con el resultado de la operacion
     */
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente);
    /**
     * Cambia el estado del pedido
     * @param pedidoAModificar
     * @return Devuelve un String con el resultado de la operacion
     */
    public String cambiarEstado(Pedido pedidoAModificar);
    /**
     * 
     * @return Devuelve una lista con todos los pedidos
     */
    public List<Pedido> verPedidos();
    /**
     * 
     * @param cliente
     * @return Devuelve true si el cliente tiene un pedido en curso
     */
    public boolean hayPedidosConEsteCliente(Cliente cliente);
    /**
     * 
     * @param producto
     * @return Devuelve true si hay un pedido que contenga el producto ingresado
     */
    public boolean hayPedidosConEsteProducto(Producto producto);
    /**
     * Cancela un pedido
     * @param pedido
     * @return Devuelve un String con el resultado de la operacion
     */
    public String cancelarPedido(Pedido pedido);
    /**
     * 
     * @param pedido
     * @return Devuelve true si existe el pedido ingresado
     */
    public boolean existeEstePedido(Pedido pedido);
    /**
     * Busca un pedido por su codigo
     * @param numero
     * @return Devuelve el pedido con el codigo ingresado
     */
    public Pedido obtenerPedido(Integer numero);
}
