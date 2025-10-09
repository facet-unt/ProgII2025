package productos.modelos;

/**
 *
 * @author Esteban
 */
public class Producto {
    //Atributos
    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;

    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
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
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
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
        if (p > 0){
            precio = p;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
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
   
}