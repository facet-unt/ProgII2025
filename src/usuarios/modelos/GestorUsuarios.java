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
 * @author Lucas
 */
public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuario = new ArrayList<>();
    private static GestorUsuarios instancia;

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    public String crearUsuario(String correo, String clave, String apellido, String nombre, Perfil perfil) {

        if (correo == null || correo.trim().isEmpty()) {
            return ERROR_CORREO;
        }
        if (clave == null || clave.trim().isEmpty()) {
            return ERROR_CLAVES;
        }
        if (apellido == null || clave.trim().isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || clave.trim().isEmpty()) {
            return ERROR_NOMBRE;
        }
        Usuario usuario;
        switch (perfil) {
            case CLIENTE:
                usuario = new Cliente(correo, clave, apellido, nombre, perfil);
                break;
            case EMPLEADO:
                usuario = new Empleado(correo, clave, apellido, nombre, perfil);
                break;
            case ENCARGADO:
                usuario = new Encargado(correo, clave, apellido, nombre, perfil);
                break;

        }
        //Usuario neuvoUsuario = new(correo, clave, apellido, nombre, perfil);
        //usuario.add(neuvoUsuario);

        return EXITO;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        for (Usuario u : usuario) {
            if (u.verApellido() == apellido) {
                return this.usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        for (Usuario u : this.usuario) {
            if (!(u.equals(usuario))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuario) {
            if (u.verCorreo() == correo) {
                return u;
            }
        }
        return null;
    }
    
    @Override
    public String borrarUsuario(Usuario usuarios) {
        GestorPedidos gPedidos = GestorPedidos.instanciar();
        if (usuarios instanceof Cliente && gPedidos.hayPedidosConEsteCliente((Cliente) usuarios) == true) {
            return ERROR_BORRAR_USUARIO;
        } else {
            usuario.remove(usuarios);
            return USUARIO_BORRADO;
        }
    }


    @Override
    public ArrayList<Usuario> verUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
