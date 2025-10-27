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
public class ModeloComboEstados extends DefaultComboBoxModel {
      /**
     * Constructor
    */
    public ModeloComboEstados() { 
        for (Estado estados : Estado.values()) {
            this.addElement(estados); 
        }
    }
    
    /**
     * Devuelve los estados seleccionada
     * @return estados  - estados seleccionada
    */
    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    
    /**
     * Selecciona los estados especificada
     * @param categoria estados
    */
    public void seleccionarEstado(Estado estados) {
        this.setSelectedItem(estados);
    }
}

