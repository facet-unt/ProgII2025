/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;
/**
 *
 * @author alumno
 */

import principal.vistas.VentanaPrincipal;
import principal.controladores.ControladorVentanaPrincipal;
import Interfaces.IControladorPrincipal;


public class PrincipalControladorVentana {
    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        new ControladorVentanaPrincipal(vista);
        vista.setVisible(true);
    }
}

