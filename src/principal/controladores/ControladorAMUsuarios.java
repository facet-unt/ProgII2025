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
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuario;

/**
 *
 * @author sofia
 */
public class ControladorAMUsuarios implements IControladorAMUsuario {
private VentanaAMUsuario vamu;
private boolean modificar; 
private Usuario usuario; 


    public ControladorAMUsuarios(Usuario usuario, boolean modificar) {
        this.vamu = new VentanaAMUsuario(this);
        this.usuario=usuario;
        this.modificar=modificar;
        
       
        vamu.setLocationRelativeTo(null);
        vamu.setVisible(true);
      if(modificar==false)
      {  vamu.setTitle(TITULO_NUEVO);
          
      }else{
            vamu.setTitle(TITULO_MODIFICAR);
      }
    }
    
       public ControladorAMUsuarios(boolean modificar) {
        this.vamu = new VentanaAMUsuario(this);
      
        this.modificar=modificar;
        
       
        vamu.setLocationRelativeTo(null);
        vamu.setVisible(true);
      if(modificar==false)
      {  vamu.setTitle(TITULO_NUEVO);
          
      }else{
            vamu.setTitle(TITULO_MODIFICAR);
      }
    }
    

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String nombre, correo, apellido, clave, claveR;
        Perfil perfil;  
        
        nombre= vamu.getTxtNombre().getText();
        apellido=vamu.getTxtApellido().getText();
        correo=vamu.getTxtAreaCorreo().getText();
        
        clave=vamu.getTxtClave().getText();
        claveR=vamu.getTxtClaveR().getText();
        
        perfil=(Perfil)vamu.getComboPerfil().getSelectedItem();
        
        IGestorUsuarios gu= GestorUsuarios.instanciar(); 
        
        if(modificar=true){
        gu.modificarUsuario(usuario, correo, apellido, nombre, perfil, clave, claveR);
        }
        else{
        gu.crearUsuario(correo, apellido, nombre, perfil, clave, claveR);
        }
        
        
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {

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
    
    
    
}
