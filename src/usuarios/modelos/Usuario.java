package usuarios.modelos;

/**
 *
 * @author alumno
 */
public abstract class Usuario {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    
    
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }

        
    //método común 
    public void mostrar() {
    System.out.println(this.toString());
    }
    
       
    // Getters y Setters
    public String getCorreo() { 
        return correo;
    }
    public void setCorreo(String correo) {
        if (correo != null && !correo.isBlank()) 
            this.correo = correo;
    }
    
    
    public String getClave() {
        return clave; 
    }
    public void setClave(String clave) {
        if (clave != null && !clave.isBlank()) 
            this.clave = clave;
    }

    
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) 
            this.nombre = nombre;
    }
    
    
    public String getApellido() { 
        return apellido; 
    }
    public void setApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()) 
            this.apellido = apellido;
    }
    
    
    @Override
    public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass()) 
        return false;
    Usuario usuario = (Usuario) obj;
    return this.correo.equalsIgnoreCase(usuario.correo);
    }

    @Override
    public int hashCode() {
    return correo.toLowerCase().hashCode();
    }
 
   
      @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", clave='" + clave + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
        
}
