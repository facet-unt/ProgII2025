/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
<<<<<<< HEAD

=======
 *
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
 * @author estudiante
 */
/* Creación de enumeracion Estado */
public enum Estado {
<<<<<<< HEAD
    DISPONIBLE ("Disponible"),
    NO_DISPONIBLE ("No disponible");

    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
   

    private String valor;
    
    private Estado(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Estado{" + '}';
=======
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
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    }

}
