/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

/**
 *
 * @author Usuario
 */

            

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import usuarios.vistas.VentanaUsuarios;
import usuarios.vistas.VentanaAMCliente; // Importante: Importar la vista de Cliente

public class ControladorUsuarios implements ActionListener {

    private VentanaUsuarios vista;

    public ControladorUsuarios(VentanaUsuarios vista) {
        this.vista = vista;
        
        // Asignamos los escuchadores a los botones de la ventana de usuarios
        this.vista.getBtnCliente().addActionListener(this);
        this.vista.getBtnEmpleado().addActionListener(this);
        this.vista.getBtnEncargado().addActionListener(this);
        this.vista.getBtnVolver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Detectamos qué botón se presionó
        if (e.getSource() == vista.getBtnCliente()) {
            // AQUI se abre la ventana de Cliente
            // Nota: Recuerda que modificamos el constructor de VentanaAMCliente en el paso anterior
            VentanaAMCliente vCliente = new VentanaAMCliente(vista, true); 
            vCliente.setVisible(true);
            
        } else if (e.getSource() == vista.getBtnEmpleado()) {
            System.out.println("Aquí abrirías la ventana de Empleado");
            
        } else if (e.getSource() == vista.getBtnEncargado()) {
            System.out.println("Aquí abrirías la ventana de Encargado");
            
        } else if (e.getSource() == vista.getBtnVolver()) {
            vista.dispose(); // Cierra la ventana de usuarios
        }
    }
}