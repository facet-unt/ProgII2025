/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechayHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> listaProductos = new ArrayList<>();
    
    public void mostrar(){
        System.out.println("Nro:" + numero);
        System.out.println("Fecha:" + verFecha());
        System.out.println("Hora: " + verHora());
        System.out.println("Cliente:" + cliente.verApellido() + cliente.verNombre());
        System.out.println("Estado:" + estado);
        for(ProductoDelPedido p: listaProductos)
        {
            p.mostrar();
        }
    }

    public Pedido(int numero, LocalDateTime fechayHora, Cliente cliente, ArrayList<ProductoDelPedido> lista) {
        this.numero = numero;
        this.fechayHora = fechayHora;
        this.cliente = cliente;
        this.listaProductos=lista;
    }
    
//    public Pedido(int numero, LocalDateTime fechayHora, Cliente cliente) {
//        this.numero = numero;
//        this.fechayHora = fechayHora;
//        this.estado = Estado.CREADO;
//        this.cliente = cliente;
//        
//    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate verFecha() {
        return fechayHora.toLocalDate();
    }
    public LocalTime verHora() {
        return fechayHora.toLocalTime();
    }

    public void asignarFechayhora(LocalDateTime fechayHora) {
        this.fechayHora = fechayHora;
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

//    public void agregarProductodelPedido(Producto produc, int cantidad) {
//        ProductoDelPedido nuevoProducto = new ProductoDelPedido(produc, cantidad);
//        this.listaProductosdelPedido.add(nuevoProducto);
//    }
    
//    public void mostrar(){
//        DateTimeFormatter Fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter Hora = DateTimeFormatter.ofPattern("hh:mm");
//        
//        String fechaFormateada = this.fechayHora.format(Fecha);
//        String horaFormateada = this.fechayHora.format(Hora);
//        
//        System.out.println("\nNro: " + this.numero);
//        System.out.println("Fecha: " + fechaFormateada + "\t\tHora: " + horaFormateada);
//        System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
//        System.out.println("Estado: " + this.estado);
//        
//        System.out.println("\t\tProducto " + "\t\tCantidad");
//        System.out.println("\t\t=================================");
//        for(ProductoDelPedido p : listaProductos)
//            p.mostrar();
//        System.out.println("#################### ");
//    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numero;
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
