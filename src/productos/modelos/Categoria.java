package productos.modelos;

public enum Categoria {
    ENTRADA("Entrada"),
    PLATOPRINCIPAL("Plato Principal"),
    POSTRE("Postre");
    
    private String valor;
    
    private Categoria(String valor){
        this.valor = valor;
    }
    
    public static Categoria desdeTexto(String texto) {
        for (Categoria c : Categoria.values()) {
            if (c.toString().equalsIgnoreCase(texto.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Categoría inválida: " + texto);
    }
    
    @Override
    public String toString() {
        return valor ;
    }  
}