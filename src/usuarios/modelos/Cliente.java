/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Esteban
 */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    private ArrayList<Pedido> pedidos= new ArrayList<>();

    
    public void mostrar() {
      System.out.println(correo);
      System.out.println(clave);
      System.out.println(apellido);
      System.out.println(nombre);
      for (Pedido p: pedidos)
            System.out.println(p.verNumero());
=======
    private ArrayList<Pedido> listaPedidos;
    
    //Metodos
    public void mostrar(){
        System.out.println("Cliente: " + apellido + " " + nombre);
>>>>>>> desarrollo
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ", clave=" + clave + ", apellido=" + apellido + ", nombre=" + nombre + '}';
    }
    
    //constructor

=======
    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
        this.listaPedidos = new ArrayList<>();
>>>>>>> desarrollo
    }
    
    //metodos get/set
    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        if (correo != null && !correo.isBlank()){
            this.correo = correo;
        }
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        if (clave != null && !clave.isBlank()){
            this.clave = clave;
        }
    }

    public String verApellido() {
        return apellido;
    }

    public void asignarApellido(String apellido) {
        if (apellido != null && !apellido.isBlank()){
            this.apellido = apellido;
        }
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()){
            this.nombre = nombre;
        }
    }
    
    public Pedido verPedido(int indice) {
        return pedidos.get(indice);
    }

    public void asignarPedido(Pedido unPedido) {
        this.pedidos.add(unPedido);
    }
    
    
    
    
    
}
=======
>>>>>>> desarrollo

    public ArrayList<Pedido> verListaPedidos() {
        return this.listaPedidos;
    }

    public void asignarPedido(Pedido p) {
        this.listaPedidos.add(p);
    }    
}
