package productos.modelos;


public class Producto {
    
    //atributos
    private int codigo;
    private String descripcion;
    private float precio;
    private String estado;
    private String categoria;
    
    //método mostrar
    public void mostrar() {
        System.out.println("Codigo: " + codigo + "\nDescripcion: " + descripcion + "\nCategoria: " + categoria + "\nEstado: " + estado + "\nPrecio: " + precio);
    }

    @Override
    public String toString() {
        return "Producto:" + codigo + " - " + descripcion;
    }
    
    
    //Constructor
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    //métodos get y set
    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }
}
