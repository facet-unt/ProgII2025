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
import java.util.ArrayList;
import usuarios.modelos.Cliente;

public class Pedido {
    private int numero = 0;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> listaproductosdelpedido;

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente,ArrayList listaproductosdelpedido) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = Estado.CREADO;
        this.cliente = cliente;
        this.listaproductosdelpedido= listaproductosdelpedido;
    }

    public int verNumero() {
        return numero;
    }
    
    public LocalDate verFecha() {
        return this.fechaYHora.toLocalDate();
    }
    
    public LocalTime verHora() {
        return this.fechaYHora.toLocalTime();
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente verCliente() {
        return cliente;
    }
    
    public void mostrar(){
        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
        
        String fechaFormateada = this.fechaYHora.format(Fecha);
        String horaFormateada = this.fechaYHora.format(Hora);
        
        System.out.println("\nNro: " + this.numero);
        System.out.println("Fecha: " + fechaFormateada + "\t\tHora: " + horaFormateada);
        System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
        System.out.println("Estado: " + this.estado);
        
        System.out.println("\t\tProducto "+ "\t\tCantidad");
        System.out.println("\t\t=================================");
        for(ProductoDelPedido p : listaproductosdelpedido)
            p.mostrar();
        
    } 
}
