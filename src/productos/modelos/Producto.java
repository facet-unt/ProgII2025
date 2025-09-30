package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {


    private int codigo;
    private String descripcion;
    private Categoria unaCategoria;
    private Estado unEstado;
    private float precio;


    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + unaCategoria.verValor());
        System.out.println("Estado: " + unEstado.verValor());
        System.out.println("Precio: " + precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + unaCategoria.verValor() + '\'' +
                ", estado='" + unEstado.verValor() + '\'' +
                ", precio=" + precio +
                '}';
    }
    
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.unEstado = estado;        
        this.descripcion = descripcion;
        this.unaCategoria = categoria;
        this.precio = precio;
    }
    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.unEstado =  Estado.valueOf(estado.toUpperCase());        
        this.descripcion = descripcion;
        this.unaCategoria =  Categoria.valueOf(categoria.toUpperCase());
        this.precio = precio;
    }
    
    public Producto(int c, String d, Categoria cat, float p) {
        codigo = c;
        descripcion = d;
        unaCategoria = cat;
        precio = p;
    }
    
    public Producto(int c, String d, float p, Categoria cat) {
        this(c, d,cat, p);        
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
        return unaCategoria;
    }

    public void asignarCategoria(Categoria c) {
        unaCategoria = c;
    }

    public Estado verEstado() {
        return unEstado;
    }

    public void asignarEstado(Estado e) {
        unEstado = e;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }

    
}