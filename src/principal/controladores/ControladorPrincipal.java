package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Cliente;

public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<> ();
        ArrayList<Encargado> listaEncargados = new ArrayList<> ();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
        Producto p2= new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
        Producto p3 = new Producto(3, "Producto3", "Plato Principal", "No Disponible", 1050.0f);
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        System.out.println("PRODUCTOS usando mostrar()");
        for (Producto p: listaProductos)
            p.mostrar();
         
        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del producto es :" +  listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
 
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente c1 = new Cliente ("jp@gmail.com","holasi","Toledo","Juan Pablo");
        Cliente c2 = new Cliente ("capoidolo@gmail.com","metelenomas","Royale","Clash");
        Cliente c3 = new Cliente ("increible@gmail.com","espectacular","Ronaldo","Cristiano");
        
        
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);
        
        for (Cliente c: listaClientes)
            System.out.println(c);
        
        System.out.println("\n El nombre del cliente es :" + listaClientes.get(1).verNombre());
        listaClientes.get(1).AsignarNombre("Tobias");
        System.out.println("\n El nuevo nombre del cliente es :" + listaClientes.get(1).verNombre());
        
        for (Cliente c: listaClientes)
            System.out.println(c);
         
        
        System.out.println("########### EMPLEADOS ###########\n");
        
        Empleado emp1 = new Empleado("hola123@gmail.com", "EgW221", "Santiago", "Montiel");
        Empleado emp2 = new Empleado("martin123@gmail.com", "Vg_21", "Martin", "Lucero");
        Empleado emp3 = new Empleado("interesante@gmail.com", "McN_28", "Alvaro", "Juarez");
        
        listaEmpleados.add(emp1);
        listaEmpleados.add(emp2);
        listaEmpleados.add(emp3);
        
        
        System.out.println("Informacion de Cada Empleado usando metodo toString\n");
        for(Empleado emp : listaEmpleados)
            System.out.println(emp);
       
            
        System.out.println("Modificacion de Atributos");
        
        listaEmpleados.get(0).AsignarApellido("Molina");
        System.out.println("Nuevo Apellido del Primer Empleado : " + listaEmpleados.get(0).verApellido());
        
        listaEmpleados.get(1).AsignarNombre("Joaquin");
        System.out.println("Nuevo Nombre del Segundo Empleado : " + listaEmpleados.get(1).verNombre());
        
        listaEmpleados.get(2).AsignarClave("Nm_1zx");
        System.out.println("Nueva Clave del tercer Empleado : " + listaEmpleados.get(2).verClave());
        
        for(Empleado emp : listaEmpleados)
            System.out.println(emp);
        
        System.out.println("############ ENCARGADOS ###############\n");
        
        Encargado enc1 = new Encargado("Modo2@gmail.com", "Bma_12", "Lucas", "Salgado");
        Encargado enc2 = new Encargado("tobiaskpo.1450@gmail.com", "QwErTy54", "Tobias", "Manzilla");
        Encargado enc3 = new Encargado("informatica@gmail.com", "info25", "Jose", "Younes");

        listaEncargados.add(enc1);
        listaEncargados.add(enc2);
        listaEncargados.add(enc3);

        System.out.println("Informacion de Cada Encargado usando metodo toString\n");
        for(Encargado enc : listaEncargados)
            System.out.println(enc);
        
        System.out.println("Modificacion de Atributos para Encargados");
        
        listaEncargados.get(0).AsignarClave("44531lv");
        System.out.println("Nueva Clave del Primer Encargado : " + listaEncargados.get(0).verClave());
        
        listaEncargados.get(1).AsignarClave("44531lv");
        System.out.println("Nueva Clave del Segundo Encargado : " + listaEncargados.get(1).verClave());
        
        listaEncargados.get(2).AsignarNombre("Enzo");
        System.out.println("Nueva Nombre del Tercer Encargado : " + listaEncargados.get(2).verNombre());
        
        
        System.out.println("Nuevos Datos de Cada Encargado\n");
        
        for(Encargado enc : listaEncargados)
            System.out.println(enc);
        
        
    }
}