package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Cliente;
import productos.modelos.Producto;

public class Pedido implements Comparable<Pedido>{
    private int numero = 0;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private List<ProductoDelPedido> listaProductosDelPedido = new ArrayList();
    
    @Override
    public int compareTo(Pedido p) {
    if (p == null) return 1;
    return Integer.compare(numero, p.verNumero());
    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente, Estado estado) {
        this(numero, fechaYHora, new ArrayList<>(), cliente, estado);
    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> lista, Cliente cliente, Estado estado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.listaProductosDelPedido = lista;
        this.cliente = cliente;        
        this.estado = estado;
    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> lista, Cliente cliente) {
        this(numero, fechaYHora, lista, cliente, Estado.CREADO);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numero;
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
    
    

    public int verNumero() {
        return numero;
    }

    public LocalDateTime verFechaHora() {
        return fechaYHora;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public Estado verEstado() {
        return estado;
    }
    
    public List<ProductoDelPedido> verlistaProductosDelPedido(){
        return listaProductosDelPedido;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }


    public void agregarProductodelPedido(Producto produc, int cantidad) {
        ProductoDelPedido nuevoProducto = new ProductoDelPedido(produc, cantidad);
        this.listaProductosDelPedido.add(nuevoProducto);
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
        
        System.out.println("\t\tProducto " + "\t\tCantidad");
        System.out.println("\t\t=================================");
        for(ProductoDelPedido p : listaProductosDelPedido)
            p.mostrar();
        System.out.println("#################### ");
    } 
}
