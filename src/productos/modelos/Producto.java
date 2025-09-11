package productos.modelos;


public class Producto {
    int codigo;
    String descripcion;
    String categoria;
    String estado;
    float precio;
    
    public void mostrar() {
        System.out.println(codigo);
        System.out.println(descripcion);
        System.out.println(categoria);
        System.out.println(estado);
        System.out.println(precio);
        
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
}
