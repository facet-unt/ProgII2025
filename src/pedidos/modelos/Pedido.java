package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

public class Pedido {
    private int numero;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> productos;

    public Pedido(int numero, LocalDateTime fechaHora, ArrayList<ProductoDelPedido> productos, Cliente cliente) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.estado = Estado.CREADO;
        this.productos = productos;
    }

    public int verNumero() {
        return numero;
    }

    public LocalDateTime verFechaHora() {
        return fechaHora;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<ProductoDelPedido> verProductos() {
        return productos;
    }

    public void mostrar() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + fechaHora.format(formatoFecha) + " Hora: " + fechaHora.format(formatoHora));
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Productos:");
        for (ProductoDelPedido pdp : productos) {
            pdp.mostrar();
        }
        System.out.println(); // Separador
    }
}

