/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author lazar
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
    private VentanaUsuarios ventana;
    
    public ControladorVentanaUsuarios(JFrame ventanaPadre) {
        this.ventana = new VentanaUsuarios(ventanaPadre , this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO);
        this.ventana.setVisible(true);
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
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaUsuarios mtp = new ModeloTablaUsuarios();
	tablaUsuarios.setModel(mtp);
        if (tablaUsuarios.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaUsuarios mtp1 = new ModeloTablaUsuarios(this.ventana.verCorreo().getText().trim());
	tablaUsuarios.setModel(mtp1);
        if (tablaUsuarios.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
        }
    }
}
