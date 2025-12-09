/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
 */
public interface IGestorUsuarios {
    //<editor-fold defaultstate="collapsed" desc="Constantes">
    public static final String USUARIO_TIENE_PEDIDO = "El usuario tiene un pedido en curso ";
    public static final String OPERACION_FALLIDA = "No pudo realizarse la operacion ";
    public static final String OPERACION_EXITOSA = "Operacion exitosa ";
    public static final String USUARIO_INEX = "El usuario no existe ";
    public static final String PEDIDO_EN_CURSO = "El usuario tiene un pedido en curso ";
    public static final String NOMBRE_ARCHIVO_U = "Usuarios.txt";
    public static final String SEPARADOR = ";";
    public static final String LECTURA_ERROR = "Error al leer los usuarios ";
    public static final String VALORES_INVALIDOS = "No se pudo realizar la Operacion, ingrese valores validos ";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo ";
    public static final String ESCRITURA_ERROR = "Error al guardar el usuario ";
    public static final String ESCRITURA_OK = "Fue posible guardar/modificar el usuario ";
    public static final String REESCRIBIR_ERROR = "Error al reescribir el archivo ";
    public static final String REESCRIBIR_OK = "Fue posible reescribir el archivo ";
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Metodos">
    public List<Usuario> ordenar();
    public String guardarEnArchivo(Usuario unUsuario, String perfil);
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    public List<Usuario> verUsuarios();
    public List<Usuario> buscarUsuarios(String apellido);
    public String borrarUsuario(Usuario usuario);
    public boolean existeEsteUsuario(Usuario usuario);
    public Usuario obtenerUsuario(String correo);
    //</editor-fold>
    
}
