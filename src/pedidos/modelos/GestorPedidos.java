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
 * @author Esteban
 */
public class GestorPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private static int num=1;
    private static GestorPedidos instancia;
    
    private GestorPedidos (){
    }
    
    public static GestorPedidos instanciar () {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }
    
    //Constantes
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
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = this.validacionDatos(fecha, hora, productosDelPedido, cliente);
        
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        LocalDateTime fechaYHora = fecha.atTime(hora);
        
        Pedido nuevoPedido = new Pedido(num, fechaYHora,Estado.CREADO, productosDelPedido,  cliente);
        num++;
        cliente.agregarPedido(nuevoPedido);
        this.listaPedidos.add(nuevoPedido);
        
        return validacion;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar){
        Estado estadoActual = pedidoAModificar.verEstado();
        
        switch (estadoActual) {
            case CREADO:
                estadoActual = Estado.PROCESANDO;
                break;
            case PROCESANDO:
                estadoActual = Estado.ENTREGADO;
                break;
            default:
                return ERROR_ESTADO;
        }
        return estadoActual.verValor();
    }
    
    public ArrayList<Pedido> verPedidos(){
        return this.listaPedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : this.listaPedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }        
        }   
        return false;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p : this.listaPedidos){
            for (ProductoDelPedido prod: p.verProductoPedido()){
                if(prod.verUnProducto().equals(producto)){
                    return true;
                }  
            }        
        }
        return false;
    }
    
    public boolean existeEstePedido(Pedido pedido){
        return this.listaPedidos.contains(pedido);
    }
    
    public Pedido obtenerPedido(Integer numero){
        
        for(Pedido p : this.listaPedidos){
            if(p.verNumero()==numero){
                return p;
            }
            else return null;
        } 
        return null;
    }
    
    //Validacion de los datos del pedido
    private String validacionDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        
//        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
//        String fechaFormateada = fechaYHora.format(Fecha);
//        String horaFormateada = fechaYHora.format(Hora);
        
        if (fecha == null) {
            return ERROR_FECHA;
        }
        
        if (hora == null) {
            return ERROR_HORA;
        }
        
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
                
        if (productosDelPedido == null) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
                
        return VALIDACION_EXITO;
    }
    
    
}
