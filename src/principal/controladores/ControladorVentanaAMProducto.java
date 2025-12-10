package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import principal.vistas.VentanaPrincipal;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

    public class ControladorVentanaAMProducto implements IControladorAMProducto {

    private VentanaAMProducto ProductosVentana;
    private VentanaPrincipal ventanaPadre;
    private Producto prod;
    
    public ControladorVentanaAMProducto(VentanaPrincipal ventanaPadre, Producto producto) {
        
        this.ventanaPadre= ventanaPadre;
        this.prod = producto;
        this.ProductosVentana = new VentanaAMProducto(ventanaPadre, this);
        ModeloComboCategorias modeloCategorias = new ModeloComboCategorias(); 
        ModeloComboEstados modeloEstados = new ModeloComboEstados();
  
        this.ProductosVentana.configurarCategorias(modeloCategorias); 
        this.ProductosVentana.configurarEstados(modeloEstados);
        if(producto == null){  
           this.ProductosVentana.setTitle(TITULO_NUEVO);
        } 
        else {
          this.ProductosVentana.mostrarProducto(producto);
        }
        this.ProductosVentana.setLocationRelativeTo(null);
        this.ProductosVentana.setVisible(true); 
    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String coincidencia; 
    
    String ObtenerCodigo = this.ProductosVentana.obtenerCodigo();
    String prec = this.ProductosVentana.obtenerPrecio();
    String ObtenerDescripcion = this.ProductosVentana.obtenerDescripcion();
    
    try {
        int Codigo = Integer.parseInt(ObtenerCodigo);
        float Precio = Float.parseFloat(prec);
        Categoria Cat = this.ProductosVentana.comboCategoria();
        Estado Estado = this.ProductosVentana.comboEstado();
        GestorProductos gp =  GestorProductos.instanciar();
        if(this.prod == null)
        {  
            coincidencia = gp.crearProducto(Codigo, ObtenerDescripcion, Precio, Cat, Estado); 
        }
        else {
            coincidencia = gp.modificarProducto(prod, Codigo, ObtenerDescripcion, Precio, Cat, Estado); 
        }
        System.out.println(coincidencia);
        if(coincidencia.equals(IGestorProductos.EXITO)) 
        {    
            this.ProductosVentana.dispose();  
        }
        else
        {
            System.out.println("Error al crear/modificar");
            javax.swing.JOptionPane.showMessageDialog(this.ProductosVentana, coincidencia, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this.ProductosVentana, "Códido y/o precio inválidos", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ProductosVentana.enfocarDescripcion();
       }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ProductosVentana.enfocarPrecio();
       }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ProductosVentana.comboCategoria();
       }
    }
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ProductosVentana.dispose();
    }
    }    
    
