/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.Objects;
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

    public Producto getUnproducto(){
        return unproducto;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void asignarUnproducto(Producto unproducto) {
        this.unproducto = unproducto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.unproducto);
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
        return Objects.equals(this.unproducto, other.unproducto);
    }
     
        // Constructor
    public ProductoDelPedido(Producto unproducto, int cantidad) {
        this.cantidad = cantidad;
        this.unproducto = unproducto;
    }
    
    
}
