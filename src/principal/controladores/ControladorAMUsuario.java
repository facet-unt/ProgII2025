/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author sofia
 */
public class ControladorAMUsuario implements IControladorAMUsuario {

    private VentanaAMUsuario vamu;
    private boolean modificar;
    private Usuario usuario;
    private IControladorUsuarios controladorU;

    public ControladorAMUsuario(Usuario usuario, boolean modificar, IControladorUsuarios controladorU) {
        this.vamu = new VentanaAMUsuario(this);
        this.usuario = usuario;
        this.controladorU = controladorU;
        this.modificar = modificar;
        if (modificar == true && usuario != null) {
            this.DatosAModificar();
        }
        vamu.setLocationRelativeTo(null);
        vamu.setVisible(true);

        vamu.setTitle(TITULO_MODIFICAR);

    }

    public ControladorAMUsuario(boolean modificar, IControladorUsuarios controladorU) {
        this.vamu = new VentanaAMUsuario(this);
        this.modificar = modificar;
        this.controladorU = controladorU;
        vamu.setLocationRelativeTo(null);
        vamu.setVisible(true);
        if (modificar == false) {
            vamu.setTitle(TITULO_NUEVO);
        }

    }

    public void DatosAModificar() {

        vamu.getTxtApellido().setText(usuario.verApellido());
        vamu.getTxtNombre().setText(usuario.verNombre());
        vamu.getTxtCorreo().setText(usuario.verCorreo());
        vamu.getTxtCorreo().setEditable(false);
        vamu.getTxtClave().setVisible(true);
        vamu.getTxtClaveR().setVisible(true);
        vamu.getTxtClave().setText("");
        vamu.getTxtClaveR().setText("");
        System.out.println(usuario.verPerfil());

        vamu.getComboPerfil().setSelectedItem(usuario.verPerfil());
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {

            String nombre, correo, apellido, clave, claveR;
            Perfil perfil;

            nombre = vamu.getTxtNombre().getText();
            apellido = vamu.getTxtApellido().getText();
            correo = vamu.getTxtCorreo().getText();
            clave = new String(vamu.getTxtClave().getPassword());
            claveR = new String(vamu.getTxtClaveR().getPassword());
            perfil = (Perfil) vamu.getComboPerfil().getSelectedItem();

            IGestorUsuarios gu = GestorUsuarios.instanciar();
            String resultado;

            if (modificar == true) {
                if (clave.isEmpty() && claveR.isEmpty()) {
                    resultado = ((GestorUsuarios) gu).modificarUsuario(usuario, correo, apellido, nombre, perfil, usuario.verClave(), usuario.verClave());
                } else {
                    resultado = ((GestorUsuarios) gu).modificarUsuario(usuario, correo, apellido, nombre, perfil, clave, claveR);
                }

                controladorU.ventanaObtenerFoco(null);
            } else {

                resultado = gu.crearUsuario(correo, apellido, nombre, perfil, clave, claveR);
                controladorU.ventanaObtenerFoco(null);
            }

            JOptionPane.showMessageDialog(vamu, resultado);

            if (resultado.equals(GestorUsuarios.EXITO)) {

                vamu.dispose();
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Algún campo no fue inicializado.");
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, "El elemento seleccionado no es un perfil válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vamu.dispose();

    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getTxtNombre().requestFocus();

        }

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getTxtClave().requestFocus();
        }

    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getTxtApellido().requestFocus();
        }

    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getTxtClaveR().requestFocus();

        }

    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getComboPerfil().requestFocus();

        }
    }

    public void comboPerfilPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnGuardarClic(null);
        }
    }
}
