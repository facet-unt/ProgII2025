package principal.vistas;

import interfaces.IControladorVentanaPrincipal;
import principal.controladores.ControladorVentanaPrincipal2;


public class Principal {
    public static void main(String[] args) {
        IControladorVentanaPrincipal controlador = new ControladorVentanaPrincipal2();
    }
}
