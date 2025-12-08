/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;
/**
 *
 * @author alumno
 */

import java.util.HashMap;
import java.util.Map;

public enum Estado {
    DISPONIBLE ("disponible"),
    NO_DISPONIBLE("No disponible");
 
     private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
     
    private Estado(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.valor;
    }
    
    public static Estado verEstado (String estado){
        Map<String, Estado> mapeo = new HashMap<>();
        for (Estado e : Estado.values()){
            mapeo.put(e.toString(), e);
        }
        return mapeo.get(estado);
    }
}
