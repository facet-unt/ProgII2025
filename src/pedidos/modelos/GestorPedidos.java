package pedidos.modelos;

import java.time.LocalDate;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPedidos implements IGestorPedidos {
     private ArrayList<Pedido> pedidos = new ArrayList<>();
     private static GestorPedidos instancia;

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

     private GestorPedidos() {

     }

     public static GestorPedidos instanciar() {
         if (instancia == null)
             instancia = new GestorPedidos();
         return instancia;
     }
     
     @Override
     public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
         int i=0;
         if (fecha == null)
             return ERROR_FECHA;
         if(hora == null)
             return ERROR_HORA;
         if (productosDelPedido == null || productosDelPedido.isEmpty())
             return ERROR_PRODUCTOS_DEL_PEDIDO;
         if (cliente == null)
             return ERROR_CLIENTE;
         
         LocalDateTime fechaYhora = fecha.atTime(hora);
         Pedido p = new Pedido(i, fechaYhora, productosDelPedido, cliente);
         if (pedidos.contains(p))
             return PEDIDOS_DUPLICADOS;

         pedidos.add(p);
         cliente.agregarPedido(p);
         return EXITO;
     }

     @Override
     public String cambiarEstado(Pedido pedidoAModificar){
         if (pedidos.contains(pedidoAModificar)){
             if (pedidoAModificar.verEstado() == null)
                 return ERROR_ESTADO;
             if (pedidoAModificar.verEstado() == Estado.CREADO){
                 pedidoAModificar.asignarEstado(Estado.PROCESADO);
                 return EXITO;
             }
             if (pedidoAModificar.verEstado() == Estado.PROCESADO){
                 pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                 return EXITO;
             }
             if (pedidoAModificar.verEstado() == Estado.ENTREGADO)
                 return "Este pedido ya fue entregado";
         }
         return PEDIDO_INEXISTENTE;
     }
     
     @Override
     public List<Pedido> verPedidos(){
         Collections.sort(pedidos);
         return pedidos;
     }

     @Override
     public boolean hayPedidosConEsteCliente(Cliente cliente) {
         if (cliente != null)
            return cliente.verPedidos().isEmpty();
         return false;
     }

     @Override
     public boolean hayPedidosConEsteProducto (Producto producto){
         int i=0;
         for (Pedido ped: pedidos){
             for (ProductoDelPedido pdp: ped.verProductosdelpedido()){
                 if (pdp.getUnproducto().equals(producto))
                     i++;
             }
         }
         return i!=0;
     }

     @Override
     public boolean existeEstePedido(Pedido pedido){
         if (pedido != null)
            return pedidos.contains(pedido);
         return false;
     }

     @Override
     public Pedido obtenerPedido(Integer numero){
         if (numero<=0){
             System.out.println("El numero ingresado es erroneo");
             System.out.println("");
             return null;
         } else {
             for(Pedido p: pedidos){
                 if (p.verNumero() == numero);
                 return p;
             }
         }
         System.out.println("No existe pedido con este numero");
         System.out.println("");
         return null;
     }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if (pedido != null && pedidos.contains(pedido)){
            pedidos.remove(pedido);
            pedido.verUnCliente().cancelarPedido(pedido);
            return EXITO;
        } else {
            return PEDIDO_INEXISTENTE;
        }
    }
     
     
}
