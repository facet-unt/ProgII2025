package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categorias: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }
        @Override
    public String toString() {
        return "Producto{Codigo: " + codigo + " Descripcion: " + descripcion + " Categoria: " + categoria + " Estado: " + estado + " Precio: " + precio;
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
    
    
    
    public void mostrar(){
        
        System.out.println("Hola, soy un producto");
    }
    //Agregar to string

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

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String c) {
        categoria = c;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String e) {
        estado = e;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        precio = p;
    }
}
