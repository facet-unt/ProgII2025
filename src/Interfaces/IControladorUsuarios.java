/*
 * Archivo: src/interfaces/IControladorUsuarios.java
 */
package Interfaces;
/**
 *
 * @author alumno
 */

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public interface IControladorUsuarios {
    // Estas son las constantes que el error dice que faltan
    public static final String TITULO = "Usuarios";
    public static final String CONFIRMACION = "¿Desea borrar el usuario especificado?";
    
    // Métodos para la ventana principal de usuarios (Menú/Tabla)
    public void btnNuevoClic(ActionEvent evt);
    public void btnModificarClic(ActionEvent evt);
    public void btnBorrarClic(ActionEvent evt);
    public void btnVolverClic(ActionEvent evt);
    public void btnBuscarClic(ActionEvent evt);
    
    public void txtApellidoPresionarTecla(KeyEvent evt);
    public void ventanaObtenerFoco(WindowEvent evt);
}
