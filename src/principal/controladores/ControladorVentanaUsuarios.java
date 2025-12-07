/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import static interfaces.IControladorPrincipal.TITULO;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author NEW GAME
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
     private VentanaUsuarios ventana;

    public ControladorVentanaUsuarios() {
        this.ventana = new VentanaUsuarios(null,true,this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
    
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        
        
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    }
    
}
