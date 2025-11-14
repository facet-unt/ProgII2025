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
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

/**
 *
 * @author Amadeo
 */
public class GestorPedidos {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private static GestorPedidos intstancia;
    private int numnero;
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tieneproductos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido eneste estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con esehjnúmero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido";

    private GestorPedidos() {

    }

    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        Pedido nuevoPedido = new Pedido(fecha, hora, productosDelPedido, cliente);
        return null;
    }

    public String cambiarEstado(Pedido pedidoAModificar) {
        switch (pedidoAModificar.verEstado()) {
            case CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            case PROCESANDO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            case ENTREGADO:
                return "Pedido Entregado :D";

        }
        return null;
    }

    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }

    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido u : pedidos) {
            if (u.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido u : pedidos) {
            if (u.verProductoPedido().contains(producto)) {
                return true;
            }
        }
        return false;
    }
}

//public String crearPedido(LocalDate fecha, LocalTime hora,
//ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente):
//crea un nuevo pedido, devolviendo el resultado de la operación. Al
//crear el pedido, el mismo se agrega al cliente especificado (empleando
//Trabajo Práctico 5 - Programación II - 2025 3 | 5
//
//FACULTAD DE CIENCIAS EXACTAS Y TECNOLOGÍA (UNT) PROGRAMACIÓN II (E11)
//
//el método agregarPedido() definido en la clase Cliente).
//○ public String cambiarEstado(Pedido pedidoAModificar): cambia el
//estado de un pedido. Si el pedido está en el estado Estado.CREADO lo
//pasa a Estado.PROCESANDO. Si el pedido está en el estado
//Estado.PROCESANDO lo pasa a Estado.ENTREGADO. Devuelve el resultado de
//la operación.
//○ public ArrayList<Pedido> verPedidos(): devuelve todos los pedidos.
//○ public boolean hayPedidosConEsteCliente(Cliente cliente): devuelve
//true si hay al menos un pedido con el cliente especificado, false en
//caso contrario.
//○ public boolean hayPedidosConEsteProducto(Producto producto):
//devuelve true si hay al menos un pedido con el producto especificado,
//false en caso contrario.
//○ public boolean existeEstePedido(Pedido pedido): devuelve true si
//existe el pedido especificado, false en caso contrario.
//○ public Pedido obtenerPedido(Integer numero): obtiene el pedido con
//el número especificado. Si no hay un pedido con el número, devuelve
//null.
//○ Métodos auxiliares que considere necesarios (por ejemplo, los que
//validen los datos de un pedido).

