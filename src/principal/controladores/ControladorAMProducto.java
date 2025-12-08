/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ESCRITURA_OK;
import static interfaces.IGestorProductos.EXITO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author salut
 */
public class ControladorAMProducto implements IControladorAMProducto{
    private VentanaAMProducto ventana;
    private Producto productoAModificar = null;
    private boolean nuevoProducto;
    
    public ControladorAMProducto(VentanaProductos ventanaPadre){
        this.nuevoProducto = true;
        this.ventana = new VentanaAMProducto(ventanaPadre,this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO_NUEVO);
        ModeloComboEstados mce = new ModeloComboEstados();
        JComboBox<String> comboEstados = this.ventana.verComboBoxEstados();
        comboEstados.setModel(mce);
        ModeloComboCategorias mcc = new ModeloComboCategorias();
        JComboBox<String> comboCategorias = this.ventana.verComboBoxCategorias();
        comboCategorias.setModel(mcc);
        this.ventana.setVisible(true);
    }
    
    public ControladorAMProducto(VentanaProductos ventanaPadre, Producto productoAModificar){
        this.nuevoProducto = false;
        this.productoAModificar = productoAModificar;
        this.ventana = new VentanaAMProducto(ventanaPadre,this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO_MODIFICAR);
        ModeloComboEstados mce = new ModeloComboEstados();
        JComboBox<String> comboEstados = this.ventana.verComboBoxEstados();
        comboEstados.setModel(mce);
        ModeloComboCategorias mcc = new ModeloComboCategorias();
        JComboBox<String> comboCategorias = this.ventana.verComboBoxCategorias();
        comboCategorias.setModel(mcc);
        this.configurarCampos(productoAModificar);
        this.ventana.setVisible(true);
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventana.dispose();
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        IGestorProductos gp = GestorProductos.instanciar();
        if(nuevoProducto){
            Categoria categoria = (Categoria)this.ventana.verComboBoxCategorias().getSelectedItem();
            Estado estado = (Estado)this.ventana.verComboBoxEstados().getSelectedItem();
            String descripcion = this.ventana.verCampoDescripcion().getText().trim();
            int codigo;
            float precio;
            try {
                codigo = Integer.parseInt(this.ventana.verCampoCodigo().getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.ventana,IGestorProductos.ERROR_CODIGO,"Error al crear el Producto",JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                precio = Float.parseFloat(this.ventana.verCampoPrecio().getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.ventana,IGestorProductos.ERROR_PRECIO,"Error al crear el Producto",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!gp.crearProducto(codigo, descripcion, precio, categoria, estado).equals(IGestorProductos.ESCRITURA_OK)) {
                JOptionPane.showMessageDialog(this.ventana, gp.crearProducto(codigo, descripcion, precio, categoria, estado),"Error al crear el Producto", JOptionPane.ERROR_MESSAGE);
            }else{
                this.ventana.dispose();
            }
        }
        if(!nuevoProducto){
            Categoria categoria = (Categoria)this.ventana.verComboBoxCategorias().getSelectedItem();
            Estado estado = (Estado)this.ventana.verComboBoxEstados().getSelectedItem();
            String descripcion = this.ventana.verCampoDescripcion().getText().trim();
            int codigo = Integer.parseInt(this.ventana.verCampoCodigo().getText().trim());
            float precio;
            try {
                precio = Float.parseFloat(this.ventana.verCampoPrecio().getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this.ventana,IGestorProductos.ERROR_PRECIO,"Error al crear el Producto",JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!gp.modificarProducto(this.productoAModificar,codigo, descripcion, precio, categoria, estado).equals(IGestorProductos.EXITO)) {
                JOptionPane.showMessageDialog(this.ventana, gp.modificarProducto(this.productoAModificar,codigo, descripcion, precio, categoria, estado),"Error al modificar el Producto", JOptionPane.ERROR_MESSAGE);
            }else{
                this.ventana.dispose();
            }
        }
    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void configurarCampos(Producto p){
        this.ventana.verCampoCodigo().setText(Integer.toString(p.verCodigo()));
        this.ventana.verCampoDescripcion().setText(p.verDescripcion());
        this.ventana.verCampoCodigo().setEnabled(false);
        this.ventana.verCampoPrecio().setText(Float.toString(p.verPrecio()));
        this.ventana.verComboBoxCategorias().setSelectedItem(p.verCategoria());
        this.ventana.verComboBoxEstados().setSelectedItem(p.verEstado());
    }
    
}
