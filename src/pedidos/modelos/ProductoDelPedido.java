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
    private Producto producto;

    public ProductoDelPedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    public void AsignarNumero(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int verNumero() {
        return cantidad;
    }
        
    public void AsignarProducto (Producto producto) {
        this.producto = producto;
    }
    
    public Producto verProducto(){
        return producto;
    }

    @Override
    public String toString() {
        return String.format("%s\t\t\t\t%d",producto.verDescripcion(), cantidad);
    }
       
}



