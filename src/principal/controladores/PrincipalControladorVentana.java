package principal.controladores;


import principal.vistas.VentanaPrincipal;
import principal.controladores.ControladorVentanaPrincipal;
import Interfaces.IControladorPrincipal;


public class PrincipalControladorVentana {
    public static void main(String[] args) {
        VentanaPrincipal vista = new VentanaPrincipal();
        new ControladorVentanaPrincipal(vista);
        vista.setVisible(true);
    }
}

