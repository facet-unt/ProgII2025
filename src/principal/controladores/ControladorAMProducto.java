/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Orlando
 */
public class ControladorAMProducto implements IControladorAMProducto {

    private VentanaAMProducto vp; //se instancia en constructor
    private Producto productoAEditar;
    private boolean esModificacion = false;

    public ControladorAMProducto() {
        this.vp = new VentanaAMProducto(null, this);
        this.esModificacion = false; //por defecto
    }

    public void mostrarVentanaProducto() {
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
        vp.setVisible(true);

    }

    public void inicializarModificacion(Producto p) {
        this.productoAEditar = p;
        this.esModificacion = true;
        vp.setTitle("Modificar Producto");
        vp.verTxtCodigo().setText(String.valueOf(p.verCodigo()));
        vp.verTxtCodigo().setEditable(false);
        vp.verTxtDescripcion().setText(p.verDescripcion());
        vp.verTxtPrecio().setText(String.valueOf(p.verPrecio()));
        vp.verComboCategorias().setSelectedItem(p.verCategoria().toString());
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vp.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            String codigo = vp.verTxtCodigo().getText().trim();
            String descripcion = vp.verTxtDescripcion().getText().trim();
            String precioStr = vp.verTxtPrecio().getText().trim();

            Float precio = Float.parseFloat(precioStr);
            int codigoInt = Integer.parseInt(codigo);

            Categoria categoriaSeleccionada = (Categoria) vp.verComboCategorias().getSelectedItem();
            Estado estadoSeleccionado = (Estado) vp.verComboEstado().getSelectedItem();

            IGestorProductos gestor = GestorProductos.instanciar();
            String resultado;

            if (this.esModificacion) {
                resultado = gestor.modificarProducto(this.productoAEditar, codigoInt, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
            } else {
                resultado = gestor.crearProducto(codigoInt, descripcion, precio, categoriaSeleccionada, estadoSeleccionado);
            }

            JOptionPane.showMessageDialog(vp, resultado);

            if (resultado.equals(GestorProductos.EXITO) || resultado.equals(GestorProductos.VALIDACION_EXITO)) {
                vp.dispose();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vp, "El código y el precio deben ser números válidos.");
        } catch (Exception e) {
            System.out.println("Error en guardarclic: " + e);
        }
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtDescripcion().requestFocus();
        }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verTxtPrecio().requestFocus();
        }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Recomendacion: Use las flechas para navegar entre los items");
            vp.verComboCategorias().requestFocus();
        }
    }

    public void comboCategoriasPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            vp.verComboEstado().requestFocus();
        }
    }

    public void comboEstadoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btnGuardarClic(null);
        }
    }
}
