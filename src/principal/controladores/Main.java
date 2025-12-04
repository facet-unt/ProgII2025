/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;

/**
 *
 * @author thoma
 */
public class Main {
    public static void main(String[] args) {
        IControladorPrincipal cp = ControladorPrincipal.instanciar();
    }
    
}
