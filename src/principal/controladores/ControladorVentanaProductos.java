package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;

import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

public class ControladorVentanaProductos implements IControladorProductos {

    private final VentanaProductos vista;
    private final ModeloTablaProductos modelo;
    private final IGestorProductos gestor;

    public ControladorVentanaProductos() {

      
        this.gestor = GestorProductos.instanciar();
        this.modelo = new ModeloTablaProductos();

        
        this.vista = new VentanaProductos(this);
        this.vista.getTableMenu().setModel(this.modelo);

       
        refrescarTabla();

       
        this.vista.setTitle(TITULO);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

   
    private void refrescarTabla() {
        modelo.actualizarTabla();
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        refrescarTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String filtro = vista.getFieldDescripcion().getText().trim();

        if (filtro.isEmpty()) {
            refrescarTabla();
            return;
        }

        List<Producto> resultado = gestor.buscarProductos(filtro);
        modelo.actualizarTabla(resultado);
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        btnBuscarClic(null);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto controlador = new ControladorVentanaAMProducto();
        ((ControladorVentanaAMProducto) controlador).mostrarVentanaProducto();

        refrescarTabla();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {

        int fila = vista.getTableMenu().getSelectedRow();

        if (fila < 0) {
            vista.mostrarMensaje("Seleccione un producto para modificar.");
            return;
        }

        Producto seleccionado = modelo.obtenerProducto(fila);

        IControladorAMProducto controlador = new ControladorVentanaAMProducto();
        ((ControladorVentanaAMProducto) controlador).inicializarModificacion(seleccionado);
        ((ControladorVentanaAMProducto) controlador).mostrarVentanaProducto();

        refrescarTabla();
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {

        int fila = vista.getTableMenu().getSelectedRow();

        if (fila < 0) {
            vista.mostrarMensaje("Seleccione un producto para borrar.");
            return;
        }

        if (!vista.confirmar("¿Seguro que desea borrar este producto?")) {
            return;
        }

        Producto seleccionado = modelo.obtenerProducto(fila);

        String resultado = gestor.borrarProducto(seleccionado);
        vista.mostrarMensaje(resultado);

        refrescarTabla();
    }
}


