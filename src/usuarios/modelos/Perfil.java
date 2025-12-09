/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public enum Perfil {
    CLIENTE("Cliente"),
    EMPLEADO("Empleado"),
    ENCARGADO("Encargado");

    private String valor;

    private Perfil(String valor) {
        this.valor = valor;
    }
    
    public static Perfil compararValor(String perfil) {
        Perfil[] valores = Perfil.values();
        for (Perfil unPerfil : valores) {
            if (unPerfil.equals(perfil)) {
                return unPerfil;
            }
        }
        return null;
    }

    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
