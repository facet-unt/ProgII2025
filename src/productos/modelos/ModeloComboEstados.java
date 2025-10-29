package productos.modelos;

import javax.swing.DefaultComboBoxModel;

public class ModeloComboEstados extends DefaultComboBoxModel {

    /**
     * Constructor
     */
    public ModeloComboEstados() {
        for (Estado estado : Estado.values()) {
            this.addElement(estado); 
        }
    }

    /**
     * Devuelve el estado seleccionado
     * @return Estado  - estado seleccionado
     */
    public Estado obtenerEstado() { 
        return (Estado)this.getSelectedItem();
    }
    
    /**
     * Selecciona la Categoria especificada
     * @param estado estado
    */
    public void seleccionarEstado(Estado estado) {
        this.setSelectedItem(estado);
    }
}