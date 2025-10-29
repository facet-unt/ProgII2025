package usuarios.modelos;

public enum Perfil {
    CLIENTE ("Cliente"),
    EMPLEADO ("Empleado"),
    ENCARGADO ("Encargado");
    
    private String valor;
    
    private Perfil (String valor){
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return valor;
    }
}