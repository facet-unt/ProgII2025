package principal.controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import pedidos.modelos.Pedido;
import pedidos.modelos.GestorPedidos;





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
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oducto");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
        }
         GestorUsuarios gu = GestorUsuarios.instanciarclase();
        System.out.println(gu.crearUsuario("cliente1@bar.com", "Toledo", "Juan", Perfil.CLIENTE,"holasi","holasi"));
        System.out.println(gu.crearUsuario("encargado2@bar.com","Peréz", "Tomás", Perfil.ENCARGADO,"tegarcho","tegarcho"));
        System.out.println(gu.crearUsuario("empleado3@bar.com","Callejas", "Tomas", Perfil.EMPLEADO,"killyou","killyou"));
        System.out.println(gu.crearUsuario("cliente2@bar.com", "Palavecino", "Juan", Perfil.CLIENTE,"holasi","holasi"));
        System.out.println(gu.crearUsuario("cliente4@bar.com", "Rush", "Juan", Perfil.CLIENTE,"holasi","holasi"));
        System.out.println(gu.crearUsuario("cliente5@bar.com", "Marsilli", "Juan", Perfil.CLIENTE,"holasi","holasi"));
        for(Usuario u :gu.verUsuarios()) {
            u.mostrar();
        }
       
        Usuario unUsuario = gu.obtenerUsuario("cliente1@bar.com");
       
        ArrayList<Usuario> UsuarioBuscado = gu.buscarUsuarios("Toledo");
        for(Usuario u : UsuarioBuscado) {
            u.mostrar();
    }
       
        System.out.println(gu.existeEsteUsuario(unUsuario));

    }
    }    
        
    
    

    
    
