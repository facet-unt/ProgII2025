/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;
/**
 *
 * @author alumno
 */

import java.util.Objects;
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

    public Producto verProducto() {
        return producto;
    }

    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido verPedido() {
        return pedido;
    }

    public void asignarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoDelPedido{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }

    
    
    //modifico equals para que no se repitan los pedidos
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.pedido);
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
        return Objects.equals(this.pedido, other.pedido);
    }
    
    
    
}
