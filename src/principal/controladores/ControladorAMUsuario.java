/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.EXITO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfiles;
import usuarios.modelos.Perfil;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author salut
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    private VentanaAMUsuario ventana;
    private boolean nuevoUsuario;
    
    public ControladorAMUsuario(VentanaUsuarios ventanaPadre, boolean nuevoUsuario){
        this.nuevoUsuario = nuevoUsuario;
        this.ventana = new VentanaAMUsuario(ventanaPadre,this);
        this.ventana.setLocationRelativeTo(null);
        if(nuevoUsuario){
            this.ventana.setTitle(TITULO_NUEVO);
        }else{
            this.ventana.setTitle(TITULO_MODIFICAR);
        }
        ModeloComboPerfiles mcp = new ModeloComboPerfiles();
        JComboBox<String> comboPerfil = this.ventana.verComboBoxPerfil();
        comboPerfil.setModel(mcp);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        if(nuevoUsuario){
            char[] clave1Char = this.ventana.verCampoClave1().getPassword();
            String clave1 = new String(clave1Char);
            char[] clave2Char = this.ventana.verCampoClave2().getPassword();
            String clave2 = new String(clave2Char);
            String correo = this.ventana.verCampoTextoCorreo().getText().trim();
            String apellido = this.ventana.verCampoTextoApellido().getText().trim();
            String nombre = this.ventana.verCampoTextoNombre().getText().trim();
            Perfil perfil = (Perfil) this.ventana.verComboBoxPerfil().getSelectedItem();
            if (!gu.crearUsuario(correo, apellido, nombre, perfil, clave1, clave2).equals(IGestorUsuarios.EXITO)) {
                JOptionPane.showMessageDialog(this.ventana, gu.crearUsuario(correo, apellido, nombre, perfil, clave1, clave2),"Error al crear el Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }
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
