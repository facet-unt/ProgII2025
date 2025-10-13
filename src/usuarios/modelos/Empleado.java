/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */

public class Empleado extends Usuario {
    //Atributos
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    ArrayList<Pedido> pedidos = new ArrayList<>();
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    //Metodos
    @Override
    public void mostrar(){
        super.mostrar();
    }
  
    //metodos get/set
    @Override
    public String verCorreo() {
        return correo;
    }

    @Override
    public void asignarCorreo(String correo) {
        if (correo != null && !correo.isBlank()){
            this.correo = correo;
        }
    }

    @Override
    public String verClave() {
        return clave;
    }

    @Override
    public void asignarClave(String clave) {
        if (clave != null && !clave.isBlank()){
            this.clave = clave;
        }
    }

    @Override
    public String verApellido() {
        return apellido;
    }

    @Override
    public void asignarApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()){
            this.apellido = apellido;
        }
    }

    @Override
    public String verNombre() {
        return nombre;
    }

    @Override
    public void asignarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            this.nombre = nombre;
        }
    }
    @Override
    public String toString(){
        return "Empleado{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }


    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }
    
}
