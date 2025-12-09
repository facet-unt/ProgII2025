package principal.controladores;

import Interfaces.IControladorProductos;
import productos.vistas.VentanaProductos;
import productos.modelos.GestorProductos; 
import productos.modelos.Producto; 

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;

public class ControladorProductos implements IControladorProductos {

    // Se quita 'final' para permitir que la vista se asigne después del constructor.
    private VentanaProductos vista; 
    private final GestorProductos gestor; 

    /**
     * Constructor. Recibe la vista (inicialmente null desde ControladorVentanaPrincipal).
     */
    public ControladorProductos(VentanaProductos vista) {
        this.vista = vista; // Inicialmente null
        this.gestor = GestorProductos.instanciar(); 
    }
    
    /**
     * Permite que la Vista se inyecte a sí misma en el Controlador.
     * ¡Esto soluciona el problema de la referencia nula!
     */
    public void setVista(VentanaProductos vista) { 
        this.vista = vista; 
    }
    
    /**
     * Inicia la carga de datos. Es llamado por ControladorVentanaPrincipal.
     */
    public void iniciar() {
        this.actualizarTablaProductos(); 
    }

    private void actualizarTablaProductos() {
        // La protección de null sigue siendo una buena práctica, aunque ya no debería ser null.
        if (this.vista == null) {
            System.err.println("Advertencia: No se puede actualizar la tabla. La referencia de la vista es nula.");
            return;
        }
        
        List<Producto> productos = gestor.menu();
        vista.setProductos(productos); // Ahora llama a la vista real
    }
    
    // --- Implementación de IControladorProductos (Manejo de Eventos) ---

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        // Se asume que la vista ya está asignada en este punto.
        String descripcion = vista.getDescripcionBusqueda();
        List<Producto> productosEncontrados = gestor.buscarProductos(descripcion);
        vista.setProductos(productosEncontrados);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        JOptionPane.showMessageDialog(vista, "Funcionalidad: Abrir Alta de Producto.");
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        Producto productoAEditar = vista.getProductoSeleccionado();
        if (productoAEditar == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto para modificar.");
            return;
        }
        JOptionPane.showMessageDialog(vista, "Funcionalidad: Modificar " + productoAEditar.verDescripcion());
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        Producto productoABorrar = vista.getProductoSeleccionado();
        if (productoABorrar == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto para borrar.");
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(vista, 
                "¿Desea borrar el producto: " + productoABorrar.verDescripcion() + "?", 
                "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            String resultado = gestor.borrarProducto(productoABorrar);
            
            if (resultado.equals(GestorProductos.EXITO_BORRADO) || resultado.equals(GestorProductos.EXITO)) {
                JOptionPane.showMessageDialog(vista, "Producto borrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "Error al borrar: " + resultado);
            }
            actualizarTablaProductos(); 
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose(); 
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscarClic(null);
        }
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent e) {
        actualizarTablaProductos();
    }
}