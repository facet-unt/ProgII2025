/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import usuarios.modelos.GestorUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author lazar
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
    private VentanaUsuarios ventana;
    IGestorUsuarios gp = GestorUsuarios.instanciar();
    
    public ControladorVentanaUsuarios() {
        this.ventana = new VentanaUsuarios(ventana,gp.verUsuarios());
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
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
    }
}
