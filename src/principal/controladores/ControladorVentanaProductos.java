/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTable;
import productos.modelos.ModeloTablaProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author lazar
 */
public class ControladorVentanaProductos implements IControladorProductos{
    private VentanaProductos ventana;
    private int filaSeleccionada;
    
    public ControladorVentanaProductos(JFrame ventanaPadre) {
        this.ventana = new VentanaProductos(ventanaPadre , this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO);
        JTable tablaProductos = this.ventana.verTabla();
        this.agregarListenerATabla(tablaProductos);
        this.ventana.setVisible(true);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaProductos mtp = new ModeloTablaProductos();
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
    public void btnBuscarClic(ActionEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaProductos mtp1 = new ModeloTablaProductos(this.ventana.verDescripcion().getText().trim());
	tablaUsuarios.setModel(mtp1);
        if (tablaUsuarios.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
        char caracter = evt.getKeyChar();
        if(Character.isLetter(caracter) || Character.isDigit(caracter)){
            ModeloTablaProductos mtp1 = new ModeloTablaProductos(this.ventana.verDescripcion().getText().trim());
            tablaUsuarios.setModel(mtp1);
                if (tablaUsuarios.getRowCount() > 0) {
                    tablaUsuarios.setRowSelectionInterval(0, 0);
                }
        }else{
            int codigoTecla = evt.getKeyCode();
            if(codigoTecla==VK_BACK_SPACE || codigoTecla==VK_DELETE){
                ModeloTablaProductos mtp1 = new ModeloTablaProductos(this.ventana.verDescripcion().getText().trim());
                tablaUsuarios.setModel(mtp1);
                if (tablaUsuarios.getRowCount() > 0) {
                    tablaUsuarios.setRowSelectionInterval(0, 0);
                }
            }
        }
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
    
    private void agregarListenerATabla(JTable tablaProductos) {
        tablaProductos.getSelectionModel().addListSelectionListener((e) -> {
        if (!e.getValueIsAdjusting()) {
        //En la tabla se puede seleccionar sólo un elemento a la vez,
        //por lo que cuando se realiza una nueva selección,
        //el elemento seleccionado antes queda como no seleccionado,
        //disparándose 2 eventos
        //Para evitar responder al evento 2 veces
        //se usa getValueIsAdjusting()
        if (tablaProductos.getSelectedRow() != -1)
            this.filaSeleccionada = tablaProductos.getSelectedRow();
        }
        });
    }
}
