/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author Lucas
 */
//Se cambió el nombre de la variable a "Estado" de pedidos.modelos para evitar conflictos con la clase "Estado" del producto.modelo
public enum Estado {
       
    CREADO("CREADO"), 
    SOLICITADO("SOLICITADO"), 
    PROCESANDO("PROCESANDO"),
    ENTREGADO("ENTREGADO"),;
    
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}