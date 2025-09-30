/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author NEW GAME
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import productos.modelos.Producto;
import pedidos.modelos.ProductoDelPedido;

public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;
    private EstadoPedido estado;
    private ArrayList<ProductoDelPedido> productos;

    
    public Pedido(int numero, Cliente cliente, EstadoPedido estado) {
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.cliente = cliente;
        this.estado = estado;
        this.productos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    
    public String getFecha() {
        return fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getHora() {
        return fechaYHora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    
    public void agregarProducto (ProductoDelPedido productos){
        this.productos.add(productos);
    }

    
    public void mostrar() {
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + getFecha() + " Hora: " + getHora());
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("-----------------------------");
        System.out.println("Producto               Cantidad");
        System.out.println("--------------------------------");
    }
}
