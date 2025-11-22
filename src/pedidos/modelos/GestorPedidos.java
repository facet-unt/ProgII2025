/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Amadeo
 */
public class GestorPedidos implements IGestorPedidos {
    private List<Pedido> pedidos = new ArrayList<>();
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
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String resultado = validarDatosPedidos(fecha, hora, productosDelPedido, cliente);
        if (!resultado.equals(VALIDACION_EXITO)) {
            return resultado;
        }

        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        int numeroPedido = pedidos.size() + 1;
        Pedido nuevoPedido = new Pedido(numeroPedido, fechaYHora, productosDelPedido, cliente);
        pedidos.add(nuevoPedido);
        return EXITO;
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        switch (pedidoAModificar.verEstado()) {
            case CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                return "Pedido en procesamiento";
            case PROCESANDO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                return "Pedido entregado";
            case ENTREGADO:
                return "Pedido ya entregado";
            default:
                return "Estado inválido";
        }
    }

    @Override
    public List<Pedido> verPedidos() {
        List<Pedido> copia = new ArrayList<>(pedidos);
        copia.sort((p1, p2) -> Integer.compare(p1.verNumero(), p2.verNumero()));
        return copia;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido u : pedidos) {
            if (u.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido u : pedidos) {
            List<ProductoDelPedido> productosDelPedido = u.verProductoPedido();
            for (ProductoDelPedido pdp : productosDelPedido) {
                if (pdp.verUnProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
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
        Pedido pedidoEncontrado = obtenerPedido(pedido.verNumero());
        if (pedidoEncontrado == null) {
            return PEDIDO_INEXISTENTE;
        } else {
            pedidoEncontrado.verCliente().cancelarPedido(pedidoEncontrado);
            pedidos.remove(pedidoEncontrado);
            return PEDIDO_CANCELADO;
        }
    }

    private String validarDatosPedidos(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        return VALIDACION_EXITO;
    }
    
}
