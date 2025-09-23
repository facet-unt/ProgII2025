/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
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
   
   
   //CONSTRUCTORES

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente unCliente, Estado unEstado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.unEstado = unEstado;
    }
    
    

    

    
    
    //METODS GET Y SET

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
    
    //METODS toString

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fechaYHora=" + fechaYHora + ", unCliente=" + unCliente + ", unEstado=" + unEstado + '}';
    }

    
    
    
    //OTROS METODOS
    public void mostrar(){
        
    }
   
    
}
