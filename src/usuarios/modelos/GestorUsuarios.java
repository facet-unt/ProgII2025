/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import static interfaces.IGestorProductos.CREACION_OK;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_APELLIDO;
import static interfaces.IGestorUsuarios.ERROR_CLAVES;
import static interfaces.IGestorUsuarios.ERROR_CORREO;
import static interfaces.IGestorUsuarios.ERROR_NOMBRE;
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
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

public class GestorUsuarios implements IGestorUsuarios{
    
    private List<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios(){
        usuarios.clear();
        this.leerArchivoUsuarios();
    }

    public static GestorUsuarios instanciarclase(){
        if (instancia == null){
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    @Override    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){       
        String resultado = validarValores(correo, apellido, nombre, perfil, clave, claveRepetida);
        
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
                    
        Usuario u = null;
        switch (perfil){
            case CLIENTE:
                u = new Cliente(correo, clave, apellido, nombre, perfil);
                break;
            case EMPLEADO:
                u = new Empleado(correo, clave, apellido, nombre, perfil);
                break;
            case ENCARGADO:
                u = new Encargado(correo, clave, apellido, nombre, perfil);
                break;
            default:
                return ERROR_PERFIL;                     
        }       
        
        if(this.existeEsteUsuario(u)){
            return USUARIOS_DUPLICADOS;
        }
        
        this.usuarios.add(u);
        agregarUsuario(u);
        return EXITO;
    }
    
    private String validarValores(String correo, String apellido, String nombre, Perfil perfil, String clave, String claverepetida){
        if (correo == null || correo.isEmpty() ){
            return ERROR_CORREO;
        }
        
        if (apellido == null || apellido.isEmpty()){
            return ERROR_APELLIDO;
    }
    
        if (nombre == null || nombre.isEmpty()){
            return ERROR_NOMBRE;
        }
    
        if (clave == null || clave.isEmpty() && claverepetida.isEmpty() && !claverepetida.equals(clave)){
            return ERROR_CLAVES;
        }
        
        if (perfil == null){
            return ERROR_PERFIL;
        }
        
        return VALIDACION_EXITO;
    }
    
    public String modificarUsuarios(Usuario us, String nombre, String apellido, String correo, String clave, String claverepetida, Perfil perfil){
        
        if(!usuarios.contains(us)){
            return USUARIO_NO_EXISTENTE;
        }
        
        String resultado = validarValores(correo, apellido, nombre, perfil, clave, claverepetida);
        
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        us.asignarApellido(apellido);
        us.asignarClave(clave);
        us.asignarNombre(nombre);
        us.asignarPerfil(perfil);
        us.asignarCorreo(correo);
      
        if(this.existeEsteUsuario(us) == true)
            return IGestorUsuarios.USUARIOS_DUPLICADOS;
        
        this.modificarArchivo(us);
        return CREACION_OK;
    }
    
    
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(usuarios);
        return this.usuarios;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        List<Usuario> buscados = new ArrayList<>();
        
        for(Usuario u : usuarios){
            if (u.verApellido().equals(apellido)){
                buscados.add(u);
            }
        }
        Collections.sort(buscados);
        return buscados;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        if(this.usuarios.contains(usuario)){
            return true;
        }
        else
            return false;
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        for (Usuario u : usuarios){
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if(usuario == null || !this.usuarios.contains(usuario)){
            return USUARIO_NO_EXISTENTE;
        }
        
        GestorPedidos gp = GestorPedidos.getInstancia();
        
        if(usuario instanceof Cliente cliente){
            if(gp.hayPedidosConEsteCliente(cliente)){
                return IGestorUsuarios.ERROR_USUARIO;
            }
        }
        
        this.usuarios.remove(usuario);
        
        try(FileWriter fw = new FileWriter(IGestorUsuarios.NOMBRE_ARCHIVO)){
            for(Usuario us : this.usuarios){
                this.agregarUsuario(us);
            }
        }
        catch(IOException e){
            return IGestorUsuarios.ESCRITURA_ERROR;
        }
        
        return USUARIO_BORRADO;
    }
            
    private static String crearArchivo(){
        File f = new File(NOMBRE_ARCHIVO);
        
        if(!f.exists()){
            try(FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true)){
                return CREACION_OK;
            }
            catch(IOException ex){
                return CREACION_ERROR;
            }
        }
        
        return "El archivo ya existe";
    }    
    
    private String agregarUsuario(Usuario u){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))){
            String linea;
            linea = this.convertirUsuarioALinea(u);
            bw.write(linea);
            bw.newLine();
            return ESCRITURA_OK;
        }
        catch(IOException e){
            return ESCRITURA_ERROR;
        }
    }
    

    private String modificarArchivo(Usuario u){
        this.buscarYReemplazar(u);
        String linea;
        
        try(FileWriter es = new FileWriter(IGestorUsuarios.NOMBRE_ARCHIVO)){      
            for(Usuario us : usuarios){
                this.agregarUsuario(us);
            }           
        }
        catch(IOException e){
            return IGestorUsuarios.ESCRITURA_ERROR;
        }
        
        return IGestorUsuarios.ESCRITURA_OK;
    }
    
    private String convertirUsuarioALinea(Usuario u){
        StringBuilder cadU = new StringBuilder();
        cadU.append(u.verClave());
        cadU.append(IGestorUsuarios.SEPARADOR);
        cadU.append(u.verCorreo());
        cadU.append(IGestorUsuarios.SEPARADOR);
        cadU.append(u.verNombre());
        cadU.append(IGestorUsuarios.SEPARADOR);
        cadU.append(u.verApellido());
        cadU.append(IGestorUsuarios.SEPARADOR);
        cadU.append(u.verPerfil().toString());
        return cadU.toString();
    }
    
    private void buscarYReemplazar(Usuario us){
        int i;
        for(i = 0; i < this.usuarios.size(); i++){
            if(this.usuarios.get(i).verClave().equals(us.verClave())){
                this.usuarios.set(i, us);
                break;
            }
        }
    }
    
    public String leerArchivoUsuarios(){
        System.out.println(this.crearArchivo());
        try(FileReader fr = new FileReader(IGestorUsuarios.NOMBRE_ARCHIVO)){
            BufferedReader lee = new BufferedReader(fr);
            String linea;    
            while((linea = lee.readLine())!= null){
                    Usuario usuario = this.convertirUsuario(linea);
                    usuarios.add(usuario);
                }               
        }
        catch(IOException e){
            return IGestorUsuarios.LECTURA_ERROR;
        }
        
        return IGestorUsuarios.LECTURA_OK;
    }
    
    private Usuario convertirUsuario(String cadena){
        String Cad[] = cadena.split(IGestorUsuarios.SEPARADOR);
        
        String clave = Cad[0].trim();
        String correo = Cad[1].trim();
        String nombre = Cad[2].trim();
        String apellido = Cad[3].trim();
        Perfil perfil = Perfil.obtenerPerfil(Cad[4]);
        
        Usuario u = null;
        switch(perfil){
            case CLIENTE:
                u = new Cliente(clave, correo, nombre, apellido, perfil);
                break;
            case EMPLEADO:
                u = new Empleado(clave, correo, nombre, apellido, perfil);
                break;
            case ENCARGADO:
                u = new Cliente(clave, correo, nombre, apellido, perfil);
                break;
        }
        
        return u;
    }
}

