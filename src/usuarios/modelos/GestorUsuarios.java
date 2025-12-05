/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IControladorPrincipal;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import principal.controladores.ControladorVentanaPrincipal;

/**
 *
 * @author salut
 */
public class GestorUsuarios implements IGestorUsuarios{

    private List<Usuario> usuarios = new ArrayList<>();
    
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
        
        if((correo==null||!correo.contains("@"))){
            return ERROR_CORREO;
        }
        for(Usuario u1: usuarios){
            if(u1.verCorreo()==correo){
                return USUARIOS_DUPLICADOS;
            }
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(claveRepetida==null){
            return ERROR_PERFIL;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==null){
            return ERROR_PERFIL;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario u = new Cliente(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario u = new Empleado(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario u = new Encargado(correo,clave,apellido,nombre);
            usuarios.add(u);
        }
        return EXITO;
        
    }
    
    public String modificarUsuario(Usuario u, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if(correo == null||!(correo.contains("@"))){
            return ERROR_CORREO;
        }
        for(Usuario u1: usuarios){
            if(u.verCorreo()==correo){
                break;
            }
            if(u1.verCorreo()==correo&&u.verCorreo()!=correo){
                return USUARIOS_DUPLICADOS;
            }
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario usuarioModificado = new Cliente(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario usuarioModificado = new Empleado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario usuarioModificado = new Encargado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        return EXITO;
    }
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(usuarios);
        return usuarios;
    }
    
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido().contains(apellido)){
                usuariosEncontrados.add(u);
            }
        }
        return usuariosEncontrados;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.equals(usuario)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        GestorPedidos gp = GestorPedidos.instanciar();
        if(!(usuario instanceof Cliente)){
            return ERROR_PERFIL;
        }
        if(!(gp.hayPedidosConEsteCliente((Cliente)usuario))){
            usuarios.remove(usuario);
        }
        return EXITO;
    }
}
