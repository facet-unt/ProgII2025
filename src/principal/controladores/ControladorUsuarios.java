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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloTablaUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author thoma
 */
public class ControladorUsuarios implements IControladorUsuarios{
    private static ControladorUsuarios instancia;
    private VentanaUsuarios ventana;
    private ModeloTablaUsuarios modeloTabla;
    private int filaSeleccionada = -1;
    
    private ControladorUsuarios() {
        this.ventana = new VentanaUsuarios(this);
        this.ventana.setTitle(TITULO);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setResizable(false);
        
        this.modeloTabla = new ModeloTablaUsuarios();
        this.actualizarTabla();
        this.ventana.definirModeloTabla(this.modeloTabla);
        this.agregarListenerATabla(this.ventana.verJtableUsuarios());
    }
    
    public static ControladorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        
        instancia.ventana.setVisible(true);
        
        return instancia;
    }
    
    private void actualizarTabla() {
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        this.modeloTabla.dibujarTabla(gu.verUsuarios());
        this.filaSeleccionada = -1;
    }
    
    // Metodo listener para tabla
     private void agregarListenerATabla(JTable tabla) {
         tabla.getSelectionModel().addListSelectionListener((e) -> {
             if (!e.getValueIsAdjusting()) {
                 if (tabla.getSelectedRow() != -1) {
                     this.filaSeleccionada = tabla.getSelectedRow();
                 }
                 else {
                     this.filaSeleccionada = -1; // Vuelve a hacer -1 la variable si se deselecciona en la tabla
                 }
             }
         });
     }
    
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMUsuario controladorNuevoUsuario = ControladorAMUsuario.instanciar(null);
        this.actualizarTabla();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this.ventana, "Seleccione un usuario en la tabla para modificar", "Atencion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Usuario usuarioAModificar = this.modeloTabla.obtenerUsuarioEnFila(filaSeleccionada);
        
        IControladorAMUsuario controladorModificarUsuario = ControladorAMUsuario.instanciar(usuarioAModificar);
        this.actualizarTabla();
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1){
            JOptionPane.showMessageDialog(this.ventana, "Seleccione un usuario en la tabla para borrar", "Atencion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Usuario usuarioABorrar = this.modeloTabla.obtenerUsuarioEnFila(filaSeleccionada);
        
        int opcion = JOptionPane.showConfirmDialog(this.ventana, CONFIRMACION, "Borrar usuario", JOptionPane.YES_NO_OPTION);
        
        if (opcion == 0) {
            IGestorUsuarios gu = GestorUsuarios.instanciar();
            String resultado = gu.borrarUsuario(usuarioABorrar);
            
            if (!resultado.equals("Usuario eliminado correctamente")) {
                JOptionPane.showMessageDialog(this.ventana, resultado, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this.ventana, resultado, "EXITO   ", JOptionPane.INFORMATION_MESSAGE);
                this.actualizarTabla();
            }
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        this.btnBuscarClic(null);
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String apellidoBuscado = this.ventana.verTxtApellido().getText().trim();
        
        IGestorUsuarios gu = GestorUsuarios.instanciar();
        List<Usuario> listaUsuariosEncontrados;
        
        if (apellidoBuscado == null || apellidoBuscado.isBlank()) {
            listaUsuariosEncontrados = gu.verUsuarios();
        }
        else {
            listaUsuariosEncontrados = gu.buscarUsuarios(apellidoBuscado);
        }
        
        this.modeloTabla.dibujarTabla(listaUsuariosEncontrados);
    }
}
