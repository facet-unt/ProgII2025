package productos.modelos;

import interfaces.IGestorProductos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import interfaces.IGestorPedidos;
import java.io.FileNotFoundException;


public class GestorProductos implements IGestorProductos{
    private List<Producto> productos = leerProductos();
    
    private static GestorProductos instancia;
    
        // Constructor
    private GestorProductos() {
        
    }
    
    public static GestorProductos instanciar() {
        if (instancia == null)
            instancia = new GestorProductos();
        return instancia;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!(codigo>0))
            return ERROR_CODIGO;
        if(descripcion == null || descripcion == "")
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        if(productos.contains(p))
            return PRODUCTOS_DUPLICADOS;
        
        guardarProducto(p);
        
        productos.add(p);
        return EXITO;
    }
    
    @Override
    public String modificarProducto(Producto p, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if(!this.productos.contains(p))
            return PRODUCTO_INEXISTENTE;
        if (codigo <= 0)
            return ERROR_CODIGO;
        if(descripcion == null || descripcion.equals(""))
            return ERROR_DESCRIPCION;
        if(precio<=0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        p.asignarCodigo(codigo);
        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);
        System.out.println(actualizarArchivo());

        return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        Collections.sort(productos, Producto.categoriaComp);
        Collections.sort(productos, Producto.descripcionComp);
        System.out.println(actualizarArchivo());
        return this.productos;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        int i=0;
        List<Producto> productosPorDescripcion = new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion().equalsIgnoreCase(descripcion) && p.verDescripcion().contains(descripcion)){
                productosPorDescripcion.add(p);
                i++;
            }
        }
        if(i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        
        Collections.sort(productosPorDescripcion);
        return productosPorDescripcion;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto) {
        if(!productos.contains(producto)){
            System.out.println(PRODUCTO_INEXISTENTE);
            return false;
        }
        System.out.println("El producto especificado existe");
        return true;
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        int i = 0;
        List<Producto> productosPorCategoria = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria() == categoria){
                productosPorCategoria.add(p);
                i++;
            }
        }
        if (i == 0)
            System.out.println(PRODUCTO_INEXISTENTE);
        
        Collections.sort(productosPorCategoria, Producto.descripcionComp);
        return productosPorCategoria;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo) {
        if(codigo>0){
            for(Producto p: productos){
                if(p.verCodigo() == codigo){
                    System.out.println(VALIDACION_EXITO);
                    return p;
                }
            }
        } else {
            System.out.println(ERROR_CODIGO);
        }
        return null;
    }

    @Override
    public String borrarProducto(Producto producto) {
        IGestorPedidos gPed = GestorPedidos.instanciar();
        if(producto != null && productos.contains(producto)){
            if(!gPed.hayPedidosConEsteProducto(producto)){
                borrarProductoDelArchivo(producto);
                productos.remove(producto);
                return "El Producto se ha borrado definitivamente";
            } else {
                return "No se ha podido borrar este producto ya que hay un pedido que lo contiene \n";
            }
        } else {
            return PRODUCTO_INEXISTENTE;
        }
    }
    
    /**
     * Verifica si el archivo ya existe, si no es asi, se crea.
     * @param archivo
     * @return Devuelve un String con el resultado de la operacion
     */
    private String verificarArchivo(File archivo){
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
                return "El archivo no existia, por ende fue creado";
            } catch (IOException e){
                return "No se ha podido crear el archivo";
            } catch (Exception e){
                return e.getMessage();
            }
        }
        return "";
    }
    
    /**
     * Guarda un producto en el archivo de texto
     * @param p
     * @return Devuelve un String con el resultado de la operacion
     */
    private String guardarProducto(Producto p) {
        String atributosProducto;
        atributosProducto = "," + p.verCodigo() + "," + p.verDescripcion() + "," + p.verCategoria() + "," + p.verEstado() + "," 
                            + p.verPrecio() + "," + "\n";
        if (!this.productos.contains(p)){
            File archivo = new File("Productos.txt");
            try (FileWriter fw = new FileWriter(archivo, true)){
                try(BufferedWriter bw = new BufferedWriter(fw)){
                    bw.write(atributosProducto);
                } catch (IOException e) {
                    return ESCRITURA_ERROR;
                }
            } catch (IOException e){
                return CREACION_ERROR;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            return PRODUCTOS_DUPLICADOS;
        }      
        return ESCRITURA_OK;
    }
    
    /**
     * Construye un objeto tipo Producto segun los datos contenidos en el archivo de texto
     * @param cadenas
     * @return Devuelve una lista con todos los productos contenidos en el archivo de texto
     */
    private List<Producto> costruirProducto(String[] cadenas){
        int i = 1;
        Producto p;
        List<Producto> productosArchivo = new ArrayList<>();
        
        while (i < cadenas.length){
            int codigo = Integer.parseInt(cadenas[i]);
            if(codigo <= 0){
                System.out.println(ERROR_CODIGO);
                return null;
            }
            i++;
            String descripcion = cadenas[i];
            if (descripcion == null || descripcion.equals("")){
                System.out.println(ERROR_DESCRIPCION);
                return null;
            }
            i++;

            Categoria categoria;
            if(cadenas[i].equals(Categoria.ENTRADA.toString())){
                categoria = Categoria.ENTRADA;
            } else if(cadenas[i].equals(Categoria.PLATO_PRINCIPAL.toString())) {
                categoria = Categoria.PLATO_PRINCIPAL;
            } else if(cadenas[i].equals(Categoria.POSTRE.toString())) {
                categoria = Categoria.POSTRE;
            } else {
                System.out.println(ERROR_CATEGORIA);
                return null;
            }
            i++;

            Estado estado;
            if(cadenas[i].equals(Estado.DISPONIBLE.toString())){
                estado = Estado.DISPONIBLE;
            } else if (cadenas[i].equals(Estado.NO_DISPONIBLE.toString())){
                estado = Estado.NO_DISPONIBLE;
            } else {
                System.out.println(ERROR_ESTADO);
                return null;
            }
            i++;

            float precio = Float.parseFloat(cadenas[i]);
            if (precio <= 0){
                System.out.println(ERROR_PRECIO);
                return null;
            }
            i = i+2;
            p = new Producto(codigo, descripcion, categoria, estado, precio);
            productosArchivo.add(p);
        }
        return productosArchivo;
    }
    
    /**
     * Lee el archivo y guarda sus contenidos en la lista de GestorProductos
     * @return Devuelve una lista con todos los productos contenidos en el archivo de texto
     */
    private List<Producto> leerProductos(){
        int caracter;
        String productos = "";
        String[] cadenas;
        List<Producto> productosArchivo= new ArrayList<>();
        File archivo = new File("Productos.txt");
        System.out.println(verificarArchivo(archivo));
        
        try (FileReader fr = new FileReader(archivo)){
            while ((caracter = fr.read()) != -1){
                productos += ((char) caracter );
            }
            cadenas = productos.split(",");
            productosArchivo = costruirProducto(cadenas);
        } catch (FileNotFoundException e) {
            System.out.println(LECTURA_ERROR);
            return null;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println(LECTURA_OK);
        return productosArchivo;
    }
    
    /**
     * Borra un producto en el archivo de texto
     * @param p
     * @return Devuelve un String con el resultado de la operacion
     */
    private String borrarProductoDelArchivo (Producto p) {
        List<Producto> temporal = new ArrayList<>(this.productos);
        temporal.remove(p);
        this.productos.clear();
        File archivo = new File("Productos.txt");
        try (FileWriter fw = new FileWriter(archivo)){
            fw.write("");
            for(Producto p2: temporal){
                guardarProducto(p2);
            }
            this.productos = temporal;
        } catch (IOException e){
            return ESCRITURA_ERROR;
        } catch (Exception e){
            return e.getMessage();
        }
        return "El producto fue borrado del archivo";
    }
    
    /**
     * Actualiza el archivo de texto segun el orden en el que se encuentren en la lista 
     * de GestorProductos
     * @return 
     */
    private String actualizarArchivo(){
        List<Producto> temporal = new ArrayList<>(this.productos);
        this.productos.clear();
        File archivo = new File("Productos.txt");
        try (FileWriter fw = new FileWriter(archivo)){
            fw.write("");
            for(Producto p2: temporal){
                guardarProducto(p2);
            }
            this.productos = temporal;
        } catch (IOException e){
            return ESCRITURA_ERROR;
        } catch (Exception e){
            return e.getMessage();
        }
        return "El Archivo fue actualizado correctamente";
    }
    
}
