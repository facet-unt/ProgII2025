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
 * @author Esteban
 */
public class GestorPedidos implements IGestorPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private static int num = 1;
    private static GestorPedidos instancia;
    
    private GestorPedidos (){
    }
    
    public static GestorPedidos instanciar () {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }
    
    //Metodos
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = this.validacionDatos(fecha, hora, productosDelPedido, cliente);
        
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        LocalDateTime fechaYHora = fecha.atTime(hora);
        
        Pedido nuevoPedido = new Pedido(num, fechaYHora, productosDelPedido, cliente, Estado.CREADO);
        num++;
        cliente.agregarPedido(nuevoPedido);
        this.listaPedidos.add(nuevoPedido);
        
        return validacion;
    }
    
    @Override
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
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        return this.listaPedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p : this.listaPedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }        
        }   
        return false;
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p : this.listaPedidos){
            for (ProductoDelPedido prod: p.verProductoPedido()){
                if(prod.verProducto().equals(producto)){
                    return true;
                }  
            }        
        }
        return false;
    }
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        return this.listaPedidos.contains(pedido);
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p : this.listaPedidos){
            if (p.verNumero() == numero){
                return p;
            }
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
