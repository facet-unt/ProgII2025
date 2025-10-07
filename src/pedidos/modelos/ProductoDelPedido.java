package pedidos.modelos;

import productos.modelos.Producto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP Casa
 */
public class ProductoDelPedido {
    private int  cantidadProducto;
    private Producto prod;

    public ProductoDelPedido(int cantidadProducto, Producto prod) {
        this.cantidadProducto = cantidadProducto;
        this.prod = prod;
    }

    public int verCantidadProducto() {
        return cantidadProducto;
    }

    public void asignarCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Producto verProd() {
        return prod;
    }

    public void asignarProd(Producto prod) {
        this.prod = prod;
    }   
}