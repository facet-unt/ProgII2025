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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
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
    private ModeloTablaUsuarios modelo = new ModeloTablaUsuarios();
    private GestorUsuarios gu = GestorUsuarios.instanciarclase();    
    

    public ControladorVentanaUsuarios(JFrame vista) {
        this.ventana = new VentanaUsuarios(vista, true, this);
        this.ventana.asignarModeloTabla(modelo);
        this.ventana.setTitle(TITULO);        
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setResizable(false);
    }
       
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario iu = new ControladorVentanaAMUsuarios(this.ventana);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int i = this.ventana.verFilaSeleccionada();
        
        try{
            Usuario u = this.modelo.seleccionarUsuario(i);           
            IControladorAMUsuario controlador = new ControladorVentanaModificarUsuarios(this.ventana, u);         
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this.ventana,
                    "No ha elegido a ningun usuario", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int i = this.ventana.verFilaSeleccionada();

        try{
            Usuario u = this.modelo.seleccionarUsuario(i);
            int respuesta = JOptionPane.showOptionDialog(null
                   , CONFIRMACION
                   , TITULO
                   , JOptionPane.YES_NO_OPTION
                   ,JOptionPane.QUESTION_MESSAGE
                   , null
                   , new Object[]{"Si","No"}
                   , "No");
           if(respuesta == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(ventana, gu.borrarUsuario(u), "Exito", JOptionPane.INFORMATION_MESSAGE);

           }
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this.ventana,
                    "No ha elegido a ningun usuario", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }    

    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        List<Usuario> usuarios = gu.verUsuarios();
        this.modelo.asignarUsuarios(usuarios);
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(ActionEvent evt) {
        this.btnBorrarClic(null);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        List<Usuario> encontrados = new ArrayList<>();
        String apellidobuscado = this.ventana.verTxtApellido();
        
        if(apellidobuscado.isEmpty() || apellidobuscado.isBlank()){
            this.btnBuscarClic(null);
        }
        else{
            encontrados = gu.buscarUsuarios(apellidobuscado);
        }
        
        this.modelo.asignarUsuarios(encontrados);
    }
    
    
}
