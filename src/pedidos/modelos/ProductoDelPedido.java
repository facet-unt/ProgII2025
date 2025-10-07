package pedidos.modelos;

import productos.modelos.Producto;

public class ProductoDelPedido {
    private Producto producto;
    private int cantidad;

    public ProductoDelPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto verProducto() {
        return producto;
    }

    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }

    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrar(){
        System.out.println("\t\t" + verProducto().verDescripcion()+ "\t\t" + verCantidad());
    }
}

