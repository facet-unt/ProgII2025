/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import usuarios.modelos.GestorUsuarios;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author Gaston
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    
    private static ControladorAMUsuario instancia;
    private VentanaAMUsuario vista;
    private IGestorUsuarios gestor;
    
    private ControladorAMUsuario() {
        this.gestor = GestorUsuarios.instanciar();
        this.vista = new VentanaAMUsuario(null, true, this);
    }
    public static ControladorAMUsuario instanciar() {
        if (instancia == null)
            instancia = new ControladorAMUsuario();
        return instancia;
    } 

    @Override
    public void btnGuardarClic(ActionEvent evt) {
    
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {

    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {

    }
    
}
