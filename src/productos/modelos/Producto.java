package productos.modelos;

public class Producto {
    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar() {    
        System.out.println("-- PRODUCTO --");
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria.toString());
        System.out.println("Estado: " + estado.toString());
        System.out.println("Precio: " + precio);
    }
    
    public int verCodigo(){
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
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
}