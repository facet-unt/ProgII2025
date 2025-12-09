package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;


public interface IControladorProductos {
    public static final String TITULO = "Productos";
    public static final String CONFIRMACION = "Â¿Desea borrar el producto especificado?";
    
    /**
     * AcciÃ³n a ejecutar cuando la ventana obtenga el foco
     * @param evt evento
     */
    public void ventanaObtenerFoco(WindowEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Volver
     * @param evt evento
    */                        
    public void btnVolverClic(ActionEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Buscar
     * Permite filtrar los productos segÃºn lo escrito en el campo de texto txtDescripcion
     * Si el botÃ³n Buscar estÃ¡ visible, y por lo tanto se implementa este mÃ©todo:
     *      El mÃ©todo txtDescripcionPresionarTecla() no tiene sentido implementar
     *      El mÃ©todo txtDescripcionPresionarEnter() hace la misma acciÃ³n que Ã©ste
     * @param evt evento
    */                        
    public void btnBuscarClic(ActionEvent evt);
    
        
    /**
     * AcciÃ³n a ejecutar cuando se presiona una tecla en el campo txtDescripcion
     * Permite filtrar los productos a medida que se escribe en el campo de texto txtDescripcion
     *      Si se implementa este mÃ©todo:
     *      El mÃ©todo txtDescripcionPresionarEnter() no tiene sentido implementar
     *      El botÃ³n Buscar puede quedar oculto
     * @param evt evento
    */
    public void txtDescripcionPresionarTecla(KeyEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Nuevo
     * @param evt evento
     */                        
    public void btnNuevoClic(ActionEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Modificar
     * @param evt evento
     */                        
    public void btnModificarClic(ActionEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Borrar
     * @param evt evento
     */                        
    public void btnBorrarClic(ActionEvent evt);
    
}
