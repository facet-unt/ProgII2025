/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author NEW GAME
 */
public enum EstadoPedido {   
    
    CREADO("Creado"),
    
    SOLICITADO("Solicitado"),
    
    PROCESANDO("Procesando"),
    
    ENTREGADO("Entregado");
    
    private String estado;  
    
     private EstadoPedido(String estado)
    {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.estado;
    }
    
    
    
    
}
