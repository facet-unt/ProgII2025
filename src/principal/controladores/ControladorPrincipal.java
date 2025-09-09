package principal.controladores;

import productos.modelos.Producto;


public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto p = new Producto();
        p.codigo=25;
        p.descripcion="pizza";
        
        p.mostrar();
        System.out.println(p);
        
    }
}
