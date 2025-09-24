/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author thoma
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

public class Pedido {
    private static int numero = 0;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;

    public Pedido(Estado estado,Cliente cliente) {
        this.numero = numero++;
        this.fechaYHora = LocalDateTime.now();
        this.estado = Estado.CREADO;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }
    
    public LocalDate getFecha() {
        return this.fechaYHora.toLocalDate();
    }
    
    public LocalTime getHora() {
        return this.fechaYHora.toLocalTime();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void mostrar(){
        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
        
        String fechaFormateada = this.fechaYHora.format(Fecha);
        String horaFormateada = this.fechaYHora.format(Hora);
        
        System.out.println("Nro: " + this.numero);
        System.out.println("Fecha: " + fechaFormateada + "\t\tHora: " + horaFormateada);
        System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
        System.out.println("Estado: " + this.estado);
    }
    
}
