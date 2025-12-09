/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
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
 * @author Gaston
 */
public class ControladorAMUsuario implements IControladorAMUsuario{
    
    private static ControladorAMUsuario instancia;
    private VentanaAMUsuario vista;
    private IGestorUsuarios gestor;
    private Usuario usuarioAModificar;
    
    private ControladorAMUsuario() {
        this.gestor = GestorUsuarios.instanciar();
        this.vista = new VentanaAMUsuario(null, true, this);
        this.vista.setLocationRelativeTo(null);
        this.cargarComboPerfiles();
    }
    public static ControladorAMUsuario instanciar() {
        if (instancia == null)
            instancia = new ControladorAMUsuario();
        return instancia;
    } 

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = this.vista.verTxtApellido().getText().trim();
        String nombre = this.vista.verTxtNombre().getText().trim();
        String correo = this.vista.verTxtCorreo().getText().trim();
        String clave = new String(this.vista.verTxtClave().getPassword());
        String claveRepetida = new String(this.vista.verTxtClaveRepetida().getPassword());
        
        String perfilTexto = (String) this.vista.verCmbPerfil().getSelectedItem();
        Perfil perfilSeleccionado = Perfil.valueOf(perfilTexto);
        
        if (!clave.equals(claveRepetida)) {
            JOptionPane.showMessageDialog(this.vista, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String resultado;

        if (this.usuarioAModificar == null) {
            resultado = this.gestor.crearUsuario(correo, apellido, nombre, perfilSeleccionado, clave, claveRepetida);
        } else {
            Perfil perfilOriginal = this.obtenerPerfil(this.usuarioAModificar);
            
            if (perfilOriginal != perfilSeleccionado) {
                
                this.gestor.borrarUsuario(this.usuarioAModificar);
                
                resultado = this.gestor.crearUsuario(correo, apellido, nombre, perfilSeleccionado, clave, claveRepetida);
                
                if (resultado.equals(GestorUsuarios.EXITO)) {
                    resultado = "Usuario modificado y perfil actualizado con éxito";
                }
                
            } else {
                this.usuarioAModificar.asignarApellido(apellido);
                this.usuarioAModificar.asignarNombre(nombre);
                this.usuarioAModificar.asignarClave(clave);

                ((GestorUsuarios)this.gestor).guardarUsuarios();
                
                resultado = GestorUsuarios.EXITO;
            }
        }
        
        if (resultado.equals(GestorUsuarios.EXITO) || resultado.contains("éxito")) {
             JOptionPane.showMessageDialog(this.vista, resultado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
             this.vista.setVisible(false);
        } else {
             JOptionPane.showMessageDialog(this.vista, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.vista.setVisible(false);
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
    public void crear(){
        this.usuarioAModificar = null;
        this.vista.setTitle(TITULO_NUEVO);
        this.limpiarPantalla();
        this.vista.verTxtCorreo().setEditable(true);
        this.vista.setVisible(true);
    }
    public void modificar(Usuario u) {
        this.usuarioAModificar = u;
        this.vista.setTitle(TITULO_MODIFICAR);
        
        this.vista.verTxtApellido().setText(u.verApellido());
        this.vista.verTxtNombre().setText(u.verNombre());
        this.vista.verTxtCorreo().setText(u.verCorreo());
        this.vista.verCmbPerfil().setSelectedItem(this.obtenerPerfil(u));
        
        this.vista.verTxtClave().setText(u.verClave());
        this.vista.verTxtClaveRepetida().setText(u.verClave());
        
        this.vista.verTxtCorreo().setEditable(false);
        
        this.vista.setVisible(true);
    }
    private Perfil obtenerPerfil(Usuario u) {
        if (u instanceof usuarios.modelos.Cliente) {
            return Perfil.CLIENTE;
        } else if (u instanceof usuarios.modelos.Empleado) {
            return Perfil.EMPLEADO;
        } else if (u instanceof usuarios.modelos.Encargado) {
            return Perfil.ENCARGADO;
        }
        return null;
    }
    private void limpiarPantalla() {
        this.vista.verTxtApellido().setText("");
        this.vista.verTxtNombre().setText("");
        this.vista.verTxtCorreo().setText("");
        this.vista.verTxtClave().setText("");
        this.vista.verTxtClaveRepetida().setText("");
        this.vista.verCmbPerfil().setSelectedIndex(0);
    }
    private void cargarComboPerfiles() {
        this.vista.verCmbPerfil().removeAllItems();
        for (Perfil p : Perfil.values()) {
            this.vista.verCmbPerfil().addItem(p.name());
        }
    }
}
