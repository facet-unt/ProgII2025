/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    
   private int numero;
   private LocalDateTime fechaYHora;
   private Cliente unCliente;
   private Estado unEstado;
   private ArrayList <ProductoDelPedido> productoPedido = new ArrayList<>();
   
   
   //CONSTRUCTORES

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente unCliente, Estado unEstado, ArrayList<ProductoDelPedido> unProductoDelPedido) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.unEstado = unEstado;
        this.unCliente.asignarPedido(this);
        this.productoPedido = unProductoDelPedido;

    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, Cliente unCliente, ArrayList<ProductoDelPedido> unProductoDelPedido) {
        this(numero,fechaYHora,unCliente,Estado.CREADO,unProductoDelPedido);
    }
    
    
    
    
    

    
    
    //METODS GET Y SET

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public ArrayList<ProductoDelPedido> verProductoPedido() {
        return productoPedido;
    }

    public void asignarProductoPedido(ArrayList<ProductoDelPedido> productoPedido) {
        this.productoPedido = productoPedido;
    }
    
    
    
    //METODS toString

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", unCliente=" + unCliente + ", unEstado=" + unEstado + '}';
    }

    
    
    
    //OTROS METODOS
   //MOSTRAR
    public void mostrar(){
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + fechaYHora.toLocalDate()+ "\tHora:" + fechaYHora.toLocalTime());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + unEstado);
        System.out.println("\t\t Producto\t\t Cantidad");
        System.out.println("\t\t========================================");
        for (ProductoDelPedido e: productoPedido)
            System.out.println("\t\t"+e.verUnProducto().verDescripcion()+"\t\t"+e.verCantidad());
        
    }

   
    
}
