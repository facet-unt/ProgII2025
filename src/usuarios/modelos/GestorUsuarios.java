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
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author thoma
 */
public class GestorUsuarios implements IGestorUsuarios {

    private List<Usuario> listaUsuarios = new ArrayList<>();

    private static GestorUsuarios instancia;

    private GestorUsuarios() {
        this.leerArchivo();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    //Metodos
    @Override
    public String crearUsuario(String correo, String clave, String apellido, String nombre, Perfil perfil, String claveRepetida) {
        String validacion = this.validacionDatos(correo, clave, apellido, nombre, perfil, claveRepetida);

        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }

        // Utilizo el metodo obtener usuario para saber si ya existe el usuario en el arraylist
        if (this.obtenerUsuario(correo) != null) {
            return USUARIOS_DUPLICADOS;
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

        this.listaUsuarios.add(nuevoUsuario);
        this.escribirArchivo();

        return EXITO;
    }

    @Override
    public List<Usuario> verUsuarios() {
        Collections.sort(this.listaUsuarios);
        return this.listaUsuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();

        if (apellido == null || apellido.isBlank()) {
            return null;
        }

        for (Usuario u : this.listaUsuarios) {
            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                usuariosEncontrados.add(u);
            }
        }
        Collections.sort(usuariosEncontrados);
        return usuariosEncontrados;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        return this.listaUsuarios.contains(usuario);
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        if (correo == null || correo.isBlank()) {
            return null;
        }

        for (Usuario u : this.listaUsuarios) {
            if (u.verCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        GestorPedidos g = GestorPedidos.instanciar();

        if (usuario instanceof Cliente) {
            Cliente c = (Cliente) usuario;

            if (g.hayPedidosConEsteCliente(c)) {
                return "Error: el cliente seleccionado tiene pedidos y no puede ser eliminado";
            }
        }

        if (this.listaUsuarios.remove(usuario)) {
            this.escribirArchivo();
            return "Usuario eliminado correctamente";
        } else {
            return "Error: No se ha encontrado el usuario";
        }
    }

    // Persistencia en archivo
    private String crearArchivo() {
        File file = new File(NOMBREARCHIVO);
        
        try {
            if (file.createNewFile()) {
                return CREACION_OK;
            }
            else {
                return ARCHIVO_EXISTENTE;
            }
        } catch (IOException e) {
            return CREACION_ERROR;
        }
    }
    
    private String leerArchivo() {
        String resultado = crearArchivo();
        if (resultado == CREACION_ERROR) {
            return LECTURA_ERROR;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBREARCHIVO))) {
            String cadena;
            while ((cadena = br.readLine()) != null) {
                String[] vectorCadenas = cadena.split(SEPARADOR);
                
                String correo = vectorCadenas[0];
                String clave = vectorCadenas[1];
                String apellido = vectorCadenas[2];
                String nombre = vectorCadenas[3];
                
                Perfil perfil = null;
                for (Perfil p : Perfil.values()) {
                    if (vectorCadenas[4].equals(p.verValor())) {
                        perfil = p;
                    }
                }
                
                if (perfil == null) {
                    return LECTURA_ERROR;
                }
                
                Usuario usuarioLeido;
                
                switch (perfil) {
                    case CLIENTE:
                        usuarioLeido = new Cliente(correo, clave, apellido, nombre, perfil);
                        break;
                    case EMPLEADO:
                        usuarioLeido = new Empleado(correo, clave, apellido, nombre, perfil);
                        break;
                    case ENCARGADO:
                        usuarioLeido = new Encargado(correo, clave, apellido, nombre, perfil);
                        break;
                    default:
                        return LECTURA_ERROR;
                }
                
                if (!this.listaUsuarios.contains(usuarioLeido)) {
                    this.listaUsuarios.add(usuarioLeido);
                }
            } 
        } catch (IllegalArgumentException | IOException ex) {
            return LECTURA_ERROR;
        }
        return LECTURA_OK;
    }
    
    private String escribirArchivo() {
        String resultado = crearArchivo();
        if (resultado == CREACION_ERROR) {
            return ESCRITURA_ERROR;
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBREARCHIVO))) {
            for (Usuario u : this.listaUsuarios) {
                String linea;
                linea = u.verCorreo() + SEPARADOR;
                linea += u.verClave() + SEPARADOR;
                linea += u.verApellido() + SEPARADOR;
                linea += u.verNombre() + SEPARADOR;
                linea += u.getPerfil();
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException ioe) {
            return ESCRITURA_ERROR;
        }
        
        return ESCRITURA_OK;
    }
    
    //Validacion datos
    private String validacionDatos(String correo, String clave, String apellido, String nombre, Perfil perfil, String claveRepetida) {
        if (correo == null || correo.isBlank()) {
            return ERROR_CORREO;
        }

        int primerArroba = correo.indexOf("@"); //Devuelve -1 si no hay arroba en la cadena
        int ultimoArroba = correo.lastIndexOf("@");

        if (primerArroba == -1 || primerArroba != ultimoArroba) {
            return ERROR_CORREO;
        }

        if (clave == null || clave.isBlank()) {
            return ERROR_CLAVES;
        }

        if (apellido == null || apellido.isBlank()) {
            return ERROR_APELLIDO;
        }

        if (nombre == null || nombre.isBlank()) {
            return ERROR_NOMBRE;
        }

        if (perfil == null) {
            return ERROR_PERFIL;
        }

        if (claveRepetida == null || claveRepetida.isBlank() || !claveRepetida.equals(clave)) {
            return ERROR_CLAVES;
        }

        return VALIDACION_EXITO;
    }
}
