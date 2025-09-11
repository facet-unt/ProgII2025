package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    public void mostrar() {
        System.out.println("codigo: " + codigo);
        System.out.println("descripcion: " + descripcion);
        System.out.println("categoria: " + categoria);
        System.out.println("estado: " + estado);
        System.out.println("precio: " + precio);
        
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
}
