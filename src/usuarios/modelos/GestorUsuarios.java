/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author octav
 */
public class GestorUsuarios implements IGestorUsuarios {
    private ArrayList<Usuario> usuarios=new ArrayList<>();
    private static GestorUsuarios instancia;
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        Usuario usuario= new Cliente(correo,apellido,nombre,perfil,clave,claveRepetida);
        if(correo == null||correo.isEmpty()||!correo.contains("@"))
            return ERROR_CORREO;
        if(apellido == null||apellido.isBlank()||apellido.isEmpty())
            return ERROR_APELLIDO;
        if(nombre == null||nombre.isBlank()||nombre.isEmpty())
            return ERROR_NOMBRE;
        if(clave == null||clave.isEmpty()||clave.isBlank())
            return ERROR_CLAVES;
        if(claveRepetida == null||!claveRepetida.contains(clave))
            return ERROR_CLAVESREPETIDAS;
        if(usuarios.contains(usuario))
            return USUARIOS_DUPLICADOS;
        else
            usuarios.add(usuario);
        return EXITO;
    }
    @Override
    public ArrayList<Usuario> verUsuarios(){
        Collections.sort(usuarios);
        return usuarios;
    }
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosbuscados= new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido().toLowerCase().contains(apellido.toLowerCase())){
                usuariosbuscados.add(u);
            }
        }
        Collections.sort(usuariosbuscados);
        return usuariosbuscados;
    }
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.verApellido().contentEquals(usuario.verApellido()))
             return true;       
        }
        return false;
    }
    @Override
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().contentEquals(correo))
                return u;
        }
        return null;
    }
    @Override
    public String borrarUsuario(Usuario usuario){
        GestorPedidos gPedidos= GestorPedidos.instanciar();
        if(usuario instanceof Cliente){
            Cliente unCliente = (Cliente)usuario;
            if(gPedidos.hayPedidosConEsteCliente(unCliente) == true){
                return ERROR_USUARIO;
            }
        }
        usuarios.remove(usuario);
        return USUARIO_BORRADO;
    }
}