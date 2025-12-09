/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_PERFIL;
import static interfaces.IGestorUsuarios.USUARIOS_DUPLICADOS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

public class GestorUsuarios implements IGestorUsuarios {

    List<Usuario> usuarios = new ArrayList();
    File archivoProductos = new File(NOMBREARCHIVO);
    private static GestorUsuarios instancia;

    private GestorUsuarios() {
        cargarArchivo();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {

        if (usuario == null || !usuarios.contains(usuario)) {
            return "usuario inexistente";
        }
        //verifica si hay pedidos que contengan el producto
        GestorPedidos gpedidos = GestorPedidos.instanciar();
        if (usuario instanceof Cliente cliente) {
            if (gpedidos.hayPedidosConEsteCliente(cliente)) {
                return "no se puede borrar el usuario porque tiene un pedido asociado";
            }
        }

        usuarios.remove(usuario);
        reescribirArchivo();
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
                guardarArchivo(E);
                break;
            }

            case EMPLEADO -> {
                Empleado e = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(e);
                guardarArchivo(e);
                break;
            }

            case CLIENTE -> {
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);
                guardarArchivo(c);
                break;
            }
            default -> {
                return ERROR_PERFIL;
            }
        }
        return EXITO;
    }

    @Override
    public String modificarUsuarios(Usuario u, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
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

        System.out.println(VALIDACION_EXITO);
        u.asignarApellido(apellido);
        u.asignarNombre(nombre);
        u.asignarCorreo(correo);
        u.asignarClave(clave);
        u.asignarPerfil(perfil);
        reescribirArchivo();

        return EXITO;
    }

    @Override
    public List<Usuario> verUsuarios() {
        Collections.sort(usuarios);
        reescribirArchivo();
        return usuarios;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> buscados = new ArrayList<>();
        apellido = apellido.toLowerCase();
        for (Usuario u : usuarios) {
            if (u.verApellido().toLowerCase().contains(apellido)) {
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

    private void creacionArchivo() {
        if (!archivoProductos.exists()) {
            try {
                archivoProductos.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException e) {
                System.out.println(CREACION_ERROR);
            }
        }
    }

    private void guardarArchivo(Usuario unUsuario) {
        creacionArchivo();
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(archivoProductos, true))) {
            escritura.write(unUsuario.verCorreo());
            escritura.write(SEPARADOR);
            escritura.write(unUsuario.verApellido());
            escritura.write(SEPARADOR);
            escritura.write(unUsuario.verNombre());
            escritura.write(SEPARADOR);
            escritura.write(unUsuario.verPerfil().toString());
            escritura.write(SEPARADOR);
            escritura.write(unUsuario.verClave());
            escritura.newLine();

            System.out.println(ESCRITURA_OK);
        } catch (IOException e) {
            System.out.println(ESCRITURA_ERROR);
        }

    }

    private void reescribirArchivo() {
        creacionArchivo();
        try (BufferedWriter escritura = new BufferedWriter(new FileWriter(archivoProductos))) {
            for (Usuario u : usuarios) {
                escritura.write(u.verCorreo());
                escritura.write(SEPARADOR);
                escritura.write(u.verApellido());
                escritura.write(SEPARADOR);
                escritura.write(u.verNombre());
                escritura.write(SEPARADOR);
                escritura.write(u.verPerfil().toString());
                escritura.write(SEPARADOR);
                escritura.write(u.verClave());
                escritura.newLine();
            }
        } catch (IOException e) {
            System.out.println(ESCRITURA_ERROR);
        }
    }

    private void cargarArchivo() {
        creacionArchivo();
        usuarios.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoProductos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(SEPARADOR);
                String correo = partes[0];
                String apellido = partes[1];
                String nombre = partes[2];
                String perfilString = partes[3];
                Perfil perfil = null;
                for (Perfil p : Perfil.values()) {
                    if (perfilString.equals(p.verValor())) {
                        perfil = p;
                    }
                }
                if (perfil == null) {
                    throw new IOException("Perfil invalido");

                }
                String clave = partes[4];
                switch (perfil) {
                    case ENCARGADO -> {
                        Encargado E = new Encargado(correo, clave, apellido, nombre);
                        usuarios.add(E);
                        break;
                    }

                    case EMPLEADO -> {
                        Empleado e = new Empleado(correo, clave, apellido, nombre);
                        usuarios.add(e);
                        break;
                    }

                    case CLIENTE -> {
                        Cliente c = new Cliente(correo, clave, apellido, nombre);
                        usuarios.add(c);
                        break;
                    }
                    default -> {
                        break;
                    }
                }
                System.out.println(LECTURA_OK);
            }

        } catch (IOException e) {
            System.out.println(LECTURA_ERROR);
        }
    }

}
