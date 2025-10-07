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

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("Codigo: " + verCodigo());
        System.out.println("Estado: " + verEstado());
        System.out.println("Descripcion: " + verDescripcion());
        System.out.println("Categoria: " + verCategoria());
        System.out.println("Precio: " + verPrecio());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
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

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria ca) {
        categoria = ca;
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

}
