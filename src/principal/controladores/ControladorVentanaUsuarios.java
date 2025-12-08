/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author NEW GAME
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
    private VentanaUsuarios ventana;
    private VentanaPrincipal ventanaprincipal; 
    private ModeloTablaUsuarios modelotabla;

    public ControladorVentanaUsuarios() {
        this.ventana = new VentanaUsuarios(ventanaprincipal,true,this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.modelotabla = new ModeloTablaUsuarios();
    }
    
    public ModeloTablaUsuarios modelo(){
        return modelotabla;
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
        this.ventana.requestFocusInWindow();
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
