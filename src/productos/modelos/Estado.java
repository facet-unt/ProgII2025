package productos.modelos;

public enum Estado {
    DISPONIBLE ("Disponible"),
    NODISPONIBLE("No Disponible");
    
    private String valor;
    
    private Estado (String valor){
        this.valor = valor;
    }
    
    public static Estado desdeTexto(String texto) {
        for (Estado e : Estado.values()) {
            if (e.toString().equalsIgnoreCase(texto.trim())) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado inválido: " + texto);
    }
    
    @Override
    public String toString() {
        return valor;
    }
}