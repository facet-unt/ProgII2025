package productos.modelos;

<<<<<<< HEAD

public class Producto 
{
    int codigo;
    String descripcion;
    String categoria;
    String estado;
    float precio;
    void mostrar()
    {
        System.out.println("------ DATOS DEL PRODUCTO ------");
        System.out.println("Descripcion : " + descripcion);
        System.out.println("\n");
        System.out.println("Categoria : " + categoria);
        System.out.println("\n");
        System.out.println("Estado : " + estado);
        System.out.println("\n");
        System.out.println("Precio  : " + estado);
        System.out.println("\n--------------------------------");
    }
    public void mostrar(String[] args) {
        /*Producto unproducto = new Producto();
        unproducto.codigo = 24;
        unproducto.descripcion = "Matambre con guarnicion";
        unproducto.estado = "Disponible";
        unproducto.precio = 2.45f;
        System.out.println(unproducto);*/
=======
/**
 *
 * @author estudiante
 */
public class Producto {
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
>>>>>>> origin
    }
}
