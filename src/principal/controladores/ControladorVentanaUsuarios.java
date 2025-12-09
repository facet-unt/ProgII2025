/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorPrincipal;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import principal.vistas.VentanaPrincipal;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author lazar
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios {
    private VentanaUsuarios ventana;
    private int filaSeleccionada;

    public ControladorVentanaUsuarios(JFrame ventanaPadre) {
        this.ventana = new VentanaUsuarios(ventanaPadre , this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO);
        JTable tablaUsuarios = this.ventana.verTabla();
        this.agregarListenerATabla(tablaUsuarios);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controladorAMUsuario = new ControladorAMUsuario(this.ventana);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        if (this.ventana.verTabla().getRowCount() > 0){
            IControladorAMUsuario controladorAMUsuario = new ControladorAMUsuario(this.ventana,gu.verUsuarios().get(filaSeleccionada));
        }else{
            JOptionPane.showMessageDialog(this.ventana,"No hay Usuarios","Error al modificar un Usuario",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        if (this.ventana.verTabla().getRowCount() > 0){
            int opcion = JOptionPane.showOptionDialog(null,"¿Esta seguro de eliminar este Usuario?","Si",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,new Object[] {"Sí", "No"}, "No");
            if(opcion==0){
                gu.borrarUsuario(gu.verUsuarios().get(filaSeleccionada));
            }
        }else{
            JOptionPane.showMessageDialog(this.ventana,"No hay Usuarios","Error al borrar un Usuario",JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaUsuarios mtu = new ModeloTablaUsuarios();
	tablaUsuarios.setModel(mtu);
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
        JTable tablaUsuarios = this.ventana.verTabla();
        if(!evt.isActionKey() && evt.getKeyCode() != KeyEvent.VK_SHIFT && evt.getKeyCode() != KeyEvent.VK_CONTROL){
            ModeloTablaUsuarios mtu1 = new ModeloTablaUsuarios(this.ventana.verApellido().getText().trim());
            tablaUsuarios.setModel(mtu1);
                if (tablaUsuarios.getRowCount() > 0) {
                    tablaUsuarios.setRowSelectionInterval(0, 0);
                }
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        JTable tablaUsuarios = this.ventana.verTabla();
	ModeloTablaUsuarios mtu1 = new ModeloTablaUsuarios(this.ventana.verApellido().getText().trim());
	tablaUsuarios.setModel(mtu1);
        if (tablaUsuarios.getRowCount() > 0) {
            tablaUsuarios.setRowSelectionInterval(0, 0);
        }
    }
    
    private void agregarListenerATabla(JTable tablaUsuarios) {
        tablaUsuarios.getSelectionModel().addListSelectionListener((e) -> {
        if (!e.getValueIsAdjusting()) {
        //En la tabla se puede seleccionar sólo un elemento a la vez,
        //por lo que cuando se realiza una nueva selección,
        //el elemento seleccionado antes queda como no seleccionado,
        //disparándose 2 eventos
        //Para evitar responder al evento 2 veces
        //se usa getValueIsAdjusting()
        if (tablaUsuarios.getSelectedRow() != -1)
            this.filaSeleccionada = tablaUsuarios.getSelectedRow();
        }
        });
    }
}
