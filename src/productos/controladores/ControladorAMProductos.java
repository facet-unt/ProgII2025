/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import productos.vistas.VentanaAMProducto;
import productos.vistas.VentanaProductos;
import productos.modelos.Producto;
import productos.modelos.GestorProductos;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author elame
 */
public class ControladorAMProductos implements IControladorAMProducto {

    private VentanaAMProducto vista;
    private IGestorProductos gestor;
    private Producto productoEdicion;

    public ControladorAMProductos(VentanaProductos padre, Producto productoEdicion) {
        this.gestor = GestorProductos.instanciar();
        this.productoEdicion = productoEdicion;
        this.vista = new VentanaAMProducto(this, padre, true);

        if (productoEdicion != null) {
            this.vista.setTitle(TITULO_MODIFICAR);
            cargarDatos();
        } else {
            this.vista.setTitle(TITULO_NUEVO);
        }
        this.vista.setLocationRelativeTo(padre);
        this.vista.setVisible(true);
    }

    public ControladorAMProductos(VentanaAMProducto padre, Producto productoEdicion) {
        this.gestor = GestorProductos.instanciar();
        this.productoEdicion = productoEdicion;
        this.vista = new VentanaAMProducto(this, padre, true);

        if (productoEdicion != null) {
            this.vista.setTitle(TITULO_MODIFICAR);
            cargarDatos();
        } else {
            this.vista.setTitle(TITULO_NUEVO);
        }
        this.vista.setLocationRelativeTo(padre);
        this.vista.setVisible(true);
    }

    private void cargarDatos() {
        vista.setCodigo(String.valueOf(productoEdicion.verCodigo()));
        vista.setDescripcion(productoEdicion.verDescripcion());
        vista.setPrecio(String.valueOf(productoEdicion.verPrecio()));
        vista.setComboCategorias1(productoEdicion.verCategoria().toString());
        vista.setComboEstado(productoEdicion.verEstado().toString());
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        vista.dispose();
    }

   @Override
    public void btnGuardarClic(ActionEvent evt) {
        try {
            int codigo = Integer.parseInt(vista.getCodigo().getText());
            String descripcion = vista.getDescripcion().getText();
            float precio = Float.parseFloat(vista.getPrecio().getText());
            Categoria categoria = vista.getComboCategorias1();
            
            String estadoSeleccionado = (String) vista.getComboEstado();
            Estado estado = Estado.valueOf(estadoSeleccionado.toUpperCase().replace(" ", "_"));

            if (productoEdicion == null) {
                String resultado = gestor.crearProducto(codigo, descripcion, precio, categoria, estado);
                JOptionPane.showMessageDialog(vista, resultado);
                if (resultado.equals(IGestorProductos.EXITO)) {
                    gestor.crearYescribirArchivo();
                    vista.dispose();
                }
            } else {
                String resultado = gestor.modificarProducto(productoEdicion, codigo, descripcion, precio, categoria, estado);
                JOptionPane.showMessageDialog(vista, resultado);
                if (resultado.equals(IGestorProductos.EXITO)) {
                    gestor.crearYescribirArchivo();
                    vista.dispose();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese valores numéricos válidos para código y precio");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(vista, "Seleccione valores válidos para categoría y estado");
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
