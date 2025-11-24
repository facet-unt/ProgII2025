package principal.controladores;

import java.io.File;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import static productos.modelos.GestorProductos.ARCHIVO;

public class ControladorPrincipal {

    public static void main(String[] args) {

        GestorProductos gp = GestorProductos.instanciar();

        System.out.println(gp.crearProducto(12, "Testeo de archivo2", 102, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(13, "Testeo de archivo3", 102, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(12, "Testeo de archivo40", 102, Categoria.ENTRADA, Estado.DISPONIBLE));
System.out.println("Archivo real: " + new File(ARCHIVO).getAbsolutePath());
    }
}
