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
import productos.modelos.Producto;
import usuarios.modelos.Cliente;



/**
 *
 * @author erika
 */
public class GestorPedidos implements IGestorPedidos{
    
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
  public String cancelarPedido(Pedido pedido){
      if (pedido==null|| !pedidos.contains(pedido)) {
            return PEDIDO_INEXISTENTE;
        }
      pedido.verCliente().cancelarPedido(pedido);
      return EXITO;
  }
  
@Override
 public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        // Validaciones
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        
        // Generar número de pedido (se puede basar en la cantidad existente + 1)
        int numero = pedidos.size() + 1;
        
        Pedido nuevo = new Pedido(numero, fechaYHora, productosDelPedido, cliente);
        
        // Verificar duplicados
        if (pedidos.contains(nuevo)) return PEDIDOS_DUPLICADOS;

        // Agregar al gestor y al cliente
        pedidos.add(nuevo);
        cliente.agregarPedido(nuevo);

        return EXITO;
    }
    //Cambia el estado del pedido según la consigna.
    
@Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (pedidoAModificar == null) {
            return PEDIDO_INEXISTENTE;
        }

        Estado estadoActual = pedidoAModificar.verEstado();

        switch (estadoActual) {
            case CREADO -> {
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                return EXITO;
            }
            case PROCESANDO -> {
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                return EXITO;
            }
            default -> {
                return ERROR_ESTADO;
            }
        }
    }
    
     
     //Devuelve todos los pedidos.
     
@Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }
    
    //Verifica si hay pedidos asociados a un cliente.
    
@Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido p : pedidos) {
            if (p.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    
    //Verifica si hay pedidos que contengan cierto producto.
    
@Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido p : pedidos) {
            for (ProductoDelPedido pdp : p.verProductoPedido()) {
                if (pdp.verUnProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }
    
     //Comprueba si existe un pedido en la lista.
    
@Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

  
     //Busca un pedido por número.
   
@Override
    public Pedido obtenerPedido(Integer numero) {
        for (Pedido p : pedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }
        return null;
    }
    
    //Valida los datos de un pedido antes de crearlo.
     
    public String validarPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productos, Cliente cliente) {
        if (fecha == null) return ERROR_FECHA;
        if (hora == null) return ERROR_HORA;
        if (productos == null || productos.isEmpty()) return ERROR_PRODUCTOS_DEL_PEDIDO;
        if (cliente == null) return ERROR_CLIENTE;
        return VALIDACION_EXITO;
    }
}