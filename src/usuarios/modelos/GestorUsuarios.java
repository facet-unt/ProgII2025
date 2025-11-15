/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Gaston
 */
public class GestorUsuarios implements IGestorUsuarios{
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    private GestorUsuarios(){
    }
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String validacion = validarDatos(correo.toLowerCase(), apellido, nombre, clave, claveRepetida);
        if(!validacion.equals(VALIDACION_EXITO)) return validacion;
        if(obtenerUsuario(correo) != null) return USUARIOS_DUPLICADOS;
        Usuario nuevoUsuario;
        switch (perfil) {
        case CLIENTE -> nuevoUsuario = new Cliente(correo, apellido, nombre, clave);
        case ENCARGADO -> nuevoUsuario = new Encargado(correo, apellido, nombre, clave);
        case EMPLEADO -> nuevoUsuario = new Empleado(correo, apellido, nombre, clave);
        default -> {
            return ERROR_PERFIL;
            }
        }
        usuarios.add(nuevoUsuario);
        return EXITO;
    }
    @Override
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u : usuarios)
            if(u.verApellido().equals(apellido.toLowerCase())) usuariosEncontrados.add(u);
        return usuariosEncontrados;
    }
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u : usuarios)
            if(u.equals(usuario)) return true;
        return false;
    }
    @Override
    public Usuario obtenerUsuario(String correo){
        for(Usuario u : usuarios)
            if(u.verCorreo().equals(correo.toLowerCase())) return u;
        return null;
    }
    private String validarDatos (String correo, String apellido, String nombre, String clave, String claveRepetida){
        if(correo == null || !correo.contains("@") ) return ERROR_CORREO;
        if(apellido == null || apellido.isBlank()) return ERROR_APELLIDO;
        if(nombre == null || nombre.isBlank()) return ERROR_NOMBRE;
        if(clave == null || clave.isBlank()) return ERROR_CLAVE;
        if((claveRepetida == null || claveRepetida.isBlank()) || !claveRepetida.equals(clave)) return ERROR_CLAVES;
        return VALIDACION_EXITO;
    }
    @Override
    public String borrarUsuario(Usuario usuario){
        if(usuario instanceof Cliente clienteABorrar){
            GestorPedidos gp = GestorPedidos.instanciar();
            if(gp.hayPedidosConEsteCliente(clienteABorrar))
                return "Este Cliente tiene un pedido, no se puede borrar";
        }
        if(usuarios.remove(usuario)){
            return "Usuario borrado con exito";
        } else return "El usuario no esta";
    }
}