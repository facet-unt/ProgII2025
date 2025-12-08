/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import productos.vistas.VentanaCrearProductos;
import productos.vistas.VentanaModificarProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author octav
 */
public class ControladorModificarProductos {
    private static ControladorModificarProductos instancia;
    private VentanaProductos ventanaProductos;
    private VentanaModificarProductos ventanaModificarProductos;
    
     public ControladorModificarProductos() {
        ventanaModificarProductos = new VentanaModificarProductos(ventanaProductos,this);
        ventanaProductos.setAlwaysOnTop(false);
        ventanaProductos.toBack();
    }
    
    public static ControladorModificarProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorModificarProductos();
        }
        return instancia;
    }    
}
