package productos.modelos;

public enum Categoria {
    ENTRADA,
    PLATO_PRINCIPAL,
    POSTRE;

    @Override
    public String toString() {
        switch (this) {
            case ENTRADA:
                return "Entrada";
            case PLATO_PRINCIPAL:
                return "Plato Principal";
            case POSTRE:
                return "Postre";
            default:
                return super.toString();
        }
    }
}
