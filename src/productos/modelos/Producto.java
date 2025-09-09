package productos.modelos;


public class Producto {
    
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    
    public void mostrar() {
        System.out.println("Soy un producto");
        //IMPLEMNETO LO QUE QUIERO QUE HAGA
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
    
}
