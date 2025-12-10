package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios instancia;

    // Archivo donde se guardan los usuarios
    private static final String NOMBRE_ARCHIVO = "usuarios.txt";
    private static final String SEP = ";";

    private GestorUsuarios() {
        this.leerUsuariosDesdeArchivo();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }

  
    // 
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        String error = validarDatosUsuarios(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (error != null)
            return error;

        Usuario u = crearUsuarioSegunPerfil(correo, apellido, nombre, perfil, clave);

        if (existeEsteUsuario(u))
            return USUARIOS_DUPLICADOS;

        usuarios.add(u);
        guardarUsuariosEnArchivo();
        return EXITO;
    }

    private Usuario crearUsuarioSegunPerfil(String correo, String apellido, String nombre, Perfil perfil, String clave) {
        return switch (perfil) {
            case CLIENTE -> new Cliente(correo, clave, apellido, nombre);
            case EMPLEADO -> new Empleado(correo, clave, apellido, nombre);
            default -> new Encargado(correo, clave, apellido, nombre);
        };
    }

  
    @Override
    public List<Usuario> verUsuarios() {
        ArrayList<Usuario> copia = new ArrayList<>(usuarios);
        ordenarPorApellidoYNombre(copia);
        return copia;
    }

    @Override
    public List<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> lista = new ArrayList<>();
        if (apellido == null || apellido.isBlank())
            return lista;

        for (Usuario u : usuarios) {
            if (u.verApellido().toLowerCase().contains(apellido.toLowerCase()))
                lista.add(u);
        }

        ordenarPorApellidoYNombre(lista);
        return lista;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.verCorreo().equals(usuario.verCorreo()))
                return true;
        }
        return false;
    }

    @Override
    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
            if (u.verCorreo().equals(correo))
                return u;
        }
        return null;
    }

  
    @Override
    public String borrarUsuario(Usuario usuario) {

        if (usuario == null)
            return "El usuario no existe";

        // no se borra si el cliente tine pedidos
        GestorPedidos gp = GestorPedidos.instanciar();
        if (usuario instanceof Cliente cliente) {
            if (gp.hayPedidosConEsteCliente(cliente))
                return "No se puede borrar el usuario, existen pedidos con el mismo.";
        }

        if (usuarios.remove(usuario)) {
            guardarUsuariosEnArchivo();
            return EXITO;
        }
        return "El usuario no existe";
    }

    
    @Override
    public String modificarUsuario(Usuario usuario, String apellido, String nombre, Perfil perfil, String clave, String clave2) {

        if (usuario == null)
            return "Usuario inexistente";

        String error = validarDatosUsuarios(usuario.verCorreo(), apellido, nombre, perfil, clave, clave2);
        if (error != null)
            return error;

        usuario.asignarApellido(apellido);
        usuario.asignarNombre(nombre);
        usuario.asignarClave(clave);

        // ✔ El perfil NO se cambia (igual que el parcial modelo)
        guardarUsuariosEnArchivo();
        return EXITO;
    }

    
    private String validarDatosUsuarios(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {

        if (correo == null || !correo.contains("@"))
            return ERROR_CORREO;

        if (apellido == null || apellido.trim().isEmpty())
            return ERROR_APELLIDO;

        if (nombre == null || nombre.trim().isEmpty())
            return ERROR_NOMBRE;

        if (clave == null || clave.isBlank() ||
                claveRepetida == null || !clave.equals(claveRepetida))
            return ERROR_CLAVES;

        if (perfil == null)
            return "Perfil inválido";

        return null;
    }

    private void ordenarPorApellidoYNombre(List<Usuario> lista) {
        lista.sort((u1, u2) -> {
            int compA = u1.verApellido().compareToIgnoreCase(u2.verApellido());
            return (compA != 0) ? compA :
                    u1.verNombre().compareToIgnoreCase(u2.verNombre());
        });
    }
    
    private void leerUsuariosDesdeArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {}
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            usuarios.clear();

            while ((linea = br.readLine()) != null) {
                Usuario u = convertirLineaAUsuario(linea);
                if (u != null)
                    usuarios.add(u);
            }

        } catch (IOException e) {
            System.out.println("Error leyendo usuarios.");
        }
    }

    private void guardarUsuariosEnArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Usuario u : usuarios) {
                bw.write(convertirUsuarioALinea(u));
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error guardando usuarios.");
        }
    }

    private String convertirUsuarioALinea(Usuario u) {
        return u.verCorreo() + SEP +
               u.verApellido() + SEP +
               u.verNombre() + SEP +
               u.verClave() + SEP +
               u.getClass().getSimpleName(); // CLIENTE / EMPLEADO / ENCARGADO
    }

    private Usuario convertirLineaAUsuario(String linea) {

        if (linea == null || linea.isBlank())
            return null;

        String[] partes = linea.split(SEP);

        if (partes.length != 5)
            return null;

        String correo = partes[0].trim();
        String apellido = partes[1].trim();
        String nombre = partes[2].trim();
        String clave = partes[3].trim();
        String tipo = partes[4].trim();

        return switch (tipo.toUpperCase()) {
            case "CLIENTE" -> new Cliente(correo, clave, apellido, nombre);
            case "EMPLEADO" -> new Empleado(correo, clave, apellido, nombre);
            default -> new Encargado(correo, clave, apellido, nombre);
        };
    }
}
