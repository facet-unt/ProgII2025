package usuarios.modelos;

import javax.swing.DefaultComboBoxModel;

public class ModeloComboPerfiles extends DefaultComboBoxModel {

    /**
     * Constructor
     */
    public ModeloComboPerfiles() {
        for (Perfil perfil : Perfil.values()) {
            this.addElement(perfil);
        }
    }

    /**
     * Devuelve la categoria seleccionada
     *
     * @return Categoria - categoría seleccionada
     */
    public Perfil obtenerCategoria() {
        return (Perfil) this.getSelectedItem();
    }

    /**
     * Selecciona la Categoria especificada
     *
     * @param categoria categoría
     */
    public void seleccionarCategoria(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
}
