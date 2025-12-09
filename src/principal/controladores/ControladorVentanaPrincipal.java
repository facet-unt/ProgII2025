package principal.controladores;


import Interfaces.IControladorPrincipal;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaUsuarios;
import productos.vistas.VentanaProductos;
import javax.swing.*;
import java.awt.event.ActionEvent;



public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal vista;

    public ControladorVentanaPrincipal(VentanaPrincipal vista) {
        this.vista = vista;
        vista.getBtnUsuarios().addActionListener(this::btnUsuariosClic);
        vista.getBtnProductos().addActionListener(this::btnProductosClic);
        vista.getBtnSalir().addActionListener(this::btnSalirClic);
    }

    

    @Override
    public void btnProductosClic(ActionEvent evt) {

        // 1. Crear el Controlador de Productos, pasando NULL o la vista principal
        //    Usó 'null' para indicar que la vista no está lista para ser usada por el constructor.
        ControladorProductos controladorProductos = new ControladorProductos(null); 

        // 2. Crear la Vista, pasándole la Ventana Principal (vista) como padre y el controlador.
        //    Esto asigna el controlador a la vista.
        VentanaProductos ventanaProductos = new VentanaProductos(vista, controladorProductos);

        // llamamos a iniciar para que cargue la tabla.
        controladorProductos.iniciar(); 

        // 4. Mostrar la ventana
        ventanaProductos.setVisible(true);
    }

    @Override
    public void btnUsuariosClic(ActionEvent evt) {
       
        // ventana pide (Frame, boolean)
        // 'vista' es la ventana principal (Frame) y 'true' es para que sea modal
        VentanaUsuarios ventanaUsuarios = new VentanaUsuarios(vista, true);
        
        // Creó el controlador
        new ControladorUsuarios(ventanaUsuarios); 
        
        // Mostramos la ventana
        ventanaUsuarios.setVisible(true);
    }    

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(
                vista,
                "¿Desea salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}