/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IControladorAMProducto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author damia
 */
public class ControladorAMProducto implements IControladorAMProducto{
    private VentanaAMProducto ventanaAM;
    private GestorProductos gp;
    private Producto productoAModificar;

    public ControladorAMProducto(VentanaAMProducto ventanaAM) {
        this.ventanaAM = ventanaAM;
        this.gp = GestorProductos.instanciar();
    }
    
    public void ventanaObtenerFoco(WindowEvent evt){
        if (ventanaAM.getTitle().equals(IControladorAMProducto.TITULO_MODIFICAR)) {
            int codigo = Integer.parseInt(ventanaAM.verTxtCodigo().getText().trim());
            String descripcion = ventanaAM.verTxtDescripcion().getText().trim();        
            float precio = Float.parseFloat(ventanaAM.verTxtPrecio().getText().trim());
            Categoria categoria = ((ModeloComboCategorias)ventanaAM.verComboCategorias().getModel()).obtenerCategoria();
            Estado estado = ((ModeloComboEstados)ventanaAM.verComboEstados().getModel()).obtenerEstado();
            this.productoAModificar = new Producto(codigo, descripcion, categoria, estado, precio);
        }
    }
    
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcion = JOptionPane.showConfirmDialog(ventanaAM, "¿Esta seguro que quiere salir? el producto no se guardara");
        if (opcion == JOptionPane.YES_OPTION){
            ventanaAM.dispose();
        }
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if (ventanaAM.getTitle().equals(IControladorAMProducto.TITULO_NUEVO)) {
            try{
                int codigo = Integer.parseInt(ventanaAM.verTxtCodigo().getText().trim());
                String descripcion = ventanaAM.verTxtDescripcion().getText().trim();        
                float precio = Float.parseFloat(ventanaAM.verTxtPrecio().getText().trim());
                Categoria categoria = ((ModeloComboCategorias)ventanaAM.verComboCategorias().getModel()).obtenerCategoria();
                Estado estado = ((ModeloComboEstados)ventanaAM.verComboEstados().getModel()).obtenerEstado();
                String mensaje = gp.crearProducto(codigo, descripcion, precio, categoria, estado);
                if (mensaje == GestorProductos.EXITO) {
                    JOptionPane.showMessageDialog(ventanaAM, mensaje);
                    ventanaAM.dispose();
                } else {
                    JOptionPane.showMessageDialog(ventanaAM, mensaje);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(ventanaAM, "No se ha podido crear el producto: " + e.getMessage());
            }
        } else {
            try{
                int codigo = Integer.parseInt(ventanaAM.verTxtCodigo().getText().trim());
                String descripcion = ventanaAM.verTxtDescripcion().getText().trim();        
                float precio = Float.parseFloat(ventanaAM.verTxtPrecio().getText().trim());
                Categoria categoria = ((ModeloComboCategorias)ventanaAM.verComboCategorias().getModel()).obtenerCategoria();
                Estado estado = ((ModeloComboEstados)ventanaAM.verComboEstados().getModel()).obtenerEstado();
                String mensaje = gp.modificarProducto(this.productoAModificar, codigo, descripcion, precio, categoria, estado);
                if (mensaje == GestorProductos.EXITO) {
                    JOptionPane.showMessageDialog(ventanaAM, mensaje);
                    ventanaAM.dispose();
                } else {
                    JOptionPane.showMessageDialog(ventanaAM, mensaje);
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(ventanaAM, "No se ha podido crear el producto: " + e.getMessage());
            }
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
    
}
