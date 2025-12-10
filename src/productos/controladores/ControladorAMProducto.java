package productos.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import productos.modelos.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import productos.vistas.VentanaAMProducto;

public class ControladorAMProducto implements IControladorAMProducto{
    private VentanaAMProducto ventana;
    private GestorProductos gestor = GestorProductos.instanciar();
    private Producto producto;

    public ControladorAMProducto(VentanaAMProducto ventana, Producto producto) {
        this.ventana = ventana;
        this.producto = producto;
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventana.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            int codigo = Integer.parseInt(ventana.getCodigo());
            String descripcion = ventana.getDescripcion();
            float precio = Float.parseFloat(ventana.getPrecio());
            Categoria categoria = ventana.getCategoriaSeleccionada();
            Estado estado = ventana.getEstadoSeleccionado();

            String resultado;
            if (producto == null) {
                resultado = gestor.crearProducto(codigo, descripcion, precio, categoria, estado);
            } else {
                resultado = gestor.modificarProducto(producto, codigo, descripcion, precio, categoria, estado);
            }

            JOptionPane.showMessageDialog(ventana, resultado);
            if (resultado.equals(IGestorProductos.EXITO)) {
                ventana.dispose();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(ventana, "Los campos Código y Precio deben ser numéricos");
        }
    }

    @Override
    public void txtCodigoPresionarTecla(java.awt.event.KeyEvent evt) {}

    @Override
    public void txtDescripcionPresionarTecla(java.awt.event.KeyEvent evt) {}

    @Override
    public void txtPrecioPresionarTecla(java.awt.event.KeyEvent evt) {}
}