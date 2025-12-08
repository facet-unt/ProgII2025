/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author Ruben
 */
public class ControladorUsuarios implements IControladorUsuarios{
    
    private VentanaUsuarios vu;
    private GestorUsuarios gu;
    
    private boolean modificar=false; 

    public ControladorUsuarios() {
        this.vu = new VentanaUsuarios(this);
        this.gu= new GestorUsuarios();
        vu.setVisible(true);
        vu.setLocationRelativeTo(null);
        ModeloTablaUsuarios model = new ModeloTablaUsuarios();
        vu.gettablaUsuario().setModel(model);
        
    }
    

    @Override
    public void btnNuevoClic(ActionEvent evt) {
     ControladorAMUsuarios camu = new ControladorAMUsuarios(modificar);    
        
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        modificar=true;
        
        int fila = vu.gettablaUsuario().getSelectedRow();
        Usuario usuario= gu.verUsuarios().get(fila);
        ControladorAMUsuarios camu = new ControladorAMUsuarios(usuario,modificar); 
        modificar=false;
        
        
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    
}
}
