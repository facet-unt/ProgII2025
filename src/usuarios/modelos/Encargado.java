/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Asus
 */
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
=======
<<<<<<< HEAD
 * @author Oli Toledo
=======
 * @author estudiante
>>>>>>> 22dc9e4978e472b497ec4e3c8fa0cb322aa6d032
 */
public class Encargado {
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;

    public Encargado(String apellido, String nombre, String correo, String clave) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

  

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }
    
    public void mostrar(){
        System.out.println("-- ENCARGADO --");
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);
     } 
    //Preguntar si deberia eliminar el void mostrar
    @Override
    public String toString() {
        return "Encargado{" + "apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
    }