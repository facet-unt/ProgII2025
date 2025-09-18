/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public void AsignarCorreo (String c){
        correo = c;
    }   
    
    public void AsignarClave (String cl) {
        clave = cl;
    }
    
    public void AsignarApellido (String a) {
        apellido = a;
    }
    
    public void AsignarNombre (String n) {
        nombre = n;
    }
    
    public String verCorreo (){
        return correo;
    }
    
    public String verApellido() {
        return apellido;
    }
    
    public String verNombre() {
        return nombre;
    }
    
    public String verClave () {
        return clave;
    }
    
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
     public void mostrar()
    {
        System.out.println("Correo : " + correo);
        System.out.println("\n");
        System.out.println("Clave : " + clave);
        System.out.println("\n");
        System.out.println("Nombre : " + nombre);
        System.out.println("\n");
        System.out.println("Apellido : " + apellido);
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    

}
