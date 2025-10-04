package usuarios.modelos;

//<<<<<<< HEAD


public class Encargado {

    public String correo;
    public String clave;
    public String apellido;
    public String nombre;

    public Encargado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }//esto es el constructor
    
    
    public void mostrar (){
        System.out.println ("soy el encargado:");
        
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

    public String verCorreo (){
        return correo;
    }
    //esto se llama get, es para otener al objeto
    
    public void asignarCorreo (String Correo) {
        if (Correo != null && !Correo.isBlank())
            correo = Correo;
    }
    
    
    public String VerClave (){
        return clave;
    }
    
    public void asignarClave (String Clave) {
        if (Clave != null && !Clave.isBlank())
            clave = Clave;
    }
    //esto es el set, sirve para que uno pueda modificar al objeto
    
    public String VerNombre (){
        return nombre;
    }
    
    public void asignarNombre (String Nombre) {
        if (Nombre!= null && !Nombre.isBlank())
            nombre = Nombre;
    }
    
    public String VerApellid0 (){
        return apellido;
    }
    
    public void asignarApellido(String Apellido) {
        if (Apellido!= null && !Apellido.isBlank())
            apellido = Apellido;
    }

}

