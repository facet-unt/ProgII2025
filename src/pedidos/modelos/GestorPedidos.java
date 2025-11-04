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
 * @author erika
 */
public class GestorPedidos {
    
private ArrayList<Pedido> pedidos = new ArrayList<>();
    
public static final String EXITO = "Pedido creado/modificado/cancelado con exito";
public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
public static final String ERROR_HORA = "La hora del pedido es incorrecta";
public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
public static final String ERROR_ESTADO = "El pedido no tiene un estado";
public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese nmero";
public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
 
private static GestorPedidos instancia;

 private GestorPedidos() {
 }
 
 public static GestorPedidos instanciar() {
    if (instancia == null) {
        instancia = new GestorPedidos();
    }
        return instancia;
    }
 
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
     
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }
    
    //Verifica si hay pedidos asociados a un cliente.
    
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido p : pedidos) {
            if (p.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    
    //Verifica si hay pedidos que contengan cierto producto.
    
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
    
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

  
     //Busca un pedido por número.
   
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