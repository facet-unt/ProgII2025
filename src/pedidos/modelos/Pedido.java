package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

public class Pedido {
     

    private int numero;
private LocalDateTime fechaHora;
private Cliente cliente;
private Estado estado;
private ArrayList<ProductoDelPedido> productosDelPedido;
private static int contador = 1;

public Pedido(int numero, LocalDate fecha, LocalTime hora, Cliente cliente) {
    this.numero = numero;
    this.fechaHora = LocalDateTime.of(fecha, hora);
    this.cliente = cliente;
    this.productosDelPedido = new ArrayList<>();
}

public Pedido(int numero, LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
    this.numero = numero;
    this.fechaHora = LocalDateTime.of(fecha, hora);
    this.cliente = cliente;
    this.productosDelPedido = productosDelPedido;
}

public Pedido(int numero, LocalDate fecha, LocalTime hora, Cliente cliente, Estado estado) {
    this.numero = numero;
    this.fechaHora = LocalDateTime.of(fecha, hora);
    this.cliente = cliente;
    this.estado = estado;
    this.productosDelPedido = new ArrayList<>();
}

    public Pedido(int i, LocalDate now, Cliente c1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaHora() {
        return fechaHora;
    }

    public void asignarFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
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

    public LocalDate verFecha() {
        return fechaHora.toLocalDate();
    }

    public LocalTime verHora() {
        return fechaHora.toLocalTime();
    }

    public ArrayList<ProductoDelPedido> verProductosDelPedido() {
        return productosDelPedido;
    }

    public void setProductosDelPedido(ArrayList<ProductoDelPedido> productosDelPedido) {
        this.productosDelPedido = productosDelPedido;
    }
    
    
    
    //metodo para eliminar un producto

    public void eliminarProducto(ProductoDelPedido productoDelPedido) {
        this.productosDelPedido.remove(productoDelPedido);
    }

    public double calcularTotal() {
        double total = 0;
        for (ProductoDelPedido pdp : productosDelPedido) {
            total += pdp.verProducto().verPrecio() * pdp.verCantidad();
        }
        return total;
    }

    public void mostrar() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha().format(formatoFecha) +
                "        Hora: " + verHora().format(formatoHora));
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);

        if (productosDelPedido.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            System.out.println("Producto       Cantidad");
            System.out.println("========================");
            for (ProductoDelPedido pdp : productosDelPedido) {
                String nombreProducto = pdp.verProducto().verDescripcion();
                int cantidad = pdp.verCantidad();
                System.out.printf("%-15s %5d%n", nombreProducto, cantidad);
            }
        }

        System.out.println();
    }

    // Comparar pedidos por número

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.numero;
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
