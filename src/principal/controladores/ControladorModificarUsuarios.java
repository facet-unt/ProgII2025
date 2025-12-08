/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import usuarios.vistas.VentanaModificarUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author octav
 */
public class ControladorModificarUsuarios {
    private static ControladorModificarUsuarios instancia;
    private VentanaUsuarios ventanaUsuarios;
    private VentanaModificarUsuarios ventanaModificarUsuarios;
    
     public ControladorModificarUsuarios() {
        ventanaModificarUsuarios = new VentanaModificarUsuarios(ventanaUsuarios,this);
        ventanaUsuarios.setAlwaysOnTop(false);
        ventanaUsuarios.toBack();
    }
    
    public static ControladorModificarUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ControladorModificarUsuarios();
        }
        return instancia;
    }    
}
