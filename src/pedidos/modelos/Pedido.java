/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente unCliente;
    private Estado unEstado;
    private List<ProductoDelPedido> productoPedido = new ArrayList<>();
    private static int contador = 1;

    //CONSTRUCTORES
    public Pedido(int numero, LocalDateTime fechaYHora, Estado unEstado, List<ProductoDelPedido> unProductoDelPedido, Cliente unCliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.unEstado = unEstado;
        this.unCliente.agregarPedido(this);
        this.productoPedido = unProductoDelPedido;
        contador++;

    }

    private static LocalDateTime ensamblarFecha(LocalDate fecha, LocalTime hora) {
        LocalDateTime fechaYHora = null;
        if (fecha != null && hora != null) {
            fechaYHora = fecha.atTime(hora);
        }
        return fechaYHora;
    }

    
    public Pedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> unProductoDelPedido, Cliente unCliente) {
        this(contador, ensamblarFecha(fecha, hora), Estado.CREADO, unProductoDelPedido, unCliente);
    }
    

    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> unProductoDelPedido, Cliente unCliente) {
        this(numero, fechaYHora, Estado.CREADO, unProductoDelPedido, unCliente);
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public LocalDate verFecha() {
        return this.fechaYHora.toLocalDate();
    }

    public LocalTime verHora() {
        return this.fechaYHora.toLocalTime();
    }

    public Cliente verCliente() {
        return unCliente;
    }

    public void asignarCliente(Cliente unCliente) {
        this.unCliente.cancelarPedido(this);
        this.unCliente = unCliente;
        this.unCliente.agregarPedido(this);
    }

    public Estado verEstado() {
        return unEstado;
    }

    public void asignarEstado(Estado estado) {
        this.unEstado = estado;
    }

    public List<ProductoDelPedido> verProductoPedido() {
        return productoPedido;
    }

    public void asignarProductoPedido(List<ProductoDelPedido> productoPedido) {
        if (!(productoPedido.contains(this.productoPedido))) {
            this.productoPedido = productoPedido;
        }
    }

    //METODO toString
    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", unCliente=" + unCliente + ", unEstado=" + unEstado + '}';
    }

    //OTROS METODOS
    public void mostrar() {
        System.out.println("Nro: " + numero);
        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
        String fechaFormateada = this.fechaYHora.format(Fecha);
        String horaFormateada = this.fechaYHora.format(Hora);
        System.out.println("Fecha: " + fechaFormateada + "\t\tHora: " + horaFormateada);
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + unEstado);
        System.out.println("\t\t Producto\t\t Cantidad");
        System.out.println("\t\t========================================");
        for (ProductoDelPedido p : productoPedido) {
            p.mostrar();
        }

        System.out.println("#################### ");

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.numero == other.numero;
    }

}
