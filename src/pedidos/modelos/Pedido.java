package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Cliente;

public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;
    private Estado estado;
    private List<ProductoDelPedido> listaProductosPedidos;

    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> listaProductos, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.listaProductosPedidos = listaProductos;
        this.cliente = cliente;
        this.estado = Estado.CREADO;
    }
    
    public void mostrar() {
        System.out.println("-- PEDIDO --");
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha() + " Hora: " + verHora());
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("Producto \t"  +  "Cantidad");
        for(ProductoDelPedido Pp :  listaProductosPedidos){
            System.out.println(Pp);
        }  
    }
    
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    
    public String verFecha() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaYHora.format(formatoFecha);
    }
    
    public String verHora() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        return fechaYHora.format(formatoHora);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numero;
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
    
    public List<ProductoDelPedido> verListaProductos() {
        return listaProductosPedidos;
    }
    
    public void asignarListaProductos(ArrayList<ProductoDelPedido> listaProductos) {
        this.listaProductosPedidos = listaProductos;
    }
}