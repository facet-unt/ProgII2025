package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos  {
    private List<Producto> productos = new ArrayList<>();
    private static GestorProductos instancia;
    
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        Producto producto= new Producto(codigo,descripcion,precio,categoria,estado);
        if(codigo<=0)
            return ERROR_CODIGO;
        if(descripcion==null||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if(categoria==null)
            return ERROR_CATEGORIA;
        if(estado==null)
            return ERROR_ESTADO;
        if(productos.contains(producto))
            return PRODUCTOS_DUPLICADOS;
        else{
            productos.add(producto);
            return EscribirArchivo(producto);
        }
        
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(productoAModificar==null)
            return PRODUCTO_INEXISTENTE;
        if(codigo<=0)
            return ERROR_CODIGO;
        productoAModificar.asignarCodigo(codigo);
        if(descripcion==null||descripcion.isBlank())
        return ERROR_DESCRIPCION;
        productoAModificar.asignarDescripcion(descripcion);
        if(precio<=0)
            return ERROR_PRECIO;
        productoAModificar.asignarPrecio(precio);
        if(categoria==null)
            return ERROR_CATEGORIA;
        productoAModificar.asignarCategoria(categoria);
        if(estado==null)
            return ERROR_ESTADO;
        productoAModificar.asignarEstado(estado);
        String cadena="Se modificó el Producto con exito";
        return cadena;
    }
    
    @Override
    public List<Producto> menu() {
        this.productos = LeerArchivo();
        Collections.sort(productos);
        return this.productos;
    }
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList <Producto>productosbuscados =new ArrayList<>();
        for (Producto p : productos) {
            if(p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                productosbuscados.add(p);
                Collections.sort(productosbuscados);
      }
        return productosbuscados;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        for (Producto p: productos) {
            if(p.verCodigo()==producto.verCodigo())
            return true;
        }
        return false;
        }
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto>productoDelaCategoria=new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria()==categoria)
                productoDelaCategoria.add(p);
            Collections.sort(productoDelaCategoria);
        }
        return productoDelaCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
        }
    @Override
    public String borrarProducto(Producto producto){
        GestorPedidos gPedidos= GestorPedidos.instanciar();
        if(gPedidos.hayPedidosConEsteProducto(producto)== true){
            return PRODUCTO_EN_PEDIDO;
        }
        else{
            productos.remove(producto);
            return PRODUCTO_BORRADO;
        }
    }

    @Override
    public String CrearArchivo(){
        File f =  new File(NOMBRE_ARCHIVO);
        try{
            f.createNewFile();
            return CREACION_OK;
        }
        catch(IOException ioe){
            return CREACION_ERROR;
        }
    }
    @Override
    public String EscribirArchivo(Producto producto){
        StringBuilder cadena1 = new StringBuilder();
        File f =  new File(NOMBRE_ARCHIVO);
        try {
            if(!f.exists()){    
                CrearArchivo();
            }
            FileWriter fw = new FileWriter(NOMBRE_ARCHIVO,true);
            BufferedWriter bw = new BufferedWriter(fw);
            cadena1.append(producto.verCodigo());
            cadena1.append(SEPARADOR);
            cadena1.append(producto.verDescripcion());
            cadena1.append(SEPARADOR);
            cadena1.append(producto.verCategoria());
            cadena1.append(SEPARADOR);
            cadena1.append(producto.verEstado());
            cadena1.append(SEPARADOR);
            cadena1.append(producto.verPrecio());
            bw.write(cadena1.toString());
            bw.newLine();
            bw.close();
            fw.close();
            return ESCRITURA_OK;
        } 
        catch (IOException ex) {
            return ESCRITURA_ERROR;
        }
        
    }
    @Override
    public List<Producto> LeerArchivo(){
        List<Producto> productos = new ArrayList<>();
        File f = new File(NOMBRE_ARCHIVO);
        if(!f.exists()){
            return productos;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] atributos = linea.split(SEPARADOR);
                if(atributos.length >= 5){
                    int codigo = Integer.parseInt(atributos[0]);
                    String descripcion = atributos[1];
                    Categoria categoria = Categoria.valueOf(atributos[2]);
                    Estado estado = Estado.valueOf(atributos[3]);
                    Float precio = Float.parseFloat(atributos[4]);
                    Producto producto = new Producto(codigo,descripcion,precio,categoria,estado);
                    productos.add(producto);
                }
        }
            br.close();
            return productos;
        }
        catch(IOException ioe){
            System.out.println(LECTURA_ERROR);
            return productos;
        }
    }
}
