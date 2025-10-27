package productos.modelos;

public enum Estado {
    DISPONIBLE ("Disponible"),
    NODISPONIBLE("No Disponible");
    
    private String valor;
    
    private Estado (String valor){
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Estado{" + '}';
    }
}