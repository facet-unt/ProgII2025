package principal.controladores;

import Interfaces.IControladorPrincipal;
import principal.vistas.VentanaPrincipal;
import usuarios.vistas.VentanaUsuarios;
import productos.vistas.VentanaProductos;
// Asegúrate de importar tu ControladorProductos
// import productos.controladores.ControladorProductos; 
import javax.swing.*;
import java.awt.event.ActionEvent;


public class ControladorVentanaPrincipal implements IControladorPrincipal {

    private VentanaPrincipal vista;
    private ControladorProductos controladorProductos;

    public ControladorVentanaPrincipal(VentanaPrincipal vista) {
        this.vista = vista;
        vista.getBtnUsuarios().addActionListener(this::btnUsuariosClic);
        vista.getBtnProductos().addActionListener(this::btnProductosClic);
        vista.getBtnSalir().addActionListener(this::btnSalirClic);
    }

    // --- MANEJO DE VENTANA DE PRODUCTOS ---
    // En principal.controladores.ControladorVentanaPrincipal.java

@Override
public void btnProductosClic(ActionEvent evt) {

    // 1. Crear el Controlador de Productos. 
    // Lo creamos primero, aunque le pasemos 'null' a su constructor, 
    // ¡el objeto 'controladorProductos' ya no es null!
    // Asumimos que tienes el constructor: public ControladorProductos(VentanaProductos vista) { ... }
    ControladorProductos controladorProductos = new ControladorProductos(null); 
    
    // 2. Crear la Vista, pasando el Controlador recién creado.
    // ESTO ES CLAVE: El controladorProductos ahora es un objeto NO NULO.
    // Asumimos que tienes el constructor: public VentanaProductos(VentanaPrincipal vista, ControladorProductos controladorProductos) { ... }
    VentanaProductos ventanaProductos = new VentanaProductos(vista, controladorProductos);

    // *Nota: En este punto, el constructor de VentanaProductos llama a controladorProductos.setVista(this), 
    // *lo cual ahora funciona porque controladorProductos no es null.*

    // 3. Iniciar la lógica del controlador (cargar la tabla, etc.)
    controladorProductos.iniciar(); 

    // 4. Mostrar la ventana
    ventanaProductos.setVisible(true);
}
    
    @Override
    public void btnUsuariosClic(ActionEvent evt) {
        
        VentanaUsuarios ventanaUsuarios = new VentanaUsuarios(vista, true);
        
        // La creación del controlador con la vista inicia la lógica de la ventana de Usuarios.
        new ControladorUsuarios(ventanaUsuarios); 
        
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