/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import productos.modelos.Producto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

/**
 *
<<<<<<< HEAD
 * @author estudiante
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYhora;
    private Estado estado;
    private Cliente unCliente; /*implementacion de asociacion con clase cliente*/
    private ArrayList<ProductoDelPedido> unPedido = new ArrayList<>(); //Asociacion 1 a mucho de Pedido y Productodelpedido

    public void mostrar() {
        String hora = "HH:mm";
        String horaFormateada = fechaYhora.format(DateTimeFormatter.ofPattern(hora));
        String fecha = "dd/MM/yyyy";
        String fechaFormateada = fechaYhora.format(DateTimeFormatter.ofPattern(fecha));
        System.out.println("Nro:" + numero);
        System.out.println("Fecha: " + fechaFormateada + " Hora: " + horaFormateada);
        System.out.println("Cliente:" + unCliente);
        System.out.println("Estado:" + estado);
        System.out.println("Producto ====== Cantidad");
        for(ProductoDelPedido pedido: unPedido)
        System.out.println(pedido.verUnProducto().verDescripcion() + "            " + pedido.verCantidad());   
    }
    

    /* Agregado de constructor */
    public Pedido(int numero, LocalDateTime fechaYhora, Estado estado, ArrayList<ProductoDelPedido> unPedido, Cliente unCliente) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.estado = estado;
        this.unCliente = unCliente;
        this.unPedido = unPedido;
    }
    
       public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> unProductoDelPedido,  Cliente unCliente) {
        this(numero,fechaYHora,Estado.CREADO,unProductoDelPedido, unCliente);
    }
    
    /* Agregado de metodos get/set */
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYHora() {
        return fechaYhora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYhora = fechaYHora;
    }

    public ArrayList<ProductoDelPedido> verProductoPedido() {
        return unPedido;
    }

    public void asignarProductoPedido(ArrayList<ProductoDelPedido> productoPedido) {
        this.unPedido = productoPedido;
    }
    
    
    public Cliente verCliente() {
        return unCliente;
    }

    public void asignarUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    
    
    //METODS toString

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYhora + ", unCliente=" + unCliente + ", unEstado=" + estado + '}';
    }

    

    public void agregarProductodelPedido(Producto produc, int cantidad) {
        ProductoDelPedido  unProductoDelPedido= new ProductoDelPedido(produc, cantidad);
        if (!unPedido.contains(unProductoDelPedido))
        {
            unPedido.add(unProductoDelPedido);
        }
    }


    //Metodo get que SOLO devuelve la hora:
    
    public LocalTime verHora() {
        return fechaYhora.toLocalTime();
    }
    //Metodo get que SOLO devuelve la fecha:
    
    public LocalDate verFecha(){
        return fechaYhora.toLocalDate();
    }

    public ArrayList<ProductoDelPedido> getunPedido() {
        return unPedido;
    }

    public void setPedido1(ArrayList<ProductoDelPedido> unPedido) {
        this.unPedido = unPedido;
    }

    /* Agregado del metodo equals y hashcode para comparar si dos pedidos son iguales en base al numero */
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
