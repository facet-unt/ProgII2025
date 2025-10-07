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
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> productos;

    public void mostrar() {
        System.out.println("Numero: " + obtenerNumero());
        System.out.println("Fecha: " + obtenerFecha() + " Hora: " + obtenerHora());
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Producto\tCantidad");
        System.out.println("========================");
        for(ProductoDelPedido p: productos){
            p.mostrar();
        }
    }

    public Pedido(int numero, LocalDateTime fechaYHora, Estado estado, Cliente cliente, ArrayList cantidadProducto) {
        ArrayList<Pedido> pedidosCliente = cliente.getPedidos();
        pedidosCliente.add(this);
        cliente.setPedidos(pedidosCliente);
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
        this.productos=cantidadProducto;
    }

    public int obtenerNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime obtenerFechaYHora() {
        return fechaYHora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String obtenerFecha() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaYHora.format(formatoFecha);
    }

    // Devuelve solo la hora
    public String obtenerHora() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return fechaYHora.format(formatoHora);
    }

    public ArrayList<ProductoDelPedido> getCantidadProducto() {
        return productos;
    }

    public void setCantidadProducto(ArrayList<ProductoDelPedido> cantidadProducto) {
        this.productos = cantidadProducto;
    }
}
