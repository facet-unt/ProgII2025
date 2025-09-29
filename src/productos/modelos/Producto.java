package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {


    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;


    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }
    
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.estado = estado;        
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    public Producto(int c, String d, Categoria categoria, float p) {
        codigo = c;
        descripcion = d;
        this.categoria = categoria;
        precio = p;
    }
    
    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        if (c > 0)
            codigo = c;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        if (d != null && !d.isBlank())
            descripcion = d;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado ;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }
    
     
    
}