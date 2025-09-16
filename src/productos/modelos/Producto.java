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
    private String categoria;
    private String estado;
    private float precio;
    
    //Metodos
    public void mostrar(){
        System.out.println("cod.: " + codigo + " Descripcion: "+ descripcion);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio + '}';
    }
    
    //constructor
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
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

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String c) {
        if (categoria != null && !c.isBlank()){
            categoria = c;
        }
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String e) {
        if (categoria != null && !e.isBlank()){
            estado = e;
        }
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