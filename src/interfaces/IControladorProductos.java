/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author root
 */
public interface IControladorProductos {
    public static final String TITULO = "Productos";
    public static final String CONFIRMACION = "¿Desea borrar el producto especificado?";
    
    /**
     * Acción a ejecutar cuando la ventana obtenga el foco
     * @param evt evento
     */
    public void ventanaObtenerFoco(WindowEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Volver
     * @param evt evento
    */                        
    public void botonVolverClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Buscar
     * Permite filtrar los productos según lo escrito en el campo de texto txtDescripcion
     * Si el botón Buscar está visible, y por lo tanto se implementa este método:
     *      El método txtDescripcionPresionarTecla() no tiene sentido implementar
     *      El método txtDescripcionPresionarEnter() hace la misma acción que éste
     * @param evt evento
    */                        
    public void botonBuscarClic(ActionEvent evt);
    
        
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtDescripcion
     * Permite filtrar los productos a medida que se escribe en el campo de texto txtDescripcion
     *      Si se implementa este método:
     *      El método txtDescripcionPresionarEnter() no tiene sentido implementar
     *      El botón Buscar puede quedar oculto
     * @param evt evento
    */
    public void txtDescripcionPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Nuevo
     * @param evt evento
     */                        
    public void botonNuevoClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Modificar
     * @param evt evento
     */                        
    public void botonModificarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Borrar
     * @param evt evento
     */                        
    public void botonBorrarClic(ActionEvent evt);

    public void buscarProductos(Object object);
    
}
