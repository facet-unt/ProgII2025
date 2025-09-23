package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {


    private int codigo;
    private String descripcion;
    private float precio;
    private Estado estado; 
    private Categoria categoria;
    //Creo el constructor

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public Producto() {
    }
   
    // Métodos
    
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
    
    public void mostrar(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    //Coloco el to string
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