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

/**
 *
 * @author estudiante
 */
public class Pedido {
    
   private int numero;
   private LocalDateTime fechaYHora;
   private Cliente unCliente;
   private Estado unEstado;
   private ArrayList <ProductoDelPedido> productoPedido = new ArrayList<>();
 
   
   
   //CONSTRUCTORES

    public Pedido(int numero, LocalDateTime fechaYHora, Estado unEstado, ArrayList<ProductoDelPedido> unProductoDelPedido, Cliente unCliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.unEstado = unEstado;
        this.unCliente.asignarPedido(this);
        this.productoPedido = unProductoDelPedido;

    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> unProductoDelPedido,  Cliente unCliente) {
        this(numero,fechaYHora,Estado.CREADO,unProductoDelPedido, unCliente);
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
        return productoPedido;
    }

    public void asignarProductoPedido(ArrayList<ProductoDelPedido> productoPedido) {
        this.productoPedido = productoPedido;
    }
    
    
    
    //METODS toString

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", unCliente=" + unCliente + ", unEstado=" + unEstado + '}';
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
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + unEstado);
        System.out.println("\t\t Producto\t\t Cantidad");
        System.out.println("\t\t========================================");
       for(ProductoDelPedido p : productoPedido)
        {
            p.mostrar();
        }
        System.out.println("\t\tProducto " + "\t\tCantidad");
        System.out.println("\t\t=================================");
        
        System.out.println("#################### ");
        
    }

   
    

    
    public LocalDate verFecha() {
        return this.fechaYHora.toLocalDate();
    }
    
    public LocalTime verHora() {
        return this.fechaYHora.toLocalTime();
    }

    public Estado verEstado() {
        return unEstado;
    }

    public void asignarEstado(Estado estado) {
        this.unEstado = estado;
    }

    public Cliente verCliente() {
        return unCliente;
    }

    public void agregarProductodelPedido(Producto produc, int cantidad) {
        ProductoDelPedido  unProductoDelPedido= new ProductoDelPedido(produc, cantidad);
        if (!productoPedido.contains(unProductoDelPedido))
        {
            productoPedido.add(unProductoDelPedido);
        }
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
