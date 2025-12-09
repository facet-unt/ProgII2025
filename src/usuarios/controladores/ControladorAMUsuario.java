package usuarios.controladores;

import interfaces.IControladorAMUsuario;
import static interfaces.IControladorAMUsuario.TITULO_MODIFICAR;
import static interfaces.IControladorAMUsuario.TITULO_NUEVO;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

public class ControladorAMUsuario implements IControladorAMUsuario {

    private VentanaAMUsuario ventana;
    private Usuario usuario;  
    private boolean esNuevo;

    public ControladorAMUsuario(java.awt.Dialog ventanaPadre) {
        this.usuario = null;
        this.esNuevo = true;

        this.ventana = new VentanaAMUsuario(ventanaPadre, true, this);
        this.ventana.setTitle(TITULO_NUEVO);
        this.ventana.setLocationRelativeTo(ventanaPadre);

        // cargar enum Perfil en el combo
        this.ventana.verCmbPerfil().setModel(new javax.swing.DefaultComboBoxModel<>(Perfil.values()));

        this.ventana.setVisible(true);
    }
   
    //     Constructor para modificar
    public ControladorAMUsuario(java.awt.Dialog ventanaPadre, Usuario usuario) {
        this.usuario = usuario;
        this.esNuevo = false;
        this.ventana = new VentanaAMUsuario(ventanaPadre, true, this);
        this.ventana.setTitle(TITULO_MODIFICAR);
        this.ventana.setLocationRelativeTo(ventanaPadre);

        // cargar enum Perfil
        this.ventana.verCmbPerfil().setModel(new javax.swing.DefaultComboBoxModel<>(Perfil.values()));

        // completar campos
        this.ventana.verTxtApellido().setText(usuario.verApellido());
        this.ventana.verTxtNombre().setText(usuario.verNombre());
        this.ventana.verTxtCorreo().setText(usuario.verCorreo());
        this.ventana.verTxtCorreo().setEnabled(false); // el correo no se cambia
        this.ventana.verPswClave().setText(usuario.verClave());
        this.ventana.verPswRepetida().setText(usuario.verClave());
        this.ventana.verCmbPerfil().setSelectedItem(usuario.verPerfil());

        this.ventana.setVisible(true);
    }
    
    //       Guardo el usuario
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = ventana.verTxtApellido().getText().trim();
        String nombre   = ventana.verTxtNombre().getText().trim();
        String correo   = ventana.verTxtCorreo().getText().trim();
        String clave    = new String(ventana.verPswClave().getPassword());
        String clave2   = new String(ventana.verPswRepetida().getPassword());
        Perfil perfil   = (Perfil) ventana.verCmbPerfil().getSelectedItem();

        IGestorUsuarios gu = GestorUsuarios.instanciar();
        String resultado;

        if (esNuevo) {
            resultado = gu.crearUsuario(correo, apellido, nombre, perfil, clave, clave2);
        } else {
            resultado = gu.modificarUsuario(usuario, apellido, nombre, perfil, clave, clave2);
        }

        JOptionPane.showMessageDialog(ventana, resultado);

        if (IGestorUsuarios.EXITO.equals(resultado)) {
            ventana.dispose();
        }
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(
            ventana,
            "¿Desea cancelar? Se perderán los cambios.",
            "Advertencia",
            JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION)
            ventana.dispose();
    }


    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.verTxtNombre().requestFocus();
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.verTxtCorreo().requestFocus();
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.verPswClave().requestFocus();
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            ventana.verPswRepetida().requestFocus();
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER)
            btnGuardarClic(null);
    }
}