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


    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Estado: " + this.estado);
        System.out.println("Precio: " + precio);
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
        //this.asignarCodigo(codigo);
        this.codigo = codigo;
        //this.estado = Estado;        
        this.descripcion = descripcion;
        //this.categoria = Categoria;
        this.precio = precio;
    }
    
//    public Producto(int c, String d, String cat, float p) {
//        codigo = c;
//        descripcion = d;
//        categoria = cat;
//        precio = p;
//    }
    
//    public Producto(int c, String d, float p) {
//        this(c, d, "Plato principal", p);        
//    }

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

//    public String verCategoria() {
//        return categoria;
//    }

//    public void asignarCategoria(String c) {
//        categoria = c;
//    }
//
//    public String verEstado() {
//        return estado;
//    }
//
//    public void asignarEstado(String e) {
//        estado = e;
//    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }
}