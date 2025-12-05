/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 *
 * @author damia
 */

public abstract class Usuario implements Comparable<Usuario>{
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private Perfil perfil;
    
    /**
     * Muestra los datos del usuario
     */
    public void mostrar(){
        System.out.println("Apellido: " + apellido);
        System.out.println("Nombre: "+nombre);
        System.out.println("Correo: "+correo);
        System.out.println("Clave: "+clave);
    }
    
    public String verCorreo(){
        return correo;
    }
    
    public void asignarCorreo(String c) {
        if (c != null && !c.isBlank()){
            correo = c;
        }
    }
    
    public String verClave(){
        return clave;
    }
    
    public void asignarClave(String c) {
        if (c != null && !c.isBlank()){
            clave = c;
        }
    }
    
    public String verNombre(){
        return nombre;
    }
    
    public void asignarNombre(String n) {
        if (n != null && !n.isBlank()){
            nombre = n;
        }
    }
    
    public String verApellido(){
        return apellido;
    }
    
    public void asignarApellido(String a) {
        if (a != null && !a.isBlank()){
            apellido = a;
        }
    }

    public Perfil verPerfil() {
        return perfil;
    }

    public void asignarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    /**
     * 
     * @return Devuelve una lista de los pedidos que tiene un usuario
     */
    public abstract List<Pedido> verPedidos();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.correo);
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
        return Objects.equals(this.correo, other.correo);
    }

    /**
     * Compara los usuarios por apellido
     */
    static Comparator<Usuario> apellidoComp = (Usuario u1, Usuario u2) -> u1.verApellido().compareTo(u2.verApellido());
    
    /**
     * Compara los usuarios por nombre
     */
    static Comparator<Usuario> nombreComp = (Usuario u1, Usuario u2) -> u1.verNombre().compareTo(u2.verApellido());

    @Override
    public int compareTo(Usuario o) {
        int cmp = this.apellido.compareTo(o.verApellido());
        if (cmp == 0) {
            cmp = this.nombre.compareTo(o.verNombre());
        }
        return cmp;
    }
   
        // Constructor
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
}
