/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Esteban
 */
public class Producto {
    //Atributos
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    //Metodos
    public void mostrar(){
        System.out.println("cod.: " + codigo + " Descripcion: "+ descripcion);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
}
