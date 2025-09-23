/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package producto.modelos;

/**
 *
 * @author Asus
 */
public enum categoria {
    ENTRADA("Entrada"),
    PLATOPRINCIPAL("Pato principal"),
    POSTRE("Postre");
    
    private String valor;

    private categoria(String valor) {
        this.valor = valor;
    }
       
     public String tostring() {
         return this.valor;
     }
}
