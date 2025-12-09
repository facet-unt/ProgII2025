/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import usuarios.vistas.VentanaUsuarios;
import productos.vistas.VentanaProductos;
/**
 *
 * @author Fernando
 */
public class ControladorPrincipal implements IControladorPrincipal{
    private static ControladorPrincipal instancia;
    private JFrame ventanaPrincipal;

    private ControladorPrincipal(JFrame ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaPrincipal.setTitle(TITULO);
    }
    
    public static IControladorPrincipal instanciar(JFrame ventanaPrincipal) {
        if (instancia == null) {
            instancia = new ControladorPrincipal(ventanaPrincipal);
        }
        return instancia;
    }
    
    @Override
    public void btnProductosClic(ActionEvent evt) {
        VentanaProductos vProductos = new VentanaProductos(this.ventanaPrincipal, true);
        vProductos.setVisible(true);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        
        VentanaUsuarios vUsuarios = new VentanaUsuarios(this.ventanaPrincipal, true);
        vUsuarios.setVisible(true);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int respuesta = JOptionPane.showConfirmDialog(
            this.ventanaPrincipal,
            "¿Realmente desea salir de la aplicación?",
            "Confirmar Salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
}
