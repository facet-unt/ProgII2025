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
    public String toString(){
        return this.valor;
    }
    
    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }
//    public static Categoria desdeString(String texto) {
//        for (Categoria c : Categoria.values()) {
//            if (c.valor.equalsIgnoreCase(texto.trim())) {
//                return c;
//            }
//        }
//        throw new IllegalArgumentException("Estado inválido: " + texto);
   public static Categoria leerValor(String texto) {
        if (texto == null) 
            return null;
        texto = texto.toUpperCase();
        if(texto.compareTo(ENTRADA.toString()) == 0){
            return ENTRADA;
        }
        else if(texto.compareTo(PLATO_PRINCIPAL.toString()) == 0)
            return PLATO_PRINCIPAL;
        else
            return POSTRE;
        }
}
