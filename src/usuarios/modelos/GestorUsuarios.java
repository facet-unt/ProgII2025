/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author karen
 */
public class GestorUsuarios implements IGestorUsuarios {

    List<Usuario> usuarios = new ArrayList();

  
    private static GestorUsuarios instancia;

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    
    @Override
     public String borrarUsuario(Usuario usuario){
         
         if (usuario==null|| !usuarios.contains(usuario)) {
            return "usuario inexistente";
        }
        //verifica si hay pedidos que contengan el producto
        GestorPedidos gpedidos = GestorPedidos.instanciar();
        if (usuario instanceof Cliente) {
            if (gpedidos.hayPedidosConEsteCliente((Cliente) usuario)) {
            return "no se puede borrar el usuario porque tiene un pedido asociado";
            }
        }
        
        usuarios.remove(usuario);
        return EXITO_BORRADO;
     }
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || correo.isEmpty() || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (clave == null || clave.isEmpty() || claveRepetida == null || claveRepetida.isEmpty() || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }

        switch (perfil) {
            case ENCARGADO -> {
                Encargado E = new Encargado(correo, clave, apellido, nombre);
                if (usuarios.contains(E)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(E);
                break;
            }

            case EMPLEADO -> {
                Empleado e = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(e);
                break;
            }

            case CLIENTE -> {
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);
                break;
            }
            default -> {
                return ERROR_PERFIL;
            }
        }
        return EXITO;
    }

    @Override
    public List<Usuario> verUsuarios() {
        Collections.sort(usuarios);
        return usuarios;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> buscados = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u.verApellido().contains(apellido)) {
                buscados.add(u);
            }
        }
        Collections.sort(buscados);
        return buscados;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return usuarios.contains(usuario);
        }
        
         return false;
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
            if (u.verCorreo().contains(correo)) {
                return u;
            }
        }
        return null;
    }
}
