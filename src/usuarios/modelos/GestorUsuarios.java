package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorUsuarios implements IGestorUsuarios{
    private ArrayList<Usuario> usuarios = new ArrayList();
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
        if (claveRepetida == null || claveRepetida.isEmpty() || claveRepetida.equals(claveRepetida))
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
        usuarios.add(u);
        return EXITO;
    }
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(usuarios, Usuario.apellidoComp);
        Collections.sort(usuarios, Usuario.nombreComp);
        return usuarios;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        int i=0;
        List<Usuario> usuariosPorApellido = new ArrayList<>();
        if(apellido != null && !apellido.equals("")){
            for (Usuario u: usuarios){
                if (u.verApellido().equalsIgnoreCase(apellido)){
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
                return EXITO;
            } else {
                return "No se puede borrar este usuario ya que tiene un pedido en marcha \n";
            }
        } else {
            return "El usuario ingresado no es valido\n";
        }
    }
    
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
    
    public String guardarUsuario(Usuario u){
        String usuariostxt = SEPARADOR + u.verCorreo() + SEPARADOR + u.verClave() + SEPARADOR + u.verApellido()
                            + SEPARADOR + u.verNombre() + SEPARADOR + "\n";
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
    
    public List<Usuario> leerArchivo(){
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
            construirUsuario(cadenas);
            
        } catch (FileNotFoundException e){
            System.out.println("No se pudo encontrar el archivo especificado");
            return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return usuariosArchivo;
    }
    
    public List<Usuario> construirUsuario(String[] cadenas){
        List<Usuario> usuariosArchivo = new ArrayList<>();
        int i = 1;
        Usuario u;
        System.out.println(cadenas.length);
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
            i = i + 2;
            
            
            
        }
        return null;
    }
}
