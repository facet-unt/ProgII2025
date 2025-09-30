package productos.modelos;

import usuarios.modelos.Categoria;
import usuarios.modelos.Estado;


public class Producto {


    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;
    
    //Producto p1 = new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("Codigo: "+ codigo +"\nDescripcion: "+descripcion);
    }
    @Override
    public String toString() {
        return "Producto[Descripcion=" + descripcion + ", Estado=" + estado + "]\n";
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

    public Categoria verCategoria() {
        return categoria;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
}