/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import principal.vistas.VentanaPrincipal;
import productos.modelos.GestorProductos;
import productos.modelos.ModeloTablaProductos;
import productos.modelos.Producto;
import productos.vistas.VentanaProductos;

/**
 *
 * @author Lyan
 */
public class ControladorProductos implements IControladorProductos{
    private VentanaProductos ventana;
    private IControladorAMProducto controlador;
    private VentanaPrincipal ventanaPadre;

    public ControladorProductos(VentanaPrincipal ventanaPadre) {
        this.ventanaPadre= ventanaPadre;
        System.out.println("SE INICIA CONTROLADOR DE PRODUCTOS"); 
        this.ventana = new VentanaProductos(null, true, this);        
        this.ventana.setLocationRelativeTo(null);
        this.btnBuscarClic(null);
        this.ventana.setVisible(true);   
    }
   
    @Override
    public void btnBuscarClic(ActionEvent evt){
        /*Instancio el GestorProductos*/
        GestorProductos gp = GestorProductos.instanciar();
        /*Creo la lista productos*/
        List<Producto> resultado;
        /*Consigo el texto*/
        String textoBuscado = this.ventana.conseguirTxt();
        
        /*Criterio de busqueda*/
        if(textoBuscado == null || textoBuscado.isEmpty()){
            resultado = gp.menu();   
        }else{
            resultado = gp.buscarProductos(textoBuscado);  
        }
            
        /*Para que muestre eso en la ventana*/
        ModeloTablaProductos nuevoModelo = new ModeloTablaProductos();
        nuevoModelo.setProductos(resultado);
        this.ventana.actualizarTabla(nuevoModelo);        
    }

    /*Metodo que destruye la ventana cuando se apreta el boton Volver */
    @Override
    public void btnVolverClic(ActionEvent evt) {
        this.ventana.dispose(); 
    }
    
    
    /* cuando se hace clic el controladorProducto instancia IControladorAMProducto para que este se haga cargo */
    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMProducto controlador = new ControladorAMProductos(this.ventanaPadre, null);
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        /*Con este metodo encuentro el producto seleccionado por el usuario*/
        Producto productoSeleccionado = this.ventana.conseguirProductoSeleccionado();
        
        if(productoSeleccionado == null){
            javax.swing.JOptionPane.showMessageDialog(this.ventana, 
            "No ha seleccionado ningun pruducto de la lista. Intente nuevamente.", 
            "Atención", 
            javax.swing.JOptionPane.WARNING_MESSAGE);
        }else{
            IControladorAMProducto controlador = new ControladorAMProductos(this.ventanaPadre, productoSeleccionado);
            this.btnBuscarClic(null); /*Para actualizar la tabla vieja*/
        } 
    }

    
    
    
    /*Metodo que se llama cuando la ventanaProductos se abra*/
     /*Lo que hace es que pide la tabla, instancia el modeloTablaProductos y le avisa al gestor que debe
    dar todos los productos, el gestor trae todos los productos y se lo asigno a la tabla */
    //De esta forma cuando cree/modifique un producto la tabla se actualizara/
    /*Mencionado en clase */
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        System.out.println("VENTANA GANA FOCO");
        GestorProductos gp = GestorProductos.instanciar();
        List<Producto> listaProductosActualizada = gp.menu();
        ModeloTablaProductos nuevoModelo = new ModeloTablaProductos();
        nuevoModelo.setProductos(listaProductosActualizada);
        this.ventana.actualizarTabla(nuevoModelo); 
    }
    
    
}
