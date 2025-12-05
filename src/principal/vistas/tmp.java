/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.vistas;

import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author damia
 */
public class tmp {
    public static void main(String[] args) {
        GestorUsuarios gu = null;
        gu = gu.instanciar();
        
        System.out.println(gu.crearUsuario("cliente3@bar.com", "ApellidoCliente3", "NombreCliente3", 
                                            Perfil.CLIENTE, "claveCliente3", "claveCliente3"));
        
        System.out.println(gu.borrarUsuario(gu.verUsuarios().get(0)));
    }
}
