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
    
    /*Metodo que devuelve la categoria especificada por el nombre */ 
    public static Categoria convertir(String nombre){ 
        Categoria[] valores = Categoria.values();
        for(Categoria e: valores){
            if(e.toString().equals(nombre))
                return e;
        }
        return null;
    }

    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
      
    
}
