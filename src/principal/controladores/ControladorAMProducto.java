package principal.controladores;

import Interfaces.IControladorAMProducto;
import productos.vistas.VentanaAMProducto;
import productos.modelos.GestorProductos; 
import productos.modelos.Producto;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

// Implementa la interfaz IControladorAMProducto y las interfaces de eventos.
public class ControladorAMProducto implements IControladorAMProducto, ActionListener, KeyListener { 

    private final VentanaAMProducto vista;
    private final GestorProductos gestor;

    public ControladorAMProducto(VentanaAMProducto vista) {
        this.vista = vista;
        this.gestor = GestorProductos.instanciar();
        
        
    }

    // -------------------------------------------------------------------
    // --- IMPLEMENTACIÓN DE IControladorAMProducto (Acciones de Botones) ---
    // -------------------------------------------------------------------

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String codigoStr = vista.getTxtCodigo();
        String descripcion = vista.getTxtDescripcion();
        String precioStr = vista.getTxtPrecio();
        Categoria categoria = vista.getCategoriaSeleccionada();
        Estado estado = vista.getEstadoSeleccionado();

        int codigo;
        float precio;

        // 1. Validación de formato numérico
        try {
            codigo = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El código debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            precio = Float.parseFloat(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El precio debe ser un número válido (ej: 12.50).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Llamar al Gestor (Modelo)
        String resultado;
        Producto productoOriginal = vista.getProductoAEditar();

        if (productoOriginal == null) {
            // MODO ALTA
            resultado = gestor.crearProducto(codigo, descripcion, precio, categoria, estado);
        } else {
            // MODO MODIFICACIÓN
            resultado = gestor.modificarProducto(productoOriginal, codigo, descripcion, precio, categoria, estado);
        }

        // 3. Manejo del resultado
        if (resultado.contains("éxito") || resultado.equals(GestorProductos.EXITO)) { 
            JOptionPane.showMessageDialog(vista, resultado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
            vista.dispose(); 
        } else {
            JOptionPane.showMessageDialog(vista, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose(); 
    }
    
    // -------------------------------------------------------------------
    // --- IMPLEMENTACIÓN DE IControladorAMProducto (Eventos de Teclado) ---
    // Estos métodos mueven el foco con la tecla Enter.
    // -------------------------------------------------------------------

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            vista.getTxtDescripcion(); // Asumo que getTxtDescripcion() existe
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            vista.getTxtPrecio(); // Asumo que getTxtPrecio() existe
        }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            // Se puede mover el foco al combo de Categoría o al botón Guardar si es el último campo
            vista.getComboCategoria().requestFocus(); // Asumo que getComboCategoria() existe
        }
    }

    // -------------------------------------------------------------------
    // --- MÉTODOS DE LAS INTERFACES DE EVENTOS (Delegación) ---
    // -------------------------------------------------------------------
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Delega la acción del botón al método de la interfaz
        if (e.getSource() == vista.getBtnGuardar()) {
            btnGuardarClic(e);
        } else if (e.getSource() == vista.getBtnCancelar()) {
            btnCancelarClic(e);
        }
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        // Delega el evento de tecla al método específico
        if (e.getSource() == vista.getTxtCodigo()) {
            txtCodigoPresionarTecla(e);
        } else if (e.getSource() == vista.getTxtDescripcion()) {
            txtDescripcionPresionarTecla(e);
        } else if (e.getSource() == vista.getTxtPrecio()) {
            txtPrecioPresionarTecla(e);
        }
        
    }

    public void ventanaObtenerFoco(WindowEvent e) {
        // Vacío por ahora
    }

}