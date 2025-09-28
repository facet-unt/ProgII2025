package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
    
    private Estado unEstado;
    private Categoria unaCategoria;
    private int codigo;
    private String descripcion;
    private float precio;

    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: " + precio);
    }

    @Override
    public String toString() {
        return "Producto{"
                + "codigo=" + codigo
                + ", descripcion='" + descripcion + '\''
                + ", precio=" + precio
                + '}';
    }

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.asignarCodigo(codigo);
        //this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }
}
