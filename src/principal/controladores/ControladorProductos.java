/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author ortiz
 */
public class ControladorProductos implements IControladorProductos {
    private static ControladorProductos instancia;
    private VentanaPrincipal ventanaPrincipal;
    private VentanaProductos ventanaProductos;
    IGestorProductos gestorProductos = GestorProductos.instanciar();
    private String descripcion;
    private ModeloTablaProductos modelo;
    private Producto producto;
    
    public ControladorProductos(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        ventanaProductos = new VentanaProductos(ventanaPrincipal,true,this,gestorProductos.menu()); 
        ventanaProductos.setTitle("Productos");
        ventanaProductos.setLocationRelativeTo(ventanaPrincipal);
        ventanaProductos.setVisible(true);
    }
    
    public static ControladorProductos instanciar(VentanaPrincipal ventanaPrincipal) {
        if (instancia == null) {
            instancia = new ControladorProductos(ventanaPrincipal);
        }
        else
            nuevaInstancia(ventanaPrincipal);
        return instancia;
}
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        ventanaProductos.requestFocusInWindow();
    }
    private static void nuevaInstancia(VentanaPrincipal ventanaPrincipal){
        instancia = new ControladorProductos(ventanaPrincipal);
    }
    @Override
    public void btnVolverClic(ActionEvent evt) {
        ventanaProductos.setVisible(false);
        ventanaPrincipal.setVisible(true);
        ventanaProductos.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        ventanaProductos.obtenerModeloProductos().setProductos(gestorProductos.buscarProductos(descripcion));
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        JTextField campo = (JTextField) evt.getComponent();
        this.descripcion = campo.getText().trim();
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto controladorProducto = ControladorCrearProductos.instanciar();
        ventanaProductos.obtenerModeloProductos().setProductos(gestorProductos.menu());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        producto = gestorProductos.menu().get(ventanaProductos.filaSeleccionada);
        IControladorAMProducto controladorModificarProducto = ControladorModificarProductos.instanciar(ventanaProductos,producto);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        ventanaProductos.obtenerModeloProductos().eliminarProducto(ventanaProductos.filaSeleccionada);
        producto = gestorProductos.menu().get(ventanaProductos.filaSeleccionada);
        gestorProductos.borrarProducto(producto);
    }
}
