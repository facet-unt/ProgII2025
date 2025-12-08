/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

/**
 *
 * @author Usuario
 */


import Interfaces.IGestorUsuarios;
import Interfaces.IControladorAMUsuario;
import static Interfaces.IControladorAMUsuario.TITULO_MODIFICAR;
import static Interfaces.IControladorAMUsuario.TITULO_NUEVO;
//import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil; // Asegurate de tener este enum
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaAMUsuarios;

public class ControladorAMUsuario implements IControladorAMUsuario, ActionListener, KeyListener {

    private VentanaAMUsuarios vista;
    private IGestorUsuarios gestor;
    private Usuario usuarioModificar; 

    // Constructor
    public ControladorAMUsuario(VentanaAMUsuarios vista, Usuario usuarioModificar) {
        this.vista = vista;
        this.usuarioModificar = usuarioModificar;
        this.gestor = GestorUsuarios.instanciar();

        
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnCancelar().addActionListener(this);

        this.vista.getTxtApellido().addKeyListener(this);
        this.vista.getTxtNombre().addKeyListener(this);
        this.vista.getTxtCorreo().addKeyListener(this);
        this.vista.getTxtClave().addKeyListener(this);
        this.vista.getTxtClaveRepetida().addKeyListener(this);

        
        if (this.usuarioModificar == null) {
            this.vista.setTitle(TITULO_NUEVO);
            this.vista.getTxtCorreo().setEditable(true); 
        } else {
            this.vista.setTitle(TITULO_MODIFICAR);
            cargarDatosEnVista(); 
            this.vista.getTxtCorreo().setEditable(false); 
        }
    }

    
    private void cargarDatosEnVista() {
        this.vista.getTxtApellido().setText(usuarioModificar.verApellido());
        this.vista.getTxtNombre().setText(usuarioModificar.verNombre());
        this.vista.getTxtCorreo().setText(usuarioModificar.verCorreo());
        this.vista.getTxtClave().setText(usuarioModificar.verClave());
        this.vista.getTxtClaveRepetida().setText(usuarioModificar.verClave());
         
       
         this.vista.getComboPerfil().setSelectedItem(usuarioModificar.verPerfil());
    }

   

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String apellido = vista.getTxtApellido().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        String correo = vista.getTxtCorreo().getText().trim();
        String clave = new String(vista.getTxtClave().getPassword());
        String claveRep = new String(vista.getTxtClaveRepetida().getPassword());
        Perfil perfil = (Perfil) vista.getComboPerfil().getSelectedItem(); 

        String resultado = IGestorUsuarios.ERROR;

       
        if (!clave.equals(claveRep)) {
            JOptionPane.showMessageDialog(vista, IGestorUsuarios.ERROR_CLAVES, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (usuarioModificar == null) {
            resultado = gestor.crearUsuario(correo, apellido, nombre, perfil, clave, claveRep);
        } else {
           
            usuarioModificar.asignarApellido(apellido);
            usuarioModificar.asignarNombre(nombre);
            usuarioModificar.asignarClave(clave);
            resultado = IGestorUsuarios.EXITO; 
        }
        
        if (resultado.equals(IGestorUsuarios.EXITO) || resultado.contains("éxito")) {
            JOptionPane.showMessageDialog(vista, resultado, "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose(); 
    }

   
    
    
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            vista.getTxtNombre().requestFocus();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (usuarioModificar == null) {
                vista.getTxtCorreo().requestFocus();
            } else {
                vista.getTxtClave().requestFocus();
            }
        }
    }

    @Override
    public void txtCorreoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            vista.getComboPerfil().requestFocus();
        }
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            vista.getTxtClaveRepetida().requestFocus();
        }
    }

    @Override
    public void passClaveRepetidaPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnGuardarClic(null);
        }
    }


    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {} 
    @Override 
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == vista.getTxtApellido()) txtApellidoPresionarTecla(e);
        else if (e.getSource() == vista.getTxtNombre()) txtNombrePresionarTecla(e);
        else if (e.getSource() == vista.getTxtCorreo()) txtCorreoPresionarTecla(e);
        else if (e.getSource() == vista.getTxtClave()) passClavePresionarTecla(e);
        else if (e.getSource() == vista.getTxtClaveRepetida()) passClaveRepetidaPresionarTecla(e);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            btnGuardarClic(e);
        } else if (e.getSource() == vista.getBtnCancelar()) {
            btnCancelarClic(e);
        }
    }
}