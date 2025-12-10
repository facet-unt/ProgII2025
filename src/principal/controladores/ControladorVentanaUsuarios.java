/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author NEW GAME
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
    private VentanaUsuarios ventana;
    private static VentanaPrincipal vista;
    private ModeloTablaUsuarios modelotabla;
    IGestorUsuarios gestorUsuarios = GestorUsuarios.instanciarclase();

    public ControladorVentanaUsuarios(VentanaPrincipal padre) {
        this.ventana = new VentanaUsuarios(padre, true, this, gestorUsuarios.verUsuarios());
        this.vista = padre;
        this.ventana.setTitle(TITULO);        
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.refrescarTabla();
        this.modelotabla = new ModeloTablaUsuarios();
    }
    
    private void refrescarTabla(){
        this.modelotabla.actualizarTabla();
    }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario iu = ControladorVentanaAMUsuarios.instanciar();
        this.ventana.verModelo().mostrarTablaAcutalizada(gestorUsuarios.verUsuarios());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        Usuario u = this.ventana.seleccionarUsuarioenFila();
        ControladorVentanaModificarUsuarios controlador = new ControladorVentanaModificarUsuarios(ventana, u);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        Usuario elegido = this.ventana.seleccionarUsuarioenFila();
        
        if(elegido != null){
           int respuesta = JOptionPane.showOptionDialog(null
                   , CONFIRMACION
                   , TITULO
                   , JOptionPane.YES_NO_OPTION
                   ,JOptionPane.QUESTION_MESSAGE
                   , null
                   , new Object[]{"Si","No"}
                   , "No");
           if(respuesta == JOptionPane.YES_OPTION){
               GestorUsuarios gu = GestorUsuarios.instanciarclase();
               String res = gu.borrarUsuario(elegido);
               JOptionPane.showMessageDialog(null, res);
               this.btnBorrarClic(null);
           }
        }
        else{   
           this.ventana.mostrarMensaje("No Ha seleccionado un Usuario para borrar");
        }
    }    

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventana.requestFocusInWindow();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(ActionEvent evt) {
  
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        List<Usuario> encontrados;
        String apellidobuscado = this.ventana.getFieldApellido().getText().trim();
        
        if(apellidobuscado.isEmpty() ){
            this.refrescarTabla();
        }
        else{
            encontrados = gestorUsuarios.buscarUsuarios(apellidobuscado);
            this.modelotabla.mostrarTablaAcutalizada(encontrados);
        }
        
    }
    
    
}
