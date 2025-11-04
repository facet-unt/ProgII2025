package principal.controladores;

import Interfaces.IGestorProductos;
import Interfaces.IGestorUsuarios;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

public class ControladorPrincipalTP5 {
    public static void main(String[] args) {      
        IGestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATOPRINCIPAL, Estado.DISPONIBLE));
                        
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto, 1, "Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oducto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
        
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        System.out.println(gu.crearUsuario("cliente1@bar.com", "ApellidoCliente1", "NombreCliente1", Perfil.CLIENTE, "claveCliente1", "claveCliente1"));
        System.out.println(gu.crearUsuario("empleado1@bar.com", "ApellidoEmpleado1", "NombreEmpleado1", Perfil.EMPLEADO, "claveEmpleado1", "claveEmpleado1"));
        System.out.println(gu.crearUsuario("encargado1@bar.com", "ApellidoEncargado1", "NombreEncargado1", Perfil.ENCARGADO, "claveEncargado1", "claveEncargado1"));
                        
        for(Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }
        
        ArrayList<Usuario> usuariosBuscados = gu.buscarUsuarios("Empleado");
        for(Usuario u : usuariosBuscados) {
            u.mostrar();
        }
        
        Usuario unUsuario = gu.obtenerUsuario("cliente1@bar.com");
        System.out.println(gu.existeEsteUsuario(unUsuario));
    }
}