/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
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
    private VentanaPrincipal ventanaprincipal; 
    private ModeloTablaUsuarios modelotabla;

    public ControladorVentanaUsuarios() {
        this.ventana = new VentanaUsuarios(ventanaprincipal,true,this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.modelotabla = new ModeloTablaUsuarios();
    }
    
    public ModeloTablaUsuarios modelo(){
        return modelotabla;
    }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        Usuario u = this.ventana.seleccionarUsuarioenFila();
        
        if(u != null){
            IControladorAMUsuario controlador = new ControladorVentanaModificarUsuarios(ventanaprincipal, u);
            this.btnBuscarClic(null);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        Usuario elegido = this.elegirUsuario();
        
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
        GestorUsuarios gu = GestorUsuarios.instanciarclase();
        List<Usuario> encontrados;
        String apellidobuscado = this.ventana.verTxtApellido();
        
        if(apellidobuscado == null || apellidobuscado.isEmpty() ){
            encontrados = gu.verUsuarios();
        }
        else{
            encontrados = gu.buscarUsuarios(apellidobuscado);
        }
        
        this.ventana.actualizarTabla(encontrados);
    }
    
    private Usuario elegirUsuario(){
        Usuario usuario = this.ventana.seleccionarUsuarioenFila();
        return usuario;
    }
}
