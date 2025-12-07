/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMUsuario;
import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import productos.modelos.ModeloTablaUsuarios;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaDeUsuarios;

/**
 *
 * @author karen
 */
public class ControladorUsuarios implements IControladorUsuarios{
    private VentanaDeUsuarios ventanaUser;
    private int filaSeleccionada=-1;
    
    public ControladorUsuarios(JFrame VentanaPrincipal){
        this.ventanaUser=new VentanaDeUsuarios(VentanaPrincipal,this);
        this.ventanaUser.setLocationRelativeTo(null);
        this.ventanaUser.setTitle(TITULO);
        this.agregarListenerATabla(this.ventanaUser.verTabla());
        this.ventanaUser.setVisible(true);
    }
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario camu = new ControladorAMUsuario(this.ventanaUser);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        JTable tablaProductos = this.ventanaUser.verTabla();
        this.filaSeleccionada = tablaProductos.getSelectedRow();
        if (this.filaSeleccionada!=1) {
            int opcion = JOptionPane.showOptionDialog(null, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null, null,null);
            if (opcion==JOptionPane.YES_OPTION) {
                ModeloTablaUsuarios mtp=(ModeloTablaUsuarios)tablaProductos.getModel();
                Usuario usuarioSele = mtp.usuarioAsignado(filaSeleccionada);
                if (usuarioSele != null) {
                    IGestorUsuarios gu = GestorUsuarios.instanciar();
                    String resultado = gu.borrarUsuario(usuarioSele);
                    if (resultado.equals(IGestorUsuarios.EXITO_BORRADO)) {
                        mtp = new ModeloTablaUsuarios();
                        if (mtp.getRowCount()>0) {
                            this.filaSeleccionada =0;
                            tablaProductos.setRowSelectionInterval(0, 0);
                        }
                        else this.filaSeleccionada=-1;
                    }
                    else JOptionPane.showMessageDialog(null, resultado, TITULO, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        JTable tablaUsuario = this.ventanaUser.verTabla();
        ModeloTablaUsuarios mtu = new ModeloTablaUsuarios();
        tablaUsuario.setModel(mtu);
        if (mtu.getRowCount()>0) {
            if (this.filaSeleccionada == -1) {
                this.filaSeleccionada =0;
            }
            tablaUsuario.setRowSelectionInterval(0, 0);
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventanaUser.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ModeloTablaUsuarios mtu;
        String cadenaApellido = this.ventanaUser.verTxtapellido().getText().trim();
        JTable tablaUsuarios = this.ventanaUser.verTabla();

        if (cadenaApellido.isEmpty()) {
            mtu = new ModeloTablaUsuarios();
            tablaUsuarios.setModel(mtu);
        } else {

            mtu = new ModeloTablaUsuarios(cadenaApellido);
            tablaUsuarios.setModel(mtu);
        }
    }
    
    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (tabla.getSelectedRow() != -1) {
                    this.filaSeleccionada = tabla.getSelectedRow();
                }
            }
        });
    }
    
}
