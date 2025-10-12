/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario{
   
    private ArrayList<Pedido> pedidos;

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos=new ArrayList<>();
    }

    public Cliente(String correo, String clave, String apellido, String nombre, ArrayList<Pedido> pedidos) {
        super(correo, clave, apellido, nombre);
        this.pedidos = pedidos;
    }
    
//    public String verApellido() {
//        return apellido;
//    }
//
//    public void asignarApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String verNombre() {
//        return nombre;
//    }
//
//    public void asignarNombre(String nombre) {
//        this.nombre = nombre;
//    }

//    public String verCorreo() {
//        return correo;
//    }
//
//    public void asignarCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    public String verClave() {
//        return clave;
//    }
//
//    public void asignarClave(String clave) {
//        this.clave = clave;
//    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido != null && !pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
    }

    public void mostrarPedidos() {
        System.out.println("-- PEDIDOS DEL CLIENTE " + verApellido() + ", " + verNombre() + " --");
        for (Pedido p : pedidos) {
            p.mostrar();
            System.out.println();
        }
    }

    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }

// 
//    @Override
//    public String toString() {
//        return "Cliente{" + "apellido=" + apellido + ", nombre=" + nombre + ", correo=" + correo + ", clave=" + clave + '}';
//    }

}