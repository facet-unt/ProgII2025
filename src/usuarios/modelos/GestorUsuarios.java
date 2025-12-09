package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorUsuarios implements IGestorUsuarios {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private static GestorUsuarios instancia;
    
    private GestorUsuarios() {
        
    }
    
    public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave,  String claveRepetida){
        String error = validarDatosUsuarios(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (error != null){
            return error;
        }
        
        if(perfil == Perfil.CLIENTE){
            Usuario u =new Cliente(correo, clave, apellido, nombre);
            usuarios.add(u);
        }
        if(perfil == Perfil.EMPLEADO){
            Usuario u =new Empleado(correo, clave, apellido, nombre);
            usuarios.add(u);
        }
        if(perfil == Perfil.ENCARGADO){
            Usuario u =new Encargado(correo, clave, apellido, nombre);
            usuarios.add(u);
        }
        
        return EXITO;
    }
      
    @Override
    public List<Usuario> verUsuarios(){
        ArrayList<Usuario> usuariosOrdenados = new ArrayList<>(this.usuarios);
        ordenarPorApellidoYNombre (usuariosOrdenados);
        
        return usuariosOrdenados;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> uBusq = new ArrayList<>();
        if(apellido == null){
            return uBusq;
        }
        
        for(Usuario u: usuarios){
            if(u.verApellido().toLowerCase().contains(apellido.toLowerCase())){
                uBusq.add(u);
            }
        }
        ordenarPorApellidoYNombre (uBusq);
        
        return uBusq;
    }

    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(usuario.verCorreo())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if (usuario == null) {
            return "El usuario no existe";
        } 

        GestorPedidos gp = GestorPedidos.instanciar();
        if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            if (gp.hayPedidosConEsteCliente(cliente)) {
                return "No se puede borrar el usuario, existen pedidos con el mismo.";
            }
        }

        if (usuarios.remove(usuario)) {
            return EXITO;
        } else {
            return "El usuario no existe";
        }
    }
    
    private String validarDatosUsuarios(String correo, String apellido, String nombre, Perfil perfil, String clave,  String claveRepetida) {
        if(correo==null || !correo.contains("@")){
            return ERROR_CORREO;
        }
        if(apellido == null || apellido.trim().isEmpty()){
            return ERROR_APELLIDO;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            return ERROR_NOMBRE;
        }
        if(clave == null || clave.trim().isEmpty() || claveRepetida == null || !clave.equals(claveRepetida)){
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return "Perfil inválido";
        }
        return null;
    }
    
    private void ordenarPorApellidoYNombre(List<Usuario> lista) {
        lista.sort((p1, p2) -> {
            int comparacionApellido = p1.verApellido().toString().compareToIgnoreCase(p2.verApellido().toString());
            if (comparacionApellido == 0) {
                return p1.verNombre().compareToIgnoreCase(p2.verNombre());
            }
            return comparacionApellido;
        });
    }

    @Override
    public String modificarUsuario(Usuario usuario, String apellido, String nombre, Perfil perfil, String clave, String clave2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}