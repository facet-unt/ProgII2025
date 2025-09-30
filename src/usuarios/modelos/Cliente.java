/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente {
    private String apellido;
    private String nombre;
    private String correo;
    private String clave;
    private ArrayList<Pedido> pedidos;

    public Cliente(String apellido, String nombre, String correo, String clave, ArrayList<Pedido> pedidos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.pedidos = pedidos;
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
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido != null && !pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
    }

    public void mostrarPedidos() {
        System.out.println("-- PEDIDOS DEL CLIENTE " + apellido + ", " + nombre + " --");
        for (Pedido p : pedidos) {
            p.mostrar();
            System.out.println();
        }
    }

//    public void mostrar(){
//        System.out.println("-- CLIENTE --");
//        System.out.println("Apellido: " + apellido);
//        System.out.println("Nombre: " + nombre);
//        System.out.println("Correo: " + correo);
//        System.out.println("Clave: " + clave);
//     }

    
    public void mostrar() {
      System.out.println(correo);
      System.out.println(clave);
      System.out.println(apellido);
      System.out.println(nombre);      
    }
 
    @Override
    public String toString() {
        return "Cliente{" + "apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
    }
}
