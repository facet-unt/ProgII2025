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

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar(){
        System.out.println("Codigo: "+ codigo);
    }
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int c) {
        codigo = c;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String d) {
        descripcion = d;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String ca) {
        categoria = ca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String e) {
        estado = e;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float p) {
        precio = p;
    }

}
