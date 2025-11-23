package pedidos.modelos;

import java.time.*;
import usuarios.modelos.*;
import java.util.ArrayList;
import interfaces.*;
import java.util.Collections;
import java.util.List;
import productos.modelos.Producto;


public class GestorPedidos implements IGestorPedidos{
    
    private List<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos instancia;
    
    /* Constructor */
    private GestorPedidos() {   
    }
    
    /* Metodo que devuelve una unica referencia a GestorPedidos */
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        Pedido p = null;

       if(fecha != null && hora!= null && productosDelPedido != null  && !productosDelPedido.isEmpty() && cliente != null)
       {
            p = new Pedido (fecha,  hora, productosDelPedido,  cliente);
               if (pedidos.contains(p)){
                   return PEDIDOS_DUPLICADOS;
               }
               cliente.agregarPedido(p);
               pedidos.add(p);
           return VALIDACION_EXITO;
           
       }
       else
       {
            return VALIDACION_FRACASO;
        }
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAmodificar){
        switch (pedidoAmodificar.verEstado()) {
            case CREADO -> {
                pedidoAmodificar.asignarEstado(Estado.PROCESANDO);
                return "Procesando Pedido";
            }

            case PROCESANDO -> {
                pedidoAmodificar.asignarEstado(Estado.ENTREGADO);
                return "Pedido entregado";
            }

            default -> {
                return CAMBIO_ESTADO_FRACASO;
            }
        }
      
    }
    
    @Override
    public List<Pedido> verPedidos(){
        
        Collections.sort(pedidos);
        return pedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        boolean bandera = false; 
        for (Pedido unPedido: pedidos){
            if (unPedido.verProductoPedido().contains(producto)){
                    bandera=true;
                    break;
            }
        }
        return bandera;
    }
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        boolean bandera = false;    
        if (pedidos.contains(pedido)){
            bandera=true;
            System.out.println("Pedido encontrado");
        }
        else System.out.println(PEDIDO_INEXISTENTE);
        return bandera;    
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for (Pedido unPedido : pedidos){
            if (unPedido.verNumero()==numero)
                return unPedido;
        
        }
        System.out.println(PEDIDO_INEXISTENTE);
        return null;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido unPedido : pedidos){
            if (unPedido.verCliente()==cliente)
                return true;
        
        }
        System.out.println(PEDIDO_INEXISTENTE);
        return false;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(pedidos.contains(pedido) && pedido!=null){
           pedidos.remove(pedido);
           pedido.verCliente().cancelarPedido(pedido);
           return CANCELACION_EXITO;
        }
        return CANCELACION_FRACASO;
    }

    }
