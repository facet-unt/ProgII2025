/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Esteban
 */
public enum Estado {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No Disponible");
    
    private String valor;
    
    //Constructor
    private Estado(String valor){
        this.valor=valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
