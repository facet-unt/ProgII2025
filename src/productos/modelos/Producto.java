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

    public int obtenerCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        codigo = c;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        descripcion = d;
    }

    public String obtenerCategoria() {
        return categoria;
    }

    public void asignarCategoria(String ca) {
        categoria = ca;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void asignarEstado(String e) {
        estado = e;
    }

    public float obtenerPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }

}
