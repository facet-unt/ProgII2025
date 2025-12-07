/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
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
        //this.btnBuscarClic(null);
        this.ventana.setVisible(true); 
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controlador = new ControladorAMUsuarios(this.ventanaPadre, null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        System.out.println("VENTANA GANA FOCO");
        GestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> listaProductosActualizada = gu.verUsuarios();
        this.ventana.actualizarTabla(listaProductosActualizada);
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
