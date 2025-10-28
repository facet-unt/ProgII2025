package productos.modelos;


public class Producto{
    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;

    public Producto(int c, String d, Categoria cat, Estado e, float p){
        codigo=c;
        descripcion=d;
        categoria=cat;
        estado=e;
        precio=p;
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
    
    
    public void mostrar() {
        System.out.println("\nSoy un producto");
        System.out.println("codigo: "+codigo);
        System.out.println("descripcion: "+descripcion);
        System.out.println("categoria: "+categoria);
        System.out.println("estado: "+estado);
        System.out.println("precio: "+precio);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.codigo;
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
}
