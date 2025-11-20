/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author estudiante
 */
public enum Categoria {
    ENTRADA ("Entrada"),
    PLATO_PRINCIPAL ("Plato principal"),
    POSTRE ("Postre");
    
    private String valor;

    private Categoria(String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.valor;
    }
    
    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
      
    public static Categoria verCategoria(String categoria) {
        Map<String, Categoria> mapeo = new HashMap<>();
        for (Categoria c : Categoria.values()) {
            mapeo.put(c.toString(), c);
        }
        return mapeo.get(categoria);
    }
}
