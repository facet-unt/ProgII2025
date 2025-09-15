package productos.modelos;


public class Producto {
    int codigo;
    String descripcion;
    String categoria;
    String estado;
    float precio;
    public void mostrar(Producto unProducto) {
        System.out.println("Soy un producto");
        System.out.println("Codigo: " + unProducto.codigo);
        System.out.println("Descripcion: " + unProducto.descripcion);
        System.out.println("Categoria: " + unProducto.categoria);
        System.out.println("Estado: " + unProducto.estado);
        System.out.println("Precio: " + unProducto.precio);
    }
}
