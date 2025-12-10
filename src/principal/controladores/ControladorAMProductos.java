/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import static interfaces.IControladorAMProducto.TITULO_NUEVO;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import principal.vistas.VentanaPrincipal;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloComboCategorias;
import productos.modelos.ModeloComboEstados;
import productos.modelos.Producto;
import productos.vistas.VentanaAMProducto;

/**
 *
 * @author rocio
 */
public class ControladorAMProductos implements IControladorAMProducto {

    private VentanaAMProducto ventanaAMProductos;
    private VentanaPrincipal ventanaPadre;
    private Producto producto;
    
    public ControladorAMProductos(VentanaPrincipal ventanaPadre, Producto producto) {
        System.out.println("SE INICIA CONTROLADORamPRODUCTOS ---");
        
        this.ventanaPadre= ventanaPadre;
        this.producto = producto;
        this.ventanaAMProductos = new VentanaAMProducto(ventanaPadre, this);
    
        
        ModeloComboCategorias modeloCategorias = new ModeloComboCategorias(); /* ControladorAM crea el modelo de Categoria y Estado */
        ModeloComboEstados modeloEstados = new ModeloComboEstados();
         
        
        this.ventanaAMProductos.configurarCategorias(modeloCategorias); /*ControladorAM se encarga de dar el modelo a la ventanaAM */
        this.ventanaAMProductos.configurarEstados(modeloEstados);
        
        
        if(producto == null){  /*Control dependiendo si hay o no productos */
           this.ventanaAMProductos.setTitle(TITULO_NUEVO);
        } 
         
        else {
          this.ventanaAMProductos.mostrarProducto(producto);
        }

        this.ventanaAMProductos.setLocationRelativeTo(null); /* Centra la ventana */
        this.ventanaAMProductos.setVisible(true); /* La hace visible */
    }
    
    
    /*Metodo para que destruye la ventana cuando se pulse el boton Cancelar */
    @Override
    public void btnCancelarClic(ActionEvent evt) {
        this.ventanaAMProductos.dispose();
    }
    
    /*Metodo que guarda los datos ingresados por el usuario*/
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String resultado; 
    
    String cod = this.ventanaAMProductos.obtenerCodigo();
    String descrip= this.ventanaAMProductos.obtenerDescripcion();
    String prec = this.ventanaAMProductos.obtenerPrecio();
    
    try {
        int codigo = Integer.parseInt(cod);
        float precio = Float.parseFloat(prec);
        Categoria categoria = this.ventanaAMProductos.comboCategoria();
        Estado estado = this.ventanaAMProductos.comboEstado();
        
        GestorProductos gp =  GestorProductos.instanciar();
        if(this.producto == null)
        {
            resultado = gp.crearProducto(codigo, descrip, precio, categoria, estado);
        }
        else {
            resultado = gp.modificarProducto(producto, codigo, descrip, precio, categoria, estado);
        }
        
        System.out.println(resultado);
        if(resultado.equals(IGestorProductos.EXITO)) 
        {
            System.out.println("Producto creado exitosamente");
            this.ventanaAMProductos.dispose(); 
        }
        else
        {
            System.out.println("Error al crear/modificar");
            javax.swing.JOptionPane.showMessageDialog(this.ventanaAMProductos, resultado, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this.ventanaAMProductos, "El código y el precio deben ser números válidos", "Error de Formato", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }

    
    /* Metodos que permiten que el usuario cambie de manera rapida al presionar la tecla ENTER */
      /* Se podria haber usado tambien KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT para cambiarlo
        con las teclas flechas (documentacion profe) 
    */
    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMProductos.enfocarDescripcion();
       }
    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMProductos.enfocarPrecio();
       }
    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        this.ventanaAMProductos.comboCategoria();
       }
    }
     
    
}
