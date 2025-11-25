package productos.modelos;

import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import static interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static interfaces.IGestorProductos.PRODUCTO_INEXISTENTE;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {
    private List<Producto> productos = new ArrayList<>();
    
    private static final String SEPARADOR = "-";
    
    private static final String NOMBREARCHIVO = "Productos.txt";
    
    private static GestorProductos instancia;
                
    private GestorProductos() {
        
    }
    
    private String validarInfo(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo <= 0){
            return ERROR_CODIGO;
        }
        
        if (descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        
        if (precio <= 0){
            return ERROR_PRECIO;
        }
        
        if (categoria == null){
            return ERROR_CATEGORIA;
        }
        
        if (estado == null){
            return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {        
        String resultado = validarInfo(codigo, descripcion, precio, categoria, estado);
        if (!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
         
        if (obtenerProducto(codigo) != null){
            return PRODUCTOS_DUPLICADOS;
        }
        
        Producto nuevo = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevo);
        this.registrarProductos(nuevo);
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (p == null || !this.productos.contains(p)){
            return PRODUCTO_INEXISTENTE;
        }
        

        String resultado = validarInfo(codigo, descripcion, precio, categoria, estado);
        if(!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        p.asignarCodigo(codigo);
        if (obtenerProducto(codigo) != null){
            return PRODUCTOS_DUPLICADOS;
        }            
        
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        this.productos = this.leerProductos();
        Collections.sort(productos);
        return this.productos;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> lista = new ArrayList<>();
        this.productos = this.leerProductos();
        for (Producto p : productos){            
            if(p.verDescripcion().equals(descripcion)){
                lista.add(p);
            }           
        }
        Collections.sort(productos);
        return lista;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        return this.productos.contains(producto);
    }
    
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> categorias = new ArrayList<>();
        
        for(Producto pr : productos){
            if(pr.verCategoria().equals(categoria)){
                categorias.add(pr);
            }
        }
        categorias.sort(dDesc);
        return categorias;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto pr : productos){
            if(pr.verCodigo() == codigo){
                return pr;
            }
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
    if (producto == null) {
        return "Error: el producto es nulo.";
    }

    
    if (!productos.contains(producto)) {
        return "El producto no existe en el sistema.";
    }

    
    GestorPedidos gp = GestorPedidos.getInstancia();
    if (gp.hayPedidosConEsteProducto(producto)) {
        return "No se puede eliminar el producto, hay pedidos asociados.";
    }

    
        productos.remove(producto);
        
        return "Producto eliminado con éxito.";
    }

    Comparator<Producto> dDesc = (Producto p1, Producto p2) -> p1.verDescripcion().compareTo(p2.verDescripcion());
    
    private String registrarProductos(Producto p){    
        String resultado = this.crearArchivo();
        if(resultado.equals(CREACION_ERROR)){
            return CREACION_ERROR;
        }
        
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(NOMBREARCHIVO, true));){
            String linea;
            linea = Integer.toString(p.verCodigo()) + SEPARADOR;
            linea += p.verDescripcion() + SEPARADOR;
            linea += p.verCategoria().toString() + SEPARADOR;
            linea += p.verEstado().toString() + SEPARADOR;
            linea += Float.toString(p.verPrecio());
            fw.write(linea);
            fw.write("\n");
            return ESCRITURA_OK;
        }
        catch(IOException e){
            return ESCRITURA_ERROR;
        }
    }
        
    private String crearArchivo(){
        File f = new File(NOMBREARCHIVO);
        
        try{
            f.createNewFile();
        }
        catch(IOException e){
            return CREACION_ERROR;  
        }      
        
        return CREACION_OK;
    }
    
    private List<Producto> leerProductos(){      
        File f = new File(NOMBREARCHIVO);
        try(BufferedReader fr = new BufferedReader(new FileReader(NOMBREARCHIVO)))
        {
            String linea;
            List<Producto> listado = new ArrayList<>();
            while((linea = fr.readLine()) != null){
                String[] cadenas = linea.split(SEPARADOR);
                int codigo = Integer.parseInt(cadenas[0]);
                String descripcion = cadenas[1];
                Categoria categoria = this.convertirCategoria(cadenas[2]);
                Estado estado = this.convertirEstado(cadenas[3]);
                float precio = Float.parseFloat(cadenas[4]);
                Producto prod = new Producto();
                prod.asignarCategoria(categoria);
                prod.asignarCodigo(codigo);
                prod.asignarDescripcion(descripcion);
                prod.asignarEstado(estado);
                prod.asignarPrecio(precio);
                listado.add(prod);
            }  
            return listado;
        }
        catch(IOException e){
            System.out.println(ERROR_LECTURA);
            return null;
        }    
          
    }
        
    private Categoria convertirCategoria(String valor){
        Categoria[] valores = Categoria.values();
        for(Categoria c: valores){
            if(c.toString().equals(valor))
                return c;
        }
        return null;
    }
 
    private Estado convertirEstado(String c){
        for(Estado e : Estado.values()){
            if(e.toString().equals(c))
                return e;
        }
        return null;
    }
    
    private String modificarProducto(Producto pModificado) {
    File archivoOriginal = new File(NOMBREARCHIVO);

    if (!archivoOriginal.exists()) {
        return "ERROR_ARCHIVO_NO_ENCONTRADO";
    }

    File archivoTemporal = new File("productos_temp.txt");

    try (
        BufferedReader br = new BufferedReader(new FileReader(archivoOriginal));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal))
    ) {

        String lineaOriginal;
        boolean encontrado = false;

        while ((lineaOriginal = br.readLine()) != null) {
            String[] partes = lineaOriginal.split(SEPARADOR);

            int codigo = Integer.parseInt(partes[0]);

            if (codigo == pModificado.verCodigo()) {
                
                String nuevaLinea = pModificado.verCodigo() + SEPARADOR +
                                    pModificado.verDescripcion() + SEPARADOR +
                                    pModificado.verCategoria() + SEPARADOR +
                                    pModificado.verEstado() + SEPARADOR +
                                    pModificado.verPrecio();

                bw.write(nuevaLinea);
                bw.newLine();
                encontrado = true;
            } else {
               
                bw.write(lineaOriginal);
                bw.newLine();
            }
        }

        bw.flush();
        br.close();

       
        if (encontrado) {
            archivoOriginal.delete();
            archivoTemporal.renameTo(archivoOriginal);
            return "MODIFICACION_OK";
        } else {
            archivoTemporal.delete();
            return "PRODUCTO_NO_ENCONTRADO";
        }

    } catch (IOException e) {
        return ESCRITURA_ERROR;
    }
}
    
}