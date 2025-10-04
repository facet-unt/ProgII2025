/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto.modelos;

/**
 *
 * @author Asus
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private String estado;
    private String categoria;
    private float precio;
    
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado + ", categoria=" + categoria + ", precio=" + precio + '}';
    }

    public Producto(int codigo, String descripcion, String estado, String categoria, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoria = categoria;
        this.precio = precio;
    }

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }
    
    
}