package productos.modelos;

import javax.swing.DefaultComboBoxModel;

public class ModeloComboEstados extends DefaultComboBoxModel {
    
    
     /* Constructor */
    
    public ModeloComboEstados() { 
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }
    
    
     /* Devuelve la estado seleccionada */
    
    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    
    
     /* Selecciona la Estado especificada */
     
    public void seleccionarEstado(Estado estado) {
        this.setSelectedItem(estado);
    }
}
