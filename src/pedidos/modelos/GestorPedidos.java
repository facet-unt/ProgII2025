/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
public class GestorPedidos implements IGestorPedidos {

    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos instancia;
    private int numnero;

    private GestorPedidos() {
    }

    public static GestorPedidos instanciar() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
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

        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        int numeroPedido = pedidos.size() + 1;
        Pedido nuevoPedido = new Pedido(numeroPedido, fechaYHora, productosDelPedido, cliente);
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

    public boolean existeEstePedido(Pedido pedido) {
        for (Pedido u : pedidos) {
            if (u.equals(pedido)) {
                return true;
            }
        }
        return false;
    }

    public Pedido obtenerPedido(Integer numero) {
        for (Pedido u : pedidos) {
            if (u.verNumero() == numero) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
