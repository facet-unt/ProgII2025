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
    Producto amProducto = null;

    public ControladorAMProducto(JDialog padre) {
        this.Ventana = new VentanaAMProducto(padre, this);
        this.Ventana.setLocationRelativeTo(null);
        this.Ventana.setTitle(TITULO_NUEVO);
        this.Ventana.setVisible(true);

    }

    public ControladorAMProducto(JDialog padre, Producto amProducto) {
        this.Ventana = new VentanaAMProducto(padre, this);
        this.Ventana.setLocationRelativeTo(null);
        this.amProducto = amProducto;
        this.Ventana.setTitle(TITULO_MODIFICAR);
        this.Ventana.setVisible(true);

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        Ventana.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

        int codigo = Integer.parseInt(this.Ventana.verTxtcodigo().getText().trim());
        String descripcion = this.Ventana.verTxtDescripcion().getText().trim();
        float precio = Float.parseFloat(this.Ventana.verTxtprecio().getText().trim());
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
            System.out.println(resultado);
            if (!resultado.equals(IGestorProductos.EXITO)) {
                JOptionPane.showMessageDialog(null, resultado, TITULO_NUEVO, codigo);
            }
            System.out.println(resultado);
        }

    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        validarCampos();
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        validarCampos();
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
        validarCampos();
    }

    private void validarCampos() {

        boolean codigoVacio = this.Ventana.verTxtcodigo().getText().trim().isEmpty();
        boolean descripcionVacia = this.Ventana.verTxtDescripcion().getText().trim().isEmpty();
        boolean precioVacio = this.Ventana.verTxtprecio().getText().trim().isEmpty();

        this.Ventana.verBotonG().setEnabled(
                !(codigoVacio || descripcionVacia || precioVacio)
        );

//        pintarCampo(this.Ventana.verTxtcodigo(), codigoVacio);
//        pintarCampo(this.Ventana.verTxtDescripcion(), descripcionVacia);
//        pintarCampo(this.Ventana.verTxtprecio(), precioVacio);
    }

    private void pintarCampo(javax.swing.JTextField campo, boolean vacio) {
        if (vacio) {
            campo.setBackground(new java.awt.Color(255, 180, 180)); // rojo claro
        } else {
            campo.setBackground(java.awt.Color.WHITE);
        }
    }
}
