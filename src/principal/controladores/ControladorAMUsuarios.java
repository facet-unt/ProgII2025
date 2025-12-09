/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author Lyan
 */
public class ControladorAMUsuarios implements IControladorAMUsuario{
    private VentanaAMUsuario ventanaAMUsuario;
    private VentanaPrincipal ventanaPadre;
    private Usuario usuario;
    
    
    public ControladorAMUsuarios(VentanaPrincipal ventanaPadre, Usuario usuario) {
        System.out.println("SE INICIA CONTROLADORamUSUARIOS ---");
        
        this.ventanaPadre = ventanaPadre;
        this.usuario = usuario;
        this.ventanaAMUsuario = new VentanaAMUsuario(ventanaPadre, this);
        
        if(this.usuario != null){
            /*Ventana Modificar*/
            this.ventanaAMUsuario.setTitle("Modificar Usurio");
            
            /*Cargamos los datos en la ventana*/
            this.ventanaAMUsuario.setTxtCorreo(usuario.verCorreo());
            this.ventanaAMUsuario.setTxtApellido(usuario.verApellido());
            this.ventanaAMUsuario.setTxtNombre(usuario.verNombre());
            this.ventanaAMUsuario.setPerfilSeleccionado(usuario.verPerfil());
            this.ventanaAMUsuario.bloquearCampoCorreo();
            this.ventanaAMUsuario.bloquearCampoPerfil();
        }else{
            /*Ventana Nuevo */
            this.ventanaAMUsuario.setTitle("Nuevo Usuario");
        }
        
        
        
        ModeloComboPerfil modeloPerfil = new ModeloComboPerfil();
        this.ventanaAMUsuario.configurarModeloPerfil(modeloPerfil); /*Configura el modelo Combo Perfil*/
        this.ventanaAMUsuario.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventanaAMUsuario.setVisible(true); /* La hace visible */
        
    }

    /*Metodo para el boton que permite guardar los datos ingresados*/
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String resultado;
        GestorUsuarios gu = GestorUsuarios.instanciar();
        String claveNueva;
        String claveNuevaRepetida;
        
        /*Trabajamos con los datos que nos da la ventana para no romper con el patron MVC*/
        String txtCorreo = this.ventanaAMUsuario.obtenerCorreo();
        String txtApe = this.ventanaAMUsuario.obtenerApellido();
        String txtNom = this.ventanaAMUsuario.obtenerNombre();
        String txtClave = this.ventanaAMUsuario.obtenerClave();
        String txtClaveRepetida = this.ventanaAMUsuario.obtenerClaveRepetida();
        Perfil perfil = this.ventanaAMUsuario.obtenerPerfilSeleccionado();

        if(!txtClave.equals(txtClaveRepetida)){
            javax.swing.JOptionPane.showMessageDialog(this.ventanaAMUsuario, /*Mensaje que muestra al usuario*/
            "Las contraseñas no coinciden.", 
            "Error de Validación", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(this.usuario == null){
            /*Crea un usuario nuevo*/
            resultado = gu.crearUsuario(txtCorreo, txtApe, txtNom, perfil, txtClave, txtClaveRepetida);
            
        }
         else{
            /*Modifica un usuario*/
            if (txtClave.isEmpty() && txtClaveRepetida.isEmpty()) {
                claveNueva = this.usuario.verClave(); /*Si el usuario no ingresa ninguna clave, decide guardarla como esta*/
                claveNuevaRepetida = this.usuario.verClave();
            }else{
                if(!txtClave.equals(txtClaveRepetida)){
                    javax.swing.JOptionPane.showMessageDialog(this.ventanaAMUsuario, 
                    "Las contraseñas no coinciden.", 
                    "Error de Validación", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }
                claveNueva = txtClave;
                claveNuevaRepetida = txtClaveRepetida;
            }
            resultado = gu.modificarUsuario(usuario ,txtCorreo, txtApe, txtNom, claveNueva, claveNuevaRepetida);
        }
        
        if (resultado.equals(GestorUsuarios.OPERACION_EXITOSA)) { 
            System.out.println(resultado);
            this.ventanaAMUsuario.dispose(); /*Cerramos la ventana*/
        } 
         else {
            System.out.println("Error al crear o modificar");
        }  
    }

    /*Metodo que destruye la ventana*/
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMUsuario.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMUsuario.enfocarNombre();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
     if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMUsuario.enfocarClave();
        }
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMUsuario.enfocarApellido();
       }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMUsuario.enfocarClaveRepetida();
      }
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMUsuario.obtenerPerfilSeleccionado();
      }
    }
   
    
}
