/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author tobias150
 */
public enum Perfil {
    CLIENTE("Cliente"),
    EMPLEADO("Empleado"),
    ENCARGADO("Encargado");
    
    private String valor;
    
    private Perfil(String valor){
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.valor;
    }
    
    public static Perfil obtenerPerfil(String cadena){
        for(Perfil p : Perfil.values()){
            if(p.toString().equals(cadena))
                return p;
        }
        
        return null;
    }
}
