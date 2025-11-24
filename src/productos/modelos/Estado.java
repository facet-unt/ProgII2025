/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**

 * @author estudiante
 */
public enum Estado {
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
        return "Estado { " + valor + " }";
    }

}
