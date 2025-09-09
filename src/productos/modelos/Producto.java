package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    public void mostrar() {
        System.out.println("Producto: "+codigo +" "+descripcion);
    }
}

