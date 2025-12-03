package interfaces;
    
import java.awt.event.ActionEvent;

public interface IControladorPrincipal {
    public static final String TITULO = "Bar";

    /**
     * Acción a ejecutar cuando se selecciona el botón Productos
     * @param evt evento
     */                        
    public void btnProductosClic(ActionEvent evt); 
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Usuarios
     * @param evt evento
     */                        
    public void btnUsuariosClic(ActionEvent evt); 
    
    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     * @param evt evento
     */                        
    public void btnSalirClic(ActionEvent evt); 
}