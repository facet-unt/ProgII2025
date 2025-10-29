package usuarios.modelos;

import productos.modelos.GestorProductos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList();
    private static GestorUsuarios instancia;

    private GestorUsuarios(){

    }

    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }

    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";

    public String crearUsuario(String correo, String apellido, String nombre, String clave, String claveRepetida){
        if (correo == null || !correo.contains("@") || correo.equals(""))
            return ERROR_CORREO;
        if(apellido == null || apellido == "")
            return ERROR_APELLIDO;
        if (nombre == null || nombre == "")
            return ERROR_NOMBRE;
        if (clave == null || clave == "")
            return ERROR_CLAVES;
        if (claveRepetida == null || claveRepetida == "" || claveRepetida != clave)
            return ERROR_CLAVES;

        Usuario u = new Empleado(correo, clave, apellido, nombre);
        if (usuarios.contains(u))
            return USUARIOS_DUPLICADOS;
        usuarios.add(u);
        return EXITO;
    }

    public ArrayList<Usuario> verUsuarios(){
        return this.usuarios;
    }

    public ArrayList<Usuario> buscarUsuarios(String apellido){
        int i=0;
        ArrayList<Usuario> usuariosPorApellido = new ArrayList<>();
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
        return this.usuarios;
    }

    public boolean existeEsteUsuario(Usuario usuario){
        if (usuarios.contains(usuario)){
            System.out.println(VALIDACION_EXITO);
            return true;
        }else{
            System.out.println("No existe este usuario");
            return false;
        }
    }

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
}
