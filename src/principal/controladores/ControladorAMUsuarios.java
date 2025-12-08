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
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
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
        if (modificar==true && usuario != null) 
        {
          this.DatosAModificar();
        }
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
        
               
     public void DatosAModificar() {

    vamu.getTxtApellido().setText(usuario.verApellido());
    vamu.getTxtNombre().setText(usuario.verNombre());
    vamu.getTxtAreaCorreo().setText(usuario.verCorreo());
    vamu.getTxtAreaCorreo().setEditable(false);
    vamu.getTxtClave().setText(usuario.verClave());
    vamu.getTxtClaveR().setText(usuario.verClave());
    


    Perfil perfil = null;

    if (usuario instanceof Encargado) {
        perfil = Perfil.ENCARGADO;
    } else if (usuario instanceof Empleado) {
        perfil = Perfil.EMPLEADO;
    } else if (usuario instanceof Cliente) {
        perfil = Perfil.CLIENTE;
    }
    
   
    if (perfil != null) {
        
        vamu.getComboPerfil().setSelectedItem(perfil.toString());
    } 
}
   
   

       
 

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try{
            
        
        String nombre, correo, apellido, clave, claveR;
        Perfil perfil;  
        
        nombre= vamu.getTxtNombre().getText();
        apellido=vamu.getTxtApellido().getText();
        correo=vamu.getTxtAreaCorreo().getText();
        clave=vamu.getTxtClave().getText();
        claveR=vamu.getTxtClaveR().getText();
        perfil = Perfil.valueOf(vamu.getComboPerfil().getSelectedItem().toString());

        
        IGestorUsuarios gu= GestorUsuarios.instanciar(); 
        String resultado;
        
        if(modificar==true){
            resultado= gu.modificarUsuario(usuario, correo, apellido, nombre, perfil, clave, claveR);
           
        }
        else{
        resultado= gu.crearUsuario(correo, apellido, nombre, perfil, clave, claveR);
        }
        
           if (resultado.equals(GestorUsuarios.EXITO) || resultado.equals(GestorUsuarios.VALIDACION_EXITO)) {
               
            model.actualizarTabla();
           
                vamu.dispose();
            }
           
        }catch (NullPointerException e) {
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
            vamu.getTxtApellido().requestFocus();
            
        }
        
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          vamu.getTxtNombre().requestFocus();
        }
        
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vamu.getTxtAreaCorreo().requestFocus();
        }
        
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
      
    String clave = vamu.getTxtClave().getText();
    String claveR = vamu.getTxtClaveR().getText();
    
    if (!clave.equals(claveR)) {
       
        vamu.getBtnGuardar().setEnabled(false);
    } else {
        vamu.getBtnGuardar().setEnabled(true);
    }
}

@Override
public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
    passClavePresionarTecla(evt); 
}

        
       
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        
    }
    
    
    
}
