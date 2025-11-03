package productos.modelos;

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
}
