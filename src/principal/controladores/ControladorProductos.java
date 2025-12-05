/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import java.awt.event.ActionEvent;
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

    
    
    
    
    
    
    
}
