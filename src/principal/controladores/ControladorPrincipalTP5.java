package principal.controladores;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import pedidos.modelos.GestorPedidos;
import usuarios.modelos.Perfil;
/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
    public static void main(String[] args) {        
        IGestorProductos gp = GestorProductos.instanciar();
        System.out.println(gp.crearProducto(1, "Producto3", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(3, "Producto1", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
        System.out.println(gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
       
        for(Producto p : gp.menu()) {
            p.mostrar();
        }

        Producto unProducto = gp.obtenerProducto(1);
        System.out.println(gp.modificarProducto(unProducto,20,"Producto3", 2.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
        for(Producto p : gp.menu()) {
            p.mostrar();
        }
        
        ArrayList<Producto> productosBuscados = gp.buscarProductos("oductos");
        for(Producto p : productosBuscados) {
            p.mostrar();
        }
        
        System.out.println(gp.existeEsteProducto(unProducto));
        
        ArrayList<Producto> productosEntrada = gp.verProductosPorCategoria(Categoria.ENTRADA);
        for(Producto p : productosEntrada) {
            p.mostrar();
       }
    
    //parte para probar gestor usuarios
    IGestorUsuarios gu = GestorUsuarios.instanciar();
        System.out.println(gu.crearUsuario("correo@UNO", "usuarioUNO", "nombreUNO",Perfil.CLIENTE, "1234","587357"));
        System.out.println(gu.crearUsuario("correo@DOS", "usuarioDOS", "nombreDOS", Perfil.ENCARGADO, "9876","34543"));
        System.out.println(gu.crearUsuario("correo@CUATRO", "usuarioCUATRO", "nombreCUATRO", Perfil.EMPLEADO, "9999","9999"));
        System.out.println(gu.crearUsuario("correoTRES", "usuarioTRES", "nombreTRES", Perfil.CLIENTE, "6666","80987725"));
        for(Usuario u : gu.verUsuarios()) {
            u.mostrar();
        }
        Usuario unUsuario = gu.obtenerUsuario("correo@UNO");
        ArrayList<Usuario> usuariosBuscados = gu.buscarUsuarios("usuarioTRES");
        for(Usuario u : usuariosBuscados) {
            u.mostrar();
        }
        
        System.out.println(gu.existeEsteUsuario(unUsuario));
     
//parte para probar gestospedidose
        
        IGestorPedidos gP = GestorPedidos.instanciar();
//        System.out.println(gP.crearPedido(LocalDate.now(),LocalTime.now(),,gu.obtenerUsuario("correo@DOS")));
//        System.out.println(gP.crearPedido(LocalDate.now(),LocalTime.now(),gp.obtenerProducto(2),gu.obtenerUsuario("correo@UNO")));
//        System.out.println(gP.crearPedido(LocalDate.now(),LocalTime.now(),gp.obtenerProducto(3),gu.obtenerUsuario("correo@TRES")));
//                        
//        for(Pedido P : gP.verPedidos()) {
//            P.mostrar();
//        }
//        
//        Pedido unPedido = gP.obtenerPedido(2);
//        System.out.println(gP.cambiarEstado(unPedido));
//        
//       
//        System.out.println(gP.existeEstePedido(unPedido));
}
}
