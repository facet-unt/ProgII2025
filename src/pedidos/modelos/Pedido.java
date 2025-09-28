/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucas
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;

    public Pedido(int numero, LocalDateTime fechaYHora, Estado estado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
    }

    public void verNumero(int numero) {
        this.numero = numero;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public int verNumero() {
        return numero;
    }

    public LocalDateTime asignarFechaYHora() {
        return fechaYHora;
    }

    public void mostrar() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + this.numero);
        System.out.println("Fecha: " + this.fechaYHora.format(dateFormatter) + " Hora: " + this.fechaYHora.format(timeFormatter));

        System.out.println("Cliente: ");
        System.out.println("Estado: " + this.estado);

    }
}
