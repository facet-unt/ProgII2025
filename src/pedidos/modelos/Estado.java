/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author Lucas
 */
public enum Estado {
       
    ECREADO("CREADO"), 
    SOLICITADO("SOLICITADO"), 
    PROCESANDO("PROCESANDO"),
    ENTREGADO("ENTREGADO");
    
    private String valor;

    private Estado(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
}