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
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Gaston
 */
public class GestorUsuarios implements IGestorUsuarios{
    
    private static final String SEPARADOR = ";";
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private static final String ESCRITURA_OK = "Exito en la escritura";
    private static final String ESCRITURA_ERROR = "Error en la escritura";
    private static final String LECTURA_OK = "Exito en la lectura";
    private static final String LECTURA_ERROR = "Error en la lectura";
    
    private List<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    private GestorUsuarios(){
    }
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    private Comparator<Usuario> compUs = (u1,u2) -> {
        if(u1 == null && u2 == null) return 0;
        if(u1 == null) return 1;
        if(u2 == null) return 2;
        int compAp = u1.verApellido().compareTo(u2.verApellido());
        if(compAp != 0)
            return compAp;
        return u1.verNombre().compareTo(u2.verNombre());
    };
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String validacion = validarDatos(correo, apellido, nombre, clave, claveRepetida);
        if(!validacion.equals(VALIDACION_EXITO)) return validacion;
        if(obtenerUsuario(correo) != null) return USUARIOS_DUPLICADOS;
        Usuario nuevoUsuario;
        if(perfil == null) return ERROR_PERFIL;
        switch (perfil) {
        case CLIENTE -> nuevoUsuario = new Cliente(correo, clave, apellido, nombre );
        case ENCARGADO -> nuevoUsuario = new Encargado(correo, clave, apellido, nombre);
        case EMPLEADO -> nuevoUsuario = new Empleado(correo, clave, apellido, nombre);
        default -> {
            return ERROR_PERFIL;
            }
        }
        usuarios.add(nuevoUsuario);
        this.guardarUsuarios();
        return EXITO;
    }
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(usuarios, compUs);
        return usuarios;
    }
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u : usuarios)
            if(u.verApellido().equalsIgnoreCase(apellido)) usuariosEncontrados.add(u);
        Collections.sort(usuariosEncontrados, compUs);
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
            if(u.verCorreo().equalsIgnoreCase(correo)) return u;
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
            this.guardarUsuarios();
            return "Usuario borrado con exito";
        } else return "El usuario no esta";
    }
    
    public String guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Usuario u : this.usuarios) {
                String perfilStr = this.obtenerPerfil(u).name();
                String linea = u.verCorreo() + SEPARADOR + 
                               u.verApellido() + SEPARADOR + 
                               u.verNombre() + SEPARADOR + 
                               perfilStr + SEPARADOR + 
                               u.verClave();
                bw.write(linea);
                bw.newLine();
            }
            return ESCRITURA_OK; 
        } catch (IOException e) {
            return ESCRITURA_ERROR;
        }
    }
    
    public String cargarUsuarios() {
        File archivo = new File(ARCHIVO_USUARIOS);
        if (!archivo.exists()) {
            return "ARCHIVO_NO_EXISTE";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            this.usuarios.clear(); 
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(SEPARADOR);
                if (datos.length < 5) continue;
                String correo = datos[0];
                String apellido = datos[1];
                String nombre = datos[2];
                Perfil perfil = Perfil.valueOf(datos[3]); 
                String clave = datos[4];
                Usuario nuevo = null;
                switch (perfil) {
                    case CLIENTE -> nuevo = new Cliente(correo, clave, apellido, nombre);
                    case ENCARGADO -> nuevo = new Encargado(correo, clave, apellido, nombre);
                    case EMPLEADO -> nuevo = new Empleado(correo, clave, apellido, nombre);
                }
                if (nuevo != null) {
                    this.usuarios.add(nuevo);
                }
            }
            return LECTURA_OK;
        } catch (IOException | IllegalArgumentException e) {
            return LECTURA_ERROR;
        }
    }
    private Perfil obtenerPerfil(Usuario u) {
        if (u instanceof Cliente) return Perfil.CLIENTE;
        if (u instanceof Empleado) return Perfil.EMPLEADO;
        if (u instanceof Encargado) return Perfil.ENCARGADO;
        return Perfil.CLIENTE;
    }
}