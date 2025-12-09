/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Lucas
 */
public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuario = new ArrayList<>();
    private static GestorUsuarios instancia;
    private final String NOMBRE_ARCHIVO = "usuarios.txt";

    private GestorUsuarios() {
        leerArchivo();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        String resultado = validarDatosUsusario(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (!resultado.equals(VALIDACION_EXITO)) {
            return resultado;
        }
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
        guardarArchivo();
        return EXITO;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> resultados = new ArrayList<>();
        for (Usuario u : usuario) {
            if (u.verApellido().equals(apellido)) {
                resultados.add(u);
            }
        }
        resultados.sort((u1, u2) -> {
            int copararApellido = u1.verApellido().compareTo(u2.verApellido());
            if (copararApellido != 0) {
                return copararApellido;
            }
            return u1.verNombre().compareToIgnoreCase(u2.verNombre());
        });
        return resultados;
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
            guardarArchivo();
            return USUARIO_BORRADO;
        }
    }

    @Override
    public ArrayList<Usuario> verUsuarios() {
        ArrayList<Usuario> copia = new ArrayList<>(usuario);
        copia.sort((u1, u2) -> {
            int copararApellido = u1.verApellido().compareTo(u2.verApellido());
            if (copararApellido != 0) {
                return copararApellido;
            }
            return u1.verNombre().compareToIgnoreCase(u2.verNombre());
        });
        return copia;
    }

    private String validarDatosUsusario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
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
        return VALIDACION_EXITO;
    }

    @Override
    public void guardarArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (Usuario u : usuario) {
                String linea = u.verCorreo() + "," + u.verClave() + ","
                        + u.verApellido() + "," + u.verNombre() + "," + u.obtenerPerfil().name(); 
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo de usuarios");
        }
    }

    private void leerArchivo() {
        try {
            File archivo = new File(NOMBRE_ARCHIVO);
            if (!archivo.exists()) {
                System.out.println("Archivo de usuarios no encontrado. Se creara al agregar usuarios");
                return;
            }
            
            try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
                usuario.clear();
                String linea;

                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue; 
                    
                    String[] v = linea.split(",");

                    if (v.length >= 5) {
                        String correo = v[0].trim();
                        String clave = v[1].trim();
                        String apellido = v[2].trim();
                        String nombre = v[3].trim();
                        String perfilStr = v[4].trim();

                        try {
                            Perfil perfil = Perfil.valueOf(perfilStr.toUpperCase());
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
                                    continue;
                            }
                            usuario.add(nuevoUsuario);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error al parsear perfil: " + perfilStr + " - formato no reconocido");
                        }
                    }
                }
                System.out.println("Archivo de usuarios cargado correctamente");

            } catch (IOException e) {
                System.out.println("Error al leer archivo de usuarios");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error general al leer archivo de usuarios");
            e.printStackTrace();
        }
    }
}
