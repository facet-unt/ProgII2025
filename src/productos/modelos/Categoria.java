/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public enum Categoria {
    ENTRADA("Entrada"),
    PLATO_PRINCIPAL("Plato principal"),
    POSTRE("Postre");

    private String valor;

    private Categoria(String valor) {
        this.valor = valor;
    }

    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }

    public static Categoria compararValor(String categoria) {
        Categoria[] valores = Categoria.values();
        for (Categoria unaCategoria : valores) {
            if (unaCategoria.equals(categoria)) {
                return unaCategoria;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.valor;
    }

}
