package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

public class ControladorVentanaAMProducto implements IControladorAMProducto {

    private VentanaAMProducto vista; 
    private Producto productoModificar;
    private boolean esModificacion;
    private final IGestorProductos gestor;

    // ✅ Constructor para CREAR producto
    public ControladorVentanaAMProducto(Producto producto, boolean esModificacion) {
        this.gestor = GestorProductos.instanciar();
        this.productoModificar = producto;
        this.esModificacion = esModificacion;
        
        inicializarVista();
    }

    private void inicializarVista() {
        this.vista = new VentanaAMProducto(null, this);
        
        // Configurar título
        if (esModificacion) {
            vista.setTitle(TITULO_MODIFICAR);
            cargarDatosProducto();
        } else {
            vista.setTitle(TITULO_NUEVO);
        }
        
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setVisible(true);
    }

    // ✅ NUEVO: Carga datos del producto a modificar
    private void cargarDatosProducto() {
        if (productoModificar != null) {
            vista.verTxtCodigo().setText(String.valueOf(productoModificar.verCodigo()));
            vista.verTxtCodigo().setEditable(false); // No se puede cambiar el código
            vista.verTxtDescripcion().setText(productoModificar.verDescripcion());
            vista.verTxtPrecio().setText(String.valueOf(productoModificar.verPrecio()));
            
            // Seleccionar categoría y estado
            ModeloComboCategorias modeloCat = (ModeloComboCategorias) vista.verComboCategorias().getModel();
            modeloCat.seleccionarCategoria(productoModificar.verCategoria());
            
            ModeloComboEstados modeloEst = (ModeloComboEstados) vista.verComboEstado().getModel();
            modeloEst.seleccionarEstado(productoModificar.verEstado());
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            // Obtener datos de la vista
            String codigoStr = vista.verTxtCodigo().getText().trim();
            String descripcion = vista.verTxtDescripcion().getText().trim();
            String precioStr = vista.verTxtPrecio().getText().trim();

            // Validar campos vacíos
            if (codigoStr.isEmpty() || descripcion.isEmpty() || precioStr.isEmpty()) {
                JOptionPane.showMessageDialog(vista, 
                    "Todos los campos son obligatorios", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Parsear valores
            int codigo = Integer.parseInt(codigoStr);
            float precio = Float.parseFloat(precioStr);

            // Obtener categoría y estado
            ModeloComboCategorias modeloCat = (ModeloComboCategorias) vista.verComboCategorias().getModel();
            Categoria categoriaSeleccionada = modeloCat.obtenerCategoria();
            
            ModeloComboEstados modeloEst = (ModeloComboEstados) vista.verComboEstado().getModel();
            Estado estadoSeleccionado = modeloEst.obtenerEstado();

            String resultado;

            if (esModificacion) {
                // ✅ MODIFICAR producto existente
                resultado = gestor.modificarProducto(
                    productoModificar, 
                    codigo, 
                    descripcion, 
                    precio, 
                    categoriaSeleccionada, 
                    estadoSeleccionado
                );
            } else {
                // ✅ CREAR nuevo producto
                resultado = gestor.crearProducto(
                    codigo, 
                    descripcion, 
                    precio, 
                    categoriaSeleccionada, 
                    estadoSeleccionado
                );
            }

            // Mostrar resultado
            if (resultado.equals(IGestorProductos.EXITO) || 
                resultado.equals(IGestorProductos.VALIDACION_EXITO)) {
                JOptionPane.showMessageDialog(vista, 
                    esModificacion ? "Producto modificado con éxito" : "Producto creado con éxito",
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista, 
                    resultado, 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, 
                "El código debe ser un número entero y el precio un número decimal válido.",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, 
                "Error inesperado: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.verTxtDescripcion().requestFocus();
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.verTxtPrecio().requestFocus();
        }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.verComboCategorias().requestFocus();
        }
    }

    public void comboCategoriasPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vista.verComboEstado().requestFocus();
        }
    }

    public void comboEstadoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnGuardarClic(null);
        }
    }
}