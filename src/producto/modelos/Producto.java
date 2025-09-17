/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Producto.Modelos;

/**
 *
 * @author Asus
 */
public class Producto {
    public int codigo;
    public String descripcion;
    public String estado;
    public String categoria;
    public float precio;
    
    public void mostrar (){
        System.out.println("datos del producto: ");
        System.out.println("codigo: " +codigo);
        System.out.println("descripcion:" +descripcion);
        System.out.println("esatdo " +estado);
        System.out.println("categoria: " +categoria);
        System.out.println("precio: $" +precio);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + ", categoria=" + categoria + ", precio=" + precio + '}';
    }
    
    
}
