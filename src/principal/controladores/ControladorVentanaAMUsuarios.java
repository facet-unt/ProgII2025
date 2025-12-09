/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.vistas.VentanaAMUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaAMUsuarios implements IControladorAMUsuario{
    private VentanaAMUsuarios ventana;
    private VentanaPrincipal ventanaprincipal;
    private ModeloTablaUsuarios modelo;
    private IControladorAMUsuario controlador;
    private static ControladorVentanaAMUsuarios instancia;
    
    private ControladorVentanaAMUsuarios(){
        this.ventana = new VentanaAMUsuarios(ventanaprincipal, controlador);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
        this.ventana.setLocationRelativeTo(null);
    }
    
    public static ControladorVentanaAMUsuarios instanciar(){
        if(instancia == null){
            instancia = new ControladorVentanaAMUsuarios();
        }
        return instancia;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
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
    
    
}
