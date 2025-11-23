/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;


public interface IGestorUsuarios {
    
    /* Mensajes */
    public static final String USUARIO_TIENE_PEDIDO = "El usuario tiene un pedido en curso ";
    public static final String OPERACION_FALLIDA = "No pudo realizarse la operacion ";
    public static final String OPERACION_EXITOSA = "Operacion exitosa ";
    public static final String USUARIO_INEX = "El usuario no existe ";
    
    /* Metodos a implementar */ 
    public List<Usuario> verUsuarios(); /* Metodo agregado TP6 */
    public List<Usuario> buscarUsuarios(String apellido); /* Metodo agregado TP6 */
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    public String borrarUsuario(Usuario usuario);
    public boolean existeEsteUsuario(Usuario usuario);
    public Usuario obtenerUsuario(String correo);
}
