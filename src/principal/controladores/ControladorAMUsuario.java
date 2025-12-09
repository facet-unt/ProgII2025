/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author thoma
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    
    private static ControladorAMUsuario instancia;
    private VentanaAMUsuario ventana;
    private ModeloComboPerfil modeloPerfil;
    private Usuario usuarioModificar = null;
    
    private ControladorAMUsuario() {
        this.ventana = new VentanaAMUsuario(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        
        this.modeloPerfil = new ModeloComboPerfil();
        this.ventana.definirComboPerfil(modeloPerfil);
        agregarEnterListener(this.ventana.verTxtNombre(), this.ventana.verTxtApellido());
        agregarEnterListener(this.ventana.verTxtApellido(), this.ventana.verTxtCorreo());
        agregarEnterListener(this.ventana.verTxtCorreo(), this.ventana.verPassClave());
        agregarEnterListener(this.ventana.verPassClave(), this.ventana.verPassClaveRepetida());
    }
    
    public static ControladorAMUsuario instanciar(Usuario usuario) {
        if (instancia == null) {
            instancia = new ControladorAMUsuario();
        }
        
        instancia.usuarioModificar = usuario;
        
        if (usuario == null) {
            instancia.ventana.setTitle(TITULO_NUEVO);
            instancia.ventana.LimpiarVentana();
            instancia.ventana.correoEditable(true);
        }
        else {
            instancia.ventana.setTitle(TITULO_MODIFICAR);
            
            // LLeno los datos del usuario
            instancia.ventana.verTxtNombre().setText(usuario.verNombre());
            instancia.ventana.verTxtApellido().setText(usuario.verApellido());
            instancia.ventana.verTxtCorreo().setText(usuario.verCorreo());
            instancia.ventana.verPassClave().setText(usuario.verClave());
            instancia.ventana.verPassClaveRepetida().setText(usuario.verClave());
            
            instancia.ventana.correoEditable(false);
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
        String resultado;
        
        if (this.usuarioModificar == null) {
           resultado = gu.crearUsuario(correo, clave, apellido, nombre, perfil, claveRepetida);
        }
        else {
            resultado = gu.modificarUsuario(usuarioModificar, clave, apellido, nombre, perfil, claveRepetida);
        }
        
        if (!resultado.equals(IGestorUsuarios.EXITO)){
            JOptionPane.showMessageDialog(this.ventana, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this.ventana, resultado, "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.ventana.LimpiarVentana();
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
    
    private void agregarEnterListener(JTextField currentField, JTextField nextField) {
            currentField.addKeyListener(new KeyAdapter() {
             @Override
             public void keyPressed(KeyEvent e) {
                  if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                  nextField.requestFocus();
                  }
             }
         });
        }
    
}
