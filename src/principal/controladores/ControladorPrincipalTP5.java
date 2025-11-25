package principal.controladores;

import java.util.ArrayList;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        GestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
                        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        List<Producto> productosBuscados = gp.buscarProductos("producto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
//        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
//        for(Producto p : productosEntrada) {
//            p.mostrar();
//        }
    
        
        //implementacion del gestor de usuarios
    GestorUsuarios gu = GestorUsuarios.instanciar();
        System.out.println(gu.crearUsuario("cliente1@mail.com", "123", "Perez", Perfil.CLIENTE, "Juan", "123"));
        System.out.println(gu.crearUsuario("encargado@mail.com", "456", "Gomez", Perfil.ENCARGADO, "Ana", "456"));
        System.out.println(gu.crearUsuario("error@mail.com", "789", "Test", Perfil.CLIENTE, "Error", "000")); // Error clave
        System.out.println(gu.crearUsuario("cliente1@mail.com", "111", "Test", Perfil.CLIENTE, "Duplicado", "111")); // Error duplicado
        System.out.println(gu.crearUsuario("correo-invalido", "111", "Test", Perfil.CLIENTE, "Error", "111")); // Error correo

        for(Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }

        List<Usuario> usuario = gu.buscarUsuarios("perez");
            for(Usuario u : usuario) {
            u.mostrar();
        }
        }
    
    //a este main no le importa como se hace para crear un producto, o como se lo obtiene
    
    //pero le importa a quien le pido y que le paso, como le pido y que me devuelve
    
    //el main no le importa si los datos que envia son aceptados por el metodo, por lo que si no se puede
    //crear no es culpa de main, este no sabe como se hace
    
    
}
