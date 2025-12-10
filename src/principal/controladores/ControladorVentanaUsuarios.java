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

    public ControladorVentanaUsuarios(JFrame vista) {
        this.ventana = new VentanaUsuarios(vista, true, this);
        this.ventana.getTableMenu().setModel(new ModeloTablaUsuarios());
        this.ventana.setTitle(TITULO);        
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }
       
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario iu = new ControladorVentanaAMUsuarios(this.ventana);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int i = this.ventana.getTableMenu().getSelectedRow();
        try{
            Usuario u = ((ModeloTablaUsuarios)this.ventana.getTableMenu().getModel()).seleccionarUsuario(i);           
            IControladorAMUsuario controlador = new ControladorVentanaModificarUsuarios(this.ventana, u);
            this.actualizarDatosTabla();          
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this.ventana,
                    "No ha elegido a ningun usuario", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int i = this.ventana.getTableMenu().getSelectedRow();
        GestorUsuarios gu = GestorUsuarios.instanciarclase();
        try{
            Usuario u = ((ModeloTablaUsuarios)this.ventana.getTableMenu().getModel()).seleccionarUsuario(i);
            int respuesta = JOptionPane.showOptionDialog(null
                   , CONFIRMACION
                   , TITULO
                   , JOptionPane.YES_NO_OPTION
                   ,JOptionPane.QUESTION_MESSAGE
                   , null
                   , new Object[]{"Si","No"}
                   , "No");
           if(respuesta == JOptionPane.YES_OPTION){
               String res = gu.borrarUsuario(u);
               this.actualizarDatosTabla();
           }
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this.ventana,
                    "No ha elegido a ningun usuario", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }    

    private void actualizarDatosTabla() {
        AbstractTableModel modelo =
                (AbstractTableModel) this.ventana.getTableMenu().getModel();
        ((ModeloTablaUsuarios) modelo).actualizarTabla();
    }
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.actualizarDatosTabla();
        this.ventana.getFieldApellido().setText(null);
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
        List<Usuario> encontrados;
        String apellidobuscado = this.ventana.getFieldApellido().getText().trim();
        
        if(apellidobuscado.isEmpty() ){
            this.actualizarDatosTabla();
        }
        else{
            IGestorUsuarios gu = GestorUsuarios.instanciarclase();
            encontrados = gu.buscarUsuarios(apellidobuscado);
            AbstractTableModel modelotabla =
                    (AbstractTableModel) this.ventana.getTableMenu().getModel();
            ((ModeloTablaUsuarios) modelotabla).mostrarTablaAcutalizada(encontrados);
        }
        
    }
    
    
}
