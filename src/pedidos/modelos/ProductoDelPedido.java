/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public class ProductoDelPedido {
    private int cantidad;
    private Producto unProducto;

    public ProductoDelPedido(int cantidad, Producto unProducto) {
        this.cantidad = cantidad;
        this.unProducto = unProducto;
    }

    public ProductoDelPedido() {
    }
    
    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto verUnProducto() {
        return unProducto;
    }

    public void asignarUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    
    
    
    
}
