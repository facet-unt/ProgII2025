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
<<<<<<< HEAD


    // Métodos
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + unaCategoria.verValor());
        System.out.println("Estado: " + unEstado.verValor());
        System.out.println("Precio: " + precio);

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

    
=======
    private Estado estado;
    private Categoria categoria;

    //Creacion del constructor
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.unEstado = estado;        
        this.descripcion = descripcion;
<<<<<<< HEAD
        this.unaCategoria = categoria;
=======
        this.categoria = categoria;
        this.estado = estado;
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
        this.precio = precio;
    }
<<<<<<< HEAD
    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.unEstado =  Estado.valueOf(estado.toUpperCase());        
        this.descripcion = descripcion;
        this.unaCategoria =  Categoria.valueOf(categoria.toUpperCase());
    }

    
   
=======

>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
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
<<<<<<< HEAD
        unEstado = e;

=======

        estado = e;
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float p) {

        precio = p;

    }

    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    //Coloco el to string
//    @Override
//    public String toString() {
//        return "Producto{" +
//                "Codigo=" + codigo +
//                ", Descripcion='" + descripcion + '\'' +
//                ", Categoria='" + categoria + '\'' +
//                ", Estado='" + estado + '\'' +
//                ", Precio=" + precio +
//                '}';
//    }
    
    /* Modificacion del metodo toString() (correcion para que se vea mejor)*/
    @Override
    public String toString() {
        System.out.println("===== PRODUCTOS CON METODO TOSTRING() =====");
        return "Producto={" + "Codigo = " + codigo + ", Descripcion = " + descripcion + ", Precio = " + precio + ", Estado = " + estado + ", Categoria = " + categoria + '}';
    }
   
    
    /* Agregado de equals y hashcode (para comparar si dos productos son iguales en base al codigo ) */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.codigo;
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
<<<<<<< HEAD

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

    
}
=======
    
    
    

}
>>>>>>> bab1bcd08362a00f95816f8e4b980d38761f6b17
