/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author lazar
 */
public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    
    public Cliente(String c,String cl,String a,String n){
        correo=c;
        clave=cl;
        apellido=a;
        nombre=n;
    }
    
    public void mostrar(){
        System.out.println("Correo: "+correo);
        System.out.println("Clave: "+clave);
        System.out.println("Apellido: "+apellido);
        System.out.println("Nombre: "+nombre);
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

    public String verCorreo() {
        return correo;
    }

    public void sasignarCorreo(String c) {
        correo = c;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String c) {
        clave = c;
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String a) {
        apellido = a;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String n) {
        nombre = n;
    }
    
}
