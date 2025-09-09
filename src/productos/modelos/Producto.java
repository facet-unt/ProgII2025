package productos.modelos;


public class Producto {
    int codigo;
    String descripcion, categoria, estado;
    float precio;
    
    public void mostrar(){
        System.out.println("los datos de este producto son: ");
        System.out.println(codigo);
        System.out.println(categoria);
        System.out.println(estado);
        System.out.println(precio);
        System.out.println(descripcion);
    }
    
    @Override
    public String toString(){
    
        return null;
    
    }
    
}
