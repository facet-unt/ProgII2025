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
        
        
        ModeloComboPerfil modeloPerfil = new ModeloComboPerfil();
        this.ventanaAMUsuario.configurarModeloPerfil(modeloPerfil); /*Configura el modelo Combo Perfil*/
        this.ventanaAMUsuario.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventanaAMUsuario.setVisible(true); /* La hace visible */
        
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String resultado;
        GestorUsuarios gu = GestorUsuarios.instanciar();
        
        String txtCorreo = this.ventanaAMUsuario.obtenerCorreo();
        String txtApe = this.ventanaAMUsuario.obtenerApellido();
        String txtNom = this.ventanaAMUsuario.obtenerNombre();
        String txtClave = this.ventanaAMUsuario.obtenerClave();
        String txtClaveRepetida = this.ventanaAMUsuario.obtenerClaveRepetida();
        Perfil perfil = this.ventanaAMUsuario.obtenerPerfilSeleccionado();

        if(!txtClave.equals(txtClaveRepetida)){
            javax.swing.JOptionPane.showMessageDialog(this.ventanaAMUsuario, 
            "Las contraseñas no coinciden.", 
            "Error de Validación", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(this.usuario == null){
            /*Crea un usuario nuevo*/
            
            resultado = gu.crearUsuario(txtCorreo, txtApe, txtNom, perfil, txtClave, txtClaveRepetida);
        }else{
            /*Modifica un usuario*/
            resultado = null;
        }
        
        if (resultado.equals(GestorUsuarios.OPERACION_EXITOSA)) { 
            System.out.println(resultado);
            this.ventanaAMUsuario.dispose(); // Cerramos la ventana si salió bien
        } else {
            // Mostramos el error que devolvió el gestor (ej: "Correo repetido")
            javax.swing.JOptionPane.showMessageDialog(this.ventanaAMUsuario, 
                resultado, 
                "Error del Sistema", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMUsuario.dispose();
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
