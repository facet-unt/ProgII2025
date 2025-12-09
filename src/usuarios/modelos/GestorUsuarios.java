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
 * @author octav
 */
public class GestorUsuarios implements IGestorUsuarios {
    private List<Usuario> usuarios=new ArrayList<>();
    private static GestorUsuarios instancia;
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        Usuario usuario= new Cliente(correo,apellido,nombre,perfil,clave,claveRepetida);
        File f =  new File(NOMBRE_ARCHIVO);
        if(correo == null||correo.isEmpty()||!correo.contains("@"))
            return ERROR_CORREO;
        if(apellido == null||apellido.isBlank()||apellido.isEmpty())
            return ERROR_APELLIDO;
        if(nombre == null||nombre.isBlank()||nombre.isEmpty())
            return ERROR_NOMBRE;
        if(clave == null||clave.isEmpty()||clave.isBlank())
            return ERROR_CLAVES;
        if(claveRepetida == null||!claveRepetida.contains(clave))
            return ERROR_CLAVESREPETIDAS;
        if(perfil == null||perfil.toString().isBlank()||perfil.toString().isBlank())
            return ERROR_NOMBRE;
        if(!f.exists()){    
            usuarios.add(usuario);
            return EscribirArchivo(usuario);
        }
        else{
            this.usuarios= LeerArchivo();
            if(usuarios.contains(usuario))
                return USUARIOS_DUPLICADOS;
            else{ 
                usuarios.add(usuario);
                return EscribirArchivo(usuario);
            }
        }
    }
    public String modificarUsuario(Usuario usuarioAModificar,String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        this.usuarios = LeerArchivo();
        if(existeEsteUsuario(usuarioAModificar)== true){
            if(correo == null||correo.isEmpty()||!correo.contains("@"))
                return ERROR_CORREO;
            if(apellido == null||apellido.isBlank()||apellido.isEmpty())
                return ERROR_APELLIDO;
            if(nombre == null||nombre.isBlank()||nombre.isEmpty())
                return ERROR_NOMBRE;
            if(clave == null||clave.isEmpty()||clave.isBlank())
                return ERROR_CLAVES;
            if(claveRepetida == null||!claveRepetida.contains(clave))
                return ERROR_CLAVESREPETIDAS;
            if(perfil == null||perfil.toString().isBlank()||perfil.toString().isBlank())
                return ERROR_NOMBRE;
            borrarUsuario(usuarioAModificar);
            usuarioAModificar.asignarCorreo(correo);
            usuarioAModificar.asignarApellido(apellido);
            usuarioAModificar.asignarNombre(nombre);
            usuarioAModificar.asignarClave(clave);
            EscribirArchivo(usuarioAModificar);
            return USUARIO_MODIFICADO;
        }
        else
            return USUARIO_INEXISTENTE;
    }
        
    @Override
    public List<Usuario> verUsuarios(){
        this.usuarios = LeerArchivo();
        Collections.sort(usuarios);
        return usuarios;
    }
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosbuscados= new ArrayList<>();
        this.usuarios = LeerArchivo();
        for(Usuario u: usuarios){
            if(u.verApellido().toLowerCase().contains(apellido.toLowerCase())){
                usuariosbuscados.add(u);
            }
        }
        Collections.sort(usuariosbuscados);
        return usuariosbuscados;
    }
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        this.usuarios = LeerArchivo();
        for(Usuario u: usuarios){
            if(u.verApellido().contentEquals(usuario.verApellido()))
             return true;       
        }
        return false;
    }
    @Override
    public Usuario obtenerUsuario(String correo){
        this.usuarios = LeerArchivo();
        for(Usuario u: usuarios){
            if(u.verCorreo().contentEquals(correo))
                return u;
        }
        return null;
    }
    @Override
    public String borrarUsuario(Usuario usuario){
        GestorPedidos gPedidos= GestorPedidos.instanciar();
        this.usuarios = LeerArchivo();
        if(usuario instanceof Cliente unCliente && gPedidos.hayPedidosConEsteCliente(unCliente) == true){
            return ERROR_USUARIO;
        }
        else{
            reescribirArchivo();
            usuarios.remove(usuario);
            for(Usuario u: usuarios){
                EscribirArchivo(u);
            }
            return USUARIO_BORRADO;
        }
    }
    private String CrearArchivo(){
        File f =  new File(NOMBRE_ARCHIVO);
        try{
            f.createNewFile();
            return CREACION_OK;
        }
        catch(IOException ioe){
            return CREACION_ERROR;
        }
    }
    private String EscribirArchivo(Usuario usuarios){
        StringBuilder cadena1 = new StringBuilder();
        File f =  new File(NOMBRE_ARCHIVO);
        try {
            if(!f.exists()){    
                CrearArchivo();
            }
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO,true);
            BufferedWriter bw = new BufferedWriter(fw);
            cadena1.append(usuarios.verApellido());
            cadena1.append(SEPARADOR);
            cadena1.append(usuarios.verClave());
            cadena1.append(SEPARADOR);
            cadena1.append(usuarios.verCorreo());
            cadena1.append(SEPARADOR);
            cadena1.append(usuarios.verNombre());
            cadena1.append(SEPARADOR);
            cadena1.append(usuarios.verPerfil());
            bw.write(cadena1.toString());
            bw.newLine();
            bw.close();
            fw.close();
            return ESCRITURA_OK;
        } 
        catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
    }
    private List<Usuario> LeerArchivo(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario;
        File f = new File(NOMBRE_ARCHIVO);
        if(!f.exists()){
            return usuarios;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] atributos = linea.split(SEPARADOR);
                if(atributos.length >= 5){
                    String apellido = atributos[0];
                    String clave = atributos[1];
                    String correo= atributos[2];
                    String nombre= atributos[3];
                    Perfil perfil= Perfil.leerValor(atributos[4]);
                    switch(perfil) {
                        case CLIENTE:
                            usuario = new Cliente(correo,apellido,nombre,perfil ,clave,clave);
                            usuarios.add(usuario);
                            break;
                        case EMPLEADO:
                            usuario = new Empleado(correo,apellido,nombre,perfil ,clave,clave);
                            usuarios.add(usuario);
                            break;
                        case ENCARGADO:
                            usuario = new Encargado(correo,apellido,nombre,perfil ,clave,clave);
                            usuarios.add(usuario);
                            break;
                    }
                }
        }
            br.close();
            return usuarios;
        }
        catch(IOException ioe){
            System.out.println(LECTURA_ERROR);
            return usuarios;
        }
    }
    public String reescribirArchivo(){
        File f = new File(NOMBRE_ARCHIVO);
        try{
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, false); // false = sobrescribir
            fw.write("");
            fw.close();
            return ESCRITURA_OK;
        }
        catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
    }
}