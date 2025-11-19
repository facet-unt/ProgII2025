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

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        if (correo == null || correo.trim().isEmpty()) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (clave == null || clave.trim().isEmpty() || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }
        // Validar que no exista usuario duplicado
        for (Usuario u : usuario) {
            if (u.verCorreo().equals(correo)) {
                return USUARIOS_DUPLICADOS;
            }
        }

        Usuario nuevoUsuario;
        switch (perfil) {
            case CLIENTE:
                nuevoUsuario = new Cliente(correo, clave, apellido, nombre, perfil);
                break;
            case EMPLEADO:
                nuevoUsuario = new Empleado(correo, clave, apellido, nombre, perfil);
                break;
            case ENCARGADO:
                nuevoUsuario = new Encargado(correo, clave, apellido, nombre, perfil);
                break;
            default:
                return ERROR_PERFIL;
        }
        usuario.add(nuevoUsuario);
        return EXITO;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> resultados = new ArrayList<>();
        for (Usuario u : usuario) {
            if (u.verApellido().equals(apellido)) {
                resultados.add(u);
            }
            resultados.sort((p1, p2) -> {
                int copararApellido = p1.verApellido().compareTo(p2.verApellido());
                if (copararApellido != 0) {
                    return copararApellido;
                }
                return p1.verNombre().compareToIgnoreCase(p2.verNombre());
            });
            return resultados;
        }
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        return this.usuario.contains(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuario) {
            if (u.verCorreo().equals(correo)) {
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
        ArrayList<Usuario> copia = new ArrayList<>(usuario);
        copia.sort((p1, p2) -> {
            int copararApellido = p1.verApellido().compareTo(p2.verApellido());
            if (copararApellido != 0) {
                return copararApellido;
            }
            return p1.verNombre().compareToIgnoreCase(p2.verNombre());
        });
        return copia;
    }
}
