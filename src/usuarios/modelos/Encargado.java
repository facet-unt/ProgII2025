package usuarios.modelos;

public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

   
    @Override
    public String toString() {
        return "Encargado{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

//    // Opcional: puedes sobrescribir mostrar() si lo deseas
//     public void mostrar() {
//         System.out.println(this.toString());
//    }
}
