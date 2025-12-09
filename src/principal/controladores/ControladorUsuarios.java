/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author Gaston
 */
public class ControladorUsuarios implements IControladorUsuarios{
    
    private static ControladorUsuarios instancia;
    private VentanaUsuarios vista;
    private IGestorUsuarios gestor;
    
    private ControladorUsuarios(){
        this.gestor = GestorUsuarios.instanciar();
        this.vista = new VentanaUsuarios(null, true, this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle(TITULO);
    }
    public static ControladorUsuarios instanciar (){
        if(instancia == null)
            instancia = new ControladorUsuarios();
        return instancia;
    }
    @Override
    public void btnNuevoClic(ActionEvent evt) {

    }

    @Override
    public void btnModificarClic(ActionEvent evt) {

    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {

    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void btnVolverClic(ActionEvent evt) {

    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {

    }

    
}
