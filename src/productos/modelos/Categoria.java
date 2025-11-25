package productos.modelos;

import java.util.HashMap;
import java.util.Map;

public enum Categoria {
    ENTRADA,   //cambiar el switch
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
    
    public static Categoria verCategoria (String categoria){
        Map<String, Categoria> mapeo = new HashMap<>();
        for (Categoria c : Categoria.values()){
            mapeo.put(c.toString(), c);
        }
        return mapeo.get(categoria);
    }
}
