/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYhora;
    private Estado estado;
    private Cliente unCliente;
    private ArrayList<ProductoDelPedido> productosdelpedido;
    
    public void mostrar(){
        System.out.println("Numero: " + numero);
        System.out.println("Fecha: " + fechaYhora.getDayOfMonth() + "/" + fechaYhora.getMonthValue() + "/" + fechaYhora.getYear() + "                  Hora: " + fechaYhora.getHour() + ":" + fechaYhora.getMinute());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("        Producto        Cantidad");
        System.out.println("      ==============================");
        for(ProductoDelPedido pdp: productosdelpedido) {
            System.out.println("        " + pdp.verUnproducto() + "        " + pdp.verCantidad() + "\n");
        }
    }

    public int verNumero() {
        return numero;
    }
    
     public Estado verEstado() {
        return estado;
    }

    public LocalDateTime verFechaYhora() {
        return fechaYhora;
    }

    public Cliente verUnCliente() {
        return unCliente;
    }

    public ArrayList<ProductoDelPedido> verProductosdelpedido() {
        return productosdelpedido;
    }
    
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public void asignarFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public void asignarUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public void asignarProductosdelpedido(ArrayList<ProductoDelPedido> productosdelpedido) {
        this.productosdelpedido = productosdelpedido;
    }
    
    public Pedido(int numero, LocalDateTime fechaYhora, Cliente unCliente, ArrayList<ProductoDelPedido> productosdelpedido) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.unCliente = unCliente;
        this.productosdelpedido = productosdelpedido;
        
    }
    
}

