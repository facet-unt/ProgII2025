/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import usuarios.vistas.VentanaModificarUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaModificarUsuarios {
    private VentanaUsuarios ventana;
    private VentanaModificarUsuarios ventana2;
    
    public ControladorVentanaModificarUsuarios(){
        ventana2 = new VentanaModificarUsuarios(ventana, this);
    }
}
