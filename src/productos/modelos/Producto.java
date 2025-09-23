package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;

    public Producto(int c, String d, String ca, String e, float p) {
        codigo = c;
        descripcion = d;
        categoria = ca;
        estado = e;
        precio = p;
    }
    
    public void mostrar(){
        System.out.println("Codigo: "+ codigo);
    }
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        codigo = c;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        descripcion = d;
    }

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String ca) {
        categoria = ca;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String e) {
        estado = e;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }

}
