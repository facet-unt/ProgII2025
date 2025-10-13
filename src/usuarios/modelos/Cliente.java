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
public class Cliente extends Usuario{
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    //metodos get/set
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
    }

    @Override
    public String verCorreo() {
        return correo;
    }

    @Override
    public String verClave() {
        return clave;
    }

    @Override
    public String verApellido() {
        return apellido;
    }

    @Override
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String verNombre() {
        return nombre;
    }

    @Override
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    public void asignarPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    @Override
    public void asignarCorreo(String c) {
        super.mostrar();
        if (c != null && !c.isBlank())
            correo = c;
    }


    @Override
    public void asignarClave(String c) {
        super.mostrar();
        if (c != null && !c.isBlank())
            correo = c;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.correo);
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
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.correo, other.correo);
    }
    
    
}
