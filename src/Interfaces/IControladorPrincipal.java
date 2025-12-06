package Interfaces;
    
import java.awt.event.ActionEvent;


public interface IControladorPrincipal {
    public static final String TITULO = "Bar";

    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Productos
     * @param evt evento
     */                        
    public void btnProductosClic(ActionEvent evt); 
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Usuarios
     * @param evt evento
     */                        
    public void btnUsuariosClic(ActionEvent evt); 
    
    /**
     * AcciÃ³n a ejecutar cuando se selecciona el botÃ³n Cancelar
     * @param evt evento
     */                        
    public void btnSalirClic(ActionEvent evt); 
}
