package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import pedidos.modelos.Pedido;
   

public abstract class Usuario {
    private String Correo;
    private String Clave;
    private String Nombre;
    private String Apellido;
    
    
    //declaro los metodos get/set
    public void mostrar(){
        System.out.println ("Mail: " + verCorreo());
        System.out.println ("Nombre: " + verNombre());
        System.out.println ("Apellido: " + verApellido()); 
        System.out.println ("Clave: " + verClave());
    }

    public String verCorreo() {
        return Correo;
    }

    public void asignarCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String verClave() {
        return Clave;
    }

    public void asignarClave(String Clave) {
        this.Clave = Clave;
    }

   public String verNombre() {
        return Nombre;
    }
    
    public void asignarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank())
            Nombre = nombre;
    }
    
    public String verApellido() {
        return Apellido;
    }
    
    public void asignarApellido(String apellido) {
        if (apellido != null && !apellido.isBlank())
            Apellido = apellido;
    }
    
     
    
    //declaro el metodo toString()

    @Override
    public String toString() {
        return "Usuario{" + "Correo=" + Correo + ", Clave=" + Clave + ", Nombre=" + Nombre + ", Apellido=" + Apellido + '}';
    }

    
    
    //agrego un constructor para inicializar las variables de instancia
    public Usuario(String Correo, String Clave, String Nombre, String Apellido) {
        this.Correo = Correo;
        this.Clave = Clave;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    
    
    //redefino el metodo equals y hascode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.Correo, other.Correo);
    }
    
    
    
    //agrego el metodo abstracto verPedidos();
    public abstract ArrayList<Pedido> verPedidos();


}
