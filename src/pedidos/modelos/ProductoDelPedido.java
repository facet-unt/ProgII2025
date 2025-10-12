package pedidos.modelos;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDelPedido other = (ProductoDelPedido) obj;
        return Objects.equals(this.producto, other.producto);
    }
    
    
}

