package principal.controladores;

import interfaces.IControladorVentanaPrincipal;
import java.awt.event.ActionEvent;
import principal.vistas.VentanaPrincipal;


public class ControladorVentanaPrincipal2 implements IControladorVentanaPrincipal{
    private VentanaPrincipal ventana;
    
    public ControladorVentanaPrincipal2() {
        this.ventana = new VentanaPrincipal(this);
        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        this.ventana.dispose();        
        System.exit(0);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        System.out.println("Boton Aceptar Clic");
        
    }
}
