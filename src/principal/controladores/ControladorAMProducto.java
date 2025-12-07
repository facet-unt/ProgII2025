/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import productos.modelos.*;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author karen
 */
public class ControladorAMProducto implements IControladorAMProducto {

    private VentanaAMProducto Ventana;
    private Producto amProducto = null;

    public ControladorAMProducto(JDialog padre) {
        this.Ventana = new VentanaAMProducto(padre, this);
        this.Ventana.setLocationRelativeTo(null);
        this.Ventana.setTitle(TITULO_NUEVO);
        this.Ventana.verBotonG().setEnabled(false);
        this.Ventana.setVisible(true);

    }

    public ControladorAMProducto(JDialog padre, Producto amProducto) {
        this.Ventana = new VentanaAMProducto(padre, this);
        this.Ventana.setLocationRelativeTo(null);
        this.amProducto = amProducto;
        this.Ventana.setTitle(TITULO_MODIFICAR);
        this.configurarCampos();
        this.Ventana.setVisible(true);

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        Ventana.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            int codigo = Integer.parseInt(this.Ventana.verTxtcodigo().getText().trim());
            float precio = Float.parseFloat(this.Ventana.verTxtprecio().getText().trim());
            String descripcion = this.Ventana.verTxtDescripcion().getText().trim();
            Categoria categoria = ((ModeloComboCategorias) this.Ventana.verComboCategorias().getModel()).obtenerCategoria();
            Estado estado = ((ModeloComboEstados) this.Ventana.verComboEstados().getModel()).obtenerEstado();
            IGestorProductos gp = GestorProductos.instanciar();
            String resultado;
            if (this.amProducto == null) {
                resultado = gp.crearProducto(codigo, descripcion, precio, categoria, estado);
                if (!resultado.equals(IGestorProductos.EXITO)) {
                    JOptionPane.showMessageDialog(null, resultado, TITULO_NUEVO, JOptionPane.ERROR_MESSAGE);
                } else {
                    this.Ventana.dispose();
                }
            } else {
                resultado = gp.modificarProducto(amProducto, codigo, descripcion, precio, categoria, estado);
                if (!resultado.equals(IGestorProductos.EXITO)) {
                    JOptionPane.showMessageDialog(null, resultado, TITULO_MODIFICAR, JOptionPane.ERROR_MESSAGE);
                } else {
                    this.Ventana.dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código o precio inválido", "PRODUCTO", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado", "PRODUCTO", JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    private void validarCampos() {

        boolean codigoVacio = this.Ventana.verTxtcodigo().getText().trim().isEmpty();
        boolean descripcionVacia = this.Ventana.verTxtDescripcion().getText().trim().isEmpty();
        boolean precioVacio = this.Ventana.verTxtprecio().getText().trim().isEmpty();

        this.Ventana.verBotonG().setEnabled(!(codigoVacio || descripcionVacia || precioVacio));
    }

    private void configurarCampos() {
        if (this.amProducto != null) {
            this.Ventana.verTxtcodigo().setText(Integer.toString(amProducto.verCodigo()));
            this.Ventana.verTxtcodigo().setEnabled(false);
            this.Ventana.verTxtDescripcion().setText(amProducto.verDescripcion());
            this.Ventana.verTxtprecio().setText(Float.toString(amProducto.verPrecio()));
            ((ModeloComboCategorias) this.Ventana.verComboCategorias().getModel()).seleccionarCategoria(amProducto.verCategoria());
            ((ModeloComboEstados) this.Ventana.verComboEstados().getModel()).seleccionarEstado(amProducto.verEstado());

        }
    }
}
