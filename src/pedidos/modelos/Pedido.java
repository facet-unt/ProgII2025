/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author rocio
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYhora;
    private Estado estado;
    private Cliente unCliente; /*implementacion de asociacion con clase cliente*/


    public void mostrar() {
        System.out.println("====================== PEDIDO ==========================");
        String hora = "HH:mm";
        String horaFormateada = fechaYhora.format(DateTimeFormatter.ofPattern(hora));
        String fecha = "dd/MM/yyyy";
        String fechaFormateada = fechaYhora.format(DateTimeFormatter.ofPattern(fecha));
        System.out.println("Nro:" + numero);
        System.out.println("Fecha: " + fechaFormateada + " Hora: " + horaFormateada);
        System.out.println("Cliente:" + unCliente);
        System.out.println("Estado:" + estado);

    }

    /* Agregado de constructor */
    public Pedido(int numero, LocalDateTime fechaYhora, Estado estado, Cliente unCliente) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.estado = estado;
        this.unCliente = unCliente;
    }

    /* Agregado de metodos get/set */
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYhora() {
        return fechaYhora;
    }

    public void asignarFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente verUnCliente() {
        return unCliente;
    }

    public void asignarUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

}
