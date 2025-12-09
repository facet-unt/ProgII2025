package usuarios.modelos;

import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_PERFIL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

public class GestorUsuarios implements IGestorUsuarios{
    private List<Usuario> usuarios = leerArchivo();
    private static GestorUsuarios instancia;

        // Constructor
    private GestorUsuarios(){

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre,Perfil perfil, String clave, String claveRepetida){
        if (correo == null || !correo.contains("@") || correo.equals(""))
            return ERROR_CORREO;
        if(apellido == null || apellido.isEmpty())
            return ERROR_APELLIDO;
        if (nombre == null || nombre.isEmpty())
            return ERROR_NOMBRE;
        if (clave == null || clave.isEmpty())
            return ERROR_CLAVES;
        if (claveRepetida == null || claveRepetida.isEmpty() || !claveRepetida.equals(clave))
            return ERROR_CLAVES;
        if (perfil == null)
            return ERROR_PERFIL;
        
        Usuario u;
        switch(perfil){
            case ENCARGADO:
                u = new Encargado(correo, clave, apellido, nombre);
                break;
            case EMPLEADO:
                u = new Empleado(correo, clave, apellido, nombre);
                break;
            case CLIENTE:
                u = new Cliente(correo, clave, apellido, nombre);
                break;
            default:
                return ERROR_PERFIL;
        }
        
        if (usuarios.contains(u))
            return USUARIOS_DUPLICADOS;
        
        guardarUsuario(u);
        usuarios.add(u);
        return EXITO;
    }
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(usuarios, Usuario.apellidoComp);
        Collections.sort(usuarios, Usuario.nombreComp);
        System.out.println(actualizarArchivo());
        return usuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        int i=0;
        apellido = apellido.toLowerCase();
        List<Usuario> usuariosPorApellido = new ArrayList<>();
        if(apellido != null && !apellido.equals("")){
            for (Usuario u: usuarios){
                if (u.verApellido().equalsIgnoreCase(apellido) || u.verApellido().contains(apellido) || u.verApellido().toLowerCase().contains(apellido)){
                    usuariosPorApellido.add(u);
                    i++;
                }
            }
            if(i==0)
                System.out.println(ERROR_APELLIDO);
        } else {
            System.out.println(ERROR_APELLIDO);
        }
        
        Collections.sort(usuariosPorApellido, Usuario.apellidoComp);
        Collections.sort(usuariosPorApellido, Usuario.nombreComp);
        return usuariosPorApellido;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        if (usuarios.contains(usuario)){
            System.out.println(VALIDACION_EXITO);
            return true;
        }else{
            System.out.println("No existe este usuario");
            return false;
        }
    }

    @Override
    public Usuario obtenerUsuario(String correo){
        if (correo != null && !correo.equals("")){
            for(Usuario u: usuarios){
                if(u.verCorreo().equals(correo)){
                    System.out.println(VALIDACION_EXITO);
                    return u;
                }
            }
        } else {
            System.out.println(ERROR_CORREO);
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if (usuario != null && usuarios.contains(usuario)){
            if(usuario.verPedidos().isEmpty()){
                System.out.println(borrarUsuarioDelArchivo(usuario));
                return "Se ha borrado el usuario correctamente";
            } else {
                return "No se puede borrar este usuario ya que tiene un pedido en marcha \n";
            }
        } else {
            return "El usuario ingresado no es valido\n";
        }
    }
    
    /**
     * Verifica si el archivo ya existe, si no es asi, se crea.
     * @param archivo
     * @return Devuelve un String con el resultado de la operacion
     */
    private String verificarArchivo(File archivo){
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
                return "El archivo no existia, por ende fue creado";
            } catch (IOException e){
                return "No se ha podido crear el archivo";
            } catch (Exception e){
                return e.getMessage();
            }
        }
        return "";
    }
    
    /**
     * Guarda un usuario en el archivo de texto
     * @param u
     * @return Devuelve un String con el resultado de la operacion
     */
    private String guardarUsuario(Usuario u){
        String usuariostxt = SEPARADOR + u.verCorreo() + SEPARADOR + u.verClave() + SEPARADOR + u.verApellido()
                            + SEPARADOR + u.verNombre() + SEPARADOR + u.verPerfil() + SEPARADOR + "\n";
        File archivo = new File("Usuarios.txt");
        System.out.println(verificarArchivo(archivo));
        try(FileWriter fw = new FileWriter(archivo, true)){
            try(BufferedWriter bw = new BufferedWriter(fw)){
                bw.write(usuariostxt);
            }
        } catch (IOException e){
            return "No se ha podido guardar el usuario";
        } catch (Exception e){
            return e.getMessage();
        }
        return EXITO;
    }
    
    /**
     * Lee el archivo y guarda sus contenidos en la lista de GestorUsuarios
     * @return Devuelve una lista con todos los usuarios contenidos en el archivo de texto
     */
    private List<Usuario> leerArchivo(){
        int caracter;
        String usuarios = "";
        String[] cadenas;
        List<Usuario> usuariosArchivo = new ArrayList<>();
        File archivo = new File("Usuarios.txt");
        System.out.println(verificarArchivo(archivo));
        
        try (FileReader fr = new FileReader(archivo)){
            while((caracter = fr.read()) != -1){
                usuarios += ((char) caracter);
            }
            cadenas = usuarios.split(SEPARADOR);
            usuariosArchivo = construirUsuario(cadenas);
            
        } catch (FileNotFoundException e){
            System.out.println("No se pudo encontrar el archivo especificado");
            return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return usuariosArchivo;
    }
    
    /**
     * Construye un objeto tipo Usuario segun los datos contenidos en el archivo de texto
     * @param cadenas
     * @return Devuelve una lista con todos los usuarios contenidos en el archivo de texto
     */
    private List<Usuario> construirUsuario(String[] cadenas){
        List<Usuario> usuariosArchivo = new ArrayList<>();
        int i = 1;
        Usuario u;
        
        while(i < cadenas.length){
            String correo = cadenas[i];
            if(correo.equals("") || correo == null){
                System.out.println(ERROR_CORREO);
                return null;
            }
            i++;
            
            String clave = cadenas[i];
            if(clave.equals("") || clave == null){
                System.out.println(ERROR_CLAVES);
                return null;
            }
            i++;
            
            String apellido = cadenas[i];
            if (apellido.equals("") || apellido == null) {
                System.out.println(ERROR_APELLIDO);
                return null;
            }
            i++;
                    
            String nombre = cadenas[i];
            if(nombre.equals("") || nombre == null){
                System.out.println(ERROR_NOMBRE);
                return null;
            }
            i++;
            
            Perfil perfil;
            if (cadenas[i].equals(Perfil.CLIENTE.toString())) {
                perfil = Perfil.CLIENTE;
            } else if (cadenas[i].equals(Perfil.EMPLEADO.toString())) {
                perfil = Perfil.EMPLEADO;
            } else if (cadenas[i].equals(Perfil.ENCARGADO.toString())) {
                perfil = Perfil.ENCARGADO;
            } else {
                System.out.println(ERROR_PERFIL);
                perfil = null;
            }
            i = i + 2;
            
            switch(perfil){
            case ENCARGADO:
                u = new Encargado(correo, clave, apellido, nombre);
                break;
            case EMPLEADO:
                u = new Empleado(correo, clave, apellido, nombre);
                break;
            case CLIENTE:
                u = new Cliente(correo, clave, apellido, nombre);
                break;
            default:
                System.out.println(ERROR_PERFIL);
                u = null;
            }
            usuariosArchivo.add(u);
        }
        return usuariosArchivo;
    }
    
    /**
     * Borra un usuario en el archivo de texto
     * @param u
     * @return Devuelve un String con el resultado de la operacion
     */
    private String borrarUsuarioDelArchivo(Usuario u){
        List<Usuario> temporal = new ArrayList<>(this.usuarios);
        temporal.remove(u);
        this.usuarios.clear();
        File archivo = new File("Usuarios.txt");
        try(FileWriter fw = new FileWriter(archivo)){
            fw.write("");
            for (Usuario u1: temporal) {
                 guardarUsuario(u1);
            }
            this.usuarios = leerArchivo();
        } catch (IOException e){
            return "No se ha podido borrar el usuario del archivo";
        } catch (Exception e){
            return e.getMessage();
        }
        return "Se ha borrado el usuario del archivo";
    }
    
    /**
     * Actualiza el archivo de texto segun el orden en el que se encuentren en la lista 
     * de GestorUsuarios
     * @return 
     */
    private String actualizarArchivo(){
        List<Usuario> temporal = new ArrayList<>(this.usuarios);
        this.usuarios.clear();
        File archivo = new File("Usuarios.txt");
        
        try(FileWriter fw = new FileWriter(archivo)){
            fw.write("");
            for (Usuario u1: temporal) {
                 guardarUsuario(u1);
            }
            this.usuarios = leerArchivo();
        } catch (IOException e){
            return "No se ha podido actualizar el archivo usuarios";
        } catch (Exception e){
            return e.getMessage();
        }
        
        return "Se ha actualizado el archivo con exito";
    }
}
