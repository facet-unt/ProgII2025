/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author thoma
 */
public class ModeloComboPerfil extends DefaultComboBoxModel{
    
    public ModeloComboPerfil() {
        for (Perfil perfil : Perfil.values()) {
            this.addElement(perfil);
        }
    }
    
    public Perfil obetenerPerfil() {
        return (Perfil)this.getSelectedItem();
    }
    
    public void seleccionarPerfil(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
}
