package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion, categoria, estado;
    public float precio;
    
    public void mostrar(){
        System.out.println("los datos de este producto son: ");
        System.out.println("Codigo"+codigo);
        System.out.println("Categoria: "+categoria);
        System.out.println("Estado: "+estado);
        System.out.println("Precio: "+ precio+ "$");
        System.out.println("Descripcion: "+descripcion);
    }

    @Override
    public String toString() {
        System.out.println("Los datos de este producto son: ");
        return "Producto" + "codigo=" + codigo + ", descripcion=" + descripcion + ", categoria=" + categoria + ", estado=" + estado + ", precio=" + precio;
    }

}
