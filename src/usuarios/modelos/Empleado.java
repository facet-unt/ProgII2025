/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */

public class Empleado extends Usuario{
    //Atributos
    
    @Override
    public String toString() {
        return "Empleado{" + "correo=" + super.verCorreo() + ", clave=" + super.verClave() + ", apellido=" + super.verApellido() + ", nombre=" + super.verNombre() + '}';
    }
    
    //constructor

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
}
