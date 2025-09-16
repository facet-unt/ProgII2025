package productos.modelos;


public class Producto {
    int codigo;
    String descripcion;
    String categoria;
    String estado;
    float precio;
    
    void mostrar() {
        System.out.println("Codigo: "+codigo+"\nDescripcion: "+descripcion);
    }
    @Override
    public String toString() {
        return "Producto[Descripcion=" + descripcion + ", Estado=" + estado + "]";
    }
}
