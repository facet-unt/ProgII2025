/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author damia
 */
public interface IGestorPedidos {
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente);
    public String cambiarEstado(Pedido pedidoAModificar);
    public ArrayList<Pedido> verPedidos();
    public boolean hayPedidosConEsteCliente(Cliente cliente);
    public boolean hayPedidosConEsteProducto(Producto producto);
    public String cancelarPedido(Pedido pedido);
    public boolean existeEstePedido(Pedido pedido);
    public Pedido obtenerPedido(Integer numero);
}
