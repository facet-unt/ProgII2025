/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;


/**
 *
<<<<<<< HEAD
 * @author estudiante
    
/**

=======

 * @author rocio

 */

/* Creacion de enumeracion Estado */
public enum Estado {
    CREADO("Creado"),
    SOLICITADO("Solicitando"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");
    
    private String valor;

    /* Se crea constructor */
    private Estado(String valor) {
        this.valor = valor;
    }

//    @Override
//    public String toString() {
//        return "{" + valor + '}';
//    }
    
    
    
    /* Modificacion del metodo toString() */
    @Override
    public String toString() {
        return valor;
    }
}

