package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {

    private Estado estado;
    private Categoria categoria;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigo;
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

 
    private int codigo;
    private String descripcion;
    private float precio;

    // Métodos

    public void mostrar() {
        System.out.println("Código: " + this.verCodigo());
        System.out.println("Descripción: " + this.verDescripcion());
        System.out.println("Categoría: " + this.verCategoria());
        System.out.println("Estado: " + this.verEstado());
        System.out.println("Precio: " + this.verPrecio());
        System.out.println("------------");
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + "\nDescripción: " + descripcion + "\nCategoría: " + categoria + "\nEstado: " + estado + "\nPrecio: " + precio;
    }

    public void mostrarProducto() {
        System.out.println("Información del Producto:\n" + this.toString());
    }




public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.asignarCodigo(codigo);
        //this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.categoria = categoria;
    }

    public Producto(int c, String d, String cat, float p) {
        codigo = c;
        descripcion = d;
        precio = p;
    }

    public Producto(int c, String d, float p) {
        this(c, d, "Plato principal", p);
    }

    //Agregar to string
    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        if (c > 0) {
            codigo = c;
        }
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        if (d != null && !d.isBlank()) {
            descripcion = d;
        }
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado unEstado) {
        this.estado = unEstado;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria unaCategoria) {
        this.categoria = unaCategoria;
    }


    
    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }
}
