/**
 *
 * @author Asus
 */
package Interfaces;
/**
 *
 * @author alumno
 */    

import java.awt.event.ActionEvent;


public interface IControladorPrincipal {
    public static final String TITULO = "Bar";

    /**
     * AcciÃ³n a ejecutar cuando se selecciona el boton Productos
     * @param evt evento
     */                        
    public void btnProductosClic(ActionEvent evt); 
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el boton Usuarios
     * @param evt evento
     */                        
    public void btnUsuariosClic(ActionEvent evt); 
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el boton Cancelar
     * @param evt evento
     */                        
    public void btnSalirClic(ActionEvent evt); 
}
