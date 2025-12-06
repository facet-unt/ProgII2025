/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author karen
 */
public class ControladorPrincipal implements IControladorPrincipal {

    private VentanaPrincipal VentanaPrincipal;

    public ControladorPrincipal() {
        this.VentanaPrincipal = new VentanaPrincipal(this);
        this.VentanaPrincipal.setLocationRelativeTo(null);
        this.VentanaPrincipal.setTitle(TITULO);
        this.VentanaPrincipal.setVisible(true);
    }

    @Override
    public void btnProductosClic(ActionEvent evt) {

    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios cu = new ControladorUsuarios();
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(VentanaPrincipal,"¿Seguro que desea salir?","Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
        System.exit(0);
        }
    }

}
