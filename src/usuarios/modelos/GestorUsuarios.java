/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IControladorPrincipal;
import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author salut
 */
public class GestorUsuarios implements IGestorUsuarios{

    private List<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        System.out.println(crearArchivo());
        return instancia;
    }
    
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        this.usuarios = this.leerArchivo();
        if((correo==null||!correo.contains("@"))){
            return ERROR_CORREO;
        }
        for(Usuario u1: usuarios){
            if(u1.verCorreo()==correo){
                return USUARIOS_DUPLICADOS;
            }
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(claveRepetida==null){
            return ERROR_PERFIL;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==null){
            return ERROR_PERFIL;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario u = new Cliente(correo,clave,apellido,nombre);
            return agregarUsuario(u);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario u = new Empleado(correo,clave,apellido,nombre);
            return agregarUsuario(u);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario u = new Encargado(correo,clave,apellido,nombre);
            return agregarUsuario(u);
        }
        return EXITO;
    }
    
    public String modificarUsuario(Usuario u, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        this.usuarios = this.leerArchivo();
        if(correo == null||!(correo.contains("@"))){
            return ERROR_CORREO;
        }
        for(Usuario u1: usuarios){
            if(u.verCorreo()==correo){
                break;
            }
            if(u1.verCorreo()==correo&&u.verCorreo()!=correo){
                return USUARIOS_DUPLICADOS;
            }
        }
        if(apellido==null||apellido.isBlank()){
            return ERROR_APELLIDO;
        }
        if(nombre==null||nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if(clave==null||clave.isBlank()){
            return ERROR_CLAVES;
        }
        if(!(claveRepetida.equals(clave))){
            return ERROR_CLAVES;
        }
        if(perfil==Perfil.CLIENTE){
            Usuario usuarioModificado = new Cliente(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.EMPLEADO){
            Usuario usuarioModificado = new Empleado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        if(perfil==Perfil.ENCARGADO){
            Usuario usuarioModificado = new Encargado(correo,clave,apellido,nombre);
            usuarios.set(usuarios.indexOf(u), usuarioModificado);
        }
        return EXITO;
    }
    
    @Override
    public List<Usuario> verUsuarios(){
        this.usuarios = this.leerArchivo();
        Collections.sort(usuarios);
        return usuarios;
    }
    
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        this.usuarios = this.leerArchivo();
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido().contains(apellido)){
                usuariosEncontrados.add(u);
            }
        }
        return usuariosEncontrados;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        this.usuarios = this.leerArchivo();
        for(Usuario u: usuarios){
            if(u.equals(usuario)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        this.usuarios = this.leerArchivo();
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        GestorPedidos gp = GestorPedidos.instanciar();
        if(!(usuario instanceof Cliente)){
            return ERROR_PERFIL;
        }
        if(!(gp.hayPedidosConEsteCliente((Cliente)usuario))){
            usuarios.remove(usuario);
        }
        return EXITO;
    }
    
    private static String crearArchivo(){
        try (FileWriter fw = new FileWriter(NOMBRE_ARCHIVO,true)){
            return CREACION_OK;
        }
        catch(IOException ioe) {
         return CREACION_ERROR;
        }
    }
    
    private String agregarUsuario(Usuario u){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))){
            StringBuilder sb = new StringBuilder();
            if(u instanceof Cliente)
                sb.append(Perfil.CLIENTE).append(SEPARADOR);
            if(u instanceof Empleado)
                sb.append(Perfil.EMPLEADO).append(SEPARADOR);
            if(u instanceof Encargado)
                sb.append(Perfil.ENCARGADO).append(SEPARADOR);
            sb.append(u.verApellido()).append(SEPARADOR);
            sb.append(u.verNombre()).append(SEPARADOR);
            sb.append(u.verCorreo()).append(SEPARADOR);
            sb.append(u.verClave()).append(SEPARADOR);
            bw.write(sb.toString());
            bw.newLine();
            return ESCRITURA_OK;
        }
        catch(IOException ioe) {
         return ESCRITURA_ERROR;
        }
    }
    
    private List<Usuario> leerArchivo(){
        File f = new File(NOMBRE_ARCHIVO);
        try(BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))){
            List<Usuario> listaUsuarios = new ArrayList<>();
            String linea;
            while((linea = br.readLine())!=null){
                String[] cadenas = linea.split(SEPARADOR);
                Usuario u1 = new Cliente();
                Usuario u2 = new Empleado();
                Usuario u3 = new Encargado();
                if(cadenas[0].equals(Perfil.CLIENTE.toString())){
                    u1.asignarApellido(cadenas[1]);
                    u1.asignarNombre(cadenas[2]);
                    u1.asignarCorreo(cadenas[3]);
                    u1.asignarClave(cadenas[4]);
                    listaUsuarios.add(u1);}
                if(cadenas[0].equals(Perfil.EMPLEADO.toString())){
                    u2.asignarApellido(cadenas[1]);
                    u2.asignarNombre(cadenas[2]);
                    u2.asignarCorreo(cadenas[3]);
                    u2.asignarClave(cadenas[4]);
                    listaUsuarios.add(u2);}
                if(cadenas[0].equals(Perfil.ENCARGADO.toString())){
                    u3.asignarApellido(cadenas[1]);
                    u3.asignarNombre(cadenas[2]);
                    u3.asignarCorreo(cadenas[3]);
                    u3.asignarClave(cadenas[4]);
                    listaUsuarios.add(u3);}
            }
            return listaUsuarios;
        } catch (FileNotFoundException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        } catch (IOException ex) {
            System.out.println(LECTURA_ERROR);
            return null;
        }
    }
}
