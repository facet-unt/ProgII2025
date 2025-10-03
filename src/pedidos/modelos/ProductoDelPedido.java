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
    private Producto unproducto;

    public int verCantidad() {
        return cantidad;
    }

    public String verUnproducto() {
        return unproducto.verDescripcion();
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void asignarUnproducto(Producto unproducto) {
        this.unproducto = unproducto;
    }
    
    public ProductoDelPedido(int cantidad, Producto unproducto) {
        this.cantidad = cantidad;
        this.unproducto = unproducto;
    }
    
    
}
