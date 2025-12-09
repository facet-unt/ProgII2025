/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorUsuarios;
import interfaces.IGestorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author Gaston
 */
public class ControladorUsuarios implements IControladorUsuarios{
    
    private static ControladorUsuarios instancia;
    private VentanaUsuarios vista;
    private IGestorUsuarios gestor;
    private int filaSeleccionada = -1;
    
    private ControladorUsuarios(){
        this.gestor = GestorUsuarios.instanciar();
        this.vista = new VentanaUsuarios(null, true, this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle(TITULO);
        this.agregarListenerATabla(this.vista.verTblUsuarios());
    }
    public static ControladorUsuarios instanciar (){
        if(instancia == null)
            instancia = new ControladorUsuarios();
        return instancia;
    }
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMUsuario.instanciar().crear();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this.vista, "Debe seleccionar un usuario.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String correo = (String) this.vista.verTblUsuarios().getValueAt(this.filaSeleccionada, 3);
        Usuario usuarioAModificar = this.gestor.obtenerUsuario(correo);

        if (usuarioAModificar != null) {
            ControladorAMUsuario.instanciar().modificar(usuarioAModificar);
        } else {
            JOptionPane.showMessageDialog(this.vista, "No se encontró el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1) {
            return;
        }
        String correo = (String) this.vista.verTblUsuarios().getValueAt(this.filaSeleccionada, 3);
        Usuario usuarioABorrar = this.gestor.obtenerUsuario(correo);
        int opcion = JOptionPane.showConfirmDialog(this.vista, CONFIRMACION, "Borrar Usuario", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            String resultado = this.gestor.borrarUsuario(usuarioABorrar);
            JOptionPane.showMessageDialog(this.vista, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            this.cargarTabla();
            this.filaSeleccionada = -1;
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.cargarTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vista.setVisible(false);
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        String textoBusqueda = this.vista.verTxtApellidoBuscar().getText();
        
        if (textoBusqueda.trim().isEmpty()) {
            this.cargarTabla();
        } else {
            List<Usuario> resultados = this.gestor.buscarUsuarios(textoBusqueda);
            this.cargarTabla(resultados);
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    }
    public void mostrar() {
        this.cargarTabla();
        this.vista.setVisible(true);
    }
    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                if (tabla.getSelectedRow() != -1)
                    this.filaSeleccionada = tabla.getSelectedRow();
            }
        });
    }
    private void cargarTabla(List<Usuario> listaDeUsuarios) {
        String[] titulos = {"Apellido", "Nombre", "Perfil", "Correo"};       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        for (Usuario u : listaDeUsuarios) {
            Object[] fila = new Object[4];
            fila[0] = u.verApellido();
            fila[1] = u.verNombre();
            if (u instanceof usuarios.modelos.Cliente) fila[2] = Perfil.CLIENTE;
            else if (u instanceof usuarios.modelos.Empleado) fila[2] = Perfil.EMPLEADO;
            else if (u instanceof usuarios.modelos.Encargado) fila[2] = Perfil.ENCARGADO;
            fila[3] = u.verCorreo();
            modelo.addRow(fila);
        }
        this.vista.verTblUsuarios().setModel(modelo);
    }
    private void cargarTabla() {
        this.cargarTabla(this.gestor.verUsuarios());
    }
    
}
