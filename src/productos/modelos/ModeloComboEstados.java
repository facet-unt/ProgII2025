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
    
    public Estado obtenerEstado(){
        return (Estado)this.getSelectedItem();
    }
    
    public void seleccionarEstado(Estado estado){
        this.setSelectedItem(estado);
    }
    
        // Constructor
    public ModeloComboEstados(){
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }
    
}
