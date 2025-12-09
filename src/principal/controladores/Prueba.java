/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import productos.vistas.VentanaProductos;
import usuarios.vistas.VentanaUsuarios;
/**
 *
 * @author tobias150
 */
public class Prueba {
    public static void main(String[] args){
        IControladorPrincipal cp = ControladorVentanaPrincipal.instanciar();
        cp.ControladorVentana();
        
    
    } 
}
