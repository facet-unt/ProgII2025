package productos.modelos;

public enum Estado {
    DISPONIBLE,
    NO_DISPONIBLE;

    @Override
    public String toString() {
        switch (this) {
            case DISPONIBLE:
                return "Disponible";
            case NO_DISPONIBLE:
                return "No disponible";
            default:
                return super.toString();
        }
    }
}
