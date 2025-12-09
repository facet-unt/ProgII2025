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
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author Lyan
 */
public class ControladorUsuarios implements IControladorUsuarios{
    private VentanaUsuarios ventana;
    private IControladorUsuarios controlador;
    private VentanaPrincipal ventanaPadre;

    public ControladorUsuarios(VentanaPrincipal ventanaPadre) {
        this.ventanaPadre = ventanaPadre;
        System.out.println("SE INICIA CONTROLADOR DE USUARIOS"); 
        this.ventana = new VentanaUsuarios(this.ventanaPadre, true, this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);   
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controlador = new ControladorAMUsuarios(this.ventanaPadre, null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
       Usuario usuarioSeleccionado = this.obtenerUsuarioSeleccionado();
         if(usuarioSeleccionado != null)
         {
           IControladorAMUsuario controlador = new ControladorAMUsuarios(this.ventanaPadre, usuarioSeleccionado);
           this.btnBuscarClic(null); /*Para actualizar la tabla vieja*/
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
       Usuario usuarioSeleccionado = this.obtenerUsuarioSeleccionado();
        
        if(usuarioSeleccionado != null){
            
        /*Antes de que se borre, se pregunta si quiere borrarlo */
        
        int opcion = JOptionPane.showOptionDialog(null,
                IControladorUsuarios.CONFIRMACION,
                IControladorUsuarios.TITULO, 
                 JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Sí", "No"}, "No");
        
        if (opcion == JOptionPane.YES_OPTION){
            
           GestorUsuarios gu = GestorUsuarios.instanciar();
           String resultado = gu.borrarUsuario(usuarioSeleccionado);
            JOptionPane.showMessageDialog(null, IControladorUsuarios.OPERACION_EXITOSA);
           
             if(resultado.equals(IGestorUsuarios.OPERACION_EXITOSA))
               {
                        this.btnBuscarClic(null);
               }
         
             else
              {
                      JOptionPane.showMessageDialog(null,
                    IControladorUsuarios.OPERACION_FALLIDA,
                           IControladorUsuarios.TITULO,
                    JOptionPane.ERROR_MESSAGE);
                 System.out.println("ERRor en borrar usaurio");
              }
        }  
      }  
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        System.out.println("VENTANA GANA FOCO");
        GestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> listaUsuariosActualizada = gu.verUsuarios();
        this.ventana.actualizarTabla(listaUsuariosActualizada);
    }

    /*Metodo que destruye la ventana cuando se apreta el boton Volver */
    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose(); 
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        GestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> resultado;
        String textoBuscado = this.ventana.conseguirTxt();
        
        if (textoBuscado == null || textoBuscado.isEmpty()) {
            resultado = gu.verUsuarios();    
        } else {
            resultado = gu.buscarUsuarios(textoBuscado);   
        }
           
        this.ventana.actualizarTabla(resultado);
    }
    
    private Usuario obtenerUsuarioSeleccionado() {
        Usuario u = this.ventana.obtenerUsuarioSeleccionado();

        if (u == null) {
            JOptionPane.showMessageDialog(this.ventana,
                    IControladorUsuarios.ADVERTENCIA,
                    IControladorUsuarios.ATENCION,
                    JOptionPane.WARNING_MESSAGE);
        }
        return u;
    }
    
 
    
    
}
