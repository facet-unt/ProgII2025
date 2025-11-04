package pedidos.modelos;

import java.time.*;
import usuarios.modelos.*;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Producto;




public class GestorPedidos {
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String CAMBIO_ESTADO_FRACASO= "Al pedido no se le puede cambiar el estado";
    
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    public static final String VALIDACION_FRACASO = "El pedido tiene los datos incorrectos";
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    private static GestorPedidos instancia;
    
    
    private GestorPedidos() {
        
    }
    
    
    public static GestorPedidos instanciar() {
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        Pedido p = new Pedido (fecha,  hora, productosDelPedido,  cliente);
        if(fecha!=null&&hora!=null&&!productosDelPedido.isEmpty()&&cliente!=null)
        {   
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
    
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        boolean bandera=false; 
        for (Pedido unPedido: pedidos){
            if (unPedido.verProductoPedido().contains(producto)){
                    bandera=true;
                    break;
            }
        }
        return bandera;
    }
    
    public boolean existeEstePedido(Pedido pedido){
        boolean bandera = false;    
        if (pedidos.contains(pedido)){
            bandera=true;
            System.out.println("Pedido encontrado");
        }
        else System.out.println(PEDIDO_INEXISTENTE);
        return bandera;    
    }
    
    public Pedido obtenerPedido(Integer numero){
        for (Pedido unPedido : pedidos){
            if (unPedido.verNumero()==numero)
                return unPedido;
        
        }
        System.out.println(PEDIDO_INEXISTENTE);
        return null;
    }
    
    
    }
