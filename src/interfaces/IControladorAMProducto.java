/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

public interface IControladorAMProducto {
    public static final String TITULO_NUEVO = "Nuevo producto"; 
    public static final String TITULO_MODIFICAR = "Modificar producto";

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     * @param evt evento
    */                        
    public void botonCancelarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Guardar
     * @param evt evento
    */                 
    public void botonGuardarClic(ActionEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtCodigo
     * @param evt evento
     */
    public void txtCodigoPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtDescripcion
     * @param evt evento
     */
    public void txtDescripcionPresionarTecla(KeyEvent evt);
    
    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtPrecio
     * @param evt evento
     */
    public void txtPrecioPresionarTecla(KeyEvent evt);
    
    public void categoriaSelección(ItemEvent evt);
    public void estadoSelección(ItemEvent evt);
}