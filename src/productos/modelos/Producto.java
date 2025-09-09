package productos.modelos;


public class Producto {
    int codigo;
    String descripcion;
    String categoria;
    String estado;
    float precio;
    public void mostrar() {
        System.out.println("Soy un producto");
        System.out.println("Descripcion: " + descripcion);
    }
}
