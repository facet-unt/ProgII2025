/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;

    public void mostrar() {
        System.out.println("Numero: " + obtenerNumero());
        System.out.println("Fecha: " + obtenerFecha() + "Hora: " + obtenerHora());
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);

    }

    public Pedido(int numero, LocalDateTime fechaYHora) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
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

}
