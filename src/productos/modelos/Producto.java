package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
// lo nuestro (lo pasé a privado a los atributos)
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
    public void mostrar(Producto unProducto) {
        System.out.println("Soy un producto");
        System.out.println("Codigo: " + unProducto.codigo);
        System.out.println("Descripcion: " + unProducto.descripcion);
        System.out.println("Categoria: " + unProducto.categoria);
        System.out.println("Estado: " + unProducto.estado);
        System.out.println("Precio: " + unProducto.precio);
// lo del ingeniero
 } 
    public void mostrar(){
        
        System.out.println("Hola, soy un producto");
    }
    //Agregar to string

    //@Override
    public Producto (int c,String descripcion, String categoria,String estado,float precio)
    {
        
    }
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
