/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gaston
 */
public class ControladorProductos implements IControladorProductos{
    
    private static ControladorProductos instancia;
    public static ControladorProductos instanciar(){
        if(instancia == null)
            instancia = new ControladorProductos();
        return instancia;
    }
    private ControladorProductos(){
        
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void btnVolverClic(ActionEvent evt) {

    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {

    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {

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
    
}
