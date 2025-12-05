/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

/**
 *
 * @author lazar
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal{
    private VentanaPrincipal ventana;
    
    public ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
        this.ventana.setTitle(TITULO);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios controladorUsuarios = new ControladorVentanaUsuarios();
    }
    
    @Override
    public void btnProductosClic(ActionEvent evt) {
        IControladorProductos controladorProductos = new ControladorVentanaProductos();
    }
    
    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showOptionDialog(null,"¿Desea salir del programa?","Salir",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Sí", "No"}, "No");
        if(opcion==0)
            this.ventana.dispose();
    }
    
}
