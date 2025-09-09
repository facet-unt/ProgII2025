package principal.controladores;

import productos.modelos.Producto;


public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto unProducto = new Producto();
        unProducto.codigo= 100;
        unProducto.categoria= "Minutas";
        unProducto.descripcion="Milanesa";
        unProducto.estado="Disponible";
        unProducto.precio= 8000.4f;
        unProducto.mostrar();
    }
}
