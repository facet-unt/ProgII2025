/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Asus
 */
public class ModeloComboEstados extends DefaultComboBoxModel{  //debe ser extension, pues redefino la clase defaultComboboxModel
   public ModeloComboEstados() { 
        // Itera sobre la enumeración Estado
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }
    
    /**
     * Devuelve la categoria seleccionada
     * @return Estado
    */
    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    
    /**
     * Selecciona la Categoria especificada
     * @param estado
    */
    

    private void addElement(Estado estado) {
       this.setSelectedItem(estado);
    }

    
    
}
