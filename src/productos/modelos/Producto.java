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

    private int codigo;
    private String descripcion;
    private Categoria unaCategoria;
    private Estado unEstado;
    private float precio;

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.unEstado = estado;
        this.descripcion = descripcion;
        this.unaCategoria = categoria;
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.unEstado = Estado.valueOf(estado.toUpperCase());
        this.descripcion = descripcion;
        this.unaCategoria = Categoria.valueOf(categoria.toUpperCase());
    }

    public int verCodigo() {
        return codigo;
    }

    public void asignarCodigo(int c) {
        if (c > 0) {
            codigo = c;
        }
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String d) {
        if (d != null && !d.isBlank()) {
            descripcion = d;
        }
    }

    public Categoria verCategoria() {

        return unaCategoria;
    }

    public void asignarCategoria(Categoria c) {
        unaCategoria = c;
    }

    public Estado verEstado() {
        return unEstado;
    }

    public void asignarEstado(Estado e) {
        unEstado = e;

    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {
        if (p > 0) {
            precio = p;
        }
    }

    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + unaCategoria.verValor());
        System.out.println("Estado: " + unEstado.verValor());
        System.out.println("Precio: " + precio);

    }

    @Override
    public String toString() {
        return "Producto{"
                + "codigo=" + codigo
                + ", descripcion='" + descripcion + '\''
                + ", categoria='" + unaCategoria.verValor() + '\''
                + ", estado='" + unEstado.verValor() + '\''
                + ", precio=" + precio
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.codigo;
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
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    }

    public int compareTo(String anotherString) {
        return (descripcion.toLowerCase()).compareTo(anotherString.toLowerCase());
    }

    public final int compareTo(Categoria o) {
        return unaCategoria.compareTo(o);
    }

}
