/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author Gaston
 */
public class ControladorProductos implements IControladorProductos{
    
    private static ControladorProductos instancia;
    private VentanaProductos vista;
    private IGestorProductos gestor;
    private int filaSeleccionada = -1;
    public static ControladorProductos instanciar(){
        if(instancia == null)
            instancia = new ControladorProductos();
        return instancia;
    }
    private ControladorProductos(){
        this.gestor = GestorProductos.instanciar();
        this.vista = new VentanaProductos(null, true, this);
        this.vista.setLocationRelativeTo(null);
        this.vista.setTitle(TITULO);
        this.agregarListenerATabla(this.vista.verTblProductos());
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.cargarTabla();
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vista.setVisible(false);
        this.filaSeleccionada = -1;
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        String texto = this.vista.verTxtDescripcion().getText();
        if (texto.trim().isEmpty()) {
            this.cargarTabla();
        } else {
            this.cargarTabla(this.gestor.buscarProductos(texto));
        }
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        ControladorAMProducto.instanciar().crear();
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this.vista, "Seleccione un producto", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Producto p = this.gestor.menu().get(this.filaSeleccionada);
        ControladorAMProducto.instanciar().modificar(p);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (this.filaSeleccionada == -1) return;
        int codigo = (int) this.vista.verTblProductos().getValueAt(this.filaSeleccionada, 0);
        Producto p = this.gestor.obtenerProducto(codigo);
        if (p == null) return;
        int op = JOptionPane.showConfirmDialog(this.vista, CONFIRMACION, "Borrar", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            String resultado = this.gestor.borrarProducto(p);
            JOptionPane.showMessageDialog(this.vista, resultado);
            this.cargarTabla();
            this.filaSeleccionada = -1;
        }
    }
    private void cargarTabla(List<Producto> lista) {
        String[] titulos = {"Codigo", "Descripcion", "Precio","Categoria","Estado"};       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        for (Producto p : lista) {
            Object[] fila = new Object[5];
            
            fila[0] = p.verCodigo();
            fila[1] = p.verDescripcion();
            fila[2] = p.verPrecio();
            fila[3] = p.verCategoria();
            fila[4] = p.verEstado(); 
        
            modelo.addRow(fila);
        }
        this.vista.verTblProductos().setModel(modelo);
        this.filaSeleccionada = -1;
    }
    private void cargarTabla() {
        this.cargarTabla(this.gestor.menu()); 
    }
    private void agregarListenerATabla(JTable tabla) {
        tabla.getSelectionModel().addListSelectionListener((e) -> {
            if (!e.getValueIsAdjusting()) {
                this.filaSeleccionada = tabla.getSelectedRow();
            }
        });
    }
    public void mostrar() {
        this.cargarTabla();
        this.vista.setVisible(true);
    }
}
