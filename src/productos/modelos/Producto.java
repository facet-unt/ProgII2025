package productos.modelos;


public class Producto {
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;

    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: " + estado);
        System.out.println("Precio: " + precio);
    }

    @Override
public String toString() {
    return "Producto{\n" +
           "  Codigo='" + codigo + "',\n" +
           "  Descripcion='" + descripcion + "',\n" +
           "  Categoria='" + categoria + "',\n" +
           "  Estado='" + estado + "',\n" +
           "  Precio=" + precio + "\n" +
           '}';
}


    // método main dentro de la misma clase
    public static void main(String[] args) {
        Producto unProducto = new Producto();
        unProducto.codigo = 10;
        unProducto.descripcion = "Sandwich";
        unProducto.categoria = "Hamburguesa";
        unProducto.estado = "Disponible";
        unProducto.precio = 20000.0f;

        unProducto.mostrar();              // Muestra cada atributo por separado
        System.out.println(unProducto);    // Llama a toString()
    }
}






/*public class Producto {
    public void mostrar() {
        System.out.println("Soy un producto");
    }
}*/
