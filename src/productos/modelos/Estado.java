/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

import java.util.HashMap;
import java.util.Map;

/**

 * @author estudiante
 */
public enum Estado {
    DISPONIBLE ("Disponible"),
    NO_DISPONIBLE ("No disponible");

    private String valor;
    
    private Estado(String valor) {
        this.valor = valor;
    }
    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
   

    @Override
    public String toString() {
        return this.valor;
    }
    
    public static Estado verEstado(String estado) {
        Map<String, Estado> mapeo = new HashMap<>();
        for (Estado e : Estado.values()) {
            mapeo.put(e.toString(), e);
        }
        return mapeo.get(estado);
    }

}
