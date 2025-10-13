package usuarios.modelos;

public class Empleado extends Usuario {

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    
    @Override
    public String toString() {
        return "Empleado{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    // Opcional: puedes heredar mostrar() o sobrescribirlo
    // public void mostrar() {
    //     System.out.println(this.toString());
    // }
}
