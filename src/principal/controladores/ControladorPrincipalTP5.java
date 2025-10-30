package principal.controladores;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
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
        GestorUsuarios gu = GestorUsuarios.instanciar();
        GestorPedidos gpd = GestorPedidos.instanciar();
        
        
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
        
        System.out.println(gu.crearUsuario("correo@usuario1", "a1", "n1", Perfil.CLIENTE, "1234", "1234"));
        System.out.println(gu.crearUsuario("correo@usuario2", "a2", "n2", Perfil.ENCARGADO, "1234", "1234"));
        System.out.println(gu.crearUsuario("correo@usuario3", "a3", "n3", Perfil.CLIENTE, "1234", "1234"));
        System.out.println(gu.crearUsuario("correo@usuario1", "a1", "n1", Perfil.CLIENTE, "1234", "1234"));
        //correo repetido
        System.out.println(gu.crearUsuario("correo@usuario4", "a4", "n4", Perfil.CLIENTE, "1234", "1235"));
        //claves diferentes
        System.out.println(gu.crearUsuario("correo@usuario4", "", "n4", Perfil.CLIENTE, "1234", "1235"));
        //apellido vacío
        System.out.println(gu.crearUsuario("correo@usuario4", "a4", "", Perfil.CLIENTE, "1234", "1235"));
        //nombre vacío
        
        for(Usuario u: gu.verUsuarios()){
            u.mostrar();
        }
        
        Usuario u1 = gu.obtenerUsuario("correo@usuario1");
        System.out.println(gu.modificarUsuario(u1, "correo@usuario1", "nuevoApellido", "nuevoNombre", Perfil.CLIENTE, "1234", "1234"));
        System.out.println(gu.modificarUsuario(u1, "correo@usuario2", "nuevoApellido", "nuevoNombre", Perfil.CLIENTE, "1234", "1234"));
        //correo ya existente
        
        for(Usuario u: gu.verUsuarios()){
            u.mostrar();
        }
        
        for(Usuario u: gu.buscarUsuarios("a")){
            u.mostrar();
        }
        
        System.out.println(gu.existeEsteUsuario(u1));
        gu.obtenerUsuario("correo@usuario3").mostrar();
        
        ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
        ArrayList<ProductoDelPedido> listapdp2 = new ArrayList<>();
        //ArrayList vacío
        
        ProductoDelPedido pdp1 = new ProductoDelPedido(gp.menu().get(0), 100);
        ProductoDelPedido pdp2 = new ProductoDelPedido(gp.menu().get(1), 200);
        listapdp1.add(pdp1);
        listapdp1.add(pdp2);
        
        System.out.println(gpd.crearPedido(LocalDate.now(),LocalTime.now(),listapdp1,(Cliente)gu.obtenerUsuario("correo@usuario1") ));
        System.out.println(gpd.crearPedido(LocalDate.now(),LocalTime.now(),listapdp1,(Cliente)gu.obtenerUsuario("correo@usuario1") ));
        System.out.println(gpd.crearPedido(LocalDate.now(),LocalTime.now(),listapdp1,(Cliente)gu.obtenerUsuario("correo@usuario1") ));
        System.out.println(gpd.crearPedido(null,LocalTime.now(),listapdp1,(Cliente)gu.obtenerUsuario("correo@usuario1") ));
        //fecha vacía
        System.out.println(gpd.crearPedido(LocalDate.now(),LocalTime.now(),listapdp1,null ));
        //cliente vacío
        System.out.println(gpd.crearPedido(LocalDate.now(),LocalTime.now(),listapdp2,(Cliente)gu.obtenerUsuario("correo@usuario1") ));
        //productos vacíos
        
        for(Pedido p: gpd.verPedidos()){
            p.mostrar();
        }
        
        System.out.println(gpd.cambiarEstado(gpd.obtenerPedido(1)));
        System.out.println(gpd.cambiarEstado(gpd.obtenerPedido(2)));
        System.out.println(gpd.cambiarEstado(gpd.obtenerPedido(2)));
        
        for(Pedido p: gpd.verPedidos()){
            p.mostrar();
        }
        
        System.out.println(gpd.hayPedidosConEsteCliente((Cliente)gu.obtenerUsuario("correo@usuario1")));
        System.out.println(gpd.hayPedidosConEsteCliente((Cliente)gu.obtenerUsuario("correo@usuario3")));
        //cliente sin pedidos
        
        System.out.println(gpd.hayPedidosConEsteProducto(gp.menu().get(0)));
        System.out.println(gpd.hayPedidosConEsteProducto(gp.menu().get(2)));
        //producto sin pedidos
        
        Pedido p1 = new Pedido(4,LocalDateTime.now(),listapdp1,(Cliente)gu.obtenerUsuario("correo@usuario1"));
        //pedido sin guardar
        System.out.println(gpd.existeEstePedido(gpd.obtenerPedido(1)));
        System.out.println(gpd.existeEstePedido(p1));
        
        gpd.obtenerPedido(3).mostrar();
    }
}
