/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorAMProducto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Gaston
 */
public class ControladorAMProducto implements IControladorAMProducto {
    
    private static ControladorAMProducto instancia;
    public static ControladorAMProducto instanciar(){
        if(instancia == null)
            instancia = new ControladorAMProducto();
        return instancia;
    }
    private ControladorAMProducto(){
        
    }
    

    @Override
    public void btnCancelarClic(ActionEvent evt) {

    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {

    }

    @Override
    public void txtCodigoPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtPrecioPresionarTecla(KeyEvent evt) {

    }
    
}
