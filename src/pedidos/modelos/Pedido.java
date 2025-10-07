/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> listaProductosPedidos;

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente, Estado estado, ArrayList<ProductoDelPedido> listaProductos) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.cliente = cliente;
        this.estado = estado;
        this.listaProductosPedidos = listaProductos;
    }
    
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    
    public String verFecha() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaYHora.format(formatoFecha);
    }
    
    public String verHora() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return fechaYHora.format(formatoHora);
    }
    
    public void mostrar() {
        System.out.println("-- PEDIDO --");
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha() + " Hora: " + verHora());
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Producto \t"  +  "Cantidad");
        for(ProductoDelPedido Pp :  listaProductosPedidos){
            System.out.println(Pp);
        }  
    }
    public ArrayList<ProductoDelPedido> verListaProductos() {
        return listaProductosPedidos;
    }
    public void asignarListaProductos(ArrayList<ProductoDelPedido> listaProductos) {
        this.listaProductosPedidos = listaProductos;
    }
   
}