/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.VALIDACION_EXITO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.vistas.VentanaAMUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author tobias150
 */
public class ControladorVentanaAMUsuarios implements IControladorAMUsuario{
    private VentanaAMUsuarios ventana;
    private static ControladorVentanaAMUsuarios instancia;
    private ModeloComboPerfil modelo = new ModeloComboPerfil();
    private IGestorUsuarios gu = GestorUsuarios.instanciarclase();
    
    public ControladorVentanaAMUsuarios(JDialog vista){
        this.ventana = new VentanaAMUsuarios(vista, true,this);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.getComboPerfil().setModel(modelo);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
        this.ventana.setLocationRelativeTo(null);
    }    
    
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = ventana.getTxtApellido().getText().trim();
        String nombre   = ventana.getTxtNombre().getText().trim();
        String correo   = ventana.getTxtCorreo().getText().trim();
        String clave    = new String(ventana.getTxtClave().getPassword());
        String clave2   = new String(ventana.getTxtClaveRepetida().getPassword());
        Perfil perfil   = (Perfil) ventana.getComboPerfil().getSelectedItem();
        
        if(gu.crearUsuario(correo, apellido, nombre, perfil, clave, clave2).equals(IGestorUsuarios.EXITO)){
            JOptionPane.showMessageDialog(ventana, IGestorUsuarios.EXITO, "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.ventana.dispose();
        }
        else{
            JOptionPane.showMessageDialog(ventana, IGestorUsuarios.CREACION_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.getTxtApellido().requestFocus();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.getTxtNombre().requestFocus();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.getTxtCorreo().requestFocus();
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.getTxtClave().requestFocus();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.getTxtClaveRepetida().requestFocus();
    }
    
    
}
