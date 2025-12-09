/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import usuarios.vistas.VentanaAMUsuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author damia
 */
public class ControladorVentanaUsuarios implements IControladorUsuarios{
    private VentanaUsuarios ventanaUsuarios;
    private GestorUsuarios gu = GestorUsuarios.instanciar();

    public ControladorVentanaUsuarios(VentanaUsuarios ventanaUsuarios) {
        this.ventanaUsuarios = ventanaUsuarios;
    }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        String[] opciones = {"Encargado", "Empleado", "Cliente", "Cancelar"};
        int opcion = JOptionPane.showOptionDialog(ventanaUsuarios, "¿Cual es el perfil del nuevo usuario?", 
                                                  "Perfil del usuario", JOptionPane.DEFAULT_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[3]);
        switch (opcion){
            case 0:
                VentanaAMUsuario ventanaEncargado = new VentanaAMUsuario(ventanaUsuarios);
                ventanaEncargado.setLocationRelativeTo(null);
                ventanaEncargado.setTitle("Nuevo encargado");
                ventanaEncargado.setVisible(true);
                break;
            case 1:
                VentanaAMUsuario ventanaEmpleado = new VentanaAMUsuario(ventanaUsuarios);
                ventanaEmpleado.setLocationRelativeTo(null);
                ventanaEmpleado.setTitle("Nuevo empleado");
                ventanaEmpleado.setVisible(true);
                break;
            case 2:
                VentanaAMUsuario ventanaCliente = new VentanaAMUsuario(ventanaUsuarios);
                ventanaCliente.setLocationRelativeTo(null);
                ventanaCliente.setTitle("Nuevo cliente");
                ventanaCliente.setVisible(true);
                break;
            case 3:
                break;
            default:
                JOptionPane.showMessageDialog(ventanaUsuarios, "Debe elegir una opcion");
                break;
        }
                                                  
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        int fila;
        Usuario u;
        String correo;
        fila = ventanaUsuarios.verTablaUsuarios().getSelectedRow();
        if (fila != -1) {
            correo = (String)ventanaUsuarios.verTablaUsuarios().getValueAt(fila, 0);
            u = gu.obtenerUsuario(correo);
            switch (u.verPerfil()) {
                case ENCARGADO:
                    {
                        VentanaAMUsuario ventanaModificar = new VentanaAMUsuario(ventanaUsuarios);
                        ventanaModificar.verTxtCorreo().setText(u.verCorreo());
                        ventanaModificar.verTxtApellido().setText(u.verApellido());
                        ventanaModificar.verTxtNombre().setText(u.verNombre());
                        ventanaModificar.verPassClave().setText(u.verClave());
                        ventanaModificar.setTitle("Modificar encargado");
                        ventanaModificar.setLocationRelativeTo(null);
                        ventanaModificar.setVisible(true);
                        break;
                    }
                case EMPLEADO:
                    {
                        VentanaAMUsuario ventanaModificar = new VentanaAMUsuario(ventanaUsuarios);
                        ventanaModificar.verTxtCorreo().setText(u.verCorreo());
                        ventanaModificar.verTxtApellido().setText(u.verApellido());
                        ventanaModificar.verTxtNombre().setText(u.verNombre());
                        ventanaModificar.verPassClave().setText(u.verClave());
                        ventanaModificar.setTitle("Modificar empleado");
                        ventanaModificar.setLocationRelativeTo(null);
                        ventanaModificar.setVisible(true);
                        break;
                    }
                case CLIENTE:
                    {
                        VentanaAMUsuario ventanaModificar = new VentanaAMUsuario(ventanaUsuarios);
                        ventanaModificar.verTxtCorreo().setText(u.verCorreo());
                        ventanaModificar.verTxtApellido().setText(u.verApellido());
                        ventanaModificar.verTxtNombre().setText(u.verNombre());
                        ventanaModificar.verPassClave().setText(u.verClave());
                        ventanaModificar.setTitle("Modificar cliente");
                        ventanaModificar.setLocationRelativeTo(null);
                        ventanaModificar.setVisible(true);
                        break;
                    }
                default:
                    JOptionPane.showMessageDialog(ventanaUsuarios, "Hay un error con el perfil del usuario seleccionado");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(ventanaUsuarios, "No se ha seleccionado ningun usuario");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila;
        Usuario u;
        String correo;
        fila = ventanaUsuarios.verTablaUsuarios().getSelectedRow();
        if (fila != -1) {
            int opcion = JOptionPane.showConfirmDialog(ventanaUsuarios, "¿Esta seguro que quiere borrar este usuario?");
            if (opcion == JOptionPane.YES_OPTION) {
                correo = (String)ventanaUsuarios.verTablaUsuarios().getValueAt(fila, 0);
                u = gu.obtenerUsuario(correo);
                gu.borrarUsuario(u);
            }
        } else {
            JOptionPane.showMessageDialog(ventanaUsuarios, "No se ha seleccionado ningun usuario");
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        TableModel modelo = new ModeloTablaUsuarios(gu.verUsuarios());
        ventanaUsuarios.verTablaUsuarios().setModel(modelo);
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaUsuarios.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        String apellidoTexto;
        apellidoTexto = ventanaUsuarios.verBuscarCampoTexto().getText().trim();
        if (!apellidoTexto.equals("") && apellidoTexto != null) {
            List<Usuario> usuariosPorApellido = new ArrayList<>();
            usuariosPorApellido = gu.buscarUsuarios(apellidoTexto);
            if ((apellidoTexto.charAt(apellidoTexto.length() - 1) != KeyEvent.CHAR_UNDEFINED) && !evt.isActionKey()) {
                TableModel modelo = new ModeloTablaUsuarios(usuariosPorApellido);
                ventanaUsuarios.verTablaUsuarios().setModel(modelo);
            }
        } else {
            TableModel modelo = new ModeloTablaUsuarios(gu.verUsuarios());
            ventanaUsuarios.verTablaUsuarios().setModel(modelo);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String apellidoTexto;
        apellidoTexto = ventanaUsuarios.verBuscarCampoTexto().getText().trim();
        if (!apellidoTexto.equals("") && apellidoTexto != null) {
            List<Usuario> usuariosPorApellido = new ArrayList<>();
            usuariosPorApellido = gu.buscarUsuarios(apellidoTexto);
            TableModel modelo = new ModeloTablaUsuarios(usuariosPorApellido);
            ventanaUsuarios.verTablaUsuarios().setModel(modelo);
        } else {
            TableModel modelo = new ModeloTablaUsuarios(gu.verUsuarios());
            ventanaUsuarios.verTablaUsuarios().setModel(modelo);
        }
    }
}
