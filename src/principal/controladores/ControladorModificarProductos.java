/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import productos.modelos.GestorProductos;
import productos.vistas.VentanaModificarProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author octav
 */
public class ControladorModificarProductos implements IControladorAMProducto{
    private static ControladorModificarProductos instancia;
    private VentanaProductos ventanaProductos;
    private VentanaModificarProductos ventanaModificarProductos;
    private int codigo;
    private float precio;
    private String descripcion;
    IGestorProductos gestorProductos = GestorProductos.instanciar();
     public ControladorModificarProductos() {
        ventanaModificarProductos = new VentanaModificarProductos(ventanaProductos,this);
        ventanaModificarProductos.setLocationRelativeTo(ventanaProductos);
        ventanaModificarProductos.setTitle(TITULO_MODIFICAR);
        ventanaModificarProductos.setVisible(true);
        ventanaModificarProductos.toFront();
        ventanaModificarProductos.requestFocus();
        ventanaModificarProductos.requestFocusInWindow();
    }
    
    public static ControladorModificarProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorModificarProductos();
        }
        return instancia;
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaModificarProductos.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        gestorProductos.crearProducto(codigo, descripcion, precio, ventanaModificarProductos.categoria, ventanaModificarProductos.estado);    
        ventanaModificarProductos.dispose();
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        String texto = campo.getText().trim();
        this.codigo = Integer.parseInt(texto);
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.descripcion = campo.getText().trim();
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        String texto = campo.getText().trim();
        this.precio = Float.parseFloat(texto);
    }
    
}
