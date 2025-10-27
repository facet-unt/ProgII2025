/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
/* Creación de enumeracion Categoria */
public enum Categoria {
<<<<<<< HEAD
    ENTRADA ("Entrada"),
    PLATO_PRINCIPAL ("Plato principal"),
    POSTRE ("Postre");
    
    private String valor;

    private Categoria(String valor) {
        this.valor = valor;
    }
    
=======
    ENTRADA("Entrada"),
    PLATO_PRINCIPAL("Plato Principal"),
    POSTRE("Postre");

    private String valor;

    /* Se crea constructor */
    private Categoria(String valor) {
        this.valor = valor;
    }

//    @Override
//    public String toString() {
//        return "{" + ", name=" + name() + '}';
//    }
//    
    /* Modificacion del metodo toString()*/
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    @Override
    public String toString() {
        return valor;
    }
<<<<<<< HEAD
    
    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
      
    
=======



>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
}
