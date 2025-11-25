package principal.controladores;

import interfaces.IControladorVentanaPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;


public class ControladorVentanaPrincipal implements IControladorVentanaPrincipal {
    private VentanaPrincipal ventana;
    
    public ControladorVentanaPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        System.out.println("Boton Aceptar Clic");
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        this.ventana.dispose();        
        System.exit(0);
    }
    
    
    
    

}
