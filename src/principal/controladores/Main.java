/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IControladorPrincipal;
import interfaces.IGestorUsuarios;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;

/**
 *
 * @author thoma
 */
public class Main {
    public static void main(String[] args) {
        
        //Usuarios de prueba para la implementacion de la tabla de usuarios
        IGestorUsuarios gusuarios = GestorUsuarios.instanciar();
        
        gusuarios.crearUsuario("cliente2@bar.com", "claveCliente3", "Perez", "NombreCliente3", Perfil.CLIENTE, "claveCliente3");
        gusuarios.crearUsuario("cliente3@bar.com", "claveCliente4", "Hernan", "Jose", Perfil.CLIENTE, "claveCliente4");
        gusuarios.crearUsuario("cliente1@bar.com", "claveCliente1", "Almendra", "NombreCliente1", Perfil.CLIENTE, "claveCliente1");
        gusuarios.crearUsuario("cliente4@bar.com", "claveCliente1", "Hernan", "Zadkiel", Perfil.CLIENTE, "claveCliente1");
        
        IControladorPrincipal cp = ControladorPrincipal.instanciar();
    }
    
}
