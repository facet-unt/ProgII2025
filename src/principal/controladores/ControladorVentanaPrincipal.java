/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorProductos;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;

import usuarios.modelos.ControladorUsuarios;

/**
 *
 * @author octav
 */
public class ControladorVentanaPrincipal implements IControladorPrincipal {
    private static ControladorVentanaPrincipal instancia;
    private VentanaPrincipal ventana;
    
    public ControladorVentanaPrincipal(VentanaPrincipal vista) {
    
        this.ventana = vista;
    
    }
//    public static ControladorVentanaPrincipal instanciar() {
//        if (instancia == null)
//            //instancia = new ControladorVentanaPrincipal();
//        return instancia;
//    }
    //@Override
    public void btnProductosClic(ActionEvent evt) {
        IControladorProductos controladorproductos = ControladorProductos.instanciar(); 
    }

    //@Override
    public void btnUsuariosClic(ActionEvent evt) {
        IControladorUsuarios controladorusuarios = new ControladorUsuarios();
    }

    //@Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(this.ventana,"¿Esta seguro que desea salir del programa?","Salir del programa",JOptionPane.YES_NO_OPTION);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (opcion == JOptionPane.YES_OPTION) {
            ventana.dispose();  
            System.exit(0);   
        }
    }
    }

