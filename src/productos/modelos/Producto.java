package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categorias: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }
        @Override
    public String toString() {
        return "Producto{Codigo: " + codigo + " Descripcion: " + descripcion + " Categoria: " + categoria + " Estado: " + estado + " Precio: " + precio;
    }
}
