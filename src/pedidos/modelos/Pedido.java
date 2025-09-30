/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

/**
 *
 * @author Lucas
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;
    private Estados estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> productoDelPedido;

//    public Pedido(int par, LocalDateTime now, ArrayList<ProductoDelPedido> productoDelPedido, Cliente cliente1) {
//        this.productoDelPedido = productoDelPedido;
//    }

    public ArrayList<ProductoDelPedido> verProductoDelPedido() {
        return productoDelPedido;
    }

    public void asignarProductoDelPedido(ArrayList<ProductoDelPedido> productoDelPedido) {
        this.productoDelPedido = productoDelPedido;
    }
    
    
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> productoDelPedido, Cliente cliente, Estados estado) { 
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
        this.productoDelPedido = productoDelPedido;
    }
    
    public int asignarNumero() {
        return numero;
    }

    public LocalDateTime asignarFechaYHora() {
        return fechaYHora;
    }

    public Estados asignarEstado() {
        return estado;
    }

    public Cliente asignarCliente() {
        return cliente;
    }

    public void verNumero(int numero) {
        this.numero = numero;
    }

    public void verFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void verEstado(Estados estado) {
        this.estado = estado;
    }

    public void verCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public void mostrar() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + this.numero);
        System.out.println("Fecha: " + this.fechaYHora.format(dateFormatter) + " Hora: " + this.fechaYHora.format(timeFormatter));

        System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
        System.out.println("Estado: " + this.estado);
        
        System.out.println("===============================");
        for(ProductoDelPedido producto : productoDelPedido){
        System.out.println("Producto " + producto.verProducto().verDescripcion());                                                                   
        System.out.println("Cantidad " + producto.verCantidad());

        }

    }
}
