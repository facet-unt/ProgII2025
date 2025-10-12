/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Esteban
 */

public class Encargado extends Usuario {
   

    @Override
    public String toString() {
        return "Encargado{" + "correo=" + super.verCorreo() + ", clave=" + super.verClave() + ", apellido=" + super.verApellido() + ", nombre=" + super.verNombre() + '}';
    }
    
    //constructor
    
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
}
