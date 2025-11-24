/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author lazar
 */
public enum Categoria {
    ENTRADA("Entrada"),
    PLATO_PRINCIPAL("Plato principal"),
    POSTRE("Postre");
    
    private String valor;

    private Categoria(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
    public static Categoria verCategoria(String p){
        for(Categoria e:Categoria.values()){
            if (p.equals(e.valor)) {
                return e;
            }
        }
        return null;
    }
}
