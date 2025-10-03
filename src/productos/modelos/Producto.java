package productos.modelos;

public class Producto {

    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private String categoriagui;
    private String estadogui;
    private float precio;
    
    
    public void mostrar() {
        System.out.println("Producto\nCodigo=" + codigo + "\nDescripcion=" + descripcion +"\nCategoria=" + categoria + "\nEstado=" + estado + "\nPrecio=" + precio);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
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

    public void asignarCategoria(Categoria c) {
        categoria = c;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado e) {
        estado = e;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion, String categoriagui, String estadogui, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoriagui = categoriagui;
        this.estadogui = estadogui;
        this.precio = precio;
    }
}
