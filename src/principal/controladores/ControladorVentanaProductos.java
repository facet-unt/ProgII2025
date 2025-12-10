package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

public class ControladorVentanaProductos implements IControladorProductos {

    private VentanaProductos vista;
    private VentanaPrincipal ventanaPadre;

   public ControladorVentanaProductos(VentanaPrincipal ventanaPadre) {
        this.ventanaPadre= ventanaPadre;
        this.vista = new VentanaProductos(null, true, this);       
        this.vista.setTitle(TITULO);
        this.btnBuscarClic(null);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);   
    }
    @Override
    public void btnBorrarClic(ActionEvent evt) {
    Producto borrado = this.obtenerProductoSeleccionado();
    
        if(borrado != null){
        int opcion = JOptionPane.showOptionDialog(null,
                IControladorProductos.CONFIRM,
                IControladorProductos.BORRARPRODUCTO, 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Sí", "No"}, "No");
        
        if (opcion == JOptionPane.YES_OPTION){
            GestorProductos gp = GestorProductos.instanciar();
            String resultado = gp.borrarProducto(borrado);
  
            if(resultado.equals(IGestorProductos.BORRADO)) {
                this.btnBuscarClic(null);
            } else {
                JOptionPane.showMessageDialog(null,
                    resultado, 
                    IControladorProductos.ERROR_BORRAR,
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null,
            "Seleccione el producto a eliminar",
            IControladorProductos.TITULO,
            JOptionPane.WARNING_MESSAGE);
    }
}
   

    @Override
    public void btnBuscarClic(ActionEvent evt) {
         GestorProductos gestor = GestorProductos.instanciar();
        List<Producto> productos;
        String textoBuscado = this.vista.conseguirTxt();
        
        if (textoBuscado == null || textoBuscado.isEmpty()) {
            productos = gestor.menu();    
        } else {
            productos = gestor.buscarProductos(textoBuscado);   
        }
        this.vista.actualizarTabla(productos);
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        btnBuscarClic(null);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto cvp = new ControladorVentanaAMProducto(this.ventanaPadre, null);
    }

   @Override
    public void btnModificarClic(ActionEvent evt) {
    Producto modificado = this.obtenerProductoSeleccionado();
    if(modificado != null) {
        IControladorAMProducto cvap = new ControladorVentanaAMProducto(this.ventanaPadre, modificado);
        this.btnBuscarClic(null);
    } else {
        JOptionPane.showMessageDialog(null, 
            "Seleccione un producto para su modificación.",
            IControladorProductos.TITULO, 
            JOptionPane.WARNING_MESSAGE);
    }
}

 private Producto obtenerProductoSeleccionado() {
        return this.vista.obtenerProductoSeleccionado();    
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.vista.dispose(); 
    }
    
     @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        GestorProductos gp = GestorProductos.instanciar();
        List<Producto> listaProductosActualizada = gp.menu();
        this.vista.actualizarTabla(listaProductosActualizada);
    }
}

