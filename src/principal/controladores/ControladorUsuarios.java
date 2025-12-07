/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;
/**
 *
 * @author Usuario
 */


import interfaces.IControladorUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JOptionPane;
import usuarios.vistas.VentanaUsuarios;
// import usuarios.vistas.VentanaAMUsuario; 

public class ControladorUsuarios implements IControladorUsuarios, ActionListener, WindowFocusListener, KeyListener {

    private VentanaUsuarios vista;

    public ControladorUsuarios(VentanaUsuarios vista) {
        this.vista = vista;
        
        this.vista.getBtnNuevo().addActionListener(this);
        this.vista.getBtnModificar().addActionListener(this);
        this.vista.getBtnBorrar().addActionListener(this);
        this.vista.getBtnVolver().addActionListener(this);
        this.vista.getBtnBuscar().addActionListener(this);
        
        // --- CORRECCIÓN AQUÍ ---
        // Antes decía getTxtApellido(), ahora dice getTxtBuscar() para coincidir con la ventana
        this.vista.getTxtBuscar().addKeyListener(this);
        
        this.vista.addWindowFocusListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnNuevo()) {
            this.btnNuevoClic(e);
        } else if (e.getSource() == vista.getBtnModificar()) {
            this.btnModificarClic(e);
        } else if (e.getSource() == vista.getBtnBorrar()) {
            this.btnBorrarClic(e);
        } else if (e.getSource() == vista.getBtnVolver()) {
            this.btnVolverClic(e);
        } else if (e.getSource() == vista.getBtnBuscar()) {
            this.btnBuscarClic(e);
        }
    }

    // --- MÉTODOS DE LA INTERFAZ DEL PROFESOR ---

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        System.out.println("Abriendo ventana de Alta...");
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (vista.getTablaUsuarios().getSelectedRow() != -1) {
            System.out.println("Modificando usuario seleccionado...");
        } else {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario");
        }
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (vista.getTablaUsuarios().getSelectedRow() != -1) {
            int opcion = JOptionPane.showConfirmDialog(vista, CONFIRMACION, TITULO, JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                System.out.println("Borrando usuario...");
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario para borrar");
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        // Aquí también usamos getTxtBuscar()
        System.out.println("Filtrando tabla por: " + vista.getTxtBuscar().getText());
    }

    @Override
    public void txtApellidoPresionarTecla(KeyEvent evt) {
        // Lógica de búsqueda en tiempo real
        System.out.println("Tecla presionada en buscador");
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        System.out.println("Refrescando tabla...");
    }
    
    // Métodos obligatorios extra
    @Override public void keyTyped(KeyEvent e) { txtApellidoPresionarTecla(e); }
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void windowGainedFocus(WindowEvent e) { ventanaObtenerFoco(e); }
    @Override public void windowLostFocus(WindowEvent e) {}
}