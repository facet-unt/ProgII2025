/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import usuarios.modelos.*;
import usuarios.vistas.*;

/**
 *
 * @author juamp
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    
    private VentanaAMUsuario vp; //se instancia en constructor
    private Usuario usuarioAEditar;
    private boolean esModificacion = false;
    
     public ControladorAMUsuario() {
        this.vp = new VentanaAMUsuario(null, this);
        this.esModificacion = false; 
    }
     
     public void mostrarVentanaAMUsuario() {
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
        vp.setVisible(true);

    }
    
    
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vp.dispose();    
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void comboPerfilesPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
