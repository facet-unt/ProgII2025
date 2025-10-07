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
<<<<<<< HEAD
    private Categoria unaCategoria;
    private Estado unEstado;
=======
>>>>>>> desarrollo
    private float precio;
    private Categoria categoria;
    private Estado estado;

    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
<<<<<<< HEAD
        System.out.println("Categoria: " + unaCategoria.verValor());
        System.out.println("Estado: " + unEstado.verValor());
        System.out.println("Precio: " + precio);
=======
        System.out.println("Precio: " + precio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
>>>>>>> desarrollo
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", categoria='" + unaCategoria.verValor() + '\'' +
                ", estado='" + unEstado.verValor() + '\'' +
                ", precio=" + precio +
                '}';
    }
<<<<<<< HEAD
    
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.unEstado = estado;        
        this.descripcion = descripcion;
        this.unaCategoria = categoria;
        this.precio = precio;
    }
    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.unEstado =  Estado.valueOf(estado.toUpperCase());        
        this.descripcion = descripcion;
        this.unaCategoria =  Categoria.valueOf(categoria.toUpperCase());
=======

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
>>>>>>> desarrollo
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }
<<<<<<< HEAD
    
    public Producto(int c, String d, Categoria cat, float p) {
        codigo = c;
        descripcion = d;
        unaCategoria = cat;
        precio = p;
    }
    
    public Producto(int c, String d, float p, Categoria cat) {
        this(c, d,cat, p);        
    }

    

=======
>>>>>>> desarrollo
   
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
<<<<<<< HEAD
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
=======
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
>>>>>>> desarrollo
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