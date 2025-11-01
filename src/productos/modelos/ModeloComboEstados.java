/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author estudiante
 */
public class ModeloComboEstados extends DefaultComboBoxModel{
   /**
     * Constructor
    */
    public ModeloComboEstados () { 
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }
    
    /**
     * Devuelve la categoria seleccionada
     * @return Categoria  - categoría seleccionada
    */
    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    
    /**
     * Selecciona la Categoria especificada
     * @param categoria categoría
    */
    public void seleccionarEstado(Estado estado) {
        this.setSelectedItem(estado);
    }  
}
