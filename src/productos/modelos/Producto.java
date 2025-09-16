package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    public void mostrar(Producto unProducto) {
        System.out.println("Soy un producto");
        System.out.println("Codigo: " + unProducto.codigo);
        System.out.println("Descripcion: " + unProducto.descripcion);
        System.out.println("Categoria: " + unProducto.categoria);
        System.out.println("Estado: " + unProducto.estado);
        System.out.println("Precio: " + unProducto.precio);
    }
}
