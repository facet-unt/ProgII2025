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
    @Override
    public String toString() {
        return valor;
    }



}
