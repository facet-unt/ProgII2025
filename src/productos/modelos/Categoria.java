/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

public enum Categoria {
    ENTRADA("Entrada"),
    PLATOPRINCIPAL("Plato principal"),
    POSTRE("Postre");

    private final String nombre;

    private Categoria(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
