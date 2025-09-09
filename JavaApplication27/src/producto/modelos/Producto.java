/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    
    public void mostrar(){
        System.out.println(codigo);
        System.out.println( descripcion);
        System.out.println(categoria);
        System.out.println(estado);
        System.out.println(precio);
        
    }
    
    public String toString() {
    String mensaje = codigo + "-" + descripcion + "-" + categoria + "-" + estado + "-" + precio;
    return mensaje;
    }

    
}
