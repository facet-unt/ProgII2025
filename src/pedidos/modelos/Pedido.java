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
import usuarios.modelos.Cliente;

/**
 *
 * @author salut
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYhora;
    private Cliente unCliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> listaProductosDelPedido = new ArrayList<>();

    public Pedido(int numero, LocalDateTime fechaYhora, Cliente unCliente, ArrayList<ProductoDelPedido> listaProductosDelPedido) {
        this.numero = numero;
        this.fechaYhora = fechaYhora;
        this.unCliente = unCliente;
        this.estado = Estado.CREANDO;
        this.listaProductosDelPedido = listaProductosDelPedido;
    }
    
    public void mostrar(){
        String patronFecha = "dd/MM/yyyy";
        String fechaEnCadena = this.fechaYhora.format(DateTimeFormatter.ofPattern(patronFecha));
        String patronHora = "hh:mm";
        String horaEnCadena = this.fechaYhora.format(DateTimeFormatter.ofPattern(patronHora));
        System.out.println("Nro: "+numero);
        System.out.println("Fecha: "+fechaEnCadena+"\tHora: "+horaEnCadena);
        System.out.println("Cliente: "+unCliente.verApellido()+", "+unCliente.verNombre());
        System.out.println("Estado: "+estado);
        System.out.println("\tProducto\tCantidad\n\t===========================");
        for(ProductoDelPedido p: listaProductosDelPedido)
            System.out.println("\tProducto "+p.verUnProducto().verCodigo()+"\t"+p.verCantidad());
    }
    
    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYhora() {
        return fechaYhora;
    }
    
    public LocalDate verFecha(LocalDateTime fechaYhora){
        LocalDate fecha = fechaYhora.toLocalDate();
        return fecha;
    }
    
    public LocalTime verHora(LocalDateTime fechaYhora){
    LocalTime hora = fechaYhora.toLocalTime();
    return hora;
    }

    public Cliente verUnCliente() {
        return unCliente;
    }

    public void asignarUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<ProductoDelPedido> verListaProductos() {
        return listaProductosDelPedido;
    }

    public void asignarListaProductos(ArrayList<ProductoDelPedido> listaProductosDelPedido) {
        this.listaProductosDelPedido = listaProductosDelPedido;
    }

}
