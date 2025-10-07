/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

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

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente unCliente, Estado unEstado, ArrayList<ProductoDelPedido> unProductoDelPedido) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.unEstado = unEstado;
        this.unCliente.asignarPedido(this);
        this.productoPedido = unProductoDelPedido;

    }
    
    public Pedido(int numero, LocalDateTime fechaYHora, Cliente unCliente, ArrayList<ProductoDelPedido> unProductoDelPedido) {
        this(numero,fechaYHora,unCliente,Estado.CREADO,unProductoDelPedido);
    }
    
    
    
    
    

    
    
    //METODS GET Y SET
=======
/**
 *
 * @author thoma
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
>>>>>>> desarrollo

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
        System.out.println("Fecha: " + fechaYHora.toLocalDate()+ "\tHora:" + fechaYHora.toLocalTime());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + unEstado);
        System.out.println("\t\t Producto\t\t Cantidad");
        System.out.println("\t\t========================================");
        for (ProductoDelPedido e: productoPedido)
            System.out.println("\t\t"+e.verUnProducto().verDescripcion()+"\t\t"+e.verCantidad());
        
    }

   
    
=======
    
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
        for(ProductoDelPedido p : listaProductosdelPedido)
            p.mostrar();
        System.out.println("#################### ");
    } 
>>>>>>> desarrollo
}
