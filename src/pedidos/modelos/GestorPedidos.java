/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import Interfaces.IGestorPedidos;
import static Interfaces.IGestorPedidos.ERROR_CLIENTE;
import static Interfaces.IGestorPedidos.ERROR_FECHA;
import static Interfaces.IGestorPedidos.ERROR_HORA;
import static Interfaces.IGestorPedidos.ERROR_PRODUCTOS_DEL_PEDIDO;
import static Interfaces.IGestorPedidos.PEDIDO_INEXISTENTE;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;

/**
 *
 * @author Asus
 */
public class GestorPedidos implements IGestorPedidos{
    private List<Pedido> pedidos = new ArrayList<>();
     private static GestorPedidos instancia;
     public static GestorPedidos instanciar(){
        if (instancia == null)
            instancia = new GestorPedidos();
        return instancia;
    }


    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
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
        Pedido p = new Pedido (numero, fecha, hora, (List<ProductoDelPedido>) productosDelPedido, cliente);
        pedidos.add(p);
        cliente.agregarPedido(p);
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

        public List<Pedido> verPedidos(){
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
            List<ProductoDelPedido> productosEnElPedido = ped.verProductosDelPedido();
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


    public String cancelarPedido(Pedido pedido){
       GestorUsuarios gu = GestorUsuarios.instanciar();
       Cliente cliente = pedido.verCliente();
       if (!this.pedidos.contains(pedido)){
           return PEDIDO_INEXISTENTE;
       }
       if (cliente == null){
           return ERROR_CLIENTE;
       }
       cliente.cancelarPedido(pedido);
       this.pedidos.remove(pedido);
       return EXITO;
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
