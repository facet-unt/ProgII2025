/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;
import static interfaces.IControladorPrincipal.TITULO;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author NEW GAME
 */
public class ControladorVentanaProductos implements IControladorProductos {

    private VentanaProductos vista;
    private IGestorProductos gestor;
    private ModeloTablaProductos modeloTabla;
 
    
    
    
    public ControladorVentanaProductos() {
        
        this.vista = new VentanaProductos(null, true,this);
        this.vista.setTitle(TITULO);
        this.vista.setLocationRelativeTo(null);
        this.gestor = GestorProductos.instanciar();
        this.modeloTabla = new ModeloTablaProductos();
        configurarVista();
        this.vista.setVisible(true);
        
    }

    public ModeloTablaProductos getModeloTabla() {
        return modeloTabla;
    }


    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vista.dispose();
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
    String descripcion = vista.obtenerTextoDescripcion(); // antes era conseguirTxt()
    
    if (descripcion == null || descripcion.trim().isEmpty()) {
        modeloTabla.cargarTodos();
    } else {
        modeloTabla.buscarPorDescripcion(descripcion);
    }
    
    vista.actualizarTabla(modeloTabla);

    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) { 
        
    }
    
     private void configurarVista() {
        
        modeloTabla.cargarTodos();
        vista.actualizarTabla(modeloTabla);
        
        // Debug
        System.out.println("🔍 Configurando vista con " + modeloTabla.getRowCount() + " productos");
    }
}