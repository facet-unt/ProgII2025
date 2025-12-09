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
 * @author Gaston
 */
public class ControladorAMProducto implements IControladorAMProducto {
    
    private static ControladorAMProducto instancia;
    private VentanaAMProducto vista;
    private IGestorProductos gestor;
    private Producto productoAModificar;
    public static ControladorAMProducto instanciar(){
        if(instancia == null)
            instancia = new ControladorAMProducto();
        return instancia;
    }
    private ControladorAMProducto(){
        this.gestor = GestorProductos.instanciar();
        this.vista = new VentanaAMProducto(null, true, this);
        this.vista.setLocationRelativeTo(null);
        this.cargarCombos();
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.vista.setVisible(false);
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String codigoStr = this.vista.verTxtCodigo().getText().trim();
        String descripcion = this.vista.verTxtDescripcion().getText().trim();
        String precioStr = this.vista.verTxtPrecio().getText().trim();
        
        String categoriaTexto = this.vista.verCmbCategoria().getSelectedItem().toString();
        String estadoTexto = this.vista.verCmbEstado().getSelectedItem().toString();
        
        Categoria categoria = Categoria.buscarPorValor(categoriaTexto); 
        Estado estado = Estado.buscarPorValor(estadoTexto);

        int codigo = 0;
        float precio = 0;
        
        try {
            codigo = Integer.parseInt(codigoStr);
            precio = Float.parseFloat(precioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this.vista, "El Código y el Precio deben ser números válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        String resultado = "";

        if (this.productoAModificar == null) {
            resultado = this.gestor.crearProducto(codigo, descripcion, precio, categoria, estado);
        } else {
            resultado = this.gestor.modificarProducto(this.productoAModificar, codigo, descripcion, precio, categoria, estado);
        }

        if (resultado.equals(GestorProductos.EXITO)) {
             JOptionPane.showMessageDialog(this.vista, resultado, "Éxito", JOptionPane.INFORMATION_MESSAGE);
             this.vista.setVisible(false);
        } else {
             JOptionPane.showMessageDialog(this.vista, resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {

    }
    public void crear() {
        this.productoAModificar = null;
        this.vista.setTitle(TITULO_NUEVO);
        this.limpiarPantalla();
        this.vista.verTxtCodigo().setEditable(true);
        this.vista.setVisible(true);
    }

    public void modificar(Producto p) {
        this.productoAModificar = p;
        this.vista.setTitle(TITULO_MODIFICAR);
        
        this.vista.verTxtCodigo().setText(String.valueOf(p.verCodigo()));
        this.vista.verTxtDescripcion().setText(p.verDescripcion());
        this.vista.verTxtPrecio().setText(String.valueOf(p.verPrecio()));
        

        this.vista.verCmbCategoria().setSelectedItem(p.verCategoria());
        this.vista.verCmbEstado().setSelectedItem(p.verEstado());
        

        this.vista.verTxtCodigo().setEditable(false);
        
        this.vista.setVisible(true);
    }
    private void cargarCombos() {
        this.vista.verCmbCategoria().removeAllItems();
        for (Categoria c : Categoria.values()) {
            this.vista.verCmbCategoria().addItem(c.toString());
        }
        
        this.vista.verCmbEstado().removeAllItems();
        for (Estado e : Estado.values()) {
            this.vista.verCmbEstado().addItem(e.toString());
        }
    }
    private void limpiarPantalla() {
        this.vista.verTxtCodigo().setText("");
        this.vista.verTxtDescripcion().setText("");
        this.vista.verTxtPrecio().setText("");
        this.vista.verCmbCategoria().setSelectedIndex(0);
        this.vista.verCmbEstado().setSelectedIndex(0);
    }
}
