/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author thoma
 */
public class GestorUsuarios {
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios () {
        
    }
    
    public static GestorUsuarios instanciar () {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    //Constantes
    public static final String EXITO = "Usuario creado/modificado con exito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    
    //Metodos
    public String crearUsuario(String correo, String clave, String apellido, String nombre, Perfil perfil, String claveRepetida) {
        String validacion = this.validacionDatos(correo, clave, apellido, nombre, perfil, claveRepetida);
        
        if (!validacion.equals(VALIDACION_EXITO)) {
            return validacion;
        }
        
        // Utilizo el metodo obtener usuario para saber si ya existe el usuario en el arraylist
        if (this.ObtenerUsuario(correo) != null) {
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
        
        return null;
    }
    
    public ArrayList<Usuario> verUsuarios() {
        return this.listaUsuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList <Usuario> usuariosEncontrados = new ArrayList<>();
        
        if (apellido == null || apellido.isBlank()) {
            return usuariosEncontrados; //Devuelvo el array vacio si no es valido el apellido
        }
        
        for (Usuario u : this.listaUsuarios) {
            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                usuariosEncontrados.add(u);
            }
        }
        
        return usuariosEncontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario) {
        return this.listaUsuarios.contains(usuario);
    }
    
    public Usuario ObtenerUsuario(String correo) {
        if (correo == null || correo.isBlank()) {
            return null;
        }
        
        for (Usuario u : this.listaUsuarios) {
            if (u.verCorreo().equals(correo))
                return u;
        }
        return null;
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
