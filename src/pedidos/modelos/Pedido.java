/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

public class Pedido {

    private int numero;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private Estado estado;

    public Pedido(int numero, LocalDateTime fechaHora, Cliente cliente, Estado estado) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fechaHora.toLocalDate();
    }

    public LocalTime getHora() {
        return fechaHora.toLocalTime();
    }

    // Método mostrar según consigna
    public void mostrar() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + getFecha().format(formatoFecha) + " Hora: " + getHora().format(formatoHora));
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);
    }
}
