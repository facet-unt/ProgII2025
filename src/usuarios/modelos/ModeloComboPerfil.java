/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Lyan
 */
public class ModeloComboPerfil extends DefaultComboBoxModel{
    
    /*Constructor*/
    public ModeloComboPerfil(){
        for(Perfil perfil: Perfil.values()){
            this.addElement(perfil);
        }
    }

    /* Devuelve el perfil seleccionado */
    public Perfil obtenerPerfil() { 
        return (Perfil)this.getSelectedItem();
    }
    
    /* Selecciona el perfil especificado */
    
    public void seleccionarPerfil(Perfil perfil) {
        this.setSelectedItem(perfil);
    }
        
}
