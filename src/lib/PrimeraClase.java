/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

/**
 *
 * @author estudiante
 */
import java.util.ArrayList;

public class PrimeraClase {
    String unaCadena;
    int unEntero;
    
    void mostrarAtributos() {
        System.out.println("Objeto: " + unaCadena);
        System.out.println("Cantidad: " + unEntero + "\n");
    }
    
    public static void main(String[] args) {
        
        PrimeraClase Objeto1 = new PrimeraClase();
        PrimeraClase Objeto2 = new PrimeraClase();
        PrimeraClase Objeto3 = new PrimeraClase();
        PrimeraClase Objeto4 = new PrimeraClase();
        PrimeraClase Objeto5 = new PrimeraClase();
        
        Objeto1.unaCadena = "Monitor";
        Objeto1.unEntero = 30;
        
        Objeto2.unaCadena = "Escritorio";
        Objeto2.unEntero = 20;
        
        Objeto3.unaCadena = "Reloj de aguja";
        Objeto3.unEntero = 1;
        
        Objeto4.unaCadena = "Proyector";
        Objeto4.unEntero = 6;
        
        Objeto5.unaCadena = "Alumnos";
        Objeto5.unEntero = 22;
        
        //Objeto1.mostrarAtributos();
        //Objeto2.mostrarAtributos();
        //Objeto3.mostrarAtributos();
        //Objeto4.mostrarAtributos();
        Objeto5.mostrarAtributos();
        
        ArrayList<PrimeraClase> listaObjetos = new ArrayList<>();
        
        listaObjetos.add(Objeto1);
        listaObjetos.add(Objeto2);
        listaObjetos.add(Objeto3);
        listaObjetos.add(Objeto4);
        listaObjetos.add(Objeto5);
        
        for (PrimeraClase objeto : listaObjetos) {
            objeto.mostrarAtributos();
        }
    }
}
