/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author octav
 */
public class ProductoDelPedido {
    private int cantidad;

public ProductoDelPedido(){
    
}
public int verCantidad(){
    return cantidad;
}
public void asignarCantidad(int cantidad){
    this.cantidad=cantidad;
}
}