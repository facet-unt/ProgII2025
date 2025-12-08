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
import productos.modelos.Producto;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;
import usuarios.vistas.VentanaUsuarios;

/**
 *
 * @author Sofia
 */
public class ControladorUsuarios implements IControladorUsuarios{
    
    private VentanaUsuarios vu;
    private GestorUsuarios gu;
    private ModeloTablaUsuarios model;
    
    private boolean modificar=false; 

    public ControladorUsuarios() {
        this.vu = new VentanaUsuarios(this);
        this.gu = GestorUsuarios.instanciar();

        this.model = new ModeloTablaUsuarios();
        vu.gettablaUsuario().setModel(model);
        model.actualizarTabla();
        vu.setVisible(true);
        vu.setLocationRelativeTo(null);
       
        
    }
    

    @Override
    public void btnNuevoClic(ActionEvent evt) {
     ControladorAMUsuarios camu = new ControladorAMUsuarios(modificar);    
        
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
         modificar=true;
              int fila = vu.gettablaUsuario().getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vu, "Seleccione un usuario para modificar.");
            return;
        }
        
        ControladorAMUsuarios camu = new ControladorAMUsuarios(this.pasarUsuario(),modificar);
        
        model.actualizarTabla();
        modificar=false;
        
        
        
    }
    
    public Usuario pasarUsuario()
    {
         int fila = vu.gettablaUsuario().getSelectedRow();
        Usuario usuario= model.obtenerUsuario(fila);
        return usuario;
        
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        int fila = vu.gettablaUsuario().getSelectedRow();

        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(vu, "Seleccione un usuario para borrar.");
            return;
        }

        int opcion = javax.swing.JOptionPane.showConfirmDialog(vu,
                "¿Seguro que desea borrar este producto?",
                "Confirmar Borrado",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            Usuario u = model.obtenerUsuario(fila);

            IGestorUsuarios gestor = GestorUsuarios.instanciar();
            String resultado = gestor.borrarUsuario(this.pasarUsuario());

            javax.swing.JOptionPane.showMessageDialog(vu, resultado);
            model.actualizarTabla();
           }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
         this.model.actualizarTabla();
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vu.dispose();
    }
        
    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
         
            this.btnBuscarClic(null);
        
        
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
           String texto = vu.getFieldDescripcion().getText().trim();

        IGestorUsuarios gestor = GestorUsuarios.instanciar();

        if (texto.isEmpty()) {
            model.actualizarTabla();
        } else {
            List<Usuario> filtrados = gestor.buscarUsuarios(texto);
            model.actualizarTabla(filtrados);
        }
        
    
}
}
