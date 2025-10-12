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

    public Pedido(int numero, LocalDateTime fechaHora, Cliente cliente) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.productosDelPedido = new ArrayList<>();
    }

    public Pedido(int numero, LocalDateTime fechaHora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.productosDelPedido = productosDelPedido;
    }

    public Pedido(int numero, LocalDateTime fechaHora, Cliente cliente, Estado estado) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.estado = estado;
        this.productosDelPedido = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fechaHora.toLocalDate();
    }

    public LocalTime getHora() {
        return fechaHora.toLocalTime();
    }

    public ArrayList<ProductoDelPedido> getProductosDelPedido() {
        return productosDelPedido;
    }

    public void setProductosDelPedido(ArrayList<ProductoDelPedido> productosDelPedido) {
        this.productosDelPedido = productosDelPedido;
    }

    // Agregar producto con validación para evitar duplicados
    public void agregarProducto(ProductoDelPedido nuevoProductoDelPedido) {
        for (ProductoDelPedido pdp : productosDelPedido) {
            if (pdp.getProducto().equals(nuevoProductoDelPedido.getProducto())) {
                System.out.println("️ El producto ya está en el pedido y no se agregó nuevamente.");
                return;
            }
        }
        this.productosDelPedido.add(nuevoProductoDelPedido);
    }

    public void eliminarProducto(ProductoDelPedido productoDelPedido) {
        this.productosDelPedido.remove(productoDelPedido);
    }

    public double calcularTotal() {
        double total = 0;
        for (ProductoDelPedido pdp : productosDelPedido) {
            total += pdp.getProducto().verPrecio() * pdp.getCantidad();
        }
        return total;
    }

    public void mostrar() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + getFecha().format(formatoFecha) +
                "        Hora: " + getHora().format(formatoHora));
        System.out.println("Cliente: " + cliente);
        System.out.println("Estado: " + estado);

        if (productosDelPedido.isEmpty()) {
            System.out.println("No hay productos en este pedido.");
        } else {
            System.out.println("Producto       Cantidad");
            System.out.println("========================");
            for (ProductoDelPedido pdp : productosDelPedido) {
                String nombreProducto = pdp.getProducto().verDescripcion();
                int cantidad = pdp.getCantidad();
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
