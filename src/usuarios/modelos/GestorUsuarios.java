/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import static interfaces.IGestorProductos.ESCRITURA_ERROR;
import static interfaces.IGestorProductos.ESCRITURA_OK;
import interfaces.IGestorUsuarios;
import static interfaces.IGestorUsuarios.ERROR_PERFIL;
import static interfaces.IGestorUsuarios.EXITO;
import static interfaces.IGestorUsuarios.USUARIOS_DUPLICADOS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import static productos.modelos.GestorProductos.ARCHIVO;
import static productos.modelos.GestorProductos.SEPARADOR;
import productos.modelos.Producto;
import static usuarios.modelos.Perfil.CLIENTE;
import static usuarios.modelos.Perfil.EMPLEADO;
import static usuarios.modelos.Perfil.ENCARGADO;

/**
 *
 * @author Orlando
 */
public class GestorUsuarios implements IGestorUsuarios {
    

        public static final String ARCHIVO = "Usuarios.txt";
        public static final String SEPARADOR = "*";
        private ArrayList<Usuario> usuarios = new ArrayList<>();

        private static GestorUsuarios gestor;
        private Usuario usuario;
        
    public GestorUsuarios() {
        cargarArchivoEnLista();
    }
   
    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    public String borrarUsuario(Usuario usuario) {
        if (usuario.verPedidos().isEmpty()) {

            usuarios.remove(usuario);
            cargarListaUsuariosEnArchivo();
            return BORRADO_EXITO;
           
        }
        cargarListaUsuariosEnArchivo();
        return BORRADO_ERROR;
    }

    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || correo.isEmpty() || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (clave == null || clave.isEmpty() || claveRepetida == null || claveRepetida.isEmpty() || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }

        switch (perfil) {
            case ENCARGADO:
                Encargado e = new Encargado(correo, clave, apellido, nombre);
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(e);
                cargarListaUsuariosEnArchivo();

                break;

            case EMPLEADO:
                Empleado en = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(en)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(en);
                cargarListaUsuariosEnArchivo();

                break;

            case CLIENTE:
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);
                cargarListaUsuariosEnArchivo();

                break;
            default:
                return ERROR_PERFIL;
        }
        return EXITO;
    }

    public List<Usuario> verUsuarios() {
        
        return usuarios;
    }

    public List<Usuario> buscarUsuarios(String apellido) {
        List<Usuario> usuariosBuscados = new ArrayList();
        for (Usuario u : usuarios) {
            if (u.verApellido().contains(apellido)) {
                
                usuariosBuscados.add(u);
            }
        }
        Collections.sort(usuariosBuscados);
        return usuariosBuscados;
    }

    public boolean existeEsteUsuario(Usuario usuario) {
        return usuarios.contains(usuario);
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario u : usuarios) {
            if (u.verCorreo().contains(correo)) {
                return u;
            }
        }
        return null;
    }
    
  
    
      public void cargarArchivoEnLista() {
        usuarios.clear();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException e) {
                System.out.println(CREACION_ERROR);
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) 
{
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split("\\*");
                if (partes.length != 6) {
                    continue;
                }
                
                String correo= partes[0];
                String clave = partes[4];
                String apellido = partes[1];
                String nombre = partes[2];
                String perfil= partes[3].toUpperCase();
                String claveRepetida= partes[5];

           
                switch(perfil)
                {
                    case "ENCARGADO":
                Encargado en = new Encargado(correo, clave, apellido, nombre);
                usuarios.add(en);

                break;

            case "EMPLEADO":
                Empleado em = new Empleado(correo, clave, apellido, nombre);
                usuarios.add(em);

                break;

            case "CLIENTE":
                Cliente cl = new Cliente(correo, clave, apellido, nombre);
                usuarios.add(cl);

                break;
            default:
                
                }        
         }
                    
    
            System.out.println(LECTURA_OK);

            }catch (Exception e) 
          {
            System.out.println(LECTURA_ERROR);
        }
        
      
    
      
}
    
    private void cargarListaUsuariosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, false))) {

            for (Usuario u : usuarios) {
                bw.write(u.verCorreo()+ SEPARADOR
                        + u.verApellido() + SEPARADOR
                        + u.verNombre() + SEPARADOR
                        + u.getClass().getSimpleName() + SEPARADOR
                        + u.verClave() + SEPARADOR
                + u.verClave());
                bw.newLine();
            }

            System.out.println(ESCRITURA_OK);
        } catch (IOException ex) {
            System.out.println(ESCRITURA_ERROR);
        }
          catch(NullPointerException ex)
                    {
                        System.out.println("Un parámetro es null");
                    }
        }

    
    
    @Override
    public String modificarUsuario(Usuario usuario, String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida)
    {
         if (correo == null || correo.isEmpty() || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (clave == null || clave.isEmpty() || claveRepetida == null || claveRepetida.isEmpty() || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }
        usuarios.remove(usuario);

        switch (perfil) {
            case ENCARGADO:
                Encargado e = new Encargado(correo, clave, apellido, nombre);
                
                if (usuarios.contains(e)) {
                    return USUARIOS_DUPLICADOS;
                }
//                int index = usuarios.indexOf(usuario);
//               if (index != -1) {
//                 usuarios.set(index, e);
//                  }

                usuarios.add(e);
                cargarListaUsuariosEnArchivo() ;
                

                break;

            case EMPLEADO:
                Empleado en = new Empleado(correo, clave, apellido, nombre);
                if (usuarios.contains(en)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(en);
//                int index2= usuarios.indexOf(usuario);
//                 if (index2 != -1) {
//                usuarios.set(index2, en);
//                      }

                cargarListaUsuariosEnArchivo() ;

                break;

            case CLIENTE:
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                if (usuarios.contains(c)) {
                    return USUARIOS_DUPLICADOS;
                }
                usuarios.add(c);
//                int index3 = usuarios.indexOf(usuario);
//              if (index3 != -1) {
//               usuarios.set(index3, c);
//                  }

                cargarListaUsuariosEnArchivo();

                break;
            default:
                return ERROR_PERFIL;
        }
        
        
        return EXITO;
        
       
    }

    

    

}
