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
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;
    private Estado estado; 
    
    public void mostrar(){
        System.out.println("Nro: "+ numero);
        System.out.println("Fecha: "+ obtener_fecha()+ "\t\tHora: "+obtener_horario());
        System.out.println("Cliente: "+ cliente.verApellido()+ ", "+cliente.verNombre());
        System.out.println("Estado: "+ estado);
              
    }

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente, Estado estado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int asignarNumero() {
        return numero;
    }

    public void verNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime asignarFechaYHora() {
        
        return fechaYHora;
    }

    public void verFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
    public String obtener_fecha(){
    DateTimeFormatter formato_fecha = DateTimeFormatter.ofPattern("dd/MM/aaaa");
    return fechaYHora.format(formato_fecha);
    }
    
    public String obtener_horario(){
    DateTimeFormatter formato_horario = DateTimeFormatter.ofPattern("hh:mm");
    return fechaYHora.format(formato_horario);
    }
    
}
