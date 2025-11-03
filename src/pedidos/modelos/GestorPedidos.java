/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;

/**
 *
 * @author Asus
 */
public class GestorPedidos {
    private ArrayList<Pedido> pedidos = new ArrayList<>();
     private static GestorUsuarios instancia;
     public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
     
     
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
     if (fecha == null){
     return ERROR_FECHA;
     }else if (hora == null){
     return ERROR_HORA;
     }else if (cliente == null){
     return ERROR_CLIENTE;
     }else if (productosDelPedido == null){
     return ERROR_PRODUCTOS_DEL_PEDIDO;
     }
     int numero = this.pedidos.size() + 1;
     Pedido p = new Pedido (numero, fecha, hora, productosDelPedido, cliente);
     pedidos.add(p);
     return EXITO;
}

public String cambiarEstado(Pedido pedidoAModificar){
    if (pedidoAModificar == null){
    return PEDIDO_INEXISTENTE;
            }
    Estado estadoActual = pedidoAModificar.verEstado();
    Estado nuevoEstado;
        return null;
    
}


    public ArrayList<Pedido> verPedidos(){
    return pedidos;
     }

    public boolean hayPedidosConEsteCliente(Cliente cliente){
    for (Pedido p : pedidos){
     if (p.verCliente() == cliente){
     return true;
         }
    }
    return false;
    }

        
public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido ped : this.pedidos) {
        ArrayList<ProductoDelPedido> productosEnElPedido = ped.verProductosDelPedido();
        for (ProductoDelPedido p : productosEnElPedido) {
            if (p.verProducto().equals(producto)) {
                
                // 5. ¡Encontrado!
                System.out.println("Ya hay pedidos con ese producto");
                return true;
            }
        }
    }
    return false;
}

    public boolean existeEstePedido(Pedido pedido){
     for (Pedido p : pedidos){
      if (p.equals(pedido))
          System.out.println("Ya existe ese pedido");
          return true;
     }
        System.out.println("No existe ese pedido");
       return false;
    }

public Pedido obtenerPedido(Integer numero){
 for (Pedido p : pedidos){
     if (p.verNumero() == numero)
         System.out.println("Hay unt pedido   con ese numero");
         return p;
 }
    System.out.println("No hay pedidos con ese numero");
    return null;
}
    
}
