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
 * @author sofia
 */


public class GestorPedidos {
    
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
public static final String ESTADO_EXITO = "El estado se cambio con exito";

   
private ArrayList<Pedido> pedidos =new ArrayList<>();
    
    private static GestorPedidos gestor;
    private static int numero=1;

    private GestorPedidos() {

    }

    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null)
        {
            return ERROR_FECHA;
        }
        if(hora== null)
        {
            return ERROR_HORA;
        }
       if(cliente == null)
       {
           return ERROR_CLIENTE;
       }
       if(productosDelPedido.isEmpty())
       {
          return ERROR_PRODUCTOS_DEL_PEDIDO; 
       }
      
        LocalDateTime fechayhora = LocalDateTime.of(fecha, hora);

       
       Pedido p=new Pedido(numero,fechayhora, productosDelPedido, cliente);
       numero++;
       cliente.agregarPedido(p);
       pedidos.add(p);
       return VALIDACION_EXITO;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar)
    {
        if (pedidoAModificar.getEstado()==null)
        {
            return ERROR_ESTADO;
        }
        if(pedidoAModificar.getEstado()==Estado.CREADO)
        {
            pedidoAModificar.setEstado(Estado.PROCESANDO);
           
        }
        
        if(pedidoAModificar.getEstado()==Estado.PROCESANDO)
        {
            pedidoAModificar.setEstado(Estado.ENTREGADO);
            
        }
         return ESTADO_EXITO;
    }
        
        public ArrayList<Pedido> verPedidos()
        {
            return pedidos;
        }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente)
    {
        for(Pedido p: pedidos)
        {
            
            if(p.getCliente()==cliente)
            {
              return true;   
            }
           
           
         }
        return false;
         
    }
    
    
   
    public boolean hayPedidosConEsteProducto(Producto producto)
    {
        for(Pedido p: pedidos)
        {
            
            for(ProductoDelPedido prod:  p.getCantidadProducto())
            {
                if(prod.getUnProducto()==producto)
              return true;   
            }
           
           
         }
        return false;
        
    }
    
    public boolean existeEstePedido(Pedido pedido)
    {
        for(Pedido p: pedidos)
        {
            if(p==pedido)
            {
               return true;     
             }
        }
        return false; 
    }
    
    public Pedido obtenerPedido(Integer numero)
    {
        for(Pedido p: pedidos)
       {
           if(p.obtenerNumero()==numero)
           {
               return p;
           }
            
       }
        return null; 
    }
    }
