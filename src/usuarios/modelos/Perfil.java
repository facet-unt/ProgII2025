/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Asus
 */
public enum Perfil {
    CLIENTE ("cliente"),   
    EMPLEADO ("empleado"),
   ENCARGADO ("encargado");
 
     private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
     
    private Perfil (String valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return this.valor;
    }
}
