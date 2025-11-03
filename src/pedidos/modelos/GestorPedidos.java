
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

// Importaciones de clases de otros paquetes
import usuarios.modelos.Cliente;
import productos.modelos.Producto;


public class GestorPedidos {
    
  
    public static final String EXITO = "Pedido creado/modificado/cancelado con exito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    
   
    private static GestorPedidos instancia;
    
   
    private ArrayList<Pedido> pedidos;
    
    
    private int contadorNumero;
    
 
    private GestorPedidos() {
        this.pedidos = new ArrayList<>();
        this.contadorNumero = 1;
    }
    
    public static GestorPedidos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, 
                             ArrayList<ProductoDelPedido> productosDelPedido, 
                             Cliente cliente) {
        
       
        String validacion = validarDatosPedido(fecha, hora, productosDelPedido, cliente);
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        
        Pedido nuevoPedido = new Pedido(contadorNumero, fechaYHora, productosDelPedido, cliente);
        
        
        if (existeEstePedido(nuevoPedido)) {
            return PEDIDOS_DUPLICADOS;
        }
        
       
        pedidos.add(nuevoPedido);
        
        // Incrementar el contador
        contadorNumero++;
        
       
        cliente.agregarPedido(nuevoPedido);
        
        return EXITO;
    }
    
    
    public String cambiarEstado(Pedido pedidoAModificar) {
        
       
        if (pedidoAModificar == null) {
            return PEDIDO_INEXISTENTE;
        }
        
        if (!existeEstePedido(pedidoAModificar)) {
            return PEDIDO_INEXISTENTE;
        }
        
        
        Estado estadoActual = pedidoAModificar.verEstado();
        
        if (estadoActual == null) {
            return ERROR_ESTADO;
        }
        

        switch (estadoActual) {
            case CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                break;
            case PROCESANDO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                break;
            case ENTREGADO:
                return ERROR_ESTADO;
            case SOLICITADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                break;
            default:
                return ERROR_ESTADO;
        }
        
        return EXITO;
    }
    

    public ArrayList<Pedido> verPedidos() {
        return new ArrayList<>(pedidos); // Devuelve una copia para proteger la lista original
    }
    

    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        
        for (Pedido pedido : pedidos) {
            if (pedido.verCliente() != null && pedido.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
    
 
    public boolean hayPedidosConEsteProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        
        for (Pedido pedido : pedidos) {
            ArrayList<ProductoDelPedido> productosDelPedido = pedido.verProductosDelPedido();
            if (productosDelPedido != null) {
                for (ProductoDelPedido pdp : productosDelPedido) {
                    if (pdp.verUnProducto() != null && pdp.verUnProducto().equals(producto)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
  
    public boolean existeEstePedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }
        
        for (Pedido p : pedidos) {
            if (p.verNumero() == pedido.verNumero()) {
                return true;
            }
        }
        return false;
    }
  
    public Pedido obtenerPedido(Integer numero) {
        if (numero == null) {
            return null;
        }
        
        for (Pedido pedido : pedidos) {
            if (pedido.verNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }
    

    private String validarDatosPedido(LocalDate fecha, LocalTime hora, 
                                     ArrayList<ProductoDelPedido> productosDelPedido, 
                                     Cliente cliente) {
        
        // Validar fecha
        if (fecha == null) {
            return ERROR_FECHA;
        }
        
        // Validar hora
        if (hora == null) {
            return ERROR_HORA;
        }
        
        // Validar cliente
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        
        // Validar productos
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        
        return VALIDACION_EXITO;
    }
    
    public void limpiarPedidos() {
        pedidos.clear();
        contadorNumero = 1;
    }
    
 
    public int cantidadPedidos() {
        return pedidos.size();
    }
}
