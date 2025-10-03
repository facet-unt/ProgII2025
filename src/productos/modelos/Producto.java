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
    private int codigo;
    private String descripcion;
    private float precio;
    private Categoria categoria;
    private Estado estado;

    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Precio: " + precio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + categoria + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Producto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }
   
    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        if (c > 0)
            codigo = c;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        if (d != null && !d.isBlank())
            descripcion = d;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria c) {
        categoria = c;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado e) {
            estado = e;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        if (p > 0){
            precio = p;
        }
    }
}