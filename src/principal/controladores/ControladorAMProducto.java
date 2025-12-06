/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
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

    public ControladorAMProducto() {
        this.vp = new VentanaAMProducto(null, this);
    }

    public void mostrarVentanaProducto() {
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
        vp.setVisible(true);

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            System.out.println("guardar clic");
            String codigo = vp.verTxtCodigo().getText().trim();
            String descripcion = vp.verTxtDescripcion().getText().trim();
            String precioStr = vp.verTxtPrecio().getText().trim();

            Float precio = Float.parseFloat(precioStr);
            int codigoInt = Integer.parseInt(codigo);
            GestorProductos.instanciar().crearProducto(codigoInt, descripcion, precio, Categoria.ENTRADA, Estado.DISPONIBLE);

            vp.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vp, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("error en guardarclic");
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

}
