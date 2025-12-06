/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import interfaces.IControladorProductos;
import interfaces.IGestorProductos;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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

        GestorProductos gp = GestorProductos.instanciar();
        List<Producto> resultado;
        String textoBuscado = this.ventana.conseguirTxt();
        
        if (textoBuscado == null || textoBuscado.isEmpty()) {
            resultado = gp.menu();    
        } else {
            resultado = gp.buscarProductos(textoBuscado);   
        }
            
     
        this.ventana.actualizarTabla(resultado);
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

        Producto productoSeleccionado = this.obtenerProductoSeleccionado();
         if(productoSeleccionado != null)
         {
           IControladorAMProducto controlador = new ControladorAMProductos(this.ventanaPadre, productoSeleccionado);
           this.btnBuscarClic(null); /*Para actualizar la tabla vieja*/
        }
          
    }

    
    
                /*Metodo que se llama cuando la ventanaProductos se abra*/
     /*Lo que hace es que pide la tabla, instancia el modeloTablaProductos y le avisa al gestor que debe
          dar todos los productos, el gestor trae todos los productos y se lo asigno a la tabla */
        /* De esta forma cuando cree/modifique un producto la tabla se actualizara */
                           /*Mencionado en clase */
    
    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

         System.out.println("VENTANA GANA FOCO");
        GestorProductos gp = GestorProductos.instanciar();
        List<Producto> listaProductosActualizada = gp.menu();
        this.ventana.actualizarTabla(listaProductosActualizada);
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
 
        Producto productoSeleccionado = this.obtenerProductoSeleccionado();
        
        if(productoSeleccionado != null){
            
        /*Antes de que se borre, se pregunta si quiere borrarlo */
        
        int opcion = JOptionPane.showOptionDialog(null,
                IControladorProductos.CONFIRMACION,
                IControladorProductos.BORRAR_PRODUCTO, 
                 JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"Sí", "No"}, "No");
        
        if (opcion == JOptionPane.YES_OPTION){
            
           GestorProductos gp = GestorProductos.instanciar();
           String resultado = gp.borrarProducto(productoSeleccionado);
            JOptionPane.showMessageDialog(null, IControladorProductos.OPERACION_EXITOSA);
           
             if(resultado.equals(IGestorProductos.OPERACION_EXITOSA))
               {
                        this.btnBuscarClic(null);
               }
         
             else
              {
                      JOptionPane.showMessageDialog(null,
                    IControladorProductos.ERROR_BORRAR,
                           IControladorProductos.TITULO,
                    JOptionPane.ERROR_MESSAGE);
                 System.out.println("ERRor en borrar producto");
              }
           
        }
        
      }
        
    }
    
    private Producto obtenerProductoSeleccionado(){
           JTable tabla = this.ventana.obtenerTabla(); /* Obtiene el modelo de la tabla actual */ 
        int fila = tabla.getSelectedRow();          /* Obtiene la fila seleccionada de la tabla */
        
       
        if (fila == -1) { 
          JOptionPane.showMessageDialog(this.ventana, 
            IControladorProductos.ADVERTENCIA, 
                            IControladorProductos.ATENCION, 
                     JOptionPane.WARNING_MESSAGE);
          
            return null ;  /* Si no selecciona nada devuelve null */
            
        }
        
        ModeloTablaProductos modelo = this.ventana.obtenerModeloTabla();
        Producto productoSeleccionado = modelo.obtenerProductoEnFila(fila);
          
        return modelo.obtenerProductoEnFila(fila);
       }
    

 
    
    
    
}
