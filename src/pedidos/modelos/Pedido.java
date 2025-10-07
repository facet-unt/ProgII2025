/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechayHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> listaProductos = new ArrayList<>();
    
    public void mostrar(){
        System.out.println("Nro:" + numero);
        System.out.println("Fecha:" + verFecha());
        System.out.println("Hora: " + verHora());
        System.out.println("Cliente:" + cliente.verApellido() + cliente.verNombre());
        System.out.println("Estado:" + estado);
        for(ProductoDelPedido p: listaProductos)
        {
            p.mostrar();
        }
    }

    public Pedido(int numero, LocalDateTime fechayHora, Estado estado, Cliente cliente, ArrayList<ProductoDelPedido> lista) {
        this.numero = numero;
        this.fechayHora = fechayHora;
        this.estado = estado;
        this.cliente = cliente;
        this.listaProductos=lista;
    }
    
//    public Pedido(int numero, LocalDateTime fechayHora, Cliente cliente) {
//        this.numero = numero;
//        this.fechayHora = fechayHora;
//        this.estado = Estado.CREADO;
//        this.cliente = cliente;
//        
//    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate verFecha() {
        return fechayHora.toLocalDate();
    }
    public LocalTime verHora() {
        return fechayHora.toLocalTime();
    }

    public void asignarFechayhora(LocalDateTime fechayHora) {
        this.fechayHora = fechayHora;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
