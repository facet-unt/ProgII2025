/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import productos.modelos.GestorProductos;
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
        IControladorAMProducto controladorAMProducto = new ControladorAMProducto(this.ventana);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        IGestorProductos gp = GestorProductos.instanciar();
        if (this.ventana.verTabla().getRowCount() > 0){
            IControladorAMProducto controladorAMProducto = new ControladorAMProducto(this.ventana,gp.menu().get(filaSeleccionada));
        }else{
            JOptionPane.showMessageDialog(this.ventana,"No hay Productos","Error al modificar un Producto",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        IGestorProductos gp = GestorProductos.instanciar();
        if (this.ventana.verTabla().getRowCount() > 0){
            int opcion = JOptionPane.showOptionDialog(null,"¿Esta seguro de eliminar este Producto?","Si",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Sí", "No"}, "No");
            if(opcion==0){
                gp.borrarProducto(gp.menu().get(filaSeleccionada));
            }
        }else{
            JOptionPane.showMessageDialog(this.ventana,"No hay Productos","Error al borrar un Producto",JOptionPane.ERROR_MESSAGE);
        }
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
