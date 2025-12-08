/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;
/**
 *
 * @author alumno
 */

public class Producto {

    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;
    private String nombre;

    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + this.codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria=" + categoria +
                ", estado=" + estado +
                ", precio=" + precio +
                '}';
    }

    // Constructores

    public Producto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        this.codigo= codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion, Categoria categoria, float precio) {
        this(codigo, descripcion, precio, categoria, Estado.DISPONIBLE); // Estado por defecto
    }

    public Producto(int codigo, String descripcion, float precio) {
        this(codigo, descripcion, precio, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE); // Categoria y estado por defecto
    }

    // Getters y setters

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
        precio = p;
    }

    public String verNombre(){
        return nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Producto producto = (Producto) obj;

        return codigo == producto.codigo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);
    }

}
