/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
/* Creación de enumeracion Estado */
public enum Estado {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private String valor;

    /* Se crea constructor */
    private Estado(String valor) {
        this.valor = valor;
    }

//   @Override
//    public String toString() {
//        return "Estado{" + '}';
//    }    
    
    
    /* Modificacion del metodo toString() */
    @Override
    public String toString() {
        return valor;
    }
}
