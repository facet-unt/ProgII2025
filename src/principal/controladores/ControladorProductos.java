package principal.controladores;

import Interfaces.IControladorProductos;
import productos.vistas.VentanaProductos;
import productos.modelos.GestorProductos; 
import productos.modelos.Producto; 
// Importaciones necesarias para Alta/Modificación:
import productos.vistas.VentanaAMProducto; 
import principal.vistas.VentanaPrincipal; // Necesario para obtener la ventana padre Frame

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities; // Necesario para obtener el ancestro Frame

public class ControladorProductos implements IControladorProductos {

    private VentanaProductos vista; 
    private final GestorProductos gestor; 

    /**
     * Constructor. Recibe la vista (inicialmente null desde ControladorVentanaPrincipal).
     */
    public ControladorProductos(VentanaProductos vista) {
        this.vista = vista; 
        this.gestor = GestorProductos.instanciar(); 
    }
    
    /**
     * Permite que la Vista se inyecte a sí misma en el Controlador.
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
        if (this.vista == null) {
            System.err.println("Advertencia: No se puede actualizar la tabla. La referencia de la vista es nula.");
            return;
        }
        
        // Usamos el método menu() del gestor para obtener todos los productos
        List<Producto> productos = gestor.menu(); 
        vista.setProductos(productos); 
    }
    
    // --- Implementación de IControladorProductos (Manejo de Eventos) ---

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String descripcion = vista.getDescripcionBusqueda();
        List<Producto> productosEncontrados = gestor.buscarProductos(descripcion);
        vista.setProductos(productosEncontrados);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        // MODO ALTA: Llama a la función auxiliar pasando NULL
        abrirVentanaAM(null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        Producto productoAEditar = vista.getProductoSeleccionado();
        if (productoAEditar == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // MODO MODIFICACIÓN: Llama a la función auxiliar pasando el Producto seleccionado
        abrirVentanaAM(productoAEditar);
    }

    /**
     * Lógica unificada para abrir la ventana de Alta o Modificación.
     * @param producto Producto a editar (Modificación), o null (Alta).
     */
    
    
    private void abrirVentanaAM(Producto producto) {

    // Obtener ventana padre
    VentanaPrincipal ventanaPadre = (VentanaPrincipal) SwingUtilities.getWindowAncestor(vista);

    // Crear la vista AM sin controlador
    VentanaAMProducto vistaAM = new VentanaAMProducto(ventanaPadre, null, producto);

    // Crear el controlador AM
    ControladorAMProducto controladorAMProducto = new ControladorAMProducto(vistaAM);

    // Inicializar la vista AM con su controlador
    vistaAM.inicializarControlador(controladorAMProducto);

    // Mostrar la ventana
    vistaAM.setVisible(true);
    }


    
    
    // --- MÉTODOS DE BORRADO, VOLVER, TECLADO Y FOCO ---
    
    @Override
    public void btnBorrarClic(ActionEvent evt) {
        Producto productoABorrar = vista.getProductoSeleccionado();
        if (productoABorrar == null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto para borrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int confirmacion = JOptionPane.showConfirmDialog(vista, 
                "¿Desea borrar el producto: " + productoABorrar.verDescripcion() + "?", 
                "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            String resultado = gestor.borrarProducto(productoABorrar);
            
            if (resultado.equals(GestorProductos.EXITO_BORRADO) || resultado.equals(GestorProductos.EXITO)) {
                JOptionPane.showMessageDialog(vista, "Producto borrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista, "Error al borrar: " + resultado, "Error", JOptionPane.ERROR_MESSAGE);
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
        // Se llama cuando la ventana regresa del modo modal (cerrar Alta/Modificación)
        actualizarTablaProductos();
    }
}