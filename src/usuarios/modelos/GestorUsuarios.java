package usuarios.modelos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
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

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil,String clave,  String claveRepetida){
        if(correo==null || !correo.contains("@")){
            return ERROR_CORREO;
        }
        if(apellido == null || apellido.trim().isEmpty()){
            return ERROR_APELLIDO;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            return ERROR_NOMBRE;
        }
        if(clave == null || clave.trim().isEmpty()){
            return ERROR_CLAVES;
        }
        if(claveRepetida == null || claveRepetida.trim().isEmpty() && claveRepetida != clave){
            return ERROR_CLAVES;
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
      
    public ArrayList<Usuario> verUsuarios(){
        return this.usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> uBusq = new ArrayList<>();
        if(apellido == null){
            return uBusq;
        }
        
        for(Usuario u: usuarios){
            if(u.verApellido().toLowerCase().contains(u.verApellido().toLowerCase())){
                uBusq.add(u);
            }
        }
        return uBusq;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(usuario.verCorreo())){
                return true;
            }
        }
        return false;
    }
    
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

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


}