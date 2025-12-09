package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;


    
public class ControladorVentanaAMProducto implements IControladorAMProducto {

    private VentanaAMProducto vista; 
    private Producto Modificado;
    private boolean modificacion = false;

    public ControladorVentanaAMProducto() {
        this.vista = new VentanaAMProducto(null, this);
        this.modificacion = false; 
    }

    public void mostrarVentanaProducto() {
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setVisible(true);

    }

    public void inicializarModificacion(Producto productomodificado) {
        this.Modificado = productomodificado;
        this.modificacion = true;
        vista.setTitle("Modificar Producto");
        vista.verTxtCodigo().setText(String.valueOf(productomodificado.verCodigo()));
        vista.verTxtCodigo().setEditable(false);
        vista.verTxtDescripcion().setText(productomodificado.verDescripcion());
        vista.verTxtPrecio().setText(String.valueOf(productomodificado.verPrecio()));
        vista.verComboCategorias().setSelectedItem(productomodificado.verCategoria().toString());
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            String codigo = vista.verTxtCodigo().getText().trim();
            String descripcion = vista.verTxtDescripcion().getText().trim();
            String precioStr = vista.verTxtPrecio().getText().trim();

            Float precio = Float.parseFloat(precioStr);
            int codigoInt = Integer.parseInt(codigo);

            Categoria categoriaSeleccionada = (Categoria) vista.verComboCategorias().getSelectedItem();
            Estado estadoSeleccionado = (Estado) vista.verComboEstado().getSelectedItem();

            IGestorProductos gestor = GestorProductos.instanciar();
            String resultado;

            if (this.modificacion) {
                resultado = gestor.modificarProducto(this.Modificado, codigoInt, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
            } else {
                resultado = gestor.crearProducto(codigoInt, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
            }

            JOptionPane.showMessageDialog(vista, resultado);

            if (resultado.equals(GestorProductos.EXITO) || resultado.equals(GestorProductos.VALIDACION_EXITO)) {
                vista.dispose();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El código y el precio deben ser números válidos.");
        } catch (Exception e) {
            System.out.println("Error en guardarclic: " + e);
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
            System.out.println("Recomendacion: Use las flechas para navegar entre los items");
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
            this.btnGuardarClic(null);
        }
    }
}

