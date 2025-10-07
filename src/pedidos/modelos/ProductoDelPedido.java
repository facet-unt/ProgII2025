package pedidos.modelos;

import productos.modelos.Producto;

public class ProductoDelPedido {
    private Producto producto;
    private Pedido pedido; // opcional
    private int cantidad;

    // Constructor simple sin el Pedido
    public ProductoDelPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Constructor completo (si lo necesitás)
    public ProductoDelPedido(Producto producto, Pedido pedido, int cantidad) {
        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoDelPedido{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
}
