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
import static usuarios.modelos.Perfil.ENCARGADO;

public class GestorUsuarios implements IGestorUsuarios{
    
    private List<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios(){
        
    }

    public static GestorUsuarios instanciarclase(){
        if (instancia == null){
            instancia = new GestorUsuarios();
        }
        System.out.print(crearArchivo());
        return instancia;
    }
        @Override    
        public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        
        String resultado = validarValores(correo, apellido, nombre, perfil, clave, claveRepetida);
        
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        if (obtenerUsuario(correo) != null){
            return USUARIOS_DUPLICADOS;
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
       
        this.agregarUsuario(u);
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
    
    @Override
    public List<Usuario> verUsuarios(){
        this.usuarios = leerUsuarios();
        Collections.sort(usuarios);
        return this.usuarios;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        this.usuarios = this.leerUsuarios();
        List<Usuario> buscados = new ArrayList<>();
        
        for(Usuario u : usuarios){
            if (u.verApellido().equals(apellido)){
                buscados.add(u);
            }
        }
        Collections.sort(buscados, compararApyNom);
        return buscados;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        this.usuarios = this.leerUsuarios();
        return usuarios.contains(usuario);
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        this.usuarios = this.leerUsuarios();
        for (Usuario u : usuarios){
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        this.usuarios = this.leerUsuarios();
        if (usuario instanceof Cliente cliente) {
            GestorPedidos gp = GestorPedidos.getInstancia();

            if (gp.hayPedidosConEsteCliente(cliente)) {
                return "No se puede eliminar el usuario, posee un pedido pendiente.";
            }
            else {
            usuarios.remove(usuario);    
            return "Usuario removido con exito";
            }
        }

    return ERROR_PERFIL;
    
    }
    
    Comparator<Usuario> compararApyNom = (Usuario u1, Usuario u2) -> {
        if(u1.verApellido().compareTo(u2.verApellido()) == 0)
            return u1.verApellido().compareTo(u2.verApellido());
        else
            return u1.verApellido().compareTo(u2.verApellido());      
    };
            
    private static String crearArchivo(){
        try(FileWriter fw = new FileWriter(NOMBRE_ARCHIVO, true)){
            return CREACION_OK;
        }
        catch(IOException ex){
            return CREACION_ERROR;
        }
    }
    
    private String agregarUsuario(Usuario u){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))){
            String linea;
            linea = u.verApellido() + SEPARADOR + u.verNombre() + SEPARADOR + u.verCorreo()
                    + SEPARADOR + u.verPerfil() + SEPARADOR + u.verClave();
            bw.write(linea);
            bw.newLine();
            return ESCRITURA_OK;
        }
        catch(IOException e){
            return ESCRITURA_ERROR;
        }
    }
    
    public List<Usuario> leerUsuarios() {

    List<Usuario> lista = new ArrayList<>();

    File f = new File(NOMBRE_ARCHIVO);
    if (!f.exists())
        return lista;

    try (BufferedReader br = new BufferedReader(new FileReader(f))) {

        String linea;
        while ((linea = br.readLine()) != null) {

            if (linea.trim().isEmpty())
                continue;

            String[] partes = linea.split(SEPARADOR);

            if (partes.length != 5) {
                System.err.println("Línea mal formateada: " + linea);
                continue;
            }

            String apellido = partes[0].trim();
            String nombre = partes[1].trim();
            String correo = partes[2].trim();
            Perfil perfil = convertirPerfil(partes[3].trim());
            String clave = partes[4].trim();

            if (perfil == null)
                continue;

            Usuario u = null;

            switch (perfil) {
                case ENCARGADO:
                    u = new Encargado(correo, clave, apellido, nombre, perfil);
                    break;
                case EMPLEADO:
                    u = new Empleado(correo, clave, apellido, nombre, perfil);
                    break;
                case CLIENTE:
                    u = new Cliente(correo, clave, apellido, nombre, perfil);
                    break;
            }

            if (u != null)
                lista.add(u);
        }

    } catch (IOException e) {
        System.err.println(LECTURA_ERROR + ": " + e.getMessage());
    }

    return lista;
}

    private Perfil convertirPerfil(String c){
        try{
            return Perfil.valueOf(c);
        }
        catch(IllegalArgumentException e){
            for (Perfil perfil : Perfil.values()){
                if(e.toString().equalsIgnoreCase(c))
                    return perfil;
            }
        }
        return null;
    }
}

