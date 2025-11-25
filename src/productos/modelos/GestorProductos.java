package productos.modelos;

import static Interfaces.IGestorProductos.ERROR_CATEGORIA;
import static Interfaces.IGestorProductos.ERROR_CODIGO;
import static Interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static Interfaces.IGestorProductos.ERROR_PRECIO;
import static Interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static Interfaces.IGestorProductos.ERROR_BORRADO;
import static Interfaces.IGestorProductos.EXITO_BORRADO;
import static Interfaces.IGestorProductos.ESCRITURA_ERROR;
import static Interfaces.IGestorProductos.CREACION_ERROR;
import static Interfaces.IGestorProductos.CREACION_OK;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import pedidos.modelos.GestorPedidos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;  
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import Interfaces.IGestorProductos;


public class GestorProductos implements IGestorProductos{
    private ArrayList<Producto> productos = new ArrayList<>();
    
    private static GestorProductos instancia; //implementacion para se pueda instancias una vez
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
  
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
                
                if (codigo <= 0){
                   return ERROR_CODIGO;
                   }else if (descripcion == null || descripcion.isEmpty()){
                    return ERROR_DESCRIPCION;
                   }else if(precio <= 0){
                       return ERROR_PRECIO;
                   }else if(categoria == null){
                       return ERROR_CATEGORIA;
                   }else if(estado == null){
                   return ERROR_ESTADO;}
                Producto p = new Producto (codigo, descripcion, precio, categoria, estado);
                if (!productos.contains(p)){
                    productos.add(p);
                    EscribirProducto(p);
                return EXITO;
                }else{
                return PRODUCTOS_DUPLICADOS;
                }
                
    }
    
    
    public String abrirArchivo(){
        try {
            FileWriter fw = new FileWriter ("PRODUCTOS.txt");
        } catch (IOException ex) {
            return CREACION_ERROR;
        }
   return CREACION_OK;
    }
     private String borrarArchivo() {
        File f;
        f = new File("PRODUCOTS.txt");
        f.delete();
        if (f != null) {
            try {
                FileWriter fw = new FileWriter(f);
                fw.close();
            } catch (IOException ex) {

            }
            return (EXITO_BORRADO);
        } else {
            return (ERROR_BORRADO);
        }
    }

        
    
    
    public String EscribirProducto (Producto produto){
//        llamo a abrir y de acuerdo su resultado escribo
        String a = abrirArchivo();

//        List listaOrdenada = menu();
        if (a.equals(CREACION_OK)){
            for (Producto p : productos){
             try (FileWriter fw = new FileWriter ("PRODUCTOS.txt", true)){
                    BufferedWriter bw = new BufferedWriter(fw);
                    StringBuilder linea = new StringBuilder();
                    linea.append(Integer.toString(p.verCodigo()));
                    linea.append(" , ");
                    linea.append(p.verDescripcion());
                    linea.append(" , ");
                    linea.append(Float.toString(p.verPrecio())); 
                    linea.append(" , ");
                    linea.append(p.verCategoria());
                    linea.append(" , ");
                    linea.append(p.verEstado());
                    linea.append("\n");
                    bw.write(linea.toString()); 
                    bw.close();
                    }
                    catch(IOException e){
                        return ESCRITURA_ERROR;
                    }
            }
            return ESCRITURA_OK;
        }
        else {
            return ESCRITURA_ERROR;
        }
    }
    
    
    
    @Override
    public List<Producto> menu() {
        Comparator<Producto> cComp = new Comparator<Producto>(){//va sin las <> al final pues da error
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verCategoria().compareTo(p2.verCategoria());
                }
         };//fin  del primer criterio de comparacion
         Comparator<Producto> dComp = new Comparator<Producto>(){
         @Override
         public int compare(Producto p1, Producto p2) {
         return p1.verDescripcion().compareTo(p2.verDescripcion()); 
         }
         };//fin  del segundo criterio de comparacion
                Comparator<Producto> combinado = cComp.thenComparing (dComp); //combina ambos criterios de comparacion
               productos.sort(combinado); //recibe la lista y la compara
               return productos; //devuelve la lista ordenada
    }
    
    
    @Override
    public String existeEsteProducto(Producto producto) {
        try (FileReader fr = new FileReader("PRODUCTOS.txt")){
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null){
                String datos[] = linea.split (",");//divide la linea en un vector por cada , que hay
                if (datos.length >0 ){
                    try {
                        int codigoDeArchivo = Integer.parseInt (datos[0].trim()); //accede al primer dato de la linea
                                              //convierte ese dato en int         //y luego lo combierte en un numero int
                                                                                  //trim hace que se borre cada espacio vacio
                        if (codigoDeArchivo == producto.verCodigo());
                        System.out.println(producto);
                       return LECTURA_OK;
                    }catch(NumberFormatException e){
                        return LECTURA_ERROR;
                    }
                }
            }
        } catch (IOException ex) {
            return LECTURA_ERROR;
        }
        return LECTURA_OK;
    }
    
    
    
     public List<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> prodcat = new ArrayList<>();
        for (Producto p : productos) {

            if (p.verCategoria() == (categoria)) {
                prodcat.add(p);
            }

        }
        prodcat.sort(Comparator.comparing(Producto::verDescripcion));
        return prodcat;
    }
    
     
       public List<Producto> buscarProductos(String descripcion) {
            if (descripcion == null){
                System.out.println("error en la descripcion");
            return null;
        }
        List <Producto> productosEncontrados = new ArrayList<>();
        String busqueda = descripcion.trim().toLowerCase();
        
        try (FileReader fr = new FileReader("PRODUCTOS.txt")){
            BufferedReader br = new BufferedReader (fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String datos [] = linea.split(",");
                if (datos.length >= 5){
                    try {
                        String DescripcionDeArchivo = datos[1].trim();
                        if (DescripcionDeArchivo.trim().toLowerCase().contains(busqueda)){
                            System.out.println(DescripcionDeArchivo);
                            int codigo = Integer.parseInt (datos[0].trim());
                            float precio = Float.parseFloat (datos[2].trim());
                            String textoCategoria = datos[3].trim();
                            Categoria categoria = Categoria.verCategoria(textoCategoria);
                            String textoEstado = datos [4];
                            Estado estado = Estado.verEstado(textoEstado);
                            Producto productoEncontrado = new Producto(codigo, descripcion, precio, categoria, estado);
                            productosEncontrados.add(productoEncontrado);
                        }
                    } catch (NumberFormatException e){
                        return null;
                    }
                }
            }           
        } catch (IOException ex) {
            return productosEncontrados;
        }            
    return productosEncontrados;
    }
     
   
    
    @Override
         public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        String resultadoArchivo;
        if (productos.contains(p)) {
            productos.remove(p);
        }
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        productos.add(p);
        if (codigo > 0 && descripcion != null && precio > 0 && categoria != null && estado != null) {
            productos.add(p);
            resultadoArchivo = borrarArchivo();
            if (resultadoArchivo.equals(EXITO_BORRADO)) {
                for (Producto unProducto : productos) {
                    resultadoArchivo = EscribirProducto(unProducto);
                    if (!(resultadoArchivo.equals(ESCRITURA_OK))) {
                        return (ESCRITURA_ERROR);
                    }
                }
                return (EXITO);
            } else {
                return (ERROR_BORRADO);
            }

        } else {
            if (codigo < 0) {
                return (EXITO);
            } else {
                if (codigo < 0) {
                    return (ERROR_CODIGO);
                } else if (precio < 0) {
                    return (ERROR_PRECIO);
                } else if (descripcion == null) {
                    return (ERROR_DESCRIPCION);
                } else if (categoria == null) {
                    return (ERROR_CATEGORIA);
                } else {
                    return (ERROR_ESTADO);
                }
            }
        }
    }
    
    
    
    
    public String borrarProducto(Producto producto){
         String resultadoArchivo;
        GestorPedidos gp = GestorPedidos.instanciar();  //uso el gestor de pedidos para obtener los podructos de cada pedido
        if (gp.hayPedidosConEsteProducto(producto)){//controlo que haya pedidos con ese producto
            return ERROR_BORRADO;
        }
        if (productos.contains(producto) && producto != null) {
            GestorPedidos pedidos = GestorPedidos.instanciar();
            for (Pedido unPedido : pedidos.verPedidos()) {
                for (ProductoDelPedido unProducto : unPedido.verProductosDelPedido()) {
                    if ((unProducto.verPedido()).equals(producto)) // si el producto se encuentra en un pedido
                    {
                        return (ERROR_BORRADO);
                    }

                }

            }
        this.productos.remove(producto);
        if (productos.contains(producto)) {
            productos.remove(producto);
        }
        resultadoArchivo = borrarArchivo();
        if (resultadoArchivo.equals(EXITO_BORRADO)) {
                for (Producto unProducto : productos) {
                    resultadoArchivo = EscribirProducto(unProducto);
                     }
                    return (EXITO);

                }else {
                return (ERROR_BORRADO);
            }
         }
        return EXITO_BORRADO; 
    }
    
    
    
   
    public Producto obtenerProducto(Integer codigo) {       
        for (Producto p : productos){   
            if (p.verCodigo() == codigo) {
                return p;
            }
            }
        return null;
    }
}
