/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

public enum Estado {
    
    
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private final String nombre;

    private Estado(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
