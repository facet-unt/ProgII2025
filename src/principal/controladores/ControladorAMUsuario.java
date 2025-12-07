/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import productos.modelos.ModeloComboPerfil;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author Erika
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    private VentanaAMUsuario ventanaU;
    private Usuario amUsuario=null;
    
    public ControladorAMUsuario(JDialog padre){
        this.ventanaU = new VentanaAMUsuario(padre, this);
        this.ventanaU.setLocationRelativeTo(null);
        this.ventanaU.setTitle(TITULO_NUEVO);
        this.ventanaU.verBotonG().setEnabled(false);
        this.ventanaU.setVisible(true);
    }
    
    public ControladorAMUsuario(JDialog padre, Usuario amUsuario){
        this.ventanaU = new VentanaAMUsuario(padre, this);
        this.ventanaU.setLocationRelativeTo(null);
        this.amUsuario=amUsuario;
        this.ventanaU.setTitle(TITULO_MODIFICAR);
        this.configurarCampos();
        this.ventanaU.setVisible(true);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
        String apellido = this.ventanaU.verTxtApellido().getText().trim();
        String nombre = this.ventanaU.verTxtNombre().getText().trim();
        String correo = this.ventanaU.verTxtCorreo().getText().trim();
        String clave = this.ventanaU.verTxtClave().getText().trim();
        String confirmacionClave = this.ventanaU.verTxtConfirmacionClave().getText().trim();
        Perfil perfil = ((ModeloComboPerfil) this.ventanaU.verComboPerfil().getModel()).obtenerPerfil();
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        String resultado;
        if (this.amUsuario==null) {
            resultado = gu.crearUsuario(correo, apellido, nombre, perfil, clave, confirmacionClave);
            if (!resultado.equals(IGestorUsuarios.EXITO)) {
                JOptionPane.showMessageDialog(null, resultado, TITULO_NUEVO, JOptionPane.ERROR_MESSAGE);

            } else {
                this.ventanaU.dispose();
            }
        }
        else{
            resultado = gu.modificarUsuarios(amUsuario, correo, apellido, nombre, perfil, clave, confirmacionClave);
            if (!resultado.equals(IGestorUsuarios.EXITO)) {
                JOptionPane.showMessageDialog(null, resultado, TITULO_NUEVO, JOptionPane.ERROR_MESSAGE);
            } else {
                this.ventanaU.dispose();
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado", "Usuarios", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaU.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        validarCampos();
    }
    
    private void validarCampos() {

        boolean apellidoV = this.ventanaU.verTxtApellido().getText().trim().isEmpty();
        boolean nombreV = this.ventanaU.verTxtNombre().getText().trim().isEmpty();
        boolean correoV = this.ventanaU.verTxtCorreo().getText().trim().isEmpty();
        boolean confClaveV = this.ventanaU.verTxtConfirmacionClave().getText().trim().isEmpty();
        boolean claveV = this.ventanaU.verTxtClave().getText().trim().isEmpty();
        this.ventanaU.verBotonG().setEnabled(!(apellidoV || nombreV || correoV||confClaveV||claveV));
    }
    
     private void configurarCampos() {
        if (this.amUsuario != null) {
            this.ventanaU.verTxtCorreo().setText(amUsuario.verCorreo());
            this.ventanaU.verTxtCorreo().setEnabled(false);
            this.ventanaU.verTxtApellido().setText(amUsuario.verApellido());
            this.ventanaU.verTxtNombre().setText(amUsuario.verNombre());
            this.ventanaU.verTxtClave().setText(amUsuario.verClave());
            this.ventanaU.verTxtConfirmacionClave().setText(amUsuario.verClave());
            ((ModeloComboPerfil) this.ventanaU.verComboPerfil().getModel()).seleccionarPerfil(amUsuario.verPerfil());

        }
    }
    
}
