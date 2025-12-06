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
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author thoma
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    
    private static ControladorAMUsuario instancia;
    private VentanaAMUsuario ventana;
    private ModeloComboPerfil modeloPerfil;
    
    private ControladorAMUsuario() {
        this.ventana = new VentanaAMUsuario(this);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        
        this.modeloPerfil = new ModeloComboPerfil();
        this.ventana.definirComboPerfil(modeloPerfil);
    }
    
    public static ControladorAMUsuario instanciar() {
        if (instancia == null) {
            instancia = new ControladorAMUsuario();
        }
        
        instancia.ventana.setVisible(true);
        
        return instancia;
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String correo = this.ventana.verTxtCorreo().getText().trim();
        String clave = this.ventana.verPassClave().getText().trim();
        String claveRepetida = this.ventana.verPassClaveRepetida().getText().trim();
        String apellido = this.ventana.verTxtApellido().getText().trim();
        String nombre = this.ventana.verTxtNombre().getText().trim();
        Perfil perfil = ((ModeloComboPerfil)this.ventana.verComboPerfiles().getModel()).obetenerPerfil();
        
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        
        String resultado = gu.crearUsuario(correo, clave, apellido, nombre, perfil, claveRepetida);
        
        System.out.println(resultado);
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
