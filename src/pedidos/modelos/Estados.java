/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author Lucas
 */
//Se cambió el nombre de la variable a "Estados" de pedidos.modelos para evitar conflictos con la clase "Estado" del producto.modelo
public enum Estados {
       
    CREADO("CREADO"), 
    SOLICITADO("SOLICITADO"), 
    PROCESANDO("PROCESANDO"),
    ENTREGADO("ENTREGADO");
    
    private String valor;

    private Estados(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}