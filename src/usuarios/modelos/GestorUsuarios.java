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
import java.io.BufferedWriter;
import java.io.FileWriter;
import pedidos.modelos.*;

/**
 *
 * @author estudiante
 */
public class GestorUsuarios implements IGestorUsuarios {

    private List<Usuario> usuarios = new ArrayList<>();

    private static GestorUsuarios instancia;

    private GestorUsuarios() {
        this.usuarios = verUsuarios();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    public List<Usuario> ordenar(){
        usuarios.sort(Comparator.comparing(Usuario::verApellido, String.CASE_INSENSITIVE_ORDER));
        return usuarios;
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

    public Usuario instanciarUsuario(String correo, String clave, String apellido, String nombre, Perfil unPerfil) {
        Usuario unUsuario = null;
        if (unPerfil == Perfil.CLIENTE) {
            unUsuario = new Cliente(correo, clave, apellido, nombre, unPerfil);
        } else if (unPerfil == Perfil.EMPLEADO) {
            unUsuario = new Empleado(correo, clave, apellido, nombre, unPerfil);
        } else if (unPerfil == Perfil.ENCARGADO) {
            unUsuario = new Encargado(correo, clave, apellido, nombre, unPerfil);
        }
        return unUsuario;
    }

    @Override
    public String guardarEnArchivo(Usuario unUsuario, String perfil) {

        if (unUsuario == null) {
            return ESCRITURA_ERROR;
        }

        if (!crearArchivo()) {
            return ESCRITURA_ERROR;
        }
        File f = new File(NOMBRE_ARCHIVO_U);

        try (FileWriter fw = new FileWriter(f, true); BufferedWriter bw = new BufferedWriter(fw)) {

            String linea = unUsuario.verCorreo() + ";"
                    + unUsuario.verClave() + ";"
                    + unUsuario.verApellido() + ";"
                    + unUsuario.verNombre() + ";"
                    + unUsuario.verPerfil();

            bw.write(linea);
            bw.newLine();
            bw.flush();

            return ESCRITURA_OK;

        } catch (IOException ioe) {
            return ESCRITURA_ERROR;
        }
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo != null && correo.contains("@") && clave != null && !clave.isEmpty() && claveRepetida != null && !claveRepetida.isEmpty() && apellido != null && !apellido.isEmpty() && nombre != null && !nombre.isEmpty()) {
            if (clave.equals(claveRepetida)) {
                for (Usuario u : usuarios) {
                    if (u.verCorreo().equals(correo)) {
                        return (USUARIOS_DUPLICADOS);
                    }
                }
                if (perfil == Perfil.CLIENTE || perfil == Perfil.ENCARGADO || perfil == Perfil.EMPLEADO) {
                    Usuario unUsuario = instanciarUsuario(correo, clave, apellido, nombre, perfil);
                    usuarios.add(unUsuario);
                    System.out.println(guardarEnArchivo(unUsuario, perfil.toString()));
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
        usuarios.clear();
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
                Perfil unPerfil = Perfil.compararValor(cadenas[4].trim());
                Usuario unUsuario = instanciarUsuario(correo, clave, apellido, nombre, unPerfil);
                if (unUsuario != null) {
                    usuarios.add(unUsuario);
                }

            }
        } catch (IOException e1) {
            System.out.println(LECTURA_ERROR);
        }
        usuarios.sort(Comparator.comparing(Usuario::verApellido, String.CASE_INSENSITIVE_ORDER));
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
    private String actualizarArchivoCompleto() {
        File f = new File(NOMBRE_ARCHIVO_U);
        if (!crearArchivo()) {
            return (ESCRITURA_ERROR);
        }
        try (FileWriter fw = new FileWriter(f, false); BufferedWriter bw = new BufferedWriter(fw)) {

            for (Usuario u : usuarios) {
                String linea = u.verCorreo() + ";" + u.verClave() + ";"
                        + u.verApellido() + ";" + u.verNombre() + ";"
                        + u.verPerfil();
                bw.write(linea);
                bw.newLine();

            }
            usuarios.sort(Comparator.comparing(Usuario::verApellido, String.CASE_INSENSITIVE_ORDER));
            return REESCRIBIR_OK;
        } catch (IOException e) {
            return (REESCRIBIR_ERROR);
        }
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        GestorPedidos gp = GestorPedidos.instanciar();
        if (!usuarios.contains(usuario)) {
            return (OPERACION_FALLIDA + USUARIO_INEX);
        }
        if (usuario instanceof Cliente) {
            for (Pedido unPedido : gp.verPedidos()) {
                if (unPedido.verCliente().equals(usuario)) {
                    return PEDIDO_EN_CURSO;
                }
            }
        }
        usuarios.remove(usuario);
        System.out.println(actualizarArchivoCompleto());
        return (OPERACION_EXITOSA);

    }
    public Boolean validarUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || !correo.contains("@")) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        if (clave == null || clave.isEmpty()) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        if (claveRepetida == null || claveRepetida.isEmpty()) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        
        if(clave!=claveRepetida){
            System.out.println(VALORES_INVALIDOS);
            return false;
        }  
        
        if (apellido == null && apellido.isEmpty()) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        if (nombre == null && nombre.isEmpty()) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        if (perfil == null) {
            System.out.println(VALORES_INVALIDOS);
            return false;
        }
        return true;
    }


    public String modificarUsuario(Usuario usuarioModificado) {
        if (usuarioModificado == null) {
            return OPERACION_FALLIDA;
        }

        int indice = -1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).verCorreo().equals(usuarioModificado.verCorreo())) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            return USUARIO_INEX;
        }
        
        usuarios.set(indice, usuarioModificado);

        return actualizarArchivoCompleto();
    }

}
