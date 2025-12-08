/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.*;

/**
 *
 * @author estudiante
 */
public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    private static GestorUsuarios instancia;

    private GestorUsuarios() {

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    private Boolean crearArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO_U);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
            return true;
        } catch (IOException e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    private Usuario instanciarUsuario(String correo, String clave, String apellido, String nombre, Perfil unPerfil) {
        Usuario unUsuario = null;
        if (unPerfil == Perfil.CLIENTE) {
            unUsuario = new Cliente(correo, clave, apellido, nombre);
        } else if (unPerfil == Perfil.EMPLEADO) {
            unUsuario = new Empleado(correo, clave, apellido, nombre);
        } else if (unPerfil == Perfil.ENCARGADO) {
            unUsuario = new Encargado(correo, clave, apellido, nombre);
        }
        return unUsuario;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo != null && correo.contains("@") && clave != null && claveRepetida != null && apellido != null && !apellido.isEmpty() && nombre != null && !nombre.isEmpty()) {
            if (clave.equals(claveRepetida)) {
                for (Usuario u : usuarios) {
                    if (u.verCorreo().equals(correo)) {
                        return (USUARIOS_DUPLICADOS);
                    }
                }
                if (perfil == Perfil.CLIENTE || perfil == Perfil.ENCARGADO || perfil == Perfil.EMPLEADO) {
                    Usuario unUsuario = instanciarUsuario(correo, clave, apellido, nombre, perfil);
                    usuarios.add(unUsuario);
                    
                    return (OPERACION_EXITOSA);
                } else {
                    return (VALORES_INVALIDOS);
                }
            } else {
                return (VALORES_INVALIDOS);
            }

        } else {
            return (VALORES_INVALIDOS);
        }
    }

    @Override
    public List<Usuario> verUsuarios() {
        if (!crearArchivo()) {
            return null;
        }
        File f = new File(NOMBRE_ARCHIVO_U);
        try (FileReader fr = new FileReader(f);) {
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] cadenas = linea.split(SEPARADOR);
                String correo = cadenas[0];
                String clave = cadenas[1];
                String apellido = cadenas[2];
                String nombre = cadenas[3];
                Perfil unPerfil = Perfil.compararValor(cadenas[4]);
                Usuario unUsuario = instanciarUsuario(correo, clave, apellido, nombre, unPerfil);
                if (unUsuario != null) {
                    usuarios.add(unUsuario);
                }

            }
        } catch (IOException e1) {
            System.out.println(LECTURA_ERROR);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido) {

        ArrayList<Usuario> encontrados = new ArrayList<>();
        for (Usuario u : usuarios) {

            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                encontrados.add(u);
            }

        }
        encontrados.sort(Comparator.comparing(Usuario::verNombre));
        return encontrados;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        if (usuarios.contains(usuario)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {

            if (u.verCorreo().equals(correo)) {
                return u;
            }

        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if (usuarios.contains(usuario) && usuario != null) {
            if (usuario instanceof Cliente) {
                GestorPedidos gDeP = GestorPedidos.instanciar();
                for (Pedido unPedido : gDeP.verPedidos()) {
                    if ((unPedido.verCliente()).equals(usuario)) {
                        return (OPERACION_FALLIDA + USUARIO_TIENE_PEDIDO);
                    }
                }
            }
            usuarios.remove(usuario);
            return (OPERACION_EXITOSA);
        }

        return (OPERACION_FALLIDA + USUARIO_INEX);

    }

}
