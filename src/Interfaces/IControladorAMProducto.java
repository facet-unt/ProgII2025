package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorAMProducto {
    public static final String TITULO_NUEVO = "Nuevo producto"; 
    public static final String TITULO_MODIFICAR = "Modificar producto";

    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Cancelar
     * @param evt evento
    */                        
    public void btnCancelarClic(ActionEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Guardar
     * @param evt evento
    */                        
    public void btnGuardarClic(ActionEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se presiona una tecla en el campo txtCodigo
     * @param evt evento
     */
    public void txtCodigoPresionarTecla(KeyEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se presiona una tecla en el campo txtDescripcion
     * @param evt evento
     */
    public void txtDescripcionPresionarTecla(KeyEvent evt);
    
    /**
     * AcciÃ³n a ejecutar cuando se presiona una tecla en el campo txtPrecio
     * @param evt evento
     */
    public void txtPrecioPresionarTecla(KeyEvent evt);              
}
