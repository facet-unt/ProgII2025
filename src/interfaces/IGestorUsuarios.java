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
 * @author damia
 */
public interface IGestorUsuarios {
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    public List<Usuario> verUsuarios();
    public List<Usuario> buscarUsuarios(String apellido);
    public String borrarUsuario(Usuario usuario);
    public boolean existeEsteUsuario(Usuario usuario);
    public Usuario obtenerUsuario(String correo);
}
