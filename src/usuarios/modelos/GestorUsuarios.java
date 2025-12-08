/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
/**
 *
 * @author alumno
 */

import static Interfaces.IGestorProductos.CREACION_ERROR;
import static Interfaces.IGestorProductos.CREACION_OK;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.*;
import Interfaces.IGestorUsuarios;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *
 * @author Asus
 */
public class GestorUsuarios implements IGestorUsuarios{
    
     private ArrayList<Usuario> usuarios = new ArrayList<>();
     private static GestorUsuarios instancia;
     private final String ARCHIVO_USUARIOS = "usuarios.txt";
    private final String SEPARADOR = ";";
    
    public String abrirArchivo(){
        try {
            FileWriter fw = new FileWriter ("PRODUCTOS.txt");
        } catch (IOException ex) {
            return CREACION_ERROR;
        }
        return CREACION_OK;
    }
    
    
    private GestorUsuarios() {
        leerArchivo();
    }
    
    
     public static GestorUsuarios instanciar() {
        if (instancia == null)
            instancia = new GestorUsuarios();
        return instancia;
    }
     
     
   


    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        
       
        if (obtenerUsuario(correo) != null) {
            return USUARIOS_DUPLICADOS;
        }

        Usuario u = null;
        if (perfil == Perfil.CLIENTE) {
            u = new Cliente(correo, clave, nombre, apellido);
        } else if (perfil == Perfil.EMPLEADO) {
            u = new Empleado(correo, clave, nombre, apellido);
        } else if (perfil == Perfil.ENCARGADO) {
            u = new Encargado(correo, clave, nombre, apellido);
        }

        if (u != null) {
            
            this.usuarios.add(u);
            guardarArchivo();
            return EXITO;
        }
        return ERROR;
    }

    

     public List<Usuario> verUsuarios(){
            Comparator <Usuario> nComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verNombre().compareTo(u2.verNombre());
               }
           };
            Comparator <Usuario> aComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verApellido().compareTo(u2.verApellido());
               }
           };
            Comparator <Usuario> combinado = aComp.thenComparing(aComp);
            usuarios.sort(combinado);
            return usuarios;
         }
     
     
     public String borrarUsuario(Usuario usuario){
//         Usuario u;
//       GestorPedidos gp = GestorPedidos.instanciar();
//         if (usuarios.contains(usuario)){
//             if (usuario instanceof Cliente){
//         if (gp.hayPedidosConEsteCliente((Cliente)usuario))
//             for (Pedido p : usuario.verPedidos())
//                 if (p.verCliente().equals((Cliente)usuario))
//                     this.usuarios.remove(usuario);
//                     return EXITO;
//         }
//           System.out.println("Este usuario no es un cliente");
//           return ERROR;
//         }
//         System.out.println("No existe este usuario");
//         return ERROR;
           if (usuarios.contains(usuario)) {
            this.usuarios.remove(usuario);
            guardarArchivo(); // Actualizamos el TXT al borrar
            return EXITO;
        }
        return ERROR;
     }
     
     
     
     public Usuario existeEsteUsuario(Usuario usuario){
         if (usuarios.contains(usuario))
              return usuario;
             else
             return null;
        }


     public List<Usuario> buscarUsuarios(String apellido){
         ArrayList <Usuario> encontrados = new ArrayList<>();
         for (Usuario u : usuarios){
             if (u.verApellido().toLowerCase().contains(apellido.toLowerCase()))
                 encontrados.add(u);
         }  
         Comparator <Usuario> nComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verNombre().compareTo(u2.verNombre());
               }
           };
            Comparator <Usuario> aComp = new Comparator<Usuario>(){
               @Override 
               public int compare (Usuario u1, Usuario u2){
                   return u1.verApellido().compareTo(u2.verApellido());
               }
           };
            Comparator <Usuario> combinado = aComp.thenComparing(aComp);
            encontrados.sort(combinado);
         return encontrados;
     }
     
     
     public Usuario obtenerUsuario(String correo){
      for (Usuario u : usuarios){   
            if (u.verCorreo().equals(correo)) {
                return u;
            }
            }
        return null;
    }

     
     
     
     
   private void leerArchivo() {
        File f = new File(ARCHIVO_USUARIOS);
        if (!f.exists()) {
            return; // Si no existe el archivo, no hacemos nada (lista vacía)
        }

        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
            
            usuarios.clear(); // Limpiamos la lista para cargar desde cero
            String linea;
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(SEPARADOR); // Separamos por ;
                
                // Esperamos al menos 5 datos: TIPO;CORREO;CLAVE;NOMBRE;APELLIDO
                if (datos.length >= 5) {
                    String tipo = datos[0].trim();
                    String correo = datos[1].trim();
                    String clave = datos[2].trim();
                    String nombre = datos[3].trim();
                    String apellido = datos[4].trim();

                    Usuario u = null;
                    // Switch tradicional compatible con versiones viejas de Java si es necesario
                    if (tipo.equals("CLIENTE")) {
                        u = new Cliente(correo, clave, nombre, apellido);
                    } else if (tipo.equals("EMPLEADO")) {
                        u = new Empleado(correo, clave, nombre, apellido);
                    } else if (tipo.equals("ENCARGADO")) {
                        u = new Encargado(correo, clave, nombre, apellido);
                    }

                    if (u != null) {
                        usuarios.add(u);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de usuarios: " + e.getMessage());
        }
    }

    
    
    private void guardarArchivo() {
        try {
            File archivo = new File(ARCHIVO_USUARIOS);

            
            System.out.println("Guardando en: " + archivo.getAbsolutePath()); 

            
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            try (FileWriter fw = new FileWriter(archivo, false);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                for (Usuario u : usuarios) {
                    String tipo = "";
                   
                    if (u instanceof Cliente) tipo = "CLIENTE";
                    else if (u instanceof Empleado) tipo = "EMPLEADO";
                    else if (u instanceof Encargado) tipo = "ENCARGADO";

                    String linea = tipo + SEPARADOR +
                                   u.verCorreo() + SEPARADOR +
                                   u.verClave() + SEPARADOR +
                                   u.verNombre() + SEPARADOR +
                                   u.verApellido();

                    bw.write(linea);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR CRÍTICO AL GUARDAR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    
