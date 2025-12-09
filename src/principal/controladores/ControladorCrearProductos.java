/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import static interfaces.IControladorAMProducto.TITULO_NUEVO;
import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_ESTADO;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.vistas.VentanaCrearProductos;
import productos.vistas.VentanaProductos;

/**
 *
 * @author ortiz
 */
public class ControladorCrearProductos implements IControladorAMProducto {
    private static ControladorCrearProductos instancia;
    private static VentanaProductos ventanaProductos;
    private VentanaCrearProductos ventanaCrearProductos;
    IGestorProductos gestorProductos = GestorProductos.instanciar();
    private int codigo;
    private String descripcion;
    private float precio;
    private ModeloTablaProductos modelo;

    public ControladorCrearProductos(VentanaProductos ventanaProductos) {
        this.ventanaProductos = ventanaProductos;
        ventanaCrearProductos = new VentanaCrearProductos(ventanaProductos,this);
        ventanaCrearProductos.setLocationRelativeTo(ventanaProductos);
        ventanaCrearProductos.setTitle(TITULO_NUEVO);    
        ventanaCrearProductos.setVisible(true); 
        ventanaCrearProductos.toFront();
        ventanaCrearProductos.requestFocus();
        ventanaCrearProductos.requestFocusInWindow();
        
    }
    
    public static ControladorCrearProductos instanciar() {
        if (instancia == null) {
            instancia = new ControladorCrearProductos(ventanaProductos);
        }
        else
            nuevaInstancia(ventanaProductos);
        return instancia;
    }    
    private static void nuevaInstancia(VentanaProductos ventanaProductos){
        instancia = new ControladorCrearProductos(ventanaProductos);
    }
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        ventanaCrearProductos.dispose();
    }
    private void mostrarError(String mensaje) {
    JOptionPane.showMessageDialog(ventanaCrearProductos, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if(codigo<=0)
            mostrarError("Error Codigo");
        else if(descripcion==null||descripcion.isBlank())
            mostrarError("Error descripcion");
        else if(precio<=0)
            mostrarError("Error precio");
        else{
            gestorProductos.crearProducto(codigo, descripcion, precio, ventanaCrearProductos.verCategoria(), ventanaCrearProductos.verEstado());
            ventanaCrearProductos.dispose();
        }
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
        System.out.println(descripcion);
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        String texto = campo.getText().trim();
        this.precio = Float.parseFloat(texto);
    }
    
}
