/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import productos.modelos.Producto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;
import productos.modelos.Producto;

public class Pedido {
    private int numero = 0;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> listaProductosdelPedido;

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente, Estado estado) {
        this(numero, fechaYHora, new ArrayList<>(), cliente, estado);
    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> lista, Cliente cliente, Estado estado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.listaProductosdelPedido = lista;
        this.cliente = cliente;        
        this.estado = estado;
    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> lista, Cliente cliente) {
        this(numero, fechaYHora, lista, cliente, Estado.CREADO);
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

    public ArrayList<ProductoDelPedido> verProductoPedido() {
        return listaProductosdelPedido;
    }

    public void asignarProductoPedido(ArrayList<ProductoDelPedido> productoPedido) {
        this.listaProductosdelPedido = productoPedido;
    }
    
    
    
    //METODS toString

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", unCliente=" + cliente + ", unEstado=" + estado + '}';
    }

    
    
    
    //OTROS METODOS
   //MOSTRAR
    public void mostrar(){
        System.out.println("Nro: " + numero);
        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
        String fechaFormateada = this.fechaYHora.format(Fecha);
        String horaFormateada = this.fechaYHora.format(Hora);
        System.out.println("Fecha: " + fechaFormateada + "\t\tHora: " + horaFormateada);
        System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        System.out.println("Estado: " + estado);
        System.out.println("\t\t Producto\t\t Cantidad");
        System.out.println("\t\t========================================");
       for(ProductoDelPedido p : listaProductosdelPedido)
        {
            p.mostrar();
        }
        
        System.out.println("#################### ");
        
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

    public void agregarProductodelPedido(Producto produc, int cantidad) {
        ProductoDelPedido nuevoProducto = new ProductoDelPedido(produc, cantidad);
        this.listaProductosdelPedido.add(nuevoProducto);
    }
   

    @Override
    public int hashCode() {
        int hash = 3;
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
