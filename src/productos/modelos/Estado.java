/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**

 * @author estudiante
 */
public enum Estado {
    DISPONIBLE ("Disponible"),
    NO_DISPONIBLE ("No disponible");

    private String valor;
    
    private Estado(String valor) {
        this.valor = valor;
    }
    
    public String verValor() {
        return valor;
    }

    public void asignarValor(String valor) {
        this.valor = valor;
    }

    public static Estado convertirEstado(String nombre){ /*Metodo que devuelve el estado especificado por el nombre */
        Estado[] valores = Estado.values();
        for(Estado c: valores){
            if(c.toString().equals(nombre))
                return c;
        }
        return null;
    }


    @Override
    public String toString() {
        return this.valor;
    }

}
