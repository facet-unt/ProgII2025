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

    // 🔹 Constructores
    public Pedido(int numero, LocalDateTime fechaHora, Cliente cliente) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.productosDelPedido = new ArrayList<>();
    }
    
    
    //constructor para la parte de ControladorPrincipalTP4Parte1
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

    // 🔹 Getters y Setters
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

    public void agregarProducto(ProductoDelPedido productoDelPedido) {
        this.productosDelPedido.add(productoDelPedido);
    }

    public void eliminarProducto(ProductoDelPedido productoDelPedido) {
        this.productosDelPedido.remove(productoDelPedido);
    }

    // 🔹 Cálculo de total
    public double calcularTotal() {
        double total = 0;
        for (ProductoDelPedido pdp : productosDelPedido) {
            total += pdp.getProducto().verPrecio() * pdp.getCantidad();
        }
        return total;
    }

    // 🔹 Mostrar pedido en formato tabular
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
                String nombreProducto = pdp.getProducto().verDescripcion(); // ⬅️ Usamos descripcion
                int cantidad = pdp.getCantidad();
                System.out.printf("%-15s %5d%n", nombreProducto, cantidad);
            }
        }

        System.out.println();
        //System.out.printf("Total: $%.2f%n", calcularTotal());
    }
    
    
    
    //hago un metodo para comparar los pedidos (con el insert code)
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.numero;
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
