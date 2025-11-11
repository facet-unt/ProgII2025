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
 * @author sofia
 */
public class GestorPedidos implements IGestorPedidos {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    private static GestorPedidos gestor;
    private static int numero = 1;

    private GestorPedidos() {

    }

    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        pedido.getCliente().cancelarPedido(pedido);
        return BORRADO_EXITO;
    }

    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        if (productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }

        LocalDateTime fechayhora = LocalDateTime.of(fecha, hora);

        Pedido p = new Pedido(numero, fechayhora, productosDelPedido, cliente);
        numero++;
        cliente.agregarPedido(p);
        pedidos.add(p);
        return VALIDACION_EXITO;
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (pedidoAModificar.getEstado() == null) {
            return ERROR_ESTADO;
        }
        if (pedidoAModificar.getEstado() == Estado.CREADO) {
            pedidoAModificar.setEstado(Estado.PROCESANDO);

        }

        if (pedidoAModificar.getEstado() == Estado.PROCESANDO) {
            pedidoAModificar.setEstado(Estado.ENTREGADO);

        }
        return ESTADO_EXITO;
    }
   

    @Override
    public List<Pedido> verPedidos() {
        
        
        return pedidos;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido p : pedidos) {

            if (p.getCliente() == cliente) {
                return true;
            }

        }
        return false;

    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido p : pedidos) {

            for (ProductoDelPedido prod : p.getCantidadProducto()) {
                if (prod.getUnProducto() == producto) {
                    return true;
                }
            }

        }
        return false;

    }

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        for (Pedido p : pedidos) {
            if (p == pedido) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pedido obtenerPedido(Integer numero) {
        for (Pedido p : pedidos) {
            if (p.obtenerNumero() == numero) {
                return p;
            }

        }
        return null;
    }
}
