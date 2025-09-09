package productos.modelos;


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
    }
}
